package Q1;

import junit.framework.Assert;
import junit.framework.TestCase;


public class VectorTest extends TestCase {
    private String fullName;

    public VectorTest(String name) {
		super(name);
		this.fullName = getClass() + ", " + name + "()";
    }

    private static void checkInitAndGetters( double x, double y, double z) {
		int length;
		Vector v = new Vector(x,y,z);

		Assert.assertEquals("Constructor and getter test: Creating a vector with " + x + " " + y + " " + z + " and getting its values. The x coordinate is not correct.",  x, v.getX());
		Assert.assertEquals("Constructor and getter test: Creating a vector with " + x + " " + y + " " + z + " and getting its values. The y coordinate is not correct.",  y, v.getY());
		Assert.assertEquals("Constructor and getter test: Creating a vector with " + x + " " + y + " " + z + " and getting its values. The z coordinate is not correct.",  z, v.getZ());
    }

    private static void checkAddVectors(Vector v, double x, double y, double z) {
		Assert.assertEquals("Add Vector Test: The x coordinate is not what it should be", x, v.getX());
		Assert.assertEquals("Add Vector Test: The y coordinate is not what it should be", y, v.getY());
		Assert.assertEquals("Add Vector Test: The z coordinate is not what it should be", z, v.getZ());
    }

    private static void checkValues(String testName, double expected, double actual) {
		Assert.assertEquals(testName + "Value is not what it should be", expected, actual);
    }


    public void testInitializationAndGetters()
    {
		double x, y, z;

		for (z = -10; z < 10; z= z+.25 ) {
			for (y = -10; y < 10; y = y +.25) {
				for (x = -10; x < 10; x = x + .25) {
					checkInitAndGetters(x,y,z);
				}
			}
		}
    }

    public void testAddVectors()
    {
		Vector v1 = new Vector(3,1.3,6);
		Vector v2 = new Vector(2,7,8);
		Vector v3 = new Vector(-2,-7.5,2.6);

		checkAddVectors(v1.add(v2), 5, 8.3, 14);
		checkAddVectors(v1.add(v3), 1, -6.2, 8.6);

    }

    public void testDotProduct()
    {
		Vector v1 = new Vector(4,2,1);
		Vector v2 = new Vector(2,-2,5);
		Vector v3 = new Vector(0,0,0);
		Vector v4 = new Vector(-2, 2, 0);
		Vector v5 = new Vector(1,1,1);

		String testName = "Dot product test";

		checkValues(testName, 9, v1.dotProduct(v2));
		checkValues(testName, 0, v1.dotProduct(v3));
		checkValues(testName, -4, v1.dotProduct(v4));
		checkValues(testName, 7, v1.dotProduct(v5));

		checkValues(testName, 0, v2.dotProduct(v3));
		checkValues(testName, -8, v2.dotProduct(v4));
		checkValues(testName, 5, v2.dotProduct(v5));

		checkValues(testName, 0, v3.dotProduct(v4));
		checkValues(testName, 0, v3.dotProduct(v5));
		checkValues(testName, 0, v4.dotProduct(v5));
    }

    public void testGetMagnitude()
    {
		Vector v1 = new Vector(3,4,0);
		Vector v2 = new Vector(1,3,5);
		Vector v3 = new Vector(0,0,0);
		Vector v4 = new Vector(-2, 2, 0);
		Vector v5 = new Vector(1,1,1);
		String testName = "Calculate Magnitude test";

		checkValues(testName, 5, v1.calculateMagnitude());
		checkValues(testName, Math.sqrt(35), v2.calculateMagnitude());
		checkValues(testName, 0, v3.calculateMagnitude());
		checkValues(testName, Math.sqrt(8), v4.calculateMagnitude());
		checkValues(testName, Math.sqrt(3), v5.calculateMagnitude());
    }

    public void testNormalize()
    {
		Vector v1 = new Vector(0,0,0);
		Vector v2 = new Vector(1,2,3);

		String testName = "Test normalize: One of the values after normalizing is not correct";

		v1.normalize();
		v2.normalize();

		checkValues(testName, 0, v1.getX());
		checkValues(testName, 0, v1.getY());
		checkValues(testName, 0, v1.getZ());

		checkValues(testName, 1.0 / Math.sqrt(14), v2.getX());
		checkValues(testName, 2.0 / Math.sqrt(14), v2.getY());
		checkValues(testName, 3.0 / Math.sqrt(14), v2.getZ());
    }

    public void testProjectOnto()
    {
		Vector v1 = new Vector(3,4,0);
		Vector v2 = new Vector(1,3,5);
		Vector v3 = new Vector(0,0,0);
		Vector v4 = new Vector(-2, 2, 0);
		Vector v5 = new Vector(1,1,1);
		String testName = "Calculate ProjectOnto test";


    }

    public static void main(String[] args) {
		junit.swingui.TestRunner.run(VectorTest.class);
    }
}
