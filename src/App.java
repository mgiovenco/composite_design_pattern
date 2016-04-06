import java.util.ArrayList;
import java.util.List;

/**
 * The Composite pattern describes that a
 * group of objects is to be treated in the same way as a single instance of an object. The intent
 * of a composite is to "compose" objects into tree structures to represent part-whole hierarchies.
 * Implementing the Composite pattern lets clients treat individual objects and compositions
 * uniformly.
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Company Organization Structure using Composite Pattern");

        Employee ceo = new EmployeeImpl("Adam", "Adamson", "CEO", 1);
        Employee cto = new EmployeeImpl("Bob", "Bobson", "CTO", 1);

        Employee vp1 = new EmployeeImpl("Chris", "Chrison", "VP of Ordering", 1);
        Employee vp2 = new EmployeeImpl("Claire", "Claireson", "VP of Mobile and Delivery", 2);

        Employee teamLead1 = new EmployeeImpl("Dan", "Danson", "Team Lead of Ordering", 1);
        Employee teamLead2 = new EmployeeImpl("Deacon", "Deaconson", "Team Lead of Mobile", 2);
        Employee teamLead3 = new EmployeeImpl("Deana", "Deanason", "Team Lead of Delivery", 1);

        Employee developer1 = new EmployeeImpl("Ed", "Edson", "Developer on Ordering Team", 1);
        Employee developer2 = new EmployeeImpl("Eric", "Ericson", "Developer on Ordering Team", 2);
        Employee developer3 = new EmployeeImpl("Erin", "Erinson", "Developer on Mobile Team", 2);
        Employee developer4 = new EmployeeImpl("Elizabeth", "Elizabethson", "Developer on Delivery Team", 2);

        Employee qa1 = new EmployeeImpl("Frank", "Frankson", "QA on Ordering Team", 1);

        ceo.addSubordinate(cto);
        cto.addSubordinate(vp1);
        cto.addSubordinate(vp2);
        vp1.addSubordinate(teamLead1);
        vp2.addSubordinate(teamLead2);
        vp2.addSubordinate(teamLead3);
        teamLead1.addSubordinate(developer1);
        teamLead1.addSubordinate(developer2);
        teamLead2.addSubordinate(developer3);
        teamLead3.addSubordinate(developer4);
        developer1.addSubordinate(qa1);

        System.out.println();

        System.out.println("Current organization structure...");
        List<Employee> organization = companyOrganizationStructure(ceo);
        System.out.println(organization);

        System.out.println();

        System.out.println("Employee introductions...");
        for (Employee employee : organization) {
            System.out.println(employee.introduceSelf());
        }
    }

    public static List<Employee> companyOrganizationStructure(Employee root) {
        List<Employee> passedNodesList = new ArrayList<>();

        if (root != null) {
            passedNodesList.add(root);

            for (int i = 0; i < passedNodesList.size(); i++) {
                List<Employee> childNodesList = passedNodesList.get(i).getSubordinates();

                if (childNodesList != null && !childNodesList.isEmpty()) {
                    for (Employee childNode : childNodesList) {
                        passedNodesList.add(childNode);
                    }
                }
            }
        }

        return passedNodesList;
    }
}
