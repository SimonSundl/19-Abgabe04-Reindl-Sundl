package at.fhj.iit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class StringQueueTest {

    private StringQueue test;

    /**
     * Build a StringQueue.
     */
    @Before
    public void setup(){
        test = new StringQueue();
    }

    @Test
    public void simple(){
        test.offer("Hi");
        test.offer("Hello");
        test.offer("Ciao");
        test.offer("Hallo");
        test.offer("Servus");
        Assert.assertEquals("Hi", test.remove());
        Assert.assertEquals("Hello", test.remove());
        Assert.assertEquals("Ciao", test.remove());
        Assert.assertEquals("Hallo", test.remove());
        Assert.assertEquals("Servus", test.remove());
    }

    @Test(expected = NoSuchElementException.class)
    public void noSuchElement(){
        test.remove();
    }

    @Test
    public void size(){
        StringQueue test2 = new StringQueue(1);
        test2.offer("Testing");
        Assert.assertEquals(1, test2.getMaxSize());
        Assert.assertEquals(5, test.getMaxSize());
        Assert.assertEquals("Testing", test2.poll());
    }

    @Test
    public void nullTests(){
        test.offer(null);
        Assert.assertEquals("nullValue", test.remove());
        Assert.assertNull(test.peek());
        Assert.assertNull(test.poll());
    }
}
