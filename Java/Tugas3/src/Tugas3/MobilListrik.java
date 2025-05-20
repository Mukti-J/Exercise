package Tugas3;

/**
 * Class MobilListrik merupakan subclass dari Kendaraan.
 * Menyediakan informasi tambahan tentang kapasitas baterai mobil listrik.
 */
class MobilListrik extends Kendaraan {
    private int kapasitasBaterai;

    /**
     * Konstruktor untuk MobilListrik.
     *
     * @param brand           Brand mobil listrik
     * @param model           Model mobil listrik
     * @param tahun           Tahun pembuatan mobil listrik
     * @param kapasitasBaterai Kapasitas baterai mobil listrik dalam kWh
     */
    public MobilListrik(String brand, String model, int tahun, int kapasitasBaterai) {
        super(brand, model, tahun);
        this.kapasitasBaterai = kapasitasBaterai;
    }

    /**
     * Menampilkan informasi detail mobil listrik, termasuk kapasitas baterai.
     * Method ini menggunakan konsep overriding untuk memperluas method displayInfo dari class Kendaraan.
     * 
     * @Override merupakan anotasi yang menunjukkan bahwa method ini meng-override method dari class induk.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Kapasitas Baterai: " + kapasitasBaterai + " kWh");
    }
}