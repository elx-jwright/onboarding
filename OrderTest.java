import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testOrderConstructorAndGetters() {
        Order order = new Order(1, "Sample Order", 3);
        assertEquals(1, order.getId());
        assertEquals("Sample Order", order.getName());
        assertEquals(3, order.getQuantity());
    }

    @Test
    void testOrderEquality() {
        Order order1 = new Order(1, "Order", 10);
        Order order2 = new Order(1, "Order", 10);
        assertEquals(order1, order2);
        assertEquals(order1.hashCode(), order2.hashCode());
    }
}