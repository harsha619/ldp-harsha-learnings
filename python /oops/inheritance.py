class Animal:
    def __init__(self, name, sound):
        self.name = name
        self.sound = sound

    def speak(self):
        print(f"{self.name} says {self.sound}")

class Dog(Animal):
    def __init__(self, name, sound, breed):
        super().__init__(name, sound)
        self.breed = breed

    def speak(self):
        print(f"{self.name} ({self.breed}) says {self.sound}")

animal1 = Animal("Cat", "Meow")
animal1.speak() 

dog1 = Dog("Buddy", "bow", "Golden Retriever")
dog1.speak()