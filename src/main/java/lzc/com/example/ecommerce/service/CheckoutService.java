package lzc.com.example.ecommerce.service;

import lzc.com.example.ecommerce.dto.Purchase;
import lzc.com.example.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
