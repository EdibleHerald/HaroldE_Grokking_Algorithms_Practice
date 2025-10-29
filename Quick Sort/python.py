# Quick Sort uses Divide and Conquer
#
# 1.) Pick a Pivot (chosen element)
#     - A good pivot is one that:
#       - Splits the array cleaner as to avoid additional, unnecessary recursive calls
# 2.) Find elements smaller than and larger tham the pivot (this is called partitioning)
# 3.) Split the array in 2. Now you have two sub arrays and a pivot
# 4.) Recursively quick sort the sub arrays
#     - This works because quicksort can handle cases where array size < 2.
#       - If it can handle array of size 1, then it can handle size 2, then it can handle size 3, and so on.


def quicksort(array):
    length = len(array)
    if(length < 2):
        return array
    else:
        pivot = array[0] # array[0] pivot is worst case scenario O(n^2)
        # find elements smaller and greater than pivot
        lesser =[i for i in array[1:] if i<=pivot]
        greater = [i for i in array[1:] if i>pivot]

        return quicksort(lesser) + [pivot] + quicksort(greater)

print(quicksort([1,6,4,9,2,9,4,34,83,68,34,78]))