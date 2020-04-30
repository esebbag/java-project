package tests;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import primitives.*;

public class RayTest
{

	@Test
	public void testEqualsObject() 
	{
		Coordinate c1 = new Coordinate(1.0);
		Coordinate c2 = new Coordinate(1.0);
		Coordinate c3 = new Coordinate(1.0);
		
		Point3D p1 = new Point3D(c1,c2,c3);
		Vector d1 = new Vector(p1);
		Ray r1 = new Ray(p1,d1);
		
		Point3D p2 = new Point3D(c1,c2,c3);
		Vector d2 = new Vector(p2);
		Ray r2 = new Ray(p2,d2);
		
		assertEquals(r1, r2);
	}

}