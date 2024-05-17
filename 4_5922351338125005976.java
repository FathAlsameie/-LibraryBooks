
package library;
import java.util.Scanner;

class Book {
	String name;
	String auther;
	int version;
}


public class Library {
	public static Scanner in   = new Scanner(System.in);
	public static Book[] library = new Book[0];
	public static void main(String[] args) {
		
		String option = "";
		String book_name, book_auther;
		int book_version;
		do {
			System.out.println("Welcome\n\n1) Add new book");
			System.out.print("2) Delete book\n3) Show books\n4)Exit\n\t : ");
			option = in.nextLine();
			
			switch (option) {
				case "1":
				System.out.print("Enter book name : ");
				book_name = in.nextLine();
				System.out.print("Enter name of book auther : ");
				book_auther = in.nextLine();
				System.out.print("Enter book version ID : ");
				book_version = in.nextInt();
				in.nextLine();
				addBook(book_name, book_auther, book_version);
				break;
				
				case "2":
				showBooks();
				System.out.print("Enter index of book to delete it : ");
				int book_index = in.nextInt();
				in.nextLine();
				if (book_index > 0 && book_index < library.length) {
					deleteBook (book_index);
					System.out.println("Deleted √");
				} else {
					System.out.println("This is index not found !!");
				}
				break;
				
				case "3" :
				showBooks();
				break;
				
				case "4":
				System.out.println("Good bye");
				break;
				
				default :
				System.out.println("Incorrect !!");
			}
			
			
		} while (!option.equals("4"));
		
	}
	
	public static void addBook (String name, String auther, int version){
		int new_length = library.length + 1;
		Book[] book_temp = new Book[new_length];
		book_temp = setupClass(book_temp);
		
		for (int i=0; i<library.length; i++) {
			book_temp[i] = library[i];
		}
		book_temp[new_length-1].name = name;
		book_temp[new_length-1].auther = auther;
		book_temp[new_length-1].version = version;
		
		library = book_temp;
	}
	
	public static void deleteBook (int index) {
		int new_length = library.length -1;
		Book[] book_temp = new Book[new_length];
		book_temp = setupClass(book_temp);
		
		int j = 0;
		
		for (int i=0; i<library.length; i++) {
			if (i == index) {
				continue;
			}
			book_temp[j] = library[i];
			j += 1;
		}
		library = book_temp;
	}
	
	public static void showBooks() {
		System.out.println("Book name  | Auther   | version");
		for (int i=0; i<library.length; i++) {
			System.out.println((i+1)+" - "+library[i].name+"  "+library[i].auther+"  "+library[i].version);
		}
	}
	
	public static Book[] setupClass(Book[] lib_array) {
		for (int i=0; i<lib_array.length; i++) {
			lib_array[i] = new Book();
		}
		return lib_array;
	}
	
}