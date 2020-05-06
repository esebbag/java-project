/**
 * 
 */
package unitTest;

import static org.junit.Assert.*;

import primitives.*;
import geometries.*;

import geometries.Polygon;
import org.junit.Test;

/**
 * Unit tests for primitives.Vector class
 * @author Tsipora Bembaron
 *
 */
public class VectorTest {
	
	 /**
     * test for vector subtraction function @link primitives.Vector# subtract(primitves.Vector);}.
     */
	 @Test
	    void subtract()
	    {
	      Vector v1 = new Vector(1.0, 1.0, 1.0);
	      Vector v2 = new Vector(-1.0, -1.0, -1.0);

	      Vector v3=v1.subtract(v2);
	      assertTrue(v3.equals(new Vector(2.0,2.0,2.0)) );

	      Vector v4=v2.subtract(v3);
	      assertTrue(v4.equals(new Vector(-3.0,-3.0,-3.0)) );

	    }
	 
	 /**
	     * test for vector addition function @link primitives.Vector# add(primitves.Vector);}.
	     */
	    @Test
	    void add() {

	        Vector v1 = new Vector(1.0, 1.0, 1.0);
	        Vector v2 = new Vector(-2.0, -2.0, -2.0);

	        v1 = v1.add(v2);
	        assertTrue(v1.equals(new Vector(-1.0,-1.0,-1.0)) );

	        v2 = v2.add(v1);
	        assertTrue(v2.equals(new Vector(-3.0,-3.0,-3.0)) );
	    }
	    
	    /**
	     * test for vector scaling function @link primitives.Vector# subtract(double);}.
	     */
	    @Test
	    void scale() {
	        Vector v1 = new Vector(1.0, 1.0, 1.0);

	        v1.scale(1);
	        assertTrue(v1.equals(v1));
	       Vector v2=v1.scale(2);
	        assertTrue(v2.equals(new Vector(2.0, 2.0, 2.0)));
	        Vector v3=v2.scale(-2);
	       assertTrue(v3.equals(new Vector(-4.0,-4.0,-4.0)));
	    }
	    
	    /**
	     * test for vector dot product function @link primitives.Vector# dotProduct(primitves.Vector);}.
	     */
		@Test
	    void dotProduct() {
	        Vector v1 = new Vector(2,7.5,-5);
	        Vector v2 = new Vector(3.5,4,1);

	        assertTrue(Double.compare(v1.dotProduct(v2), (7 + 30 + -5)) == 0);
	        Vector v3 = new Vector(2, 3, 4);
	        Vector v4 = new Vector(-1, -3, -2);
	        assertEquals(v3.dotProduct(v4),-19);
	    }
	

	/**
	 * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
	 */
	@Test
    public void testCrossProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-2, -4, -6);

        // ============ Equivalence Partitions Tests ==============
        Vector v3 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v3);

        // Test that length of cross-product is proper (orthogonal vectors taken for simplicity)
        assertEquals("crossProduct() wrong result length", v1.length() * v3.length(), vr.length(), 0.00001);

        // Test cross-product result orthogonality to its operands
        assertTrue("crossProduct() result is not orthogonal to 1st operand", isZero(vr.dotProduct(v1)));
        assertTrue("crossProduct() result is not orthogonal to 2nd operand", isZero(vr.dotProduct(v3)));

        // =============== Boundary Values Tests ==================
        // test zero vector from cross-productof co-lined vectors
        try {
            v1.crossProduct(v2);
            fail("crossProduct() for parallel vectors does not throw an exception");
        } catch (Exception e) {}
    }


	private boolean isZero(double dotProduct) {
		
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Test method for {@link primitives.Vector#subtract(primitives.Point3D)}.
	 */
	@Test
	public void testAdd() {
		Vector v1= new Vector (0.0,1.0,0.0);
		Vector v2= new Vector (1.0,0.0,0.0);
		
		Vector v3= v1.add(v2);
		assertEquals(new Vector (1.0, 1.0,0.0),v3);
		 
		
		fail("Not yet implemented");
	}

	
	/**
	 * Test method for {@link primitives.Vector#lengthSquared()}.
	 */
	@Test
	public void testLengthSquared() {
		
		Vector v1= new Vector(1,2,3);
		assertTrue (v1.lengthSquared()==(1+4+9));
		
		
	    assertEquals(new Vector(2,4,0).lengthSquared(),20);		
	}

	/**
	 * Test method for {@link primitives.Vector#normalize()}.
	 */
	@Test
	public void testNormalize() {
		
		Vector v1=new Vector(0,3,4);
		Vector vr= new Vector(0,3/5,4/5);
		
		try {
		assertEquals(v1.normalize() , vr);
		}
		
		catch(ArithmeticException e) {
			fail("the vectors should be equals");
		}
		
		Vector v2=new Vector(2,3,4);
		v2.normalize();
		
		Vector v3= new Vector(2/Math.sqrt(29),3/Math.sqrt(29),4/Math.sqrt(29));		
		assertTrue(v2.equals(v3));
		
		Vector v4= new Vector(1, 2, 3);
        Vector v4Copy = new Vector(v4);
        Vector v4CopyNormalize = v4Copy.normalize();
        assertTrue(v4CopyNormalize.equals(v4Copy));	
		
	}

	/**
	 * Test method for {@link primitives.Vector#normalized()}.
	 */
	@Test
	public void testNormalized() {
		
		Vector v1=new Vector (1,2,3);
		Vector vr= v1.normalized();
		Vector v2=new Vector (1/Math.sqrt(14), 2/Math.sqrt(14),3/Math.sqrt(14));
		assertTrue(vr.equals(v2));
		
		Vector v3= new Vector (1,0,2);
		Vector v= vr.normalized();
		assertTrue(!v3.equals(v));
	}
}

