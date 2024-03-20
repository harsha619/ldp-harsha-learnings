def add_contact(phonebook, name, number):
    phonebook[name] = number
    print(f"Contact '{name}' added successfully.")


def remove_contact(phonebook, name):
    if search_contact(phonebook, name):
        phonebook.pop(name)
        print(f"Contact '{name}' removed successfully.")
    else:
        print(f"Contact '{name}' not found in the phonebook.")


def search_contact(phonebook, name):
    if name in phonebook:
        print(f"Contact '{name}' found in the phonebook with number: {phonebook[name]}")
        return True
    else:
        print(f"Contact '{name}' not found in the phonebook.")
        return False


def phonebook_options():
    phonebook = {}
    prompt = """Enter number to do particular task:
    1. Add a contact
    2. Remove a contact
    3. Search a contact
    4. Stop
    """
    while True:
        print(prompt)
        option = int(input("Enter option: "))
        match option:
            case 1:
                name = input("Enter contact name: ")
                number = input("Enter contact number: ")
                add_contact(phonebook, name, number)
            case 2:
                name = input("Enter contact name to remove: ")
                remove_contact(phonebook, name)
            case 3:
                name = input("Enter contact name to search: ")
                search_contact(phonebook, name)
            case 4:
                print("Exiting phonebook application.")
                break
            case _:
                print("Invalid option. Please choose again.")


phonebook_options()
