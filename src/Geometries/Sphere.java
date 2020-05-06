package geometries;
import java.util.ArrayList;
import java.util.List;

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
	 
	 public Vector getNormal(Point3D p)
	    {
	        Vector orthogonal = new Vector(p.subtract(this.center));
	        return orthogonal.normalized();
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

	@Override
	public List<Point3D> findIntersections(Ray ray) {
		ArrayList <Point3D> intersection = null;
		Vector l = new Vector(_center);//(2,2,2)
		
		try
		{
			l = l.subtract(new Vector(ray.get_Point()));
		}
		catch(IllegalArgumentException e)
		{
			 // in case the ray starts in the center of the sphere, 
			// the intersection point will be: P = O + r*V
			
			//after refactoring
			Point3D p = ray.getPoint(this._radius);
			
			//Vector Radius_Mult_V =  new Vector(ray.getDirection());
			//Radius_Mult_V = Radius_Mult_V.scale(_radius);
			//Point3D p = new Point3D(_center.add(Radius_Mult_V));
									
			intersection = new ArrayList<Point3D>();
			intersection.add(p);
			return intersection;				
		}
		double t_m = l.dotProduct(ray.getDirection());
		double d = Math.sqrt(l.dotProduct(l)-t_m*t_m); 
		
		if(d>_radius) // there are no intersections
			return null;
		 
		double t_h = Math.pow((Math.pow(_radius, 2)-(Math.pow(d,2))),0.5);
		double t1 = Util.alignZero(t_m-t_h);//2-1=1
		double t2 = Util.alignZero(t_m+t_h);//2+1=3
		
		
		if(t1 > 0)
		{
			intersection = new ArrayList<Point3D>();
			//Vector v1 = new Vector(ray.getDirection());
			//v1 = v1.scale(t1);//t1v
			//Point3D p1 = new Point3D(ray.get_Point());
			//p1 = p1.add(v1);
			
			//after refactoring
			Point3D p1 = ray.getPoint(t1);
			
			
			intersection.add(p1);			
		}
		
		if(t2 > 0)
		{
			//Vector v2 = new Vector(ray.getDirection());
			//v2 = v2.scale(t2);//t2v
			//Point3D p2 = new Point3D(ray.get_Point());
			//p2 = p2.add(v2);
			
			Point3D p2 = ray.getPoint(t2);
						
			if(intersection == null)
				intersection = new ArrayList<Point3D>();
			
			intersection.add(p2);
		}
			
		return intersection;

		}
	}
	
	
	
	

}
