import random as r

MIN_LINES = 1
MAX_LINES = 3
MIN_BET = 1

SYMBOLS_COUNT = {
    "7": 5,
    "X": 6,
    "O": 8,
    "H": 10,
    "M": 11,
    "C": 12
}

SYMBOLS_MULTIPLIER = {
    "7": 20,
    "X": 10,
    "O": 8,
    "H": 5,
    "M": 3,
    "C": 2
}


def get_user_numeric_response(fun, demand_msg, error_msg):
    while True:
        response = input(demand_msg)
        try:
            response = int(response)
            if fun(response):
                return response
            else:
                print(error_msg)
        except ValueError:
            print("Please enter a number")


def get_balance():
    return get_user_numeric_response(lambda x: x > 0,
                                     "Enter your deposit amount : ",
                                     "Please enter a positive number.")


def get_lines():
    return get_user_numeric_response(lambda x: MIN_LINES <= x <= MAX_LINES,
                                     f"Enter the number of lines to bet on ({MIN_LINES}-{MAX_LINES}) : ",
                                     f"Please enter a correct number of lines ({MIN_LINES}-{MAX_LINES}).")


def get_bet():
    return get_user_numeric_response(lambda x: MIN_BET <= x,
                                     f"How much do you want to bet ? ",
                                     f"You have to bet min ${MIN_BET}.")


def create_symbols():
    all_symbols = []
    for symbol, count in SYMBOLS_COUNT.items():
        for _ in range(count):
            all_symbols.append(symbol)
    return all_symbols


def get_slot_spin(all_symbols):
    columns = []
    for _ in range(3):
        column = []
        for _ in range(3):
            column.append(r.choice(all_symbols))
        columns.append(column)
    return columns


def slots_display(columns):
    for column in columns:
        print(' | '.join(column))


def main():
    balance = get_balance()
    lines = get_lines()
    while True:
        bet = get_bet()
        total_bet = bet * lines
        if total_bet > balance:
            print(f"Your total bet (${total_bet}) is greater than your balance (${balance}). Enter a valid bet.")
        else:
            break
    print(f"You're betting ${bet} on {lines} lines. Your total bet is ${total_bet}.")

    possibilities = create_symbols()
    slots = get_slot_spin(possibilities)
    slots_display(slots)


if __name__ == "__main__":
    main()
