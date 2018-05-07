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

  private List<Order> orders;

  @PostConstruct
  public void init() throws UnirestException {

    orders = orderEJB.createOrders();
//    DriversInfo driversInfo = orderEJB.driversInfo();
//    TrucksInfo trucksInfo = orderEJB.trucksInfo();
  }

  public List<Order> getOrders() {
    return orders;
  }

}