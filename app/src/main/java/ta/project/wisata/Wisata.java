package ta.project.wisata;

public class Wisata {

    private String namaWisata;
    private String gambar;
    private String deskripsi;
    private String alamat;
    private String fasilitas;

    public Wisata(){}

    public Wisata(String namaWisata, String gambar, String deskripsi, String alamat, String fasilitas) {
        this.namaWisata = namaWisata;
        this.gambar = gambar;
        this.deskripsi = deskripsi;
        this.alamat = alamat;
        this.fasilitas = fasilitas;
    }

    public String getNamaWisata() {
        return namaWisata;
    }

    public void setNamaWisata(String namaWisata) {
        this.namaWisata = namaWisata;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }
}
