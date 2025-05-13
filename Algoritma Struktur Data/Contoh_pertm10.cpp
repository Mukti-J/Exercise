#include <iostream>

int main() {
    int data[5]; // deklarasi array dengan 5 elemen
    for(int i = 1; i < 6; i++) { //Fungsi loop untuk mengulang dari 1 hingga ke 5
        std::cout << "Masukkan nilai ke-" << i << ": ";
        std::cin >> data[i]; //menerima inputan user yang akan di store didalam variebal data
    }
    for(int i = 1; i < 6; i++) {
        std::cout << "--------------------" << "\nNilai ke-" << i << ": " << data[i] << std::endl;
    }
    return 0;
}