import javax.ejb.Stateful;
import java.util.List;

@Stateful
public class Order {

    private long id;
    private long uniqueNumber;
    private String orderStatus;
    private Truck truck;
    private List<Driver> drivers;

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(long uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uniqueNumber=" + uniqueNumber +
                ", orderStatus='" + orderStatus + '\'' +
                ", truck=" + truck +
                ", drivers=" + drivers +
                '}';
    }
}
