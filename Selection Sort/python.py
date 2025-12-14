# Selection Sort:
# 
#   - Goes through an array and grabs smallest number
#   - Adds it to new array (sorted smallest to largest)
#   - Should result in a new, sorted smallest to largest array. 
#   Big O Notation: O(n^2)

testArray = [2245,621,25,844,7,10,15]

def findSmallest(arr):
    smallest = arr[0]
    smallest_index = 0

    for i in range(1,len(arr)):
        # Compare to entire array
        if arr[i]<smallest:
            smallest = arr[i]
            smallest_index = i
    
    return smallest_index

def selectionSort(arr):
    # Use findSmallest(arr) to get smallest number
    newArr = []
    copiedArr = list(arr)
    for i in range(len(copiedArr)):
        smallest = findSmallest(copiedArr)
        newArr.append(copiedArr.pop(smallest))
    return newArr

print("Selection Sort Algorithm: ")
print("The old array is: ")

print("[",end=" ")
for i in testArray:
    print(i,end=" ")
print("]")

newArray = selectionSort(testArray)

print("The sorted array is:")
print("[",end=" ")
for i in newArray:
    print(i,end=" ")
print("]")