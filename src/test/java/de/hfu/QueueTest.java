package de.hfu;
import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.Assert;

public class QueueTest {

	@Test
	public void TestEnqueue() {
		
		Queue name = new Queue(3);
		name.enqueue(1);
		name.enqueue(2);
		name.enqueue(3);
		
		Assert.assertEquals(1, name.queue[0]);
		Assert.assertEquals(2, name.queue[1]);
		Assert.assertEquals(3, name.queue[2]);
		name.enqueue(4);
		Assert.assertEquals(4, name.queue[2]);
		
	}
	
	@Test
	public void TestDequeue() {
		
		Queue name = new Queue(3);
		name.enqueue(1);
		name.enqueue(2);
		name.enqueue(3);
		Assert.assertEquals(1,name.dequeue());
	}
	
	@Test
    public void testdequeueEmptyArray() {
        try {
            Queue q1 = new Queue(3);
            q1.dequeue();
            Assert.fail();
        } catch(IllegalStateException e) {
            Assert.assertEquals(e.getMessage(), "dequeue on empty queue");
        }
    }
	
	@Test
	public void testRing() {
		Queue name = new Queue(3);
		name.enqueue(1);
		name.enqueue(2);
		name.enqueue(3);
		name.dequeue();
		name.enqueue(3);
		Assert.assertEquals(3, name.queue[0]);
		name.enqueue(4);
		Assert.assertEquals(4, name.queue[0]);
	}
	
	
	
}
