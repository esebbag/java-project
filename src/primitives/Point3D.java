package primitives;

public class Point3D {
	Coordinate x,y,z;

public Point3D(Coordinate x, Coordinate y, Coordinate z) {
	this.x = x;
	this.y = y;
	this.z = z;
}

public Point3D(double x, double y, double z) {
	this(new Coordinate(x), new Coordinate(y), new Coordinate(z));
}

public final static Point3D ZERO=new Point3D(0.0,0.0,0.0);

public Coordinate getX() {
	return new Coordinate(x);
}


public Coordinate getY() {
	return new Coordinate(y);
}


public Coordinate getZ() {
	return new Coordinate(z);
}




public Vector subtract(Point3D p) {
	
	return new Vector(new Point3D(
			p.x._coord-this.x._coord,
			p.y._coord-this.y._coord,
			p.z._coord-this.z._coord
			));
}

public Point3D add(Vector v)
{
	return new Point3D(
			this.x._coord+v._head.x._coord, 
			this.y._coord+v._head.y._coord, 
			this.z._coord+v._head.z._coord);
}


@Override
public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null||getClass() != obj.getClass())
		return false;
	Point3D other = (Point3D) obj;
	return x.equals(other.x)&&
			y.equals(other.y)&&
			z.equals(other.z);
}

@Override
public String toString() {
	return "Point3D [x=" + x + ", y=" + y + ", z=" + z + ", getX()=" + getX() + ", getY()=" + getY() + ", getZ()="
			+ getZ() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
			+ "]";
}


}





