package Book;
import java.util.ArrayList;
import java.util.Scanner;

import Book.Book;
import Book.BookKind;
import Book.ExBook;
import Book.Newspaper;

public class BookManager {
	ArrayList<Book> books = new ArrayList<Book>();
	Scanner input;
	BookManager(Scanner input){
		this.input = input;
	}
	
	public void addBook() {//1�� �Է��ϸ� ������ ��
		int kind = 0;
		Book book;
		while(kind != 1 && kind !=2) {
			System.out.println("1 for Extra");
			System.out.println("2 for Novel");
			System.out.println("3 for Newspaper");
			System.out.print("Select num 1, 2, or 3 for Book Kind:");
			kind = input.nextInt();
			if(kind == 1) {
				book = new Book(BookKind.Extra);
				book.getUserInput(input);
				books.add(book);
				break;
			}
			else if(kind == 2) {
				book = new ExBook(BookKind.Novel);
				book.getUserInput(input);
				books.add(book);
				break;
			}
			else if(kind == 3) {
				book = new Newspaper(BookKind.Newspaper);
				book.getUserInput(input);
				books.add(book);
				break;
			}
			else {
				System.out.print("Select num for Book Kind between 1 & 2:");
			}
		}
	}
	public void deleteBook() {//2�� �Է��ϸ� ������ ��
		System.out.print("Book Number: ");
		int bookNu = input.nextInt();
		int index = -1;
		for(int i =0; i<books.size();i++) {
			if(books.get(i).getNumber() == bookNu) {
				index = i;
				break;
		}
		if(index >= 0) {
			books.remove(index);
			System.out.println("the book:" + bookNu + "is deleted");
		}
		else {
			System.out.println("the student has not been registered");
			return;
		}
		}
	}
	public void editBook() {//3�� �Է��ϸ� ������ ��
		System.out.print("Book Number: ");
		int bookNu = input.nextInt();
		for(int i =0; i<books.size();i++) {
			Book book = books.get(i);
			if(book.getNumber() == bookNu) {
				int num = -1;
				while (num != 5) {
					System.out.println("**Student Info Edit Menu");
					System.out.println("1: Edit Number");
					System.out.println("2: Edit Name");
					System.out.println("3: Edit Author");
					System.out.println("4: Edit Publisher");
					System.out.println("5: Exit");
					System.out.println("Select one number between 1 ~ 6");
					num = input.nextInt();
					if(num == 1) {
						System.out.print("Book Number: ");
						int number = input.nextInt();
						book.setNumber(number);
					}
					else if(num == 2) {
						System.out.print("Book Name: ");
						String name = input.next();
						book.setName(name);
					}
					else if(num == 3) {
						System.out.print("Book Author: ");
						String author = input.next();
						book.setAuthor(author);
					}
					else if(num == 4) {
						System.out.print("Book Publisher: ");
						String publish = input.next();
						book.setPublish(publish);
					}
					else {
						continue;
					}//if
				}//while
				break;
			}//if
		}//for
	}
	public void viewBooks() {//4�� �Է��ϸ� ������ ��
//		System.out.print("Book Number: ");
//		int bookNu = input.nextInt();
		for(int i =0; i<books.size();i++) {
			books.get(i).printInfo();
		}
	}
}