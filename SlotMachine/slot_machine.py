MIN_LINES = 1
MAX_LINES = 3
MIN_BET = 1

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


def main():
    balance = get_user_numeric_response(lambda x: x > 0,
                                        "Enter your deposit amount : ",
                                        "Please enter a positive number")
    lines = get_user_numeric_response(lambda x: MIN_LINES <= x <= MAX_LINES,
                                      f"Enter the number of lines to bet on ({MIN_LINES}-{MAX_LINES}) : ",
                                      f"Please enter a correct number of lines ({MIN_LINES}-{MAX_LINES})")


if __name__ == "__main__":
    main()
