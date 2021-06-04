package java_8.lab_employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int[] salary = new int[12];
}
