import java.io.Serializable;
import javax.ejb.*;
//import javax.faces.bean.ApplicationScoped;
//import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
//import javax.inject.Singleton;

@ManagedBean
@Startup
@ApplicationScoped
public class DataGridView implements Serializable {

    @Inject
    private DataGridService dataGridService;
    
    public DriversInfo getDriversInfo() {
        System.out.println("DataGridView.getDriversInfo");
        return dataGridService.getDriversInfo();
    }

    public TrucksInfo getTrucksInfo() {
        System.out.println("DataGridView.getTrucksInfo");
        return dataGridService.getTrucksInfo();
    }
}
