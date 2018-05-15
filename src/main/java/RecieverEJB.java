import com.mashape.unirest.http.exceptions.UnirestException;
import com.rabbitmq.client.*;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

@Stateless
public class RecieverEJB{

    private final static String QUEUE_NAME = "queue1";

    @EJB
    private OrderEJB orderEJB;
    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;

    public void recieve() throws Exception {
        factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
        channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                try {
                    orderEJB.applyChanges(message);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }

    @PreDestroy
    public void close() throws IOException, TimeoutException {
        channel.close();
        connection.close();
    }
}