/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas2Bayu;
public interface LibraryOperations {
    void addBook(Book book);
    void viewBooks();
    void borrowBook(int bookId, int userId);
    void returnBook(int bookId);
    void addUser(User user);
    void viewUsers();
    void updateUser(int userId, String name, String email);
    void deleteUser(int userId);
}
