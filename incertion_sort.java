import java.util.Arrays;
import java.util.Random;

public class incertion_sort {
    // Format Array to String
    public static String printArr(int[] arr){
        String output = "";
       for (int i = 0; i < arr.length; i++){
            output += arr[i];   
            output += " "; 
        } 
        return output;
    }
    // Main
    public static void main(String args[]){
        int[] arr = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20 };
        
        // SHUFFLE
        Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			int randomIndexToSwap = rand.nextInt(arr.length);
			int temp = arr[randomIndexToSwap];
			arr[randomIndexToSwap] = arr[i];
			arr[i] = temp;
		}
		System.out.print("Start List:     " + printArr(arr) + "\n\n");
		
		// SORT
		int[] newArr = Arrays.copyOf(arr, arr.length);
		for (int i = 1; i < arr.length; i++){
		    int top = newArr.length;
		    int bottom = -1;
		    while (top > bottom){
		        int middle = (top + bottom)/2;
		        if (middle == bottom) { 
		            System.out.println(middle);
		            break; }
		        else if (arr[i] > newArr[middle]){
		            bottom = middle;
		        }
		        else if (arr[i] < newArr[middle]){
		            top = middle;
		        }
		        else { 
		            System.out.println(middle);
		            break; }
		    }
		    System.out.println(printArr(arr));
		    
		    newArr[middle+1] = arr[i]; // error line, it seems that middle cannot be found outside of the while loop it is created in
		    /* ERROR:
		    /bubble_sort.java:50: error: cannot find symbol
            		    newArr[middle+1] = arr[i]; // error line
            		           ^
              symbol:   variable middle
              location: class bubble_sort
            1 error
            */
		}
		
		arr = newArr;
		
		// CONCLUSION
		System.out.println("\nSorted List:    " + printArr(arr));
    }
}