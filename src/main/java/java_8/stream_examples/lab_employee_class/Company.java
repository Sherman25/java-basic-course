package java_8.stream_examples.lab_employee_class;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Singular
    private List<Employee> employees;

    private Seniority seniority;

    public Company(List<Employee> employees) {
        this.employees = employees;
    }

}
