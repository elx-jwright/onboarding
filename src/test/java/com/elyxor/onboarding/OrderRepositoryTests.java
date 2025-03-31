package com.elyxor.onboarding;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository repository;

    @Test
    void testFindByTicker() {
        Order order = new Order();
        order.setQuantity(1000);
        order.setTicker("MSFT");
        order.setPrice((float)123.45);
        order.setDirection(Direction.BUY);

        String transaction = repository.save(order).getTransaction();

        Order foundOrder = repository.findByTransaction(transaction);
        assertThat(foundOrder).isNotNull();
        assertThat(foundOrder.getTicker()).isEqualTo("MSFT");
        assertThat(foundOrder.getQuantity()).isEqualTo(1000);
        assertThat(foundOrder.getDirection()).isEqualTo(Direction.BUY);
        assertThat(foundOrder.getPrice()).isEqualTo((float)123.45);
    }
}
