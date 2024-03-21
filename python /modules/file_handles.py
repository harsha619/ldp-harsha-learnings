file_path = "modules/sample.txt"
try:
    f=open(file_path, "r") 
    # with open(file_path, "r") as file_text:
    #     print(file_text.read(5))
    print(f.read(5))
except FileNotFoundError:
    print(f"File '{file_path}' not found.")
except Exception as e:
    print(f"An error occurred: {e}")
