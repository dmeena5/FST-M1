numList1 = list(input("Enter the numbers in List1: "). split(","))
numList2 = list(input("Enter the numbers in List2: "). split(","))
print("List1: ", numList1)
print("List2: ", numList2)
numList3 = []
for num in numList1:
    if (int(num) % 2 != 0):
        numList3.append(num)
for num in numList2:
    if (int(num) % 2 == 0):
        numList3.append(num)
print("numbers in List3: ", numList3)
