package com.raggerbreak.ecommerce.web.controllers;

import com.raggerbreak.ecommerce.dto.Purchase;
import com.raggerbreak.ecommerce.dto.PurchaseResponse;
import com.raggerbreak.ecommerce.services.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
@RequiredArgsConstructor
public class CheckoutController {

    private final CheckoutService checkoutService;

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }
}
