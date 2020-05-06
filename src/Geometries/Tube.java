package geometries;
import java.util.List;

import primitives.*;

public class Tube extends RadialGeometry {	
	Ray _axisRay;
	
	public Tube (Ray r, double d)
	{
		super (d);
		this._axisRay=r;		
	}
	
	public Tube (Ray r, RadialGeometry g)
	{
		super (g);
		this._axisRay=r;		
	}
	
	public Ray getRay()
	{
		return _axisRay;
	}
	
	 public Vector getNormal(Point3D p) {
	        //The vector from the point of the cylinder to the given point
	        Vector vector1 = p.subtract(this._axisRay.getPoint());

	        //We need the projection to multiply the _direction unit vector
	        double projection = vector1.dotProduct(this._axisRay.getVec());

	        Vector vector2 = this._axisRay.getVec().scale(projection);

	        //This vector is orthogonal to the _direction vector.
	        Vector check = vector1.subtract(vector2);
	        return check.normalize();
	    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tube other = (Tube) obj;
		if (_axisRay == null) {
			if (other._axisRay != null)
				return false;
		} else if (!_axisRay.equals(other._axisRay))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "Tube [_axisRay=" + _axisRay + ", _radius=" + _radius + ", getRay()=" + getRay() + ", getRadius()="
				+ getRadius() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public List<Point3D> findIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
