package HaroldE_GrokkingAlg_Practice.Selection_Sort;
// Selection Sort:
// 
//   - Goes through an array and grabs smallest number
//   - Adds it to new array (sorted smallest to largest)
//   - Should result in a new, sorted smallest to largest array. 
//   Big O Notation: O(n^2)
public class Main{
    public static void main(String[] args) {
        int[] originalArray = {10,35,2,6,245,2,46,24,6,7,89,6,42,7,3};
        System.out.println("Original, unsorted array: ");
        System.out.print("[ ");
        for(int i : originalArray){
            System.out.print(i + " ");
        }
        System.out.print("]\n");

        Selection_Sort(originalArray);
        System.out.println("Sorted array: ");
        System.out.print("[ ");
        for(int i : originalArray){
            System.out.print(i + " ");
        }
        System.out.print("]");
    }

    public static void Selection_Sort(int[] array){
        // Use int i as pointer to sequentially place smallest numbers
        // (i < array.length - 1) because j will compare i with the last element anyways and 
        // theres nothing after the last element to check
        for(int i = 0; i < array.length - 1;i++){
            int min = i; 

            for(int j = i; j < array.length;j++){
                // This loop checks the entire rest of the array for the smallest integer
                if(array[j] < array[min]){
                    min = j; // Smallest integer
                }
            }

            // Now swap index i with index min (where the smallest integer is at)
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

        // Returns nothing, as it modified the given array
    }
}
