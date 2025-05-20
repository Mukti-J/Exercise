package Tugas3;

/**
 * Class MobilSports merupakan subclass dari Kendaraan.
 * Menyediakan informasi tambahan tentang kecepatan tertinggi mobil sports.
 */
class MobilSports extends Kendaraan {
    private int topSpeed;

    /**
     * Konstruktor untuk MobilSports.
     *
     * @param brand    Brand mobil sport
     * @param model    Model mobil sport
     * @param tahun    Tahun pembuatan mobil sport
     * @param topSpeed Kecepatan maksimum mobil sport dalam km/h
     */
    public MobilSports(String brand, String model, int tahun, int topSpeed) {
        super(brand, model, tahun);
        this.topSpeed = topSpeed;
    }

    /**
     * Menampilkan informasi detail mobil sport, termasuk kecepatan maksimum.
     * 
     * @Override digunakan di sini untuk memberikan versi yang diubah dari method displayInfo
     * yang ada di class induk (Kendaraan).
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Top Speed: " + topSpeed + " km/h");
    }
}