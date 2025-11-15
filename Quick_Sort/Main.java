package HaroldE_GrokkingAlg_Practice.Quick_Sort;

public class Main {
    public static void main(String[] args){
        int[] array = {1,12,53,5,36,3,6,6,2,35,63,2,523,5};

        System.out.println("Old Array: ");
        System.out.print("[");
        for(int i : array){
            System.out.printf("%d ", i);
        }
        System.out.printf("]\n\n");

        Quick_Sort(array, 0, array.length-1);

        System.out.println("New Array: ");
        System.out.print("[");
        for(int i : array){
            System.out.printf("%d ", i);
        }
        System.out.printf("]");
    } 

    public static void Quick_Sort(int[] array, int low, int high){
        if(low<high){
            int pi = Partition(array,low,high);

            Quick_Sort(array, low, pi-1);
            Quick_Sort(array, pi+1, high);
        }
    }

    public static int Partition(int[] array, int low, int high){
        int i = low - 1;
        int pivot = array[high];

        for(int j = low;j<high;j++){
            if(array[j] < pivot){
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i + 1; // New pivot index
    }
}
