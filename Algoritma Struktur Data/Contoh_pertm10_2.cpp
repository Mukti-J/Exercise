#include <iostream> 
#include <string>   //Library string

struct Mahasiswa { // Define struct Mahasiswa
    std::string nama; // Field nama 
    int umur;          // Field umur 
};

int main() { 
    Mahasiswa saya;   // Deklarasi variabel saya dengan tipe Mahasiswa

    std::cout << "Masukkan nama: "; // Tampilkan teks "Masukkan nama: "
    std::getline(std::cin, saya.nama); // Baca input nama dan simpan ke variabel saya.nama

    std::cout << "Masukkan umur: "; // Tampilkan teks "Masukkan umur: "
    std::cin >> saya.umur; // Baca input umur dan simpan ke variabel saya.umur

    std::cout << "\n\n---------------\n"; 

    std::cout << "Halo Perkenalkan ;)\n"
              << "Nama Saya " << saya.nama << "\n"
              << "Umur Saya " << saya.umur << " Tahun" <<std::endl; 

    return 0; 

    
}