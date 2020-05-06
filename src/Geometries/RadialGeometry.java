package geometries;

public abstract class RadialGeometry implements Geometry {
     double _radius;
     
     public RadialGeometry (double r)
     {
    	 this._radius=r;
     }
     
     public RadialGeometry (RadialGeometry other)
     {
    	 this._radius=other._radius;
     }
     
     public double getRadius()
     {
    	 return _radius;
     }   
}
