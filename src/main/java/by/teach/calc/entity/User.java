package by.teach.calc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @ToString.Exclude private int id;
    private String username;
    private String fName;
    private String lName;
    @ToString.Exclude private String password;
}
