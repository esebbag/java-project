package geometries;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

import geometries.*;

import java.util.Arrays;
import java.util.List;
import primitives.*;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;


/**
 * Polygon class represents two-dimensional polygon in 3D Cartesian coordinate
 * system
 * 
 * @author Dan
 */
public class Polygon implements Geometry {
	/**
	 * List of polygon's vertices
	 */
	protected List<Point3D> _vertices;
	
	/**
	 * Associated plane in which the polygon lays
	 */
	protected Plane _plane;

	/**
	 * Polygon constructor based on vertices list. The list must be ordered by edge
	 * path. The polygon must be convex.
	 * 
	 * @param vertices list of vertices according to their order by edge path
	 * @return 
	 * @throws IllegalArgumentException in any case of illegal combination of
	 *                                  vertices:
	 *                                  <ul>
	 *                                  <li>Less than 3 vertices</li>
	 *                                  <li>Consequent vertices are in the same
	 *                                  point
	 *                                  <li>The vertices are not in the same
	 *                                  plane</li>
	 *                                  <li>The order of vertices is not according
	 *                                  to edge path</li>
	 *                                  <li>Three consequent vertices lay in the
	 *                                  same line (180&#176; angle between two
	 *                                  consequent edges)
	 *                                  <li>The polygon is concave (not convex></li>
	 *                                  </ul>
	 */
	 public Polygon(Point3D... vertices) 
	    {
	        if (vertices.length < 3)
	            throw new IllegalArgumentException("A polygon can't have less than 3 vertices");
	        _vertices = new ArrayList<Point3D>();
	        // Generate the plane according to the first three vertices and associate the
	        // polygon with this plane.
	        // The plane holds the invariant normal (orthogonal unit) vector to the polygon
	        _plane = new Plane(vertices[0], vertices[1], vertices[2]);
	        
	        if (vertices.length == 3)
	        {
	        	_vertices.add(vertices[0]);
	        	_vertices.add(vertices[1]);
	        	_vertices.add(vertices[2]);
	        	return; // no need for more tests for a Triangle
	        }
	    }

	public boolean isZero(double dotProduct) {
		
		if(dotProduct==0)
			return true;
		
	    return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polygon other = (Polygon) obj;
		if (_plane == null) {
			if (other._plane != null)
				return false;
		} else if (!_plane.equals(other._plane))
			return false;
		if (_vertices == null) {
			if (other._vertices != null)
				return false;
		} else if (!_vertices.equals(other._vertices))
			return false;
		return true;
	}
	
	
	public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersections = _plane.findIntersections(ray);
        if (intersections == null) return null;

        Point3D p = ray.getPoint();
        Vector v = ray.getVec();

        Vector v1  = _vertices.get(1).subtract(p);
        Vector v2 = _vertices.get(0).subtract(p);
        Vector crossProduct=v1.crossProduct(v2);
        double sign = v.dotProduct(crossProduct);
        if (isZero(sign))
            return null;

        boolean positive = sign > 0;

        for (int i = _vertices.size() - 1; i > 0; --i) {
            v1 = v2;
            v2 = _vertices.get(i).subtract(p);
            double dotProduct=v.dotProduct(v1.crossProduct(v2));
            sign = alignZero(dotProduct);
            if (isZero(sign))
                return null;
            if (positive != (sign >0))
                return null;
        }

        return intersections;
    }

	@Override
	public String toString() {
		return "polygon [_vertices=" + _vertices + ", _plane=" + _plane + "]";
	}

	@Override
	public Vector getNormal(Point3D point) {
		return _plane.getNormal(point);
	}
}