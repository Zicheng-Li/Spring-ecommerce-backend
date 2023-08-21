package lzc.com.example.ecommerce.service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import lzc.com.example.ecommerce.dto.PaymentInfo;
import lzc.com.example.ecommerce.dto.Purchase;
import lzc.com.example.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
    PaymentIntent createPaymentIntent(PaymentInfo info) throws StripeException;
}
