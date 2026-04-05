#include <iostream>
#include "main.h"

int main(){
    // Unsorted list
    std::vector<int> obj = std::vector{3,5,4,10,15,13,2,9,8,20,17,16,1,7,6,18,16,11,12,14};

    // Construct in place
    std::vector<int> sortedObj = Selection_Sort(obj);

    // Verify results
    std::cout << " [ ";
    for(int i=0;i<sortedObj.size();++i)
    {
        std::cout << i << " ";
    }
    std::cout << "]" << std::endl;
}

// Takes reference, alters data, returns new copy.
std::vector<int> Selection_Sort(std::vector<int> &vector)
{
    // Make vector to be returned
    std::vector<int> newEmptyCopy = std::vector<int>(vector);

    int min;

    // Run loop over entire array. Looks for smallest value and places in order. O(n)
    for(int i=0;i<vector.size()-1;++i)
    {
        // Assume vector[i] is smallest value
        min=i;
        
        // Verify by running another for-loop for the rest of the array. O(n^2)
        for(int j=0;j<vector.size();++j){
            if(vector[i] < vector[min]){
                min=i;
            }
        }

        // Now we have index of smallest value
        // swap places with vector[i]
        int temp=vector[i];
        vector[i] = vector[min];
        vector[min] = temp;
    }

    // Move assignment or construct in place somewhere
    return newEmptyCopy;
}
