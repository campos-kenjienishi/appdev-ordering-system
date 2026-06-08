package com.pup.taguig.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pup.taguig.app.model.Order;
import com.pup.taguig.app.model.OrderItem;

@Mapper
public interface OrderMapper {
	
	public int createOrder(Order order);
	public int createOrderItem(OrderItem item);
	public Order getOrderById(Long id);
	public List<Order> getCustomerOrders(Long customerId);
	public List<OrderItem> getOrderItems(Long orderId);
	public int cancelOrder(Long id);
	
}
