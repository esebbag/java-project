package unitTest;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import geometries.Triangle;
import primitives.Point3D;
import primitives.Ray;
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

	@Test
	public void testFindIntersections()
	{
		Point3D a = new Point3D(0, 0, 1);
		Point3D b = new Point3D(0, 1, 0);
		Point3D c = new Point3D(1, 0, 0);
		
		Triangle tr = new Triangle(a , b, c);

		//============ Equivalence Partitions Tests ==============
		
		Ray ray1 = new Ray(new Point3D(0.5, 0.5,  0.5), new Vector(-1, -1, -1));
		List<Point3D> intersectionPoints1 = tr.findIntersections(ray1);		
		assertEquals("ERROR, there must be an intersection point", intersectionPoints1.size(), 1, 0.000001);
		
		//outside against edge
		Ray ray2 = new Ray(new Point3D(1, 1,  0), new Vector(0, 1, 0));
		//List intersectionPoints2 =  tr.findIntersections(ray2);
		
		assertEquals("ERROR, there must not be any intersection point", null, tr.findIntersections(ray2));
		
		//outside against vertex
		Ray ray3 = new Ray(new Point3D(0, 2,  0), new Vector(0, 0, -1));
		List<Point3D> intersectionPoints3 = tr.findIntersections(ray3);
		
		assertEquals("ERROR, there must not be any intersection point", null, intersectionPoints3);
		
		// =============== Boundary Values Tests ==================
			
		try
		{
			Ray ray4 = new Ray(new Point3D(1, 0,  0), new Vector(0, 1, 0));
			List<Point3D> intersectionPoints4 = tr.findIntersections(ray4);
			
			Ray ray5 = new Ray(new Point3D(1, 1,  0), new Vector(-1, -1, 0));
			List<Point3D> intersectionPoints5 = tr.findIntersections(ray5);
			
			Ray ray6 = new Ray(new Point3D(-0.5, 2,  0), new Vector(-1, 0, 0));
			List<Point3D> intersectionPoints6 = tr.findIntersections(ray6);
		}
		catch(Exception e)
		{
			fail("ERROR, there must be no intersections");
		}
		
		

	}
	
}
