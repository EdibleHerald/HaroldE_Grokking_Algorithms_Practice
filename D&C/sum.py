
# Add up all numbers in the array
def sum(array):
    if(array == []):
        return 0
    else:
        return array.pop(0) + sum(array)

sumOfItems = sum([1,2,3,4,5,6])
print("The sum of the array is: " + str(sumOfItems))

# Count the amount of items in an array
def countItems(array):
    if(array == []):
        return 0
    else:
        array.pop(0)
        return 1 + countItems(array)

numberOfItems = countItems([1,2,3,4,5,6])
print ("The amount of items in the array is: " + str(numberOfItems))

# Find the maximum number in an array
def max(array):
    if(len(list == 2)):
        return array[0] if array[0] > array[1] else array[1]
    # Cut off index 0 off the list
    sub_max = max(list[1:])
    
    return array[0] if array[0] > sub_max else sub_max

    
        

maximum = max([3,5,7,2,9,3,7])
print(str(maximum))
        
        