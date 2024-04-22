def add_fruit(fruit):
    fruit_list.append(fruit)
    print(f"new fruit list: {fruit_list}")

def remove_fruit(fruit):
    if(search_fruit(fruit)):
        fruit_list.remove(fruit)
    else:
        print(f"Fruit with name {fruit} is removed")
def search_fruit(fruit):
    for search_item in fruit_list:
        if(fruit==search_item):
            print(f"Fruit with name {fruit} is found in list")
            return True
        else:
            print(f"Fruit with name {fruit} is not found in list")
            return False

def fruit_options():
    prompt="""enter number to do particular task:
    1 add a fruit
    2 remove a fruit
    3 search a fruit
    4 stop
    """
    while(True):
        print(prompt)
        option= int(input("enter option:"))
        fruit= input("enter fruit name:")
        print(option,"option")
        match option:
            case 1:
                add_fruit(fruit)
            case 2:
                remove_fruit(fruit)
            case 3:
                search_fruit(fruit)
            case 4:
                break
            case _:
                print("please enter correct option:")



fruit_list=input("Enter your favorite fruits in a list: ").split()
fruit_options()
