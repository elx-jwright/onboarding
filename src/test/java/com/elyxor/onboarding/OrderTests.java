package com.elyxor.onboarding;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testOrderConstructorAndGetters() {
        Order order = new Order();
        order.setQuantity(1000);
        order.setTicker("MSFT");
        order.setPrice((float)123.45);
        order.setDirection(Direction.BUY);
        assertEquals(1000, order.getQuantity());
        assertEquals("MSFT", order.getTicker());
        assertEquals((float)123.45, order.getPrice());
        assertEquals(Direction.BUY, order.getDirection());
        assertNotNull(order.getTransaction());
    }
}