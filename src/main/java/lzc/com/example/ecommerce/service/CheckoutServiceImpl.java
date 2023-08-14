package lzc.com.example.ecommerce.service;

import lzc.com.example.ecommerce.dao.CustomerRepository;
import lzc.com.example.ecommerce.dto.Purchase;
import lzc.com.example.ecommerce.dto.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {
        return null;
    }
}
