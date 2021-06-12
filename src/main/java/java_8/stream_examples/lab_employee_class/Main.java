package java_8.stream_examples.lab_employee_class;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                Employee.builder().name("Dany").salary(24).build(),
                Employee.builder().name("Targarien").salary(34).build(),
                Employee.builder().name("Stark").salary(41).build(),
                Employee.builder().name("Legolas").salary(41).build(),
                Employee.builder().name("Stark").salary(12).build());

        List<Employee> employees2 = List.of(
                Employee.builder().name("Dany").salary(14).build(),
                Employee.builder().name("Targarien").salary(10).build(),
                Employee.builder().name("Stark").salary(41).build(),
                Employee.builder().name("Legolas").salary(41).build(),
                Employee.builder().name("Stark").salary(12).build());

        List<Company> companies = List.of(new Company(employees), new Company(employees2));

        EmployeeUtils.setCompanyStatus(companies);

        System.out.println();
    }
}
