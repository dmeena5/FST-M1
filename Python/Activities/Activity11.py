"""Create a Python dictionary that contains a bunch of fruits and their prices.

Write a program that checks if a certain fruit is available or not."""
fruit_dict = dict(apple = '50.00/kg', banana = 40.00)
#print(fruit_dict)
#fruit_dict = {"apple":10, "banana":20, "mango":30, "grapes":40}
print("fruits available: ", fruit_dict)
available = input("Which fruit do you want?")
if available in fruit_dict:
    print("Fruit is available")
else:
    print("fruit is not avabilable")