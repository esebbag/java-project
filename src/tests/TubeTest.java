package tests;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Geometries.Tube;
import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

public class TubeTest
{

	@Test
	public void testGetNormal() 
	{
		Point3D center = new Point3D(0,0,0);
		Vector d = new Vector(0,0,1);// the direction's vector
		Ray ray = new Ray(center, d);
		Tube tube = new Tube(ray, 25);
		
		Point3D p = new Point3D(25, 0, 1);
	 
        double t = p.subtract(center).dotProduct(d);
        
        Point3D o=null;    
        if (!Util.isZero(t))
        	 o = center.add(d.scale(t));
        
        //============ Equivalence Partitions Tests ==============
        Vector n = (p.subtract(o)).normalize();
        Vector vec = new Vector(1, 0, 0);
		
        assertEquals("ERROR, Tube's GetNormal() - wrong result ", vec, n);
				
	}

}
