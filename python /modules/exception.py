try:
    result = 10 / 0
    print("Result:", result)
except ZeroDivisionError:
    print("Cannot divide by zero!")
except Exception as e:
    print("An error occurred:", e)
else:
    print("No exception occurred.")
finally:
    print("Finally block executed.")

print("Program continues...")
