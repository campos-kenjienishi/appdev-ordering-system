package com.pup.taguig.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pup.taguig.app.dto.OrderItemRequestDTO;
import com.pup.taguig.app.dto.OrderItemResponseDTO;
import com.pup.taguig.app.dto.OrderRequestDTO;
import com.pup.taguig.app.dto.OrderResponseDTO;
import com.pup.taguig.app.mapper.OrderMapper;
import com.pup.taguig.app.mapper.ProductMapper;
import com.pup.taguig.app.model.Order;
import com.pup.taguig.app.model.OrderItem;
import com.pup.taguig.app.model.Product;
import com.pup.taguig.app.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO request) {

        Double totalPrice = 0.0;

        // Validate products and calculate total
        for (OrderItemRequestDTO item : request.getItems()) {

            Product product = productMapper.getProductById(item.getProductId());

            if (product == null) {
                throw new RuntimeException("Product not found");
            }

            if (product.getStock() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock");
            }

            totalPrice += product.getPrice() * item.getQuantity();
        }

        Order order = new Order();
        order.setCustomerId(request.getCustomerId());
        order.setStatus("PENDING");
        order.setTotalPrice(totalPrice);

        orderMapper.createOrder(order);

        // Insert order items and reduce stock
        for (OrderItemRequestDTO item : request.getItems()) {

            Product product = productMapper.getProductById(item.getProductId());

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setProductId(item.getProductId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(product.getPrice());

            orderMapper.createOrderItem(orderItem);

            Integer newStock = product.getStock() - item.getQuantity();
            productMapper.updateProductStock(product.getId(), newStock);
        }

        return getOrderById(order.getId());
    }

    @Override
    public OrderResponseDTO getOrderById(Long id) {
        Order order = orderMapper.getOrderById(id);

        if (order == null) {
            return null;
        }

        return toResponseDTO(order);
    }

    @Override
    public List<OrderResponseDTO> getCustomerOrders(Long id) {
        List<Order> orders = orderMapper.getCustomerOrders(id);
        List<OrderResponseDTO> responseList = new ArrayList<>();

        for (Order order : orders) {
            responseList.add(toResponseDTO(order));
        }

        return responseList;
    }

    @Override
    public boolean cancelOrder(Long id) {
        Order order = orderMapper.getOrderById(id);

        if (order == null) {
            return false;
        }

        if (!"PENDING".equals(order.getStatus())) {
            return false;
        }

        List<OrderItem> items = orderMapper.getOrderItems(id);

        for (OrderItem item : items) {
            Product product = productMapper.getProductById(item.getProductId());

            if (product != null) {
                Integer restoredStock = product.getStock() + item.getQuantity();
                productMapper.updateProductStock(product.getId(), restoredStock);
            }
        }

        return orderMapper.cancelOrder(id) > 0;
    }

    private OrderResponseDTO toResponseDTO(Order order) {
        OrderResponseDTO response = new OrderResponseDTO();

        response.setId(order.getId());
        response.setCustomerId(order.getCustomerId());
        response.setStatus(order.getStatus());
        response.setTotalPrice(order.getTotalPrice());

        List<OrderItemResponseDTO> itemResponses = new ArrayList<>();

        if (order.getItems() != null) {
            for (OrderItem item : order.getItems()) {
                OrderItemResponseDTO itemResponse = new OrderItemResponseDTO();

                itemResponse.setProductId(item.getProductId());
                itemResponse.setQuantity(item.getQuantity());
                itemResponse.setPrice(item.getPrice());

                itemResponses.add(itemResponse);
            }
        }

        response.setItems(itemResponses);

        return response;
    }
}