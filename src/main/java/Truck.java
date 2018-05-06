import javax.ejb.Stateful;

@Stateful
public class Truck {
    private String regNumber;

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "regNumber='" + regNumber + '\'' +
                '}';
    }
}
