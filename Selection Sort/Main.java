// Selection Sort:
// 
//   - Goes through an array and grabs smallest number
//   - Adds it to new array (sorted smallest to largest)
//   - Should result in a new, sorted smallest to largest array. 
//   Big O Notation: O(n^2)
import java.util.ArrayList;
public class Main{
    public static void main(String[] args) {
        ArrayList<Integer> testArray = new ArrayList<>();
        testArray.add(6);
        testArray.add(5000);
        testArray.add(1000);
        testArray.add(58);
        testArray.add(78);
        testArray.add(5);
        testArray.add(20);
        testArray.add(10000);
        testArray.add(50);
        testArray.add(1);

        ArrayList<Integer> newArr;

        

        newArr = selectionSort(testArray);

        for(int i: newArr){
            System.out.println(i);
        }
        
    }

    public static int getSmallest(ArrayList<Integer> arr){
        int smallest = arr.get(0);
        int smallest_id = 0;

        for(int i=0;i<arr.size();i++){
            if(arr.get(i)<smallest){
                smallest = arr.get(i);
                smallest_id = i;
            }            
        }

        return smallest_id;
    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> arr){
        ArrayList<Integer> newArr = new ArrayList<>();
        ArrayList<Integer> copiedArr = arr;
        int length = copiedArr.size();
        int smallest;

        for(int i = 0;i<length;i++){  
            // Array has set length, so we ignore all "null" entries
            smallest = getSmallest(copiedArr);
            newArr.add(copiedArr.remove(smallest)); 
        }

        return newArr;
    }


}
