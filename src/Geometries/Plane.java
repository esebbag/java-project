package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

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
	public List<Point3D> findIntersections(Ray ray) {
		 Vector v;
	        try {
	            v= _p.subtract(ray.getPoint());
	        } catch (IllegalArgumentException e) {
	            return null; // ray starts from point Q - no intersections
	        }
	        double n = _normal.dotProduct(ray.getVec());
	        if (isZero(n)) // ray is parallel to the plane - no intersections
	            return null;

	        double a = alignZero(_normal.dotProduct(v) / n);
	         if(a<=0)
	             return null;
	        return List.of(ray.getFinalPoint(a));
	}

	
	@Override
	public String toString() {
		return "Plane [_p=" + _p + ", _normal=" + _normal + ", getClass()=" + getClass() + 
				 ", toString()=" + super.toString() + "]";
	}

	
	
	
}
