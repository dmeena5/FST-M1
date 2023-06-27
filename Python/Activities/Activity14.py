"""Write a program that asks the user how many Fibonnaci numbers to generate and then generates them.
Hint: The Fibonnaci seqence is a sequence of numbers where the next number in the sequence is the 
sum of the previous two numbers in the sequence. The sequence looks like this: 1, 1, 2, 3, 5, 8, 13, …"""

def fibonnaci(number):
    if number <=1 :
        return number
    else:
        return(fibonnaci(number-1) + fibonnaci(number-2))
series = int(input("Enter a number: "))
if series <= 0:
    print("Enter a valid input")
else:
    print("Fibonacci series: ")
    for i in range(series):
        print(fibonnaci(i))
