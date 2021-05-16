package model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person extends Object {
    private String name;
    @Setter
    private int age;
    private int salary;


}
