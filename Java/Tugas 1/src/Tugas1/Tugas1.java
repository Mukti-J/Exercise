/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tugas1;

import java.util.Scanner; // Funsgi buat baca input user
import java.util.Random; // Import FUngsi Random
import java.util.HashSet;  // Mengimpor HashSet, STruktur data untuk menyimpan elemen unik
import java.util.Set;      // Mengimpor Set, antarmuka yang diterapkan oleh HashSet

/**
 *
 * @author Mukti
 */
public class Tugas1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("====== Main Menu ======");
            System.out.println("1. Batu, Gunting, Kertas");
            System.out.println("2. Bingo");
            System.out.println("3. Rahasia-rahasian");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    playRockPaperScissors();
                    break;
                case 2:
                    playBingo();
                    break;
                case 3:
                    secretsMenu();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

        } while (choice != 4);

        scanner.close();
    }

    public static void playRockPaperScissors() {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    String[] choices = {"Batu", "Gunting", "Kertas"};
    String playAgain = "y"; // Inisialisasi untuk memulai loop

    do {
        System.out.println("=== Batu, Gunting, Kertas ===");
        boolean validInput = false; // Flag untuk memeriksa input valid

        int userChoice = 0; // Deklarasikan variabel di luar loop

        // Loop sampai input valid diberikan
        while (!validInput) {
            System.out.println("Pilih salah satu: ");
            System.out.println("1. Batu");
            System.out.println("2. Gunting");
            System.out.println("3. Kertas");
            System.out.print("Masukkan pilihanmu (1-3): ");

            if (scanner.hasNextInt()) { // Periksa apakah input adalah integer
                userChoice = scanner.nextInt();
                if (userChoice >= 1 && userChoice <= 3) {
                    validInput = true; // Input valid, keluar dari loop
                } else {
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } else {
                System.out.println("Input tidak valid, silakan masukkan angka.");
                scanner.next(); // Abaikan input tidak valid
            }
        }

        // Setelah input valid diterima, lanjutkan dengan logika permainan
        String userMove = choices[userChoice - 1];
        String computerMove = choices[random.nextInt(3)];

        System.out.println("Kamu memilih: " + userMove);
        System.out.println("Komputer memilih: " + computerMove);

        if (userMove.equals(computerMove)) {
            System.out.println("Hasil: Seri!");
        } else if ((userMove.equals("Batu") && computerMove.equals("Gunting")) ||
                (userMove.equals("Gunting") && computerMove.equals("Kertas")) ||
                (userMove.equals("Kertas") && computerMove.equals("Batu"))) {
            System.out.println("Hasil: Kamu menang!");
        } else {
            System.out.println("Hasil: Komputer menang!");
        }

        // Tanyakan apakah ingin bermain lagi
        System.out.print("Ingin bermain lagi? (y/n): ");
        playAgain = scanner.next();

    } while (playAgain.equalsIgnoreCase("y"));
}


    public static void playBingo() {
        int[][] bingoCard = new int[5][5];
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bingoCard[i][j] = random.nextInt(90) + 1;
            }
        }
        
        // Inisialisasi Set untuk menyimpan angka-angka yang telah ditandai pada permainan Bingo
        Set<Integer> markedNumbers = new HashSet<>();
        boolean hideUnmarked = false; // Lacak kapan angka yang tidak ditandai harus disembunyikan
        printBingoCard(bingoCard, markedNumbers, hideUnmarked); // Tampilkan awal

        Scanner scanner = new Scanner(System.in);
        boolean won = false;
        int attempts = 0;

        while (!won && attempts < 5) {
            int number = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Pilih Nomer Untuk ditandai (atau -1 untuk keluar): ");

                if (scanner.hasNextInt()) {
                    number = scanner.nextInt();
                    if (number == -1) {
                        System.out.println("Pemain Meninggalkan Permainan");
                        return;
                    }

                    if (number < 1 || number > 90) {
                        System.out.println("Nomor Tidak Valid. Masukkan Nomor Antara 1 dan 90.");
                    } else if (markedNumbers.contains(number)) {
                        System.out.println("Nomor Ini Sudah Ditandai. Pilih Nomor Yang Lain.");
                    } else {
                        validInput = true;
                    }
                } else {
                    System.out.println("Input Tidak Valid. Silakan Masukkan Nomor Yang Valid.");
                    scanner.next(); 
                }
            }
            
            // Ketika nomor dipilih oleh pemain, tambahkan ke dalam Set untuk dilacak
            markedNumbers.add(number); // Tandai nomor
            hideUnmarked = true; // Setelah pilihan pertama, sembunyikan nomor yang belum dipilih
            markBingoCard(bingoCard, number);
            printBingoCard(bingoCard, markedNumbers, hideUnmarked); // Tampilkan dengan nomor tersembunyi

            won = checkWin(bingoCard);
            if (won) {
                System.out.println("Selamat, Anda MENANG!!!");
            }

            attempts++;
        }

        if (!won) {
            System.out.println("Maaf, Anda KALAH!!!");
        }
    }

    // Tampilan Kartu Bingo yang Ditingkatkan dengan nomor tersembunyi
    public static void printBingoCard(int[][] bingoCard, Set<Integer> markedNumbers, boolean hideUnmarked) {
        System.out.println("Kartu Bingo Anda:");
        System.out.println("--------------------------");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
//          Pada fungsi printBingoCard, program memeriksa apakah nomor tersebut ada dalam Set `markedNumbers`
//          Jika iya, maka nomor dianggap telah ditandai dan digantikan oleh "X" pada tampilan kartu
                if (bingoCard[i][j] == -1) {
                    System.out.printf("| %2s ", "X"); // Menampilkan X untuk nomor yang telah ditandai
                } else if (hideUnmarked && !markedNumbers.contains(bingoCard[i][j])) {
                    System.out.printf("| %2s ", "-"); // Sembunyikan(HIde) nomor yang belum ditandai dengan "-"
                } else {
                    System.out.printf("| %2d ", bingoCard[i][j]); // Tampilkan angka aslinya
                }
            }
            System.out.println("|");
            System.out.println("--------------------------");
        }
    }

    public static void markBingoCard(int[][] bingoCard, int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingoCard[i][j] == number) {
                    bingoCard[i][j] = -1;
                }
            }
        }
    }

    public static boolean checkWin(int[][] bingoCard) {
        for (int i = 0; i < 5; i++) {
            boolean rowWin = true;
            boolean colWin = true;
            for (int j = 0; j < 5; j++) {
                if (bingoCard[i][j] != -1) {
                    rowWin = false;
                }
                if (bingoCard[j][i] != -1) {
                    colWin = false;
                }
            }
            if (rowWin || colWin) {
                return true;
            }
        }

        boolean diagonal1Win = true;
        boolean diagonal2Win = true;
        for (int i = 0; i < 5; i++) {
            if (bingoCard[i][i] != -1) {
                diagonal1Win = false;
            }
            if (bingoCard[i][4 - i] != -1) {
                diagonal2Win = false;
            }
        }
        return diagonal1Win || diagonal2Win;
    }

    public static void secretsMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=== Rahasia-rahasian ===");
        System.out.println("1. Enkripsi");
        System.out.println("2. Dekripsi");
        System.out.print("Pilih Opsi (1-2): ");
        choice = scanner.nextInt();
        scanner.nextLine(); // Untuk mengosongkan buffer input

        switch (choice) {
            case 1:
                System.out.print("Masukkan Teks Yang Akan Dienkripsi: ");
                String textToEncrypt = scanner.nextLine();
                String encryptedText = encrypt(textToEncrypt);
                System.out.println("Hasil Enkripsi: " + encryptedText);
                break;
            case 2:
                System.out.print("Masukkan Teks Yang Akan Didekripsi: ");
                String textToDecrypt = scanner.nextLine();
                String decryptedText = decrypt(textToDecrypt);
                System.out.println("Hasil Dekripsi: " + decryptedText);
                break;
            default:
                System.out.println("Pilihan Tidak Valid.");
        }
    }

    // Fungsi untuk enkripsi berdasarkan logika yang dijelaskan
    public static String encrypt(String text) {
    if (text.length() < 3) {
        return "Teks Terlalu Pendek Untuk Dienkripsi.";
    }

    StringBuilder result = new StringBuilder();
    
    // Kelompok 1: Karakter pertama dan karakter kedua dari akhir
    result.append(text.charAt(text.length() - 2)).append(text.charAt(0));
    
    // Kelompok 2: Karakter kedua sampai kedua dari akhir
    result.append(modifyVowels(text.substring(1, text.length() - 2)));
    
    // Kelompok 3: Karakter pertama (uppercase) dan karakter terakhir (lowercase)
    result.append(Character.toUpperCase(text.charAt(0)));
    result.append(Character.toLowerCase(text.charAt(text.length() - 1)));

    return result.toString();
}

