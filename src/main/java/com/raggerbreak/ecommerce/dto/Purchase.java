package com.raggerbreak.ecommerce.dto;

import com.raggerbreak.ecommerce.domain.Address;
import com.raggerbreak.ecommerce.domain.Customer;
import com.raggerbreak.ecommerce.domain.Order;
import com.raggerbreak.ecommerce.domain.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    protected Set<OrderItem> orderItems;
}
