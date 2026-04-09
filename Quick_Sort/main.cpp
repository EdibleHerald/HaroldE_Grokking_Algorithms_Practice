#include <iostream>
#include <vector>

std::vector<int> Quick_Sort(std::vector<int> array);
std::vector<int>& Actual_Quick_Sort(std::vector<int>& array, int low, int high);
int Partition(std::vector<int>& array, int low, int high);

int main(){
    // Unsorted Vector
    std::vector<int> obj = std::vector{3,5,4,10,15,13,2,9,8,20,17,16,1,7,6,18,11,12,14,19};

    std::vector<int> newObj = Quick_Sort(obj);


    // Display obj
    std::cout << "obj (unsorted):" << std::endl;
    std::cout << " [ ";
    for(int i : obj)
    {
        std::cout << i << " ";
    }
    std::cout << "]" << std::endl;

    // Display newObj
    std::cout << "newObj (sorted):" << std::endl;
    std::cout << " [ ";
    for(int i : newObj)
    {
        std::cout << i << " "; 
    }
    std::cout << "]" << std::endl;
    return 0;
}


// I need to use pointers in this case for more efficiency. 
std::vector<int> Quick_Sort(std::vector<int> array)
{
    // I want to return a new array, to do this we will seperate this scope from
    // the actual recursion:

    // Copy constructor. Not needed, compiler will copy over the object itself.
    // std::vector<int> newArray = std::vector<int>(array);

    return Actual_Quick_Sort(array,0,array.size()-1);
}

// Next two functions uses references so objects aren't being unecessarily copied between function calls. Saves resources for particularly large vectors.

// Actual Quick Sort, uses low and high to determine areas being recursively sorted in a given loop. "high" is assumed to be the last index (i.e. if size=5, high=4).
std::vector<int>& Actual_Quick_Sort(std::vector<int>& array, int low, int high)
{
    // Checks that theres more than one element being sorted
    if(low < high){
        // Sort an element within "array" correctly, keeping numbers less than it on the left, and those larger on the right
        int pi = Partition(array, low, high);

        // Now that one number as been sorted, we recursively order the rest:

        // Numbers BEFORE the sorted number (we don't want to re-sort the already sorted number)
        Actual_Quick_Sort(array, low, pi - 1); 

        // Numbers AFTER the sorted number
        Actual_Quick_Sort(array, pi+1, high);
    }

    return array;
}

// Sort a single number within the given array, keeping numbers less than the pivot to the left, and those larger on the right.
int Partition(std::vector<int>& array, int low, int high)
{
    int i = low - 1; // element before the "first" one
    int pivot = array[high];


    for(int j=low;j<high;j++)
    {
        if(array[j] < pivot)
        {
            // Line up all numbers less than pivot to the left (i is used to track this)
            ++i;

            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
    }

    // Now, we know that "i+1" represents where the pivot should sit in the array.
    ++i;
    int temp = array[high];
    array[high] = array[i];
    array[i] = temp;
    
    // New Pivot index.
    return i;
}
