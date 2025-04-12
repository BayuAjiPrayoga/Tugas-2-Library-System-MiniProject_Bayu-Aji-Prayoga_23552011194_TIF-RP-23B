# Mini Proyek Pemrograman Berorientasi Obyek 2

## Informasi Proyek

- **Mata Kuliah:** Pemrograman Berorientasi Obyek 2
- **Dosen Pengampu:** [Muhammad Ikhwan Fathulloh](https://github.com/Muhammad-Ikhwan-Fathulloh)
- **Proyek:** Sistem Manajemen Produk
- **Dibuat oleh:**
  - **Nama:** [Bayu Aji Prayoga](https://github.com/BayuAjiPrayoga)
  - **NPM:** 23552011194
  - **Kelas:** TIF RP-23 CNS A

---

## Judul Studi Kasus

**Sistem Manajemen Perpustakaan (Library Management System))**

---

## Penjelasan Studi Kasus

Aplikasi ini digunakan untuk mempermudah proses pengelolaan buku, pengguna, dan transaksi peminjaman dalam sebuah sistem perpustakaan sederhana. Aplikasi ini memiliki fitur untuk:

- Menambah, melihat, memperbarui, dan menghapus buku
- Menambah, melihat, memperbarui, dan menghapus pengguna
- Meminjam dan mengembalikan buku
- Melihat daftar buku yang sedang dipinjam

Aplikasi ini berbasis **Java** dengan antarmuka berbasis teks.

---

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance

Inheritance memungkinkan suatu kelas untuk mewarisi atribut dan metode dari kelas lain. Dalam proyek ini, kelas `User` dan `Book` mewarisi atribut dan metode dari kelas abstrak `LibraryEntity`.

#### Implementasi Inheritance dalam Kode:

````java
public abstract class LibraryEntity {
    private int id;

    public LibraryEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract String getDetails();
}

public class Book extends LibraryEntity {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author, boolean isAvailable) {
        super(id);
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    @Override
    public String getDetails() {
        return "Book ID: " + getId() + ", Title: " + title + ", Author: " + author;
    }
}
````
---

### 2. Encapsulation
Encapsulation diterapkan dengan baik dalam proyek ini. Atribut di kelas User dan Book bersifat private dan hanya dapat diakses melalui metode getter dan setter. Hal ini memastikan bahwa data dalam objek dilindungi dari akses langsung dari luar kelas.

#### Implementasi Encapsulation dalam Kode:
```java
public class User extends LibraryEntity {
    private String name;
    private String email;

    public User(int id, String name, String email) {
        super(id);
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
````

---

### 3. Polymorphism

Polymorphism diterapkan melalui overriding metode getDetails() di kelas Book dan User. Setiap kelas memberikan implementasi spesifik untuk metode ini.

#### Implementasi Polymorphism dalam Kode:

```java
public abstract class LibraryEntity {
    public abstract String getDetails();
}

public class Book extends LibraryEntity {
    @Override
    public String getDetails() {
        return "Book Details";
    }
}

public class User extends LibraryEntity {
    @Override
    public String getDetails() {
        return "User Details";
    }
}
```

---

### 4. Abstraction

Abstraction diterapkan melalui penggunaan interface LibraryOperations dan UserOperations, yang mendefinisikan operasi dasar untuk buku dan pengguna tanpa mengungkapkan detail implementasinya.

#### Implementasi Abstraction dalam Kode:

```java
public interface LibraryOperations {
    void addBook(Book book);
    void viewBooks();
    void borrowBook(int bookId, int userId);
    void returnBook(int bookId);
}

public interface UserOperations {
    void addUser(User user);
    void viewUsers();
    void updateUser(int userId, String name, String email);
    void deleteUser(int userId);
}
```

---

## Struktur Tabel Aplikasi

### Tabel `books`

```sql
CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    is_available BOOLEAN DEFAULT TRUE
);
```

### Tabel `users`

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);
```

### Tabel `transactions`

```sql
CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    return_date TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
```

---

## Tampilan Aplikasi

### Menu Utama

```
=============================
<<<Library Management Menu>>>
=============================
1. Add Book
2. View Books
3. Borrow Book
4. Return Book
5. View Borrowed Books
6. Add User
7. View Users
8. Update User
9. Delete User
10. Exit
=============================
```

### Contoh Output

#### Menambah buku

```
Enter book title: Java Programming
Enter book author: John Doe
Book added successfully!
```

#### Melihat Semua Buku

```
Books:
Book ID: 1, Title: Java Programming, Author: John Doe
```

#### Meminjam Buku

```
Enter book ID to borrow: 1
Enter user ID: 1
Book borrowed successfully!
```

#### Melihat Buku yang Dipinjam

```
Borrowed Books:
Book ID: 1, Title: Java Programming, Author: John Doe, Borrowed By: Bayu Aji (User ID: 1)
```

---

## Demo Proyek

<ul>
  <li>Github: <a href="https://github.com/BayuAjiPrayoga/Tugas-2-Library-System-MiniProject_Bayu-Aji-Prayoga_23552011194_TIF-RP-23B">[Github]</a></li>
  <li>Youtube: <a href="https://youtu.be/-iXCo0GZmzs">[Youtube]</a></li>
</ul>
