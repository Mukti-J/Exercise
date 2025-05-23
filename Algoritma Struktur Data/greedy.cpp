#include <iostream> //fungsi input output
#include <vector> //struktur data vector
#include <algorithm> //fungsi sort

using namespace std;

void sortDescending(vector<int> &arr) { //mendefinisikan sort descending untuk mengurutkan arr secara menurun
    sort(arr.begin(), arr.end(), greater<int>()); //menggunakan sort dengan parameter greater<int> untuk pengurutan menurun
}

int main() {
    const int size = 99; // size sebesar 99
    int i, uang, n; //deklarasi sebagai integer
    vector<int> x(size), hasil(size);//deklarasi vektor x dan hasil untuk mentimpan nilai koin dan hasil pecahan koin

    cout << "Banyak Koin: ";
    cin >> n; //menyimpan banyak koin dalam n
    if(n>0){ //jika n lebih dari 0
        cout << "\nMasukan Jenis Koin:\n";
        for (i = 0; i < n; i++) { //supaya bisa memasukkan nilai sebanyak nilai n menggunakan loop supaya i tidak boleh lebih besar dari n
            cin >> x[i];// menyimpan Jenis koin dalam x[i]
        }

        sortDescending(x);//melempar x kedalam void sortDescending untuk mengurutkan secara menurun

        cout << "\nKoin yang tersedia:\n";
        for (i = 0; i < n; i++) {//loop untuk mencetak elemen x[i](baris 27) yang sudah diurutkan
            cout << x[i] << " ";
        }
        cout << endl; //enter

        cout << "\nMasukan Nilai yang dipecah: ";
        cin >> uang;//menyimpan nilai yang dipecah dalam variabel uang

        for (i = 0; i < n; i++) {
            hasil[i] = uang / x[i];//Menghitung jumlah keping koin x[i] yang dibutuhkan
            uang %= x[i];//Menghitung sisa uang setelah menggunakan koin x[i]
        }

        for (i = 0; i < n; i++) {
            if (hasil[i] > 0) {
                cout << "Keping " << x[i] << " sebanyak: " << hasil[i] << endl; //Menampilkan jumlah keping untuk setiap jenis koin yang digunakan
            }
        }

        cout << "Sisa yang tidak bisa dipecah: " << uang << endl;//Menampilkan sisa uang yang tidak bisa dipecah.
    }
    else {//program jika n tidak lebih besar dari 0
        cout<< "nilai yang dimasukkan tdak valid";
    }
    return 0;
}
