#include <iostream>
#include <algorithm> // Diperlukan untuk std::sort
#include <string> // Diperlukan untuk tipe data string
using namespace std;

// Fungsi untuk melakukan pencarian biner pada array string
int binarySearch(string listData[], int size, string value) {
    int low = 0; // Inisialisasi batas bawah
    int high = size - 1; // Inisialisasi batas atas

    while (low <= high) { // Loop selama batas bawah kurang dari atau sama dengan batas atas
        int mid = (low + high) / 2; // Hitung titik tengah

        if (listData[mid] == value) { // Jika nilai tengah sama dengan nilai yang dicari
            return mid; // Kembalikan indeks tengah
        } else if (listData[mid] < value) { // Jika nilai tengah kurang dari nilai yang dicari
            low = mid + 1; // Sesuaikan batas bawah ke tengah + 1
        } else { // Jika nilai tengah lebih besar dari nilai yang dicari
            high = mid - 1; // Sesuaikan batas atas ke tengah - 1
        }
    }
    return -1; // Kembalikan -1 yang berarti nilai tidak ditemukan
}

int main() {
    string value; // Deklarasi variabel untuk menyimpan nilai yang akan dicari
    string nums[] = {"yefta ariel", "tio", "iqbal", "riza", "indah", "juan", "cicy", "johanes", "domi", "lina",
                     "ope", "james", "rogers", "ardis", "solo", "aliffia", "helena", "niar", "destio", "yeho/aji",
                     "odit", "dikta", "mukti", "michael", "adit", "ferdycksen", "vando"}; // Inisialisasi array dengan nilai
    int size = sizeof(nums) / sizeof(nums[0]); // Hitung ukuran array dalam elemen

    // Urutkan array sebelum melakukan pencarian biner
    sort(nums, nums + size);

    cout << "Masukkan nama yang ingin dicari: "; // Tampilkan pesan untuk meminta input
    cin >> value; // Input nilai yang akan dicari

    int result = binarySearch(nums, size, value); // Menyimpan hasil pengembalian dari fungsi binarySearch

    if (result != -1) { // Jika hasil tidak sama dengan -1 (nilai ditemukan)
        cout << "Nama ditemukan" << endl;
    } else { // Jika hasil sama dengan -1 (nilai tidak ditemukan)
        cout << "Nama tidak ditemukan." << endl;
    }

    return 0;
}
