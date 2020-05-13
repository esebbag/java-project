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
	public List<Point3D> findIntersections(Ray ray)
	{
		ArrayList<Point3D> intersectionPoint = null;
		Vector n = new Vector(_normal);
		Vector pq = new Vector(_p);
		
		try
		{
			pq = pq.subtract(new Vector(ray.getPoint()));
		}
		catch(IllegalArgumentException e) // this means that the ray starts at the exact point that resembles the plane and that is why we'll get ZERO vector from subtraction
		{
			return intersectionPoint;
		}
	 
		double mone = n.dotProduct(pq);
		double mechane = n.dotProduct(new Vector(ray.getVec()));
		if(isZero(mechane))
			return intersectionPoint;
		double t = alignZero(mone/mechane);
		 
		if( t > 0)
		{
			intersectionPoint = new ArrayList<Point3D>();
			
			//Vector vec = new Vector(ray.getDirection());
			//vec = vec.scale(t);//t1*vec
			//Point3D p = new Point3D(ray.get_Point());
			//p = p.add(vec);
			
			//refactor
			Point3D p = ray.getPoint(t);	
			
			intersectionPoint.add(p);
			return intersectionPoint;
		}
		
		return intersectionPoint;
	}

	
	@Override
	public String toString() {
		return "Plane [_p=" + _p + ", _normal=" + _normal + ", getClass()=" + getClass() + 
				 ", toString()=" + super.toString() + "]";
	}

	
	
	
}
