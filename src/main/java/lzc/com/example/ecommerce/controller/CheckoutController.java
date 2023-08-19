package lzc.com.example.ecommerce.controller;

import lzc.com.example.ecommerce.dto.Purchase;
import lzc.com.example.ecommerce.dto.PurchaseResponse;
import lzc.com.example.ecommerce.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
}
