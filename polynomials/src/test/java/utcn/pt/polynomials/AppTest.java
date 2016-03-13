package utcn.pt.polynomials;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import utcn.pt.polynomials.polynomial.Polynom;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
		// TODO Create Test environment
		Polynom P = new Polynom();
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp1() {
		// TODO Create test
		Assert.assertEquals("abcd", "abc");

	}

	public void testApp2() {
		// TODO Create test
		Assert.assertEquals("abc", "abcd");

	}

	public void testApp3() {
		// TODO Create test
		Assert.assertEquals("abc", "abc");

	}
}
