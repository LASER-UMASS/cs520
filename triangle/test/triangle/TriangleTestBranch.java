package triangle;

import static org.junit.Assert.*;
import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

import org.junit.Test;

public class TriangleTestBranch extends TriangleTestLine{
	@Test
	public void testInit() {
		super.testInit();
	}

	@Test
	public void testNegativeDimensions() {
		super.testNegativeDimensions();
		Type actual2 = Triangle.classify(1, -1, 1);
		Type actual3 = Triangle.classify(1, 1, -1);
		Type expected = INVALID;
		assertEquals(actual2, expected);
		assertEquals(actual3, expected);
	}

	@Test
	public void testScalene() {
		super.testScalene();
		Type actual3 = Triangle.classify(4, 1, 2);
		Type actual4 = Triangle.classify(2, 4, 1);
		Type expected = INVALID;
		assertEquals(actual3, expected);
		assertEquals(actual4, expected);
	}

	@Test
	public void testIsosceles() {
		super.testIsosceles();
		Type actual5 = Triangle.classify(3, 1, 1);
		Type actual6 = Triangle.classify(1, 3, 1);
		Type expected = INVALID;
		assertEquals(actual5, expected);
		assertEquals(actual6, expected);
	}

	@Test
	public void testEquilateral() {
		super.testInit();
	}
}
