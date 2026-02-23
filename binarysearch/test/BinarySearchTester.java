public class BinarySearchTester 
{
  public void test() {
    BinarySearch binarySearch = new BinarySearch();
    int[] arr = { 9, 7, 5, 3, 1 };
    
    // Test not found
    int x = 4;
    int result = binarySearch.search(arr, x);
    assert -1 == result;
    
    // Test found
    x = 7;
    result = binarySearch.search(arr, x);
    assert 3 == result;
  }
  
  public static void main(String[] args) {
    BinarySearchTester tester = new BinarySearchTester();
    tester.test();
    // Checks that assertions are turned on
    assert false;
  }
}
