package entity;

public class buku {
    private int id;
    private String kode;
    private String judul;
    private String pengarang;
    private String penerbit;
    private int thnTerbit;
    
    public buku(int id, String kode, String judul, String pengarang, String penerbit, int thnTerbit){
        this.id = id;
        this.kode = kode;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.thnTerbit = thnTerbit;
    }
    public buku(String kode, String judul, String pengarang, String penerbit, int thnTerbit){
        this.kode = kode;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.thnTerbit = thnTerbit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getThnTerbit() {
        return thnTerbit;
    }

    public void setThnTerbit(int thnTerbit) {
        this.thnTerbit = thnTerbit;
    }
    @Override
    public String toString() {
        return "[ "+ id + ", " + kode +", "+ judul +", "+ pengarang +", "+ penerbit +", "+ thnTerbit +" ];";
    }
    
}
