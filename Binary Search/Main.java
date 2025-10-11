import java.util.Scanner;
import java.lang.Math;

public class Main {
	public static void main(String[] args){
        // Binary Search
        Scanner scanObj = new Scanner(System.in);
        System.out.println("This program will: ");
        System.out.println("1. Ask you for the length of an array, creating an array with elements ranging from 1 - arrayLength ");
        System.out.println("2. A number to search for within that array using Binary Search");

        System.out.println("What length is the array? : ");

        int arrLen = getUserInput(scanObj);
        int[] array = makeArray(arrLen);

        System.out.println("What number are you looking for? : ");

        int userDesire = getUserInput(scanObj);

        int guessCount = findIndex(userDesire,array);

        // find max attempts
        int maxAttempts = (int) Math.ceil(Math.log(arrLen)/Math.log(2.0));

        if(guessCount > 0){
            System.out.println("Number " + userDesire + " Found!");
            System.out.println("It took " + guessCount + " guesses to find");
            System.out.println("It should take a maximum of " + maxAttempts + " guesses to find a specific element \nin an array that has " + arrLen + " elements");
        }else{
            System.out.println("Number " + userDesire + " could not be found in " + guessCount + " guesses");
            System.out.println("It should take a maximum of " + maxAttempts + " guesses to confirm\nthe existence of a specific element.");
        }
	}

    public static int getUserInput(Scanner scanObj){
        // Ask user for array length
        int userInput = 0;
        do{
            try{
                userInput = scanObj.nextInt();
                scanObj.nextLine();
            }catch(Exception e){
                System.out.println("Invalid input - Please enter an integer from 1 - 100,000,000:");
            }

        }while(userInput < 1 || userInput > 100000000);

        return userInput;
    }

    public static int[] makeArray(int number){
        int[] array = new int[number];
        for(int i = 0; i<number;i++){
            array[i] = i+1;
        }

        return array;
    }

    public static int findIndex(int num, int[] array){
        // Returns number of guesses
        int length = array.length;
        int low = 0;
        int high = length - 1;
        int guessCount = 0;
        int mid;
        int guess;

        while(low <= high){
            mid = (int) Math.floor((high + low)/2);
            guess = array[mid];
            if(guess == num){
                return guessCount;
            }else if(guess > num){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
            guessCount+=1;
        }
        return 0;
    }
}