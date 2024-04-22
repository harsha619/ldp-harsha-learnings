class Book:
    
    def create_book(self,title,author,genre):
        self.title=title
        self.author=author
        self.genre=genre
    
    def display_details(self):
        print(f"title: {self.title}, author: {self.author},genre: {self.genre} ")
    
    def check_genre(self,genre):
        if(self.genre==genre):
            print("The book belongs to the Fiction genre.")
        else:
            print("The book does not belong to the Fiction genre.")

book1= Book()
book1.create_book("first book","ram","horror")
book2=Book()
book2.create_book("second book","kalam","Science Fiction")
book1.display_details()
book2.display_details()
book1.check_genre("Science Fiction")
book2.check_genre("Science Fiction")
