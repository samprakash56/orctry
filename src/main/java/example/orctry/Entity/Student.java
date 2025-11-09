package example.orctry.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @SequenceGenerator(name = "student_seq", sequenceName = "student_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    private Integer id;

    private String name;
    private Integer age;
    private String tech;
}
