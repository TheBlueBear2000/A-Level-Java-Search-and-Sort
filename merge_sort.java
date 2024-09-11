import java.util.Arrays;
import java.util.Random;

public class merge_sort {
    // Format Array to String
    public static String printArr(int[] arr){
        String output = "";
       for (int i = 0; i < arr.length; i++){
            output += arr[i];   
            output += " "; 
        } 
        return output;
    }
    
    // Sample from an Array
    public static int[] sample(int[] arr, int start, int end){
        int[] out = new int[end-start];
        for (int i = 0; i < end - start; i++){
            out[i] = arr[i + start];
        }
        return out;
    }
    
    // Add Arrays
    public static int[] addArrs(int[] firstArr, int[] toAdd, int startingPos){
        for (int i = 0; i < toAdd.length; i++){
            firstArr[startingPos + i] = toAdd[i];
        }
        return firstArr;
    }
    
    // merge function
    public static int[] merge(int[] arr, int[] left, int[] right){
        int[] sorted = Arrays.copyOf(arr, arr.length);
        int sortedIndex = 0;
        int i = 0;  int j = 0;
        while (i < left.length  &&  j < right.length){
            if (left[i] < right[i]){
                sorted[sortedIndex] = left[i];
                i++;
                sortedIndex++;
            }
            else{
                sorted[sortedIndex] = right[j];
                j++;
                sortedIndex++;
            }
        }
        // sorted += right[j:] // CURRENT
        sorted = addArrs(sorted, sample(right, j, right.length-1), 0);
        sorted = addArrs(sorted, sample(left, i, left.length-1), right.length);
        return sorted;
    }
    
    // sort function
    public static int[] sort(int[] arr){
        if (arr.length > 1){
            int middle = arr.length / 2;
            int[] left = sort(sample(arr, 0, middle));
            int[] right = sort(sample(arr, middle, arr.length));
            arr = merge(arr, left, right);
        }
        return arr;
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
		arr = sort(arr);
		
		// CONCLUSION
		System.out.println("\nSorted List:    " + printArr(arr));
    }
}


// I dont know where the error is and i dont think i ever will
// its a logic error though thats for sure