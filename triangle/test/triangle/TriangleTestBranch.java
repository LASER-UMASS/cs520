package triangle;

import static org.junit.Assert.*;
import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

import org.junit.Test;

public class TriangleTestBranch {
	@Test
	public void testInit() {
		Triangle t = new Triangle();
		assertEquals(t.classify(1, 1, 1), EQUILATERAL);
	}

	@Test
	public void testNegativeDimensions() {
		Type actual1 = Triangle.classify(-1, -1, -1);
		Type actual2 = Triangle.classify(1, -1, 1);
		Type actual3 = Triangle.classify(1, 1, -1);
		Type expected = INVALID;
		assertEquals(actual1, expected);
		assertEquals(actual2, expected);
		assertEquals(actual3, expected);
	}

	@Test
	public void testScalene() {
		// valid scalene
		Type actual1 = Triangle.classify(3, 4, 5);
		Type expected = SCALENE;
		assertEquals(actual1, expected);
		// invalid scalene
		Type actual2 = Triangle.classify(1, 2, 4);
		Type actual3 = Triangle.classify(4, 1, 2);
		Type actual4 = Triangle.classify(2, 4, 1);
		expected = INVALID;
		assertEquals(actual2, expected);
		assertEquals(actual3, expected);
		assertEquals(actual4, expected);
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
		Type actual5 = Triangle.classify(3, 1, 1);
		Type actual6 = Triangle.classify(1, 3, 1);
		expected = INVALID;
		assertEquals(actual4, expected);
		assertEquals(actual5, expected);
		assertEquals(actual6, expected);
	}

	@Test
	public void testEquilateral() {
		Type actual = Triangle.classify(5, 5, 5);
		Type expected = EQUILATERAL;
		assertEquals(actual, expected);
	}
}
