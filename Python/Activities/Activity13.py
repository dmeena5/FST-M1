"""Write a function sum() such that it can accept a list of elements and print the sum of all elements"""

def calc_sum(numbers):
    sum = 0
    for element in elements:
        sum += int(element)
    return sum
elements = list(input("Enter the desired elements in the list:"))
print("List of elements: " , elements)    
print("Sum of all elements is: ", calc_sum(elements))

    
