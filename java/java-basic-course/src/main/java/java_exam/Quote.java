package java_exam;

import lombok.AllArgsConstructor;
import lombok.Getter;


import java.io.Serializable;

@AllArgsConstructor
@Getter
public class Quote implements Serializable {
    int id;
    String text;
    Status status;
}
