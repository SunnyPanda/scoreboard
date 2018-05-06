//import javax.annotation.PostConstruct;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.ViewScoped;
//import java.io.Serializable;
//import java.util.List;
//
//@ManagedBean(name = "dtOrderView")
//@ViewScoped
//public class HelloWorld implements Serializable {
//
//  private List<String> orders;
//
//  @ManagedProperty("#{orderServise}")
//  private OrderService orderService;
//
//  @PostConstruct
//  public void init() {
//    orders = orderService.createOrders();
//  }
//
//  public List<String> getOrders() {
//    return orders;
//  }
//
//  public void setOrderService(OrderService orderService) {
//    this.orderService = orderService;
//  }
//
//}

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.rabbitmq.client.GetResponse;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.Serializable;
import java.util.List;

@Named("orders")
@SessionScoped
public class HelloWorld implements Serializable {

  /** Default value included to remove warning. **/
  private static final long serialVersionUID = 1L;

  @EJB
  private OrderEJB orderEJB;

  private String json;

  private List<String> orders;


  @PostConstruct
  public void init() throws UnirestException {
    HttpResponse<String> httpResponse = Unirest.get("http://localhost:8000/api/info").asString();
    json = httpResponse.getBody();
    System.out.println(json);
    orders = orderEJB.createOrders();
  }

  public List<String> getOrders() {
    return orders;
  }

//  public void setOrders() {
//    orders = orderEJB.createOrders();
//  }

}