package Geometries;
import primitives.Point3D;

/**
 * Class Triangle
 */
public class Triangle extends Polygon {
     
	public Triangle (Point3D a, Point3D b, Point3D c)
	{
		/**
	     * Constructor of the triangle class
	     * @param p1
	     * @param p2
	     * @param p3
	     */
		super(a,b,c);
	}

	@Override
	public String toString() {
		return "Triangle [_vertices=" + _vertices + ", _plane=" + _plane + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
