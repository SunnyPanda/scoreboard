import javax.ejb.Stateful;

@Stateful
public class Driver {

    private long personalNumber;

    public long getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(long personalNumber) {
        this.personalNumber = personalNumber;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "personalNumber=" + personalNumber +
                '}';
    }
}
