/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Tugas2Bayu;

import java.sql.SQLException;
import java.util.Scanner;

public class LibrarySystemPBO2 {
    public static void main(String[] args) {
        try {
            LibrarySystem librarySystem = new LibrarySystem(); 
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nLibrary System Menu:");
                System.out.println("1. Add Book");
                System.out.println("2. View Books");
                System.out.println("3. Borrow Book");
                System.out.println("4. Return Book");
                System.out.println("5. View Borrowed Books");
                System.out.println("6. Add User");
                System.out.println("7. View Users");
                System.out.println("8. Update User");
                System.out.println("9. Delete User");
                System.out.println("10. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = scanner.next();
                        System.out.print("Enter book author: ");
                        String author = scanner.next();
                        librarySystem.addBook(new Book(0, title, author, true));
                        break;
                    case 2:
                        librarySystem.viewBooks();
                        break;
                    case 3:
                        System.out.print("Enter book ID to borrow: ");
                        int bookId = scanner.nextInt();
                        System.out.print("Enter user ID: ");
                        int userId = scanner.nextInt();
                        librarySystem.borrowBook(bookId, userId);
                        break;
                    case 4:
                        System.out.print("Enter book ID to return: ");
                        int returnBookId = scanner.nextInt();
                        librarySystem.returnBook(returnBookId);
                        break;
                    case 5:
                        librarySystem.viewBorrowedBooks();
                        break;
                    case 6:
                        System.out.print("Enter user name: ");
                        String userName = scanner.next();
                        System.out.print("Enter user email: ");
                        String userEmail = scanner.next();
                        librarySystem.addUser(new User(0, userName, userEmail)); // Gunakan LibrarySystem
                        System.out.println("Current Users:");
                        librarySystem.viewUsers(); // Gunakan LibrarySystem
                        break;
                    case 7:
                        System.out.println("Current Users:");
                        librarySystem.viewUsers(); // Gunakan LibrarySystem
                        break;
                    case 8:
                        System.out.print("Enter user ID to update: ");
                        int updateUserId = scanner.nextInt();
                        System.out.print("Enter new name: ");
                        String newName = scanner.next();
                        System.out.print("Enter new email: ");
                        String newEmail = scanner.next();
                        librarySystem.updateUser(updateUserId, newName, newEmail); // Gunakan LibrarySystem
                        break;
                    case 9:
                        System.out.print("Enter user ID to delete: ");
                        int deleteUserId = scanner.nextInt();
                        librarySystem.deleteUser(deleteUserId); // Gunakan LibrarySystem
                        break;
                    case 10:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
