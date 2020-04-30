package Geometries;
import primitives.*;

public class Plane implements Geometry {

	Point3D _p;
	Vector _normal;

	public Plane(Point3D _p, Vector vec1) {
		super();
		this._p = _p;
		this._normal = vec1;
	}

	public Plane(Point3D p1, Point3D p2, Point3D p3) {
		_p=new Point3D(p1.getX(),p1.getY(),p1.getZ());
		  this._normal=null;
	        this._p=p1;
	}

	public Vector get_normal() {
		return _normal;
	}
	
	 public Vector getNormal(Point3D p) {
		  return _normal;	    }

	@Override
	public String toString() {
		return "Plane [_p=" + _p + ", _normal=" + _normal + ", getClass()=" + getClass() + 
				 ", toString()=" + super.toString() + "]";
	}

	
	
	
}
