package operasi;
/**
 * Nama : Ismi Nururrizqi 
 * NIM  : 17090042 
 * Kelas: 4D
 * Kasus: CRUD buku di perpustakaan
 */
import java.util.ArrayList;
import java.util.List;
import data.buku;

public class crudServices{
    
    private static List<buku> data = new ArrayList<>();

    public int cekGetIndex(buku buku){
        return data.indexOf(buku);
    }
    public void tambahBuku(buku buku){
        data.add(buku);
        System.out.println("Data disimpan ");
    }
    public void ubahBuku(buku buku){
        int result = cekGetIndex(buku);
        if(result >= 0){
            data.set(result, buku);
            System.out.println("berhasil diubah");
        }else{
            System.out.println("\nKode tidak ditemukan");
        }
    }
    public void hapusSemuaBuku(){
        data.clear();
        System.out.println("Data buku dihapus semua");
    }
    public void hapusBuku(buku buku){
        int result = cekGetIndex(buku);
        if(result >= 0){
            data.remove(result);
            System.out.println("\nData buku pada index: "+ result +", kode: "+ buku.getKode() +" dihapus");
        }else{
            System.out.println("\nKode tidak ditemukan");
        }
    }
    public List<buku> tampilkanBuku(){
        return data;
    }
} 