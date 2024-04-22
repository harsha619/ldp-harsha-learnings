
first_number = int(input("Enter first number:"))  
second_number = int(input("Enter second number:"))  
operator = input("Enter operator:")  
answer = False  
if operator == "==":
    answer = first_number == second_number
elif operator == "!=":
    answer = first_number != second_number
elif operator == ">":
    answer = first_number > second_number
elif operator == ">=":
    answer = first_number >= second_number
elif operator == "<":
    answer = first_number < second_number
elif operator == "<=":
    answer = first_number <= second_number


print(f"Result of {first_number} {operator} {second_number}: {answer}")
