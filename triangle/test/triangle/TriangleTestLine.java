package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

/**
 * Test class for the Line component.
 */
public class TriangleTestLine {

	@Test
	public void testInit() {
		Triangle t = new Triangle();
		assertEquals(t.classify(1, 1, 1), EQUILATERAL);
	}

	@Test
	public void testNegativeDimensions() {
		Type actual = Triangle.classify(-1, -1, -1);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testScalene() {
		// valid scalene
		Type actual1 = Triangle.classify(3, 4, 5);
		Type expected = SCALENE;
		assertEquals(actual1, expected);
		// invalid scalene
		Type actual2 = Triangle.classify(1, 2, 4);
		expected = INVALID;
		assertEquals(actual2, expected);
	}

	@Test
	public void testIsosceles() {
		// valid isosceles
		Type actual1 = Triangle.classify(3, 3, 5);
		Type actual2 = Triangle.classify(3, 5, 3);
		Type actual3 = Triangle.classify(5, 3, 3);
		Type expected = ISOSCELES;
		assertEquals(actual1, expected);
		assertEquals(actual2, expected);
		assertEquals(actual3, expected);
		// invalid isosceles
		Type actual4 = Triangle.classify(1, 1, 3);
		expected = INVALID;
		assertEquals(actual4, expected);
	}

	@Test
	public void testEquilateral() {
		Type actual = Triangle.classify(5, 5, 5);
		Type expected = EQUILATERAL;
		assertEquals(actual, expected);
	}
}