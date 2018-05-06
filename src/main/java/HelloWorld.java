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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named("orders")
@SessionScoped
public class HelloWorld implements Serializable {

  /** Default value included to remove warning. **/
  private static final long serialVersionUID = 1L;

  @EJB
  private OrderEJB orderEJB;

  private String jsonString;

  private List<Order> orders;

//  public static class Order {
//    public long id;
//    public long uniqueNumber;
//    public String orderStatus;
//
//    @Override
//    public String toString() {
//      return "Order{" +
//              "id=" + id +
//              ", uniqueNumber=" + uniqueNumber +
//              ", orderStatus='" + orderStatus + '\'' +
//              '}';
//    }
//  }

  @PostConstruct
  public void init() throws UnirestException {
//    Unirest.setObjectMapper(new ObjectMapper() {
//      private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
//              = new com.fasterxml.jackson.databind.ObjectMapper();
//
//      public <T> T readValue(String value, Class<T> valueType) {
//        try {
//          return jacksonObjectMapper.readValue(value, valueType);
//        } catch (IOException e) {
//          throw new RuntimeException(e);
//        }
//      }
//
//      public String writeValue(Object value) {
//        try {
//          return jacksonObjectMapper.writeValueAsString(value);
//        } catch (JsonProcessingException e) {
//          throw new RuntimeException(e);
//        }
//      }
//    });
//
//    HttpResponse<Order[]> httpResponse = Unirest.get("http://localhost:8000/api/info").asObject(Order[].class);
//    List<Order> tempOrders = Arrays.asList(httpResponse.getBody());
//    System.out.println("tempOrders = " + tempOrders);

    orders = orderEJB.createOrders();
  }

  public List<Order> getOrders() {
    return orders;
  }

//  public void setOrders() {
//    orders = orderEJB.createOrders();
//  }

}