package Tugas3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Class Main merupakan titik masuk untuk program Anugerah Mobil.
 * Program ini menampilkan menu interaktif untuk menampilkan berbagai jenis mobil,
 * seperti mobil listrik, mobil sport, serta memungkinkan pengguna untuk memfilter mobil berdasarkan brand.
 */
public class Main {
    private static List<Kendaraan> daftarMobil = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Method main menjalankan program dan menampilkan menu interaktif.
     *
     * @param args argumen baris perintah (tidak digunakan dalam program ini)
     */
    public static void main(String[] args) {
        // Menginisialisasi daftar mobil
        initializeDaftarMobil();

        // Loop untuk menampilkan menu sampai pengguna memilih untuk keluar
        while (true) {
            displayMenu();
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Mengkonsumsi karakter newline setelah input

            // Pilihan menu
            switch (pilihan) {
                case 1:
                    displaySemuaMobil();
                    break;
                case 2:
                    displayMobilListrik();
                    break;
                case 3:
                    displayMobilSports();
                    break;
                case 4:
                    filterMobilByBrand();
                    break;
                case 5:
                    // Banner keluar program
                    System.out.println("========================================");
                    System.out.println("|                                      |");
                    System.out.println("|    Terima kasih telah menggunakan    |");
                    System.out.println("|           Anugerah Mobil!            |");
                    System.out.println("|          Sampai jumpa lagi!          |");
                    System.out.println("|                                      |");
                    System.out.println("========================================");
                    return;
                default:
                    System.out.println("Pilihan Menu tidak valid. Silakan coba lagi.");
            }

            System.out.println("\nTekan Enter untuk melanjutkan...");
            scanner.nextLine();  // Pause sebelum kembali ke menu
        }
    }

    /**
     * Menginisialisasi daftar mobil dengan data contoh (mobil listrik, mobil sports, dan mobil reguler).
     */
    private static void initializeDaftarMobil() {
        daftarMobil.add(new MobilListrik("Tesla", "Model S", 2021, 100));
        daftarMobil.add(new MobilListrik("Hyundai", "IONIQ 5", 2023, 77));
        daftarMobil.add(new MobilListrik("BYD", "Dolphin", 2023, 60));
        daftarMobil.add(new MobilSports("Porsche", "911 GT3", 2019, 318));
        daftarMobil.add(new MobilSports("Porsche", "718 Cayman GT4", 2023, 295));
        daftarMobil.add(new MobilSports("Audi", "R8", 2020, 330));
        daftarMobil.add(new MobilSports("Bugatti", "Chiron", 2016, 420));
        daftarMobil.add(new Kendaraan("Toyota", "Fortuner", 2022));
        daftarMobil.add(new Kendaraan("Mitsubishi", "Pajero Sport", 2020));
    }

    /**
     * Menampilkan menu utama program.
     */
    private static void displayMenu() {
        System.out.println("=== Anugerah Mobil ===");
        System.out.println("1. Tampilkan Semua Mobil");
        System.out.println("2. Tampilkan Mobil Listrik");
        System.out.println("3. Tampilkan Mobil Sports");
        System.out.println("4. Filter Mobil berdasarkan Brand");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu (1-5): ");
    }

    /**
     * Menampilkan semua mobil yang ada dalam daftar.
     */
    private static void displaySemuaMobil() {
        System.out.println("\nDaftar Semua Mobil:");
        for (Kendaraan mobil : daftarMobil) {
            mobil.displayInfo();
            System.out.println();
        }
    }

    /**
     * Menampilkan hanya mobil listrik yang ada dalam daftar.
     */
    private static void displayMobilListrik() {
        System.out.println("\nDaftar Mobil Listrik:");
        for (Kendaraan mobil : daftarMobil) {
            if (mobil instanceof MobilListrik) {
                mobil.displayInfo();
                System.out.println();
            }
        }
    }

    /**
     * Menampilkan hanya mobil sport yang ada dalam daftar.
     */
    private static void displayMobilSports() {
        System.out.println("\nDaftar Mobil Sports:");
        for (Kendaraan mobil : daftarMobil) {
            if (mobil instanceof MobilSports) {
                mobil.displayInfo();
                System.out.println();
            }
        }
    }

    /**
     * Memungkinkan pengguna untuk memfilter mobil berdasarkan brand.
     */
    private static void filterMobilByBrand() {
        System.out.print("Masukkan nama brand: ");
        String brandFilter = scanner.nextLine();

        System.out.println("\nHasil pencarian untuk Mobil dengan brand '" + brandFilter + "':");
        boolean found = false;
        for (Kendaraan mobil : daftarMobil) {
            if (mobil.brand.equalsIgnoreCase(brandFilter)) {
                mobil.displayInfo();
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Tidak ada mobil dengan brand '" + brandFilter + "' ditemukan dalam Daftar Mobil.");
        }
    }
}
