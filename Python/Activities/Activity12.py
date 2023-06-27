"""Write a recursive function to calculate the sum of numbers from 0 to 10"""
def calculate_sum(num):
    if num:
        return num + calculate_sum(num-1)
    else: 
        return 0
Total = calculate_sum(10)
print("total sum of numbers is: ", Total)
#