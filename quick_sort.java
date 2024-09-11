import java.util.Arrays;
import java.util.Random;

public class quick_sort {
    // Format Array to String
    public static String printArr(int[] arr){
        String output = "";
       for (int i = 0; i < arr.length; i++){
            output += arr[i];   
            output += " "; 
        } 
        return output;
    }
    
    // findPos function
    public static int[] findPos(int p, int q, int[] arr){
        int top = p;
        int bottom = q;
        while (true){
            if ((arr[q] > arr[p] && p > q) || (arr[q] < arr[p] && p < q)){
                int temp = arr[p];
                arr[p] = arr[q];
                arr[q] = temp;
                
                temp = p;
                p = q;
                q = temp;
            }
            if (p > q) {p--;}
            else if (p < q) {p++;}
            else {break;}
        }
        
        System.out.println(printArr(arr));
        
        if (p < top){
            arr = findPos(top, p+1, arr);
        }
        if (p > bottom){
            arr = findPos(p-1, bottom, arr);
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
		arr = findPos(arr.length-1, 0, arr);
		
		// CONCLUSION
		System.out.println("\nSorted List:    " + printArr(arr));
    }
}
