package java_8.lab_employee;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeContainer {
    @Singular
    private List<Employee> employees;
}
