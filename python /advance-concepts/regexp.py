import re

text = "How much wood would a woodchuck chuck if a woodchuck could chuck wood?"

search_word = input("Enter the word you want to search for: ")

pattern = rf"\b{re.escape(search_word)}\b" 

matches = re.findall(pattern, text, flags=re.IGNORECASE)

if matches:
    print(f"The word '{search_word}' was found in the text.")
    print("Occurrences found:")
    for match in matches:
        print(match)
else:
    print(f"The word '{search_word}' was not found in the text.")