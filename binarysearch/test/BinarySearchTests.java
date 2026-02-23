import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinarySearchTests 
{
  @Test 
  void testNotFound() {
    BinarySearch binarySearch = new BinarySearch();
    int[] arr = { 0, 2, 4, 6, 8 };
    int pos = -1;
    int i = 1;
    int result = binarySearch.search(arr, i);
    assertEquals(pos, result);
  }

  @DisplayName("Tests if binary search finds an element in the array.")
  @Test
  public void testFound() {
    BinarySearch binarySearch = new BinarySearch();
    int[] arr = { 0, 2, 4, 6, 8 };
    int pos = 1;
    int i = arr[pos];
    int result = binarySearch.search(arr, i);
    assertEquals(pos, result);
  }
}
