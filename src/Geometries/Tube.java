package Geometries;
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
	
	public Vector getNormal (Point3D p)
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
	
	
	
	

}
