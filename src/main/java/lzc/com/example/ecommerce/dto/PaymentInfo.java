package lzc.com.example.ecommerce.dto;

import lombok.Data;

@Data
public class PaymentInfo {
    private int amount;
    private String currency;
}
