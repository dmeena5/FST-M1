"""Given a tuple of numbers, iterate through it and print only those numbers which are divisible by 5"""
tNum = tuple(input("Enter numbers in the tuple:").split(","))
print("Given tuple is: ", tNum)
print("Numbers in tuple that are divisible by 5 are: ")
for num in tNum:
    if (int(num) % 5 == 0 ):
        print(num)
      
