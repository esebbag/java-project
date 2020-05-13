package primitives;

public class Ray {
	private Point3D point;
	private Vector vec;
	
	public Ray (Point3D p, Vector v)
	{
		if (this.vec.normalize() == this.vec)
		{
		    this.point=p;
		    this.vec=v;
		}
		else
		{
			this.vec.normalize();
			this.point=p;
		    this.vec=v;		
		}
	}
	
	public Point3D getPoint()
	{
		return this.point;
	}
	
	public Point3D getPoint(double t2)
	{ 
		Vector v = this.getVec();
		Point3D p = new Point3D(this.point);
		p = p.add(v.scale(t2));
		
		return p;
		
	}
	
	
	public Vector getVec()
	{ 
		return vec;
		
	}
		
	
	public Point3D getFinalPoint(double length) {
        return Util.isZero(length ) ? point : point.add(vec.scale(length));}

	@Override
	public String toString() {
		return "Ray [point=" + point + ", vec=" + vec + ", getPoint()=" + getPoint() + ", getVec()=" + getVec()
				+ ", getClass()=" + getClass() +  ", toString()=" + super.toString()
				+ "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		return vec.equals(other.vec)&&point.equals(other.point);
		
	}



	

}
