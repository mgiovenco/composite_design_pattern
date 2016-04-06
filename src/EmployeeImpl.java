import java.util.ArrayList;
import java.util.List;

public class EmployeeImpl implements Employee {

    private String firstName;
    private String lastName;
    private String title;
    private int band;
    private final List<Employee> subordinates = new ArrayList<>();

    public EmployeeImpl(String firstName, String lastName, String title, int band) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.band = band;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getBand() {
        return band;
    }

    @Override
    public void setBand(int band) {
        this.band = band;
    }

    @Override
    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    @Override
    public void removeSubordinate(Employee employee) {
        subordinates.remove(employee);
    }

    @Override
    public String introduceSelf() {
        return "Hello my name is " + firstName + " " + lastName + ". My title is " + title + " grade " + band + ".  I'm in charge of the following people: " + ((subordinates.size() == 0) ? " no one :(" : subordinates);
    }

    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeImpl)) return false;

        EmployeeImpl employee = (EmployeeImpl) o;

        if (getBand() != employee.getBand()) return false;
        if (getFirstName() != null ? !getFirstName().equals(employee.getFirstName()) : employee.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(employee.getLastName()) : employee.getLastName() != null)
            return false;
        if (getTitle() != null ? !getTitle().equals(employee.getTitle()) : employee.getTitle() != null) return false;
        return getSubordinates() != null ? getSubordinates().equals(employee.getSubordinates()) : employee.getSubordinates() == null;

    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + getBand();
        result = 31 * result + (getSubordinates() != null ? getSubordinates().hashCode() : 0);
        return result;
    }
}
