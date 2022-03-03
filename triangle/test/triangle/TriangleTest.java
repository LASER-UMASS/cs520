package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

/**
 * Test class for the Triangle implementation.
 */
public class TriangleTest {

    @Test
    public void equilateral() {
        Type actual = Triangle.classify(10, 10, 10);
        Type expected = EQUILATERAL;
        assertEquals(actual, expected);
    }

    @Test
    public void invalidTriangle() {
        Type actualNegative = Triangle.classify(-1, 10, 10);
        Type actualZero = Triangle.classify(0, 0, 0);
        Type actualImpossible = Triangle.classify(1, 2, 10);
        Type expected = INVALID;
        assertEquals(actualNegative, expected);
        assertEquals(actualZero, expected);
        assertEquals(actualImpossible, expected);
    }

    @Test
    public void scalene() {
        Type actual = Triangle.classify(5, 6, 7);
        Type expected = SCALENE;
        assertEquals(actual, expected);
    }

    @Test
    public void isosceles() {
        Type expected = ISOSCELES;
        Type actualAB = Triangle.classify(5, 5, 6);
        Type actualBC = Triangle.classify(6, 5, 5);
        Type actualAC = Triangle.classify(5, 6, 5);
        assertEquals(actualAB, expected);
        assertEquals(actualBC, expected);
        assertEquals(actualAC, expected);
    }
}