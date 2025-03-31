package com.elyxor.onboarding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderRepository orderRepository;

    @Autowired // Constructor Injection
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("orders")
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("orders/{ticker}")
    public List<Order> getOrdersByTicker(@PathVariable String ticker) {
        return orderRepository.findByTicker(ticker);
    }

    @GetMapping("order/{transaction}")
    public Order getOrder(@PathVariable String transaction) {
        return orderRepository.findByTransaction(transaction);
    }

    @PostMapping
    public List<Order> createOrders(@RequestBody List<Order> orders) {
        return orderRepository.saveAll(orders);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderRepository.findById(id)
                .map(existingOrder -> {
                    existingOrder.setQuantity(order.getQuantity());
                    existingOrder.setTicker(order.getTicker());
                    existingOrder.setPrice(order.getPrice());
                    existingOrder.setDirection(order.getDirection());
                    return orderRepository.save(existingOrder);
                })
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }
}
