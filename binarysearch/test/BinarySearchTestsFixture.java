import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinarySearchTestsFixture 
{
  // Create a clean testing environment using a test fixture
  private BinarySearch binarySearch;
  
  @BeforeEach
  void setUp() {
    this.binarySearch = new BinarySearch();
  }
  
  @AfterEach
  void tearDown() {
    this.binarySearch = null;
  }
  
  @Test 
  void testNotFound() {
    int[] arr = { 0, 2, 4, 6, 8 };
    int pos = -1;
    int i = 1;
    int result = this.binarySearch.search(arr, i);
    assertEquals(pos, result);
  }

  @DisplayName("Tests if binary search finds an element in the array.")
  @Test
  public void testFound() {
    int[] arr = { 0, 2, 4, 6, 8 };
    int pos = 1;
    int i = arr[pos];
    int result = this.binarySearch.search(arr, i);
    assertEquals(pos, result);
  }
}
