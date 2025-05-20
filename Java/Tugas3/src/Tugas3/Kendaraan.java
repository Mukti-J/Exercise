package Tugas3;

/**
 * Class Kendaraan adalah class dasar yang merepresentasikan kendaraan umum.
 * Class ini digunakan sebagai parent class untuk MobilListrik dan MobilSports.
 */
class Kendaraan {
    protected String brand;
    protected String model;
    protected int tahun;

    /**
     * Konstruktor untuk class Kendaraan.
     *
     * @param brand Brand kendaraan
     * @param model Model kendaraan
     * @param tahun Tahun pembuatan kendaraan
     */
    public Kendaraan(String brand, String model, int tahun) {
        this.brand = brand;
        this.model = model;
        this.tahun = tahun;
    }

    /**
     * Menampilkan informasi dasar kendaraan.
     */
    public void displayInfo() {
        System.out.println("Brand: " + brand + "\nModel: " + model + "\nTahun: " + tahun);
    }
}