package de.hfu;
import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.Assert;

public class UtilTest {

	@Test
	public void testIstErstesHalbjahr() {
		
		Assert.assertEquals(true, Util.istErstesHalbjahr(1));
		Assert.assertEquals(true, Util.istErstesHalbjahr(2));
		Assert.assertEquals(true, Util.istErstesHalbjahr(3));
		Assert.assertEquals(true, Util.istErstesHalbjahr(4));
		Assert.assertEquals(true, Util.istErstesHalbjahr(5));
		Assert.assertEquals(true, Util.istErstesHalbjahr(6));
		
		
		//ab hier false
		
		Assert.assertEquals(false, Util.istErstesHalbjahr(7));
		Assert.assertEquals(false, Util.istErstesHalbjahr(8));
		Assert.assertEquals(false, Util.istErstesHalbjahr(9));
		Assert.assertEquals(false, Util.istErstesHalbjahr(10));
		Assert.assertEquals(false, Util.istErstesHalbjahr(11));
		Assert.assertEquals(false, Util.istErstesHalbjahr(12));
		
		
		
	}
	
}
