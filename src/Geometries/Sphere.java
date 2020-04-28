package Geometries;
import primitives.*;

public class Sphere extends RadialGeometry {
	Point3D center;
	
	public Sphere (Point3D p, double d)
	{
		super (d);
		this.center= p;
	}
	
	public Sphere (Point3D p, RadialGeometry other)
	{
		super (other);
		this.center= p;
	}
	
	public Point3D getCenter ()
	{
		return center;
	}
	 
	public Vector getNormal(Point3D c)
	{
		return null;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sphere other = (Sphere) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sphere [center=" + center + ", _radius=" + _radius + ", getCenter()=" + getCenter() + ", getRadius()="
				+ getRadius() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	

}
