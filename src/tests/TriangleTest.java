package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import Geometries.Plane;
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
		Vector vec1 = new Vector(b.subtract(a));
		Vector vec2 = new Vector(c.subtract(a));
		
		Vector vec3 = vec1.crossProduct(vec2);
		Vector normalToPln = vec3.normalize();
		
		assertEquals("Triangle, GetNormal() wrong result- this is not the normal", normalToPln, normal);
	}

}
