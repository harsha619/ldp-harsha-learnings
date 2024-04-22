def log_function(func):
    def wrapper(*args, **kwargs):
        print(f"Calling function '{func.__name__}' with arguments: {args}, {kwargs}")
        return func(*args, **kwargs)
    return wrapper

def multiply_decorator(func):
    print("multiply out function")
    def wrapper(*args, **kwargs):
        print("multiply function")
        result = func(*args, **kwargs)
        return result * 10
    return wrapper

def subtract_decorator(func):
    print("subtract  out function")
    def wrapper(*args, **kwargs):
        print("subtract function")
        result = func(*args, **kwargs)
        return result - 5
    return wrapper

@log_function
@multiply_decorator
@subtract_decorator
def add(x, y):
    return x + y

result = add(5, 3)
print("Result of decorated addition:", result)
