package unitTest;
import primitives.*;

import org.junit.jupiter.api.Test;

import geometries.*;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.List;

/**
 * plane tests
 */
class PlaneTest {
    /**
     * test for plane get normal function @link geometries.Plane# getNormal(primitves.Point3D)}.
     */
    @Test
    void getNormal() {
        Point3D point=new Point3D(3, 2,0);
        Point3D vectorPoint=new Point3D(0,0,1);
        Vector v=new Vector(vectorPoint);
        Plane p=new Plane(point,v);
        assertEquals(p.getNormal(point),v);
    }
    
    
	

}