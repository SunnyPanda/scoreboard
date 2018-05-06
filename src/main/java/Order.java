import javax.ejb.Stateful;

@Stateful
public class Order {

    private long id;
    private long uniqueNumber;
    private String orderStatus;

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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uniqueNumber=" + uniqueNumber +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
