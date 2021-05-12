package com.raggerbreak.ecommerce.services;

import com.raggerbreak.ecommerce.dto.Purchase;
import com.raggerbreak.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
