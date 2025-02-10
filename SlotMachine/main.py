import random

def welcome_display():
    print("\nWelcome to SlotMachine")
    print("Symbols: 🍒 🍉 🍋 🔔 ⭐")

def result_display(result):
    print(' | '.join(result))

def get_result():
    possibilities = ["🍒", "🍉", "🍋", "🔔", "⭐"]

    return [random.choice(possibilities) for i in range(3)]

def get_payout(result, bet):
    switch = {
        "🍒": 3,
        "🍉": 4,
        "🍋": 5,
        "🔔": 10,
        "⭐": 20
    }
    if result[0] == result[1] == result[2]:
        return bet * switch.get(result[0])
    else:
        return 0

def main():
    money = 100

    welcome_display()

    while money > 0:
        print(f"Money: ${money}")

        bet = input("How much money do you want to bet : ")

        if not bet.isdigit():
            print(f"Please enter a valid bet (just numbers)")
            continue

        bet = int(bet)

        if bet > money or bet <= 0:
            print(f"Please enter a valid bet (between {money} and 0)")
            continue

        money -= bet

        result = get_result()
        result_display(result)

        payout = get_payout(result,bet)
        if payout == 0:
            if money == 0:
                print("You lost all your money.")
            else:
                print(f"You lost ${bet} !")
        else:
            print(f"You won ${payout}!")

        money += payout


if __name__ == "__main__":
    main()