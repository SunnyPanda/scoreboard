import com.mashape.unirest.http.exceptions.UnirestException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.Serializable;

//@Startup
@ApplicationScoped
public class DataGridService implements Serializable {

    @EJB
    private OrderEJB orderEJB;

    @EJB
    private RecieverEJB recieverEJB;

    private DriversInfo driversInfo;
    private TrucksInfo trucksInfo;

    @PostConstruct
    public void init() throws Exception {
//        Unirest.setObjectMapper(new ObjectMapper() {
//            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
//                    = new com.fasterxml.jackson.databind.ObjectMapper();
//
//            public <T> T readValue(String value, Class<T> valueType) {
//                try {
//                    return jacksonObjectMapper.readValue(value, valueType);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//
//            public String writeValue(Object value) {
//                try {
//                    return jacksonObjectMapper.writeValueAsString(value);
//                } catch (JsonProcessingException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });


        System.out.println("DataGridView.init");
        driversInfo = updateDriversInfo();
        trucksInfo = updateTrucksInfo();
        recieverEJB.recieve();
    }

    public DriversInfo updateDriversInfo() throws UnirestException {
        return orderEJB.driversInfo();
    }

    public TrucksInfo updateTrucksInfo() throws UnirestException {
        return orderEJB.trucksInfo();
    }

    public void setDriversInfo(DriversInfo driversInfo) {
        this.driversInfo = driversInfo;
    }

    public void setTrucksInfo(TrucksInfo trucksInfo) {
        this.trucksInfo = trucksInfo;
    }

    public DriversInfo getDriversInfo() {
        return driversInfo;
    }

    public TrucksInfo getTrucksInfo() {
        return trucksInfo;
    }
}
