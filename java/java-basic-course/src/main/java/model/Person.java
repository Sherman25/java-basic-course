package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(exclude = "salary")
public class Person extends Object {
    private String name;
    @Setter
    private int age;
    private int salary;
}
