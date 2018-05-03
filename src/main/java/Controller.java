import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import java.awt.event.ActionEvent;
import java.io.Serializable;

@ManagedBean
public class Controller implements Serializable {

    public void buttonAction(ActionEvent actionEvent) {
        System.out.println("Hello!");
    }
}
