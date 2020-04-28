package primitives;

public class Vector {
	
	 Point3D _head;
	 
	 /**
	     * Vector constructor
	     * @param x-coordinate
	     * @param y-coordinate
	     * @param z-coordinate
	     */
				
	public Vector (Coordinate a, Coordinate b, Coordinate c) {
		
		 if(new Point3D(a,b,c).equals(Point3D.ZERO))
	        {
	            throw new IllegalArgumentException("The vector is not valid");
	        }
	        this._head=new Point3D(a,b,c);
	}
	
	public Vector(Point3D p) {	
		
		if (p.equals(Point3D.ZERO))
		{
			throw new IllegalArgumentException("The Vector is not valid");
		}
		this._head=p;
	}
	
	/**
     * Vector Constructor
     * @param x-double
     * @param y-double
     * @param z-double
     */
	
	public Vector (double a, double b, double c) {
		

        if(new Point3D(new Coordinate(a),new Coordinate(b),new Coordinate(c)).equals(Point3D.ZERO))
        {
            throw new IllegalArgumentException("The Vector is not valid");
        }
        this._head=new Point3D(new Coordinate(a),new Coordinate(b),new Coordinate(c));
	}
	
	public Vector (Vector vec)
	{
		this._head=vec._head;
	}
	
	 public Point3D getPoint() {
			return _head;
		}
	

	public double dotProduct (Vector other)
	{
		
		double num= (this._head.x._coord) * (other._head.x._coord) + 
				    (this._head.y._coord) * (other._head.y._coord) + 
				    (this._head.z._coord) * (other._head.z._coord);
		return num;
	}
	
	public Vector crossProduct (Vector v)
	{
       return new Vector ((v._head.y._coord*this._head.z._coord-v._head.z._coord*this._head.y._coord),
    		              (v._head.z._coord*this._head.x._coord-v._head.x._coord*this._head.z._coord),
    		              (v._head.x._coord*this._head.y._coord-v._head.y._coord*this._head.x._coord));
	}
	
	public Vector subtract(Point3D p) {
		
		return new Vector(new Point3D(
				this._head.x._coord-_head.x._coord,
				this._head.y._coord-_head.y._coord,
				this._head.z._coord-_head.z._coord
				));
	}
	
	public Vector subtract (Vector v)
	{
		return new Vector ()
	}
	
    public Vector add(Point3D p) {
		
		return new Vector(new Point3D(
				this._head.x._coord+_head.x._coord,
				this._head.y._coord+_head.y._coord,
				this._head.z._coord+_head.z._coord
				));
	}
		
    public Vector add (Vector v) {
    	return new Vector (this._head.add(v));
    	  }
    
	public Vector scale ( double num)
	{
		return new Vector(this._head.x._coord*num,this._head.y._coord*num,this._head.z._coord*num);		
	}
	
	public double lengthSquared ()
	
	{
		double l= this._head.x._coord*this._head.x._coord
				 +this._head.y._coord*this._head.y._coord
			     +this._head.z._coord*this._head.z._coord;
		return l;
	}
	public double length()
	{
		double c = lengthSquared();
		double d= Math.sqrt(c);
		return d;
	}
	
	public Vector normalize()
	{
		double m=length();
		Vector v= new Vector ((this._head.x._coord)/m, (this._head.y._coord)/m,(this._head.z._coord)/m);
		return this;
	}
	
	public Vector normalized()
	{
		Vector vec= this.normalize();
		return vec;
		
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
		Vector other = (Vector) obj;
		return _head.equals(other._head);
	}

	@Override
	public String toString() {
		return "Vector [p=" + _head + "]";
	}
	
	
	
	
	

}
