package triangle;

import static org.junit.Assert.*;
import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

import org.junit.Test;

public class TriangleTestMutant extends TriangleTestBranch {

    public void testNegativeDimensions() {
		super.testNegativeDimensions();
		Type actual4 = Triangle.classify(-1, 1, 1);
		Type expected = INVALID;
		assertEquals(actual4, expected);
	}

	@Test
	public void testZeroDimensions() {
        Type actual1 = Triangle.classify(0, 1, 1);
		Type actual2 = Triangle.classify(1, 0, 1);
		Type actual3 = Triangle.classify(1, 1, 0);

		Type expected = INVALID;
        assertEquals(actual1, expected);
		assertEquals(actual2, expected);
		assertEquals(actual3, expected);
	}

    @Test
	public void testScalene() {
		super.testScalene();
        Type actual5 = Triangle.classify(2, 3, 5);
        Type actual6 = Triangle.classify(2, 5, 3);
		Type actual7 = Triangle.classify(7, 2, 4);
		Type actual8 = Triangle.classify(5, 2, 3);

        Type expected = INVALID;

        assertEquals(actual5, expected);
        assertEquals(actual6, expected);
		assertEquals(actual7, expected);
		assertEquals(actual8, expected);

		Type actual9 = Triangle.classify(6, 4, 3);
		expected = SCALENE;

		assertEquals(actual9, expected);
    }

	@Test
	public void testIsosceles() {
		super.testIsosceles();
		Type actual7 = Triangle.classify(3, 3, 6);
		Type actual8 = Triangle.classify(6, 3, 3);
		Type actual9 = Triangle.classify(3, 6, 3);
		Type expected = INVALID;
		assertEquals(actual7, expected);
		assertEquals(actual8, expected);
		assertEquals(actual9, expected);
	}

}