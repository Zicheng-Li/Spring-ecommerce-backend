package lzc.com.example.ecommerce.controller;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import lzc.com.example.ecommerce.dto.PaymentInfo;
import lzc.com.example.ecommerce.dto.Purchase;
import lzc.com.example.ecommerce.dto.PurchaseResponse;
import lzc.com.example.ecommerce.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private CheckoutService service;

    @Autowired
    public CheckoutController(CheckoutService service) {
        this.service = service;
    }
    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
      PurchaseResponse response = service.placeOrder(purchase);
      return response;
    }

    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfo info) throws StripeException {
        PaymentIntent intent = service.createPaymentIntent(info);

        String paymentStr= intent.toJson();
        return new ResponseEntity<>(paymentStr, HttpStatus.OK);
    }
}
