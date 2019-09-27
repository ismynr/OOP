package data;
/**
 * Nama : Ismi Nururrizqi 
 * NIM  : 17090042
 * Kelas: 4D 
 * Kasus: CRUD buku di perpustakaan
 */
public class buku{

    private String kode;
    private String judul;
    private String pengarang;
    private String penerbit;
    private String thnTerbit;

    public buku(){}
    public buku(String kode, String judul, String pengarang, String penerbit, String tahunTerbit){
        this.kode = kode;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        thnTerbit = tahunTerbit;
    }
    @Override
    public boolean equals(Object obj) {
        buku mhs = (buku) obj;
        if(this.kode.equals(mhs.getKode())){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public String toString() {
        return "[ "+ kode +", "+ judul +", "+ pengarang +", "+ penerbit +", "+ thnTerbit +" ];";
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
    public String getThnTerbit() {
        return thnTerbit;
    }
    public void setThnTerbit(String thnTerbit) {
        this.thnTerbit = thnTerbit;
    }

}