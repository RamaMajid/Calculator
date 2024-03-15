package Modul2.Kegiatan;

import java.util.Scanner;

public class Main {
    Book[] bookList = new Book[100];
    int bookCount = 0;
    User[] userStudent = new User[100];
    int studentCount = 0;
    Admin admin = new Admin();
    Student student;

    Main() {
        bookList[bookCount++] = new Book("1", "NGANTUK", "TIDUR", 10);
        bookList[bookCount++] = new Book("2", "MIMPI", "BURUK", 15);
        bookList[bookCount++] = new Book("3", "KAGET", "BANGUN", 20);
    }

    void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Login sebagai admin");
            System.out.println("2. Login sebagai student");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    if (loginAdmin()) {
                        menuAdmin();
                    } else {
                        System.out.println("Username atau password salah.");
                    }
                    break;
                case 2:
                    if (inputNim()) {
                        menuStudent();
                    } else {
                        System.out.println("NIM tidak ditemukan.");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Ngantuk Ya?");
                    System.out.println();
            }
        }
    }

    boolean loginAdmin() {
        Scanner scanner = new Scanner(System.in);
        String username, password;
        do {
            System.out.print("Masukkan username: ");
            username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            password = scanner.nextLine();
            if (!admin.adminUsername.equals(username) || !admin.adminPassword.equals(password)) {
                System.out.println("Username atau password salah. Silakan coba lagi.");
            }
        } while (!admin.adminUsername.equals(username) || !admin.adminPassword.equals(password));
        return true;
    }

    boolean inputNim() {
        Scanner scanner = new Scanner(System.in);
        String nim;
        do {
            System.out.print("Masukkan NIM: ");
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("NIM tidak valid. NIM harus memiliki panjang 15 karakter.");
            }
        } while (nim.length() != 15);
        return checkNim(nim);
    }

    boolean checkNim(String nim) {
        for (int i = 0; i < studentCount; i++) {
            if (userStudent[i].nim.equals(nim)) {
                student = new Student(userStudent[i].nama, userStudent[i].fakultas, userStudent[i].programStudi);
                return true;
            }
        }
        return false;
    }

    void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("ADMIN MENU");
            System.out.println("1. Tambah student");
            System.out.println("2. Tampilkan student");
            System.out.println("3. Kembali");
            System.out.print("Pilih opsi: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    admin.addStudent();
                    userStudent = admin.studentList;
                    studentCount = admin.studentCount;
                    break;
                case 2:
                    admin.displayStudents();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Tidur dulu kalau ngantuk");
            }
        }
    }

    void menuStudent() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("STUDENT MENU");
            System.out.println("1. Tampilkan buku");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Tampilkan buku yang dipinjam");
            System.out.println("4. Logout");
            System.out.print("Pilih opsi: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    student.displayBooks(bookList, bookCount);
                    break;
                case 2:
                    student.borrowBook(bookList, bookCount);
                    break;
                case 3:
                    student.displayBorrowedBooks();
                    break;
                case 4:
                    student.logout();
                    return;
                default:
                    System.out.println("tinggal tidur aja kok ngeyel");
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}
