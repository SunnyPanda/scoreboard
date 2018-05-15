import com.mashape.unirest.http.exceptions.UnirestException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class DataTableService {

    @EJB
    private OrderEJB orderEJB;

    private List<Order> orders;

    @PostConstruct
    public void init() throws UnirestException {
        orders = orderEJB.createOrders();

    }

    public List<Order> getOrders() {

        return orders;
    }
}
