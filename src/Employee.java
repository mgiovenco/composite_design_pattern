import java.util.List;

public interface Employee {
    String getFirstName();
    void setFirstName(String firstName);

    String getLastName();
    void setLastName(String lastName);

    String getTitle();
    void setTitle(String title);

    int getBand();
    void setBand(int band);

    List<Employee> getSubordinates();
    void addSubordinate(Employee employee);
    void removeSubordinate(Employee employee);

    String introduceSelf();
}
