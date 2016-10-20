import java.util.Arrays;

public class LP {

    public static void main(String[] args){
        long startTime = System.nanoTime(); //get starting time
        //System.out.println("Started at: " + startTime);
        int[] arr = new int[Integer.parseInt(args[0])]; //get input size
        for(int i = 0; i < arr.length; i ++){ //initialize array of values to be permutated
            arr[i] = (i);
        }
        boolean print = Boolean.parseBoolean(args[1]); //get print boolean
        if(print)
            System.out.println(Arrays.toString(arr)); //print the array before its permuated
        while(nextPermutation(arr)){ //permutate the array until there is no more
            if(print)
            System.out.println(Arrays.toString(arr)); //print the entire array
        }
        System.out.println("Execution finished. Total time: " + (System.nanoTime() - startTime)); //display the run time
    }

    private static boolean nextPermutation(int[] array) {
        // this will find the first non-increasing int in array

        // Now i is the head index of the suffix
        int i;
        for(i = array.length - 1; i > 0 && array[i - 1] >= array[i]; i--){}

        // Are we at the last permutation already?
        if (i <= 0)
            return false;

        // Let array[i - 1] be the pivot
        // Find rightmost element that exceeds the pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;
        // Now the value array[j] will become the new pivot
        // Assertion: j >= i

        // Swap the pivot with j
        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        // Successfully computed the next permutation
        return true;
    }
}
