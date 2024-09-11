import java.util.Arrays;
import java.util.Random;

public class bubble_sort {
    public static String printArr(int[] arr){
        String output = "";
       for (int i = 0; i < arr.length; i++){
            output += arr[i];   
            output += " "; 
        } 
        return output;
    }
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
		for (int j = 0; j < arr.length; j++){
		    boolean sorted = true;
		    for (int i = 0; i < arr.length-1; i++){
		        if (arr[i] > arr[i+1]){
		            sorted = false;
		            int temp = arr[i];
		            arr[i] = arr[i+1];
		            arr[i+1] = temp;
		        }}
		    System.out.println(printArr(arr));
		    if (sorted){
		        break;
		    }
		}
		
		// CONCLUSION
		System.out.println("\nSorted List:    " + printArr(arr));
    }
}