public static String decrypt(String text) {
    if (text.length() < 4) {
        return "Teks Terlalu Pendek Untuk Didekripsi.";
    }

    StringBuilder result = new StringBuilder();
    
    // Pulihkan karakter pertama (dari Kelompok 1)
    result.append(text.charAt(1));
    
    // Pulihkan karakter tengah (dari Kelompok 2)
    result.append(reverseModifyVowels(text.substring(2, text.length() - 2)));
    
    // Pulihkan karakter kedua dari belakang (dari Kelompok 1)
    result.append(text.charAt(0));

    // Pulihkan karakter terakhir (dari Kelompok 3)
    result.append(text.charAt(text.length() - 1));

    return result.toString();
}

private static String modifyVowels(String group) {
    StringBuilder result = new StringBuilder();
    String vowels = "aeiouAEIOU";

    for (char c : group.toCharArray()) {
        if (vowels.indexOf(c) != -1) {
            result.append((char) (c + 1));
        } else {
            result.append(c);
        }
    }
    return result.toString();
}

private static String reverseModifyVowels(String group) {
    StringBuilder result = new StringBuilder();
    String vowels = "aeiouAEIOU";

    for (char c : group.toCharArray()) {
        if (vowels.indexOf((char)(c - 1)) != -1) {
            result.append((char) (c - 1));
        } else {
            result.append(c);
        }
    }
    return result.toString();
}
}
