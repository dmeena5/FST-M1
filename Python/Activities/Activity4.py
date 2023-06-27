while True:
    option1 = input("Is Player1 choosing rock, paper or scissors: ").lower()
    option2 = input("Is Player2 choosing rock, paper or scissors: ").lower()
    if option1 == option2:
        print("it is a tie")
    elif option1 == "rock":
        if option2 == "scissors":
            print("Player1 wins")
        else:
            print("Player2 wins")
    elif option1 == "scissors":
        if option2 == "paper":
            print("Player1 wins")
        else:
            print("Player2 wins")
    elif option1 == "paper":
        if option2 == "rock":
            print("Player1 wins")
        else:
            print("Player2 wins")
    else:
        print("Please try again")

    playagain = input("Do you want to play another round? Yes/No: ").lower()
    if playagain == "yes":
        pass
    elif(playagain == "no"):
        raise SystemExit
    else:
        print("You entered an invalid option. Exiting now.")
        raise SystemExit
    