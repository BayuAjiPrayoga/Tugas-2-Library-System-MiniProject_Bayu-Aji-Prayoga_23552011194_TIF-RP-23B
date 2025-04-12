package Tugas2Bayu;

public interface UserOperations {
    void addUser(User user);
    void viewUsers();
    void updateUser(int userId, String name, String email);
    void deleteUser(int userId);
}