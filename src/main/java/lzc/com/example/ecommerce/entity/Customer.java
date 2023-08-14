package lzc.com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Customer")
@Getter
@Setter
public class Customer {

    @Column(name = "first_name")
    private String firstName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy ="customer", cascade=CascadeType.ALL)
    private Set<Order> orders=new HashSet<Order>();

    public void add(Order order) {
        if(order != null) {
            if(orders == null) {
                orders = new HashSet<Order>();
            }
            orders.add(order);
            order.setCustomer(this);
        }
    }
}
