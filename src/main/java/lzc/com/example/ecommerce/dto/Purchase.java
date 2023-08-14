package lzc.com.example.ecommerce.dto;

import lombok.Data;
import lzc.com.example.ecommerce.entity.Address;
import lzc.com.example.ecommerce.entity.Customer;
import lzc.com.example.ecommerce.entity.Order;
import lzc.com.example.ecommerce.entity.OrderItem;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address address;
    private Address shippingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
