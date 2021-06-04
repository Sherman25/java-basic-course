package java_8.lab_employee;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<EmployeeContainer> containerList = List.of(EmployeeContainer.builder().employee(Employee.builder().salary(generateSalaries()).build()).build(),
                EmployeeContainer.builder().employee(Employee.builder().salary(generateSalaries()).build()).build(),
                EmployeeContainer.builder().employee(Employee.builder().salary(generateSalaries()).build()).build());

        long count = containerList.stream()
                .flatMap(employeeContainer -> employeeContainer.getEmployees().stream())
                .peek(System.out::println)
                .flatMapToInt(employee -> Arrays.stream(employee.getSalary())).sum();

        System.out.println("count = " + count);
    }

    private static int[] generateSalaries(){
        int min = 1000;
        int max = 10000;
        int[] res = new int[12];
        for(int i = 0; i < 12; i++) {
            res[i] = (int) Math.floor(Math.random() * (max - min + 1) + min);
        }
        return res;
    }
}
