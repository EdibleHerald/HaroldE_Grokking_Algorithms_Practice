
# Add up all numbers in the array
def sum(array):
    if(array == []):
        return 0
    else:
        return array.pop(0) + sum(array)

array = [1,2,3,4,5,6]
sumOfItems = sum(list(array))
print("Add up all numbers in array:")
print("[",end=" ")
for i in array:
    print(i,end=" ")
print("]")
print("The sum of the array is: " + str(sumOfItems) +"\n")

# Count the amount of items in an array
def countItems(array):
    if(array == []):
        return 0
    else:
        array.pop(0)
        return 1 + countItems(array)

numberOfItems = countItems(list(array))
print("Count the number of elements in array:")
print("[",end=" ")
for i in array:
    print(i,end=" ")
print("]")
print ("The amount of items in the array is: " + str(numberOfItems) + "\n")

# Find the maximum number in an array
def max(array):
    if(len(array) == 2):
        return array[0] if array[0] > array[1] else array[1]
    # Cut off index 0 off the list
    sub_max = max(array[1:])
    
    return array[0] if array[0] > sub_max else sub_max

array2 = [3,5,7,2,9,3,7]
maximum = max(array2)
print("Find the largest integer in array:")
print("[",end=" ")
for i in array2:
    print(i,end=" ")
print("]")
print("Largest integer is: " +str(maximum))
        
        