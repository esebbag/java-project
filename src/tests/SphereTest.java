package tests;
import primitives.*;
import Geometries.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * sphere tests
 */
class SphereTest {
    /**
     * test for sphere get normal @link geometries.Sphere# getNormal(primitves.Point3D)}.
     */
    @Test
    void getNormal() {
        Sphere s = new Sphere(new Point3D(0,0,0), 2);


        assertTrue(s.getNormal(new Point3D(0,0,2)).equals(new Vector(new Point3D(0,0,1))));
        assertTrue(s.getNormal(new Point3D(0,0,-2)).equals(new Vector(new Point3D(0,0,-1))));
        assertTrue(s.getNormal(new Point3D(0,2,0)).equals(new Vector(new Point3D(0,1,0))));
        assertTrue(s.getNormal(new Point3D(0,-2,0)).equals(new Vector(new Point3D(0,-1,0))));
        assertTrue(s.getNormal(new Point3D(2,0,0)).equals(new Vector(new Point3D(1,0,0))));
        assertTrue(s.getNormal(new Point3D(-2,0,0)).equals(new Vector(new Point3D(-1,0,0))));

    }


}