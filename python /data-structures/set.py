def remove_duplicates(words):
    unique_words = list(set(words))
    unique_words.sort()
    return unique_words

def input_words():
    words = input("Enter a list of words separated by spaces: ").split()
    return words

def print_unique_words(unique_words):
    print("Unique words sorted alphabetically:")
    for word in unique_words:
        print(word)


words = input_words()
unique_words = remove_duplicates(words)
print_unique_words(unique_words)
