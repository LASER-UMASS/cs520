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
    public void invalidNegative() {
        Type actualNegative = Triangle.classify(-1, 10, 10);
        Type expected = INVALID;
        assertEquals(actualNegative, expected);
    }

    @Test
    public void invalidZero() {
        Type actualZero = Triangle.classify(0, 0, 0);
        Type expected = INVALID;
        assertEquals(actualZero, expected);

    }

    @Test
    public void invalidImpossible() {
        Type actualImpossible = Triangle.classify(1, 2, 10);
        Type expected = INVALID;
        assertEquals(actualImpossible, expected);
    }


    @Test
    public void scalene() {
        Type actual = Triangle.classify(5, 6, 7);
        Type expected = SCALENE;
        assertEquals(actual, expected);
    }

    @Test
    public void isoscelesAB() {
        Type actualAB = Triangle.classify(5, 5, 6);
        Type expected = ISOSCELES;
        assertEquals(actualAB, expected);
    }

    @Test
    public void isoscelesBC() {
        Type actualBC = Triangle.classify(6, 5, 5);
        Type expected = ISOSCELES;
        assertEquals(actualBC, expected);
    }

    @Test
    public void isoscelesAC() {
        Type actualAC = Triangle.classify(5, 6, 5);
        Type expected = ISOSCELES;
        assertEquals(actualAC, expected);
    }
}
