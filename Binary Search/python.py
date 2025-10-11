

def Main():
    # Assume sorted arr

    # Create array
    print("This program will ask you to choose the size of an array and using Binary Search to find a number within this sorted array.")
    print("1. Choose the size of the array")
    print("Please enter a number between 1 - 100,000,000: ")
    arrLen = 0

    while arrLen < 1 or arrLen > 100000000:

        arrLen = input()

        try:
            arrLen = int(arrLen)
            if(arrLen < 1 or arrLen > 100000000):
                raise ValueError
        except ValueError:
            print("Invalid Input - Please enter a number between 1 - 100,000,000")
            continue

        
    
    # declare array, fill array
    arr=[] # Should take log_2(n) guesses in the worst case

    for i in range(arrLen):
        # range -> 0 - (arrLen-1)
        arr.append(i+1)

    print("Enter a number 1 - " + (str(arrLen)) + " to look for here: ")
    num = 0
    while num < 1 or num > 100000000:

        num = input()

        try:
            num = int(num)
            if(num < 1 or num > 100000000):
                raise ValueError
        except ValueError:
            print("Invalid Input - Please enter a number 1 - " + (str(arrLen)) + " to look for here:")
            continue

    found, middle, guessCount = Binary_Search(arr,arrLen,num)

    if(found):
        print("Number " + str(num) + " was found at index " + str(middle) + " in " + str(guessCount) + " guesses")
    else:
        print("Number was NOT found. " + str(guessCount) + " guesses taken" ) 
    
def Binary_Search(arr,arrLen,num):
    # Implement Binary Search
    # Establish low and high
    low = 0
    high = arrLen-1
    guessCount = 0

    while(low <= high):
        middle = (low + high) // 2
        guess = arr[middle]

        if(guess == num):
            return True, middle, guessCount
        elif(guess < num):
            low = middle + 1
        elif(guess > num):
            high = middle - 1

        guessCount +=1 
        # ^ We do this after, because in the book, "finding" is established as being the # of guesses to guarantee 
        # that the next index is the num we're looking for. Therefore, we only count whenever the loop would continue

    return False, middle, guessCount


Main()
