package pl.edu.uj.generics;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PriorityQueTest {
    @Test
    public void testPriorityQueueIntegerOfPDF() throws Exception {
        PriorityQueue<Integer> intQueue = new PriorityQueue<>();
        intQueue.add(12, 1);
        intQueue.add(11, 5);
        var value = intQueue.get();
        Assert.assertEquals(11, value.intValue());
    }

    @Test
    public void testPriorityQueueIntegerMyOwn() throws Exception {
        PriorityQueue<Integer> intQueue = new PriorityQueue<>();
        intQueue.add(1, 1);
        intQueue.add(8, 2);
        intQueue.add(3, 2);
        intQueue.add(54, 2);
        intQueue.add(57, 2);
        intQueue.add(12, 2);

        Assert.assertEquals(8, (int) intQueue.get());
    }

    @Test
    public void testPriorityQueueString() throws Exception {
        PriorityQueue<String> strQueue = new PriorityQueue<>();
        strQueue.add("Litwo", 1);
        strQueue.add("ojczyzno", 2);
        strQueue.add("moja", 3);
        strQueue.add("ty,", 1);
        strQueue.add("jesteś", 2);
        strQueue.add("jak", 1);
        strQueue.add("zdrowie", 2);

        Assert.assertEquals("moja", (String) strQueue.get());
    }

    @Test
    public void testPriorityQueueStringException(){
        PriorityQueue<String> strQueue = new PriorityQueue<>();
        try {
            strQueue.get();
            fail();
        } catch (Exception e) {
            assertEquals("EmptyQueueException", e.getMessage());
        }

    }
}
