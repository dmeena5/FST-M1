numbers = list(input("Enter the numbers in the list:"))
print("Entered list is:" ,numbers)
if(numbers[0] == numbers[-1]):
    print("True")
else:
    print("First and last numbers in List are not same. Exiting now.")
    raise SystemExit