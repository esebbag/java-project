package primitives;

public class Ray {
	Point3D point;
	Vector vec;
	
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
		return point;
		
	}
	public Vector getVec()
	{ 
		return vec;
		
	}

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
