package lzc.com.example.ecommerce.dto;

import lombok.Data;

@Data
public class PurchaseResponse {
    private final String orderTrackingNumber; // lombok will generate constructor automatically for final fields
}
