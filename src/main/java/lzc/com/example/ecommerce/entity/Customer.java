package lzc.com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Customer")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
}
