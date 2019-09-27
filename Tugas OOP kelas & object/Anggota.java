public class Anggota {
    Integer nomorAngg;
    String namaAngg;
    
    public Anggota(int nomorAngg, String namaAngg){
        this.nomorAngg = nomorAngg; 
        this.namaAngg = namaAngg;
    }
    public String getAnggota(){
        return nomorAngg + " : " + namaAngg;
    }
    public void print(){
        System.out.println(getAnggota());
    }
}