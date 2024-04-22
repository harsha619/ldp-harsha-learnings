def fibonacci_generator(limit):
    a, b = 0, 1
    while (a<10):
        yield a
        a, b = b, a + b

fib_gen = fibonacci_generator(10)
for i in fib_gen:
    print(i)
