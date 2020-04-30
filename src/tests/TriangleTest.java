package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import Geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;

public class TriangleTest
{

	@Test
	public void testGetNormal() 
	{
		Point3D a = new Point3D(1, 0, 0);
		Point3D b = new Point3D(0, 1, 0);
		Point3D c = new Point3D(0, 0, 1);
		
		Triangle tr = new Triangle(a , b, c);
		Vector normal = tr.getNormal(a); // the function that does receive a point	 
		 
		// ============ Equivalence Partitions Tests ============== 
		Vector v1 = new Vector(b.subtract(a));
		Vector v2 = new Vector(c.subtract(a));
		
		Vector v3 = v1.crossProduct(v2);
		Vector n = v3.normalize();// vector normal to plane
		
		assertEquals("Triangle, GetNormal() wrong result- this is not the normal", n, normal);
	}

}
