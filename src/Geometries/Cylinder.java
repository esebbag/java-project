package geometries;
import java.util.List;

import primitives.*;

public class Cylinder extends Tube
{
	/**
	 * cylinder has height, radius, and a ray
	 */
	private double _height;
	
	public Cylinder(double h, double radius, Ray ray)
	{
		
		super(ray, radius);
		try
		{		
			if(h > 0)
				_height = h;
			else
				throw new IllegalArgumentException("the height of a Cylinder cannot be zero or nagitive");
		}
		catch(IllegalArgumentException ex)
		{
			System.out.println(ex);
		}					
	}
	
	/**
	 * @param Point3D
	 * @return Vector
	 */
	public Vector getNormal(Point3D a)
	{
		Point3D center = this._axisRay.getPoint();
		Coordinate newZ = new Coordinate(center.getZ().get() + a.getZ().get());
		Point3D highCenterPoint = new Point3D(center.getX(), center.getY(), newZ);
		
		Vector normal = new Vector(a.subtract(highCenterPoint));
		normal.normalize();
		
		return normal;
	}
	
	@Override
	public List<Point3D> findIntersections(Ray ray)
	{
		return null;
	}
}

