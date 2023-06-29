package Q1;

public class Vector {
	// first define your member variables here. for example
	private double x;
    private double y;
    private double z;


	/*now define your constructor here */

    public Vector(double xcoord, double ycoord, double zcoord) {
        this.x = xcoord;
        this.y = ycoord;
        this.z = zcoord;
    }

	// finally define your methods here. For example:

	public double getX() {
        return x;
	}

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vector add (Vector v) {
        return new Vector((this.x + v.getX()), (this.y + v.getY()), (this.z + v.getZ()));
    }

    public double dotProduct (Vector v) {
        return (this.x * v.getX() + (this.y * v.getY()) + (this.z * v.getZ()));
    }

    public double calculateMagnitude () {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public void normalize () {
        double mag = this.calculateMagnitude();
        if (mag != 0) {
            this.x = this.x / mag;
            this.y = this.y / mag;
            this.z = this.z / mag;
        }
    }

    public void scaleVector (double factor) {
        this.x = this.x * factor;
        this.y = this.y * factor;
        this.z = this.z * factor;
    }

    public Vector projectOnto (Vector v) {
        double magV = v.calculateMagnitude();

        if (magV == 0) {
            return v;
        } else {
            Vector scaledVector = new Vector(v.getX(), v.getY(), v.getZ());
            scaledVector.scaleVector(this.dotProduct(v) / (magV * magV));
            return scaledVector;
        }
    }
}