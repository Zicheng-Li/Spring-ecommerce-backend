package lzc.com.example.ecommerce.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import jakarta.transaction.Transactional;
import lzc.com.example.ecommerce.dao.CustomerRepository;
import lzc.com.example.ecommerce.dto.PaymentInfo;
import lzc.com.example.ecommerce.dto.Purchase;
import lzc.com.example.ecommerce.dto.PurchaseResponse;
import lzc.com.example.ecommerce.entity.Customer;
import lzc.com.example.ecommerce.entity.Order;
import lzc.com.example.ecommerce.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, @Value("${stripe.key.secret}") String secretKey){
        this.customerRepository = customerRepository;
        // initialize stripe api with new key
        Stripe.apiKey=secretKey;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve the order info from dto
        Order order = purchase.getOrder();
        // generate tracking number
        String trackingNumber = generateTrackingNumber(order);
        order.setOrderTrackingNumber(trackingNumber);
        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(orderItem ->order.add(orderItem));
        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setAddress(purchase.getShippingAddress());
        // populate customer with order
        Customer customer = purchase.getCustomer();
        // check if this is an existing customer
        String theEmail = customer.getEmail();
        Customer existingCustomer = customerRepository.findByEmail(theEmail);
        if (existingCustomer != null){
            customer = existingCustomer;
        }
        customer.add(order);
        // save to the database
        customerRepository.save(customer);
        // return a response
        return new PurchaseResponse(trackingNumber);
    }

    @Override
    public PaymentIntent createPaymentIntent(PaymentInfo info) throws StripeException {
        List<String> paymentMethodsTypes = new ArrayList<String>();
        paymentMethodsTypes.add("card");
        Map<String, Object> params = new HashMap<>();
        params.put("amount", info.getAmount());
        params.put("currency", info.getCurrency());
        params.put("payment_method_type", paymentMethodsTypes);
        return PaymentIntent.create(params);
    }

    private String generateTrackingNumber(Order order) {
        // generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}
