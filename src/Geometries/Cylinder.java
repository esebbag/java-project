package Geometries;

	import primitives.*;

	public class Cylinder extends Tube{
		
		double _height;
		
		public Cylinder (Ray r, double d, double e)
		{
			super (r,d);
			this._height=e;
		}
		
		public Cylinder (Ray r, RadialGeometry rad, double d)
		{
			super(r,rad);
			this._height=d;
		}
		
		public double getHeight()
		{
			return _height;
		}
		
		public Vector getNormal(Point3D p)
		{
			return null;
		}

		@Override
		public String toString() {
			return "Cylinder [_height=" + _height + ", _axisRay=" + _axisRay + ", _radius=" + _radius + ", getHeight()="
					+ getHeight() + ", getRay()=" + getRay() + ", getRadius()=" + getRadius() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cylinder other = (Cylinder) obj;
			if (Double.doubleToLongBits(_height) != Double.doubleToLongBits(other._height))
				return false;
			return true;
		}

	}


}
