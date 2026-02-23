import java.util.Arrays;

public class BinarySearch 
{
  public BinarySearch() {
    super();
  }
	
  public int search(int[] arr, int k) {
    // 1. Sort
    int i, j, temp;
    boolean swapped;
    for (i = 0; i < arr.length - 1; i++) {
      swapped = false;
      for (j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          // Swap arr[j] and arr[j+1]
          temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swapped = true;
        }
      }	

      // If no two elements were
      // swapped by inner loop, then break
      if (swapped == false)
        break;
      }

      // 2. Search
      int low = 0;
      int high = arr.length - 1;
      while (low <= high) {
        int mid = low + (high - low) / 2;
        
        if (arr[mid] == k)
          // Found
          return mid;

          if (arr[mid] < k)
            low = mid + 1;
          else
            high = mid - 1;
        }

        // Not found
        return -1;
    }

    /**
     * Performs binary search on all of the elements of args
     * except the last one to look for the last element.
     *
     * @param args The first elements are the array to be searched and 
     *             the last element is the key to be searched for
     */             
    public static void main (String[] args) {
      int[] arr = new int[args.length - 1];
      for (int p = 0; p < args.length - 1; p++) {
        arr[p] = Integer.parseInt(args[p]);
      }
      int k = Integer.parseInt(args[args.length - 1]);
      BinarySearch binarySearch = new BinarySearch();
      System.out.println("arr: " + Arrays.toString(arr));
      System.out.println("k: " + k);
      int result = binarySearch.search(arr, k);
      System.out.println("result: " + result);
    }
}
