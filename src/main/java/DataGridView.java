import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ManagedBean
//@Named("info")
@ViewScoped
public class DataGridView implements Serializable {

    @EJB
    private OrderEJB orderEJB;

    private DriversInfo driversInfo;
    private TrucksInfo trucksInfo;

    @PostConstruct
    public void init() throws UnirestException {
        driversInfo = orderEJB.driversInfo();
        trucksInfo = orderEJB.trucksInfo();
    }

    public DriversInfo getDriversInfo() {
        return driversInfo;
    }

    public TrucksInfo getTrucksInfo() {
        return trucksInfo;
    }
}
