import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
//@Named("info")
@ViewScoped
public class DataGridView implements Serializable {

    @EJB
    private OrderEJB orderEJB;

    @EJB
    private RecieverEJB recieverEJB;

    private DriversInfo driversInfo;
    private TrucksInfo trucksInfo;

    @PostConstruct
    public void init() throws Exception {
        driversInfo = orderEJB.driversInfo();
        trucksInfo = orderEJB.trucksInfo();
        recieverEJB.recieve();
    }

    public DriversInfo getDriversInfo() {
        return driversInfo;
    }

    public TrucksInfo getTrucksInfo() {
        return trucksInfo;
    }
}
