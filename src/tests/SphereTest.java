package tests;

import Geometries.Sphere;
import primitives.Point3D;
import primitives.Vector;
public class SphereTest
{

	@Test
	public void testGetNormal() 
	{
		Point3D p = new Point3D(2, 3, 4);
		Point3D p1 = new Point3D(2+4, 3, 4);
		Sphere s = new Sphere(p1, 4);		
		
		//============ Equivalence Partitions Tests 
		Vector normal = new Vector(p1.subtract(p));
		normal.normalize();
		Vector vec = new Vector(1, 0, 0);
		assertEquals("Error, Sphere - GetNormal(), wrong result", vec, normal);			
	}
}
