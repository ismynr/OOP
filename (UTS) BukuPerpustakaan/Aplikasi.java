/**
 * Nama : Ismi Nururrizqi 
 * NIM  : 17090042
 * Kelas: 4D
 * Kasus: CRUD buku di perpustakaan
 */
import java.util.List;
import java.util.Scanner;
import data.buku;
import operasi.crudServices;

public class Aplikasi{
 
    private static Scanner masukan;
    private static crudServices cSRV = new crudServices();

    public static void main(String[] args){
        String jwb = "";
        masukan = new Scanner(System.in);
        do{
            menu();
            jwb = masukan.nextLine();
            System.out.println("\n============================================");
            switch(jwb){
                case "1": 
                    System.out.println("-- Tambah Data Buku --");
                    inputData();
                    break;
                case "2":
                    System.out.println("-- Ubah Data Buku --");
                    ubahData();
                    break;
                case "3":
                    System.out.println("-- Hapus Data Buku --");
                    hapusData();
                    break;
                case "4":
                    System.out.println("-- Data Buku --");
                    tampilData();
                    break;
                case "5":
                    System.out.println("Terima kasih telah menggunakan program");
                    break;
                default:
                    System.out.println("Pilihan anda tidak sesuai dengan daftar ");
                    break;
            }
            System.out.println("============================================");
        }while(!jwb.equals("5"));
    }
    private static void menu(){
        System.out.println("\n\n\n<--><--><--><><--><--><--><><--><--><--><><--><--><-->");
        System.out.println("     Aplikasi Sederhana - CRUD Buku Di Perpustakaan");
        System.out.println("<--><--><--><><--><--><--><><--><--><--><><--><--><-->");
        System.out.println("1. Tambah data buku");
        System.out.println("2. Ubah data buku berdasarkan kode");
        System.out.println("3. Hapus data buku");
        System.out.println("4. Tampilkan semua data buku");
        System.out.println("5. Keluar");
        System.out.print("Pilih salah satu -> ");
    }
    private static void inputData(){
        masukan = new Scanner(System.in);
        String kode, judul, pengarang, penerbit, thnTerbit;
        System.out.print("Kode         > ");
        kode = masukan.nextLine();
        System.out.print("Judul        > ");
        judul = masukan.nextLine();
        System.out.print("Pengarang    > ");
        pengarang = masukan.nextLine();
        System.out.print("Penerbit     > ");
        penerbit = masukan.nextLine();
        System.out.print("Tahun Terbit > ");
        thnTerbit = masukan.nextLine();
        cSRV.tambahBuku(new buku(kode, judul, pengarang, penerbit, thnTerbit));
    }
    private static void ubahData(){
        List<buku> listBuku = cSRV.tampilkanBuku();
        masukan = new Scanner(System.in);
        String kode="", judul="", pengarang="", penerbit="", thnTerbit="", in;
        int idxKode;
        
        tampilData();
        System.out.print("Masukan kode yang ingin diubah > ");
        kode = masukan.nextLine();
        idxKode = cSRV.cekGetIndex(new buku(kode, null, null, null, null)); 

        if(idxKode >= 0){
            System.out.println("\nKet: ketik Y / y untuk mengubah data, ketik sembarang untuk tidak mengubah data");
            
            System.out.print("Ubah Judul        ? [Y/y]> ");
            in = masukan.nextLine();
            if(in.equals("Y") || in.equals("y")) {System.out.print("Masukan judul baru       -->> ");judul = masukan.nextLine();}
            else {judul = listBuku.get(idxKode).getJudul();}
            
            System.out.print("\nUbah Pengarang    ? [Y/y]> ");
            in = masukan.nextLine();
            if(in.equals("Y") || in.equals("y")) {System.out.print("Masukan pengarang baru   -->> "); pengarang = masukan.nextLine();}
            else {pengarang = listBuku.get(idxKode).getPengarang();}

            System.out.print("\nUbah Penerbit     ? [Y/y]> ");
            in = masukan.nextLine();
            if(in.equals("Y") || in.equals("y")) {System.out.print("Masukan penerbit baru    -->> "); penerbit = masukan.nextLine();}
            else {penerbit = listBuku.get(idxKode).getPenerbit();}

            System.out.print("\nUbah Tahun Terbit ? [Y/y]> ");
            in = masukan.nextLine();
            if(in.equals("Y") || in.equals("y")) {System.out.print("Masukan Tahun Terbit baru -->>"); thnTerbit = masukan.nextLine();}
            else {thnTerbit = listBuku.get(idxKode).getThnTerbit();}

            cSRV.ubahBuku(new buku(kode, judul, pengarang, penerbit, thnTerbit));

        }else{
            System.out.println("Kode yang anda masukan tidak ada");
        }
    }
    private static void hapusData(){
        masukan = new Scanner(System.in);
        String opsiHapus, indexHapus;
        System.out.println("1. Hapus semua ");
        System.out.println("2. Hapus berdasarkan kode");
        System.out.print("Pilih salah satu -> ");
        opsiHapus = masukan.nextLine();
        switch(opsiHapus){
            case "1":
                cSRV.hapusSemuaBuku();
                break;
            case "2":
                System.out.println();
                tampilData();
                System.out.print("Masukan kode yang ingin dihapus -> ");
                indexHapus = masukan.nextLine();
                cSRV.hapusBuku(new buku(indexHapus, null, null, null, null));
                break;
            default:
                System.out.println("Pilihan tidak sesuai dengan daftar");
                break;
        }
    }
    private static void tampilData(){
        List<buku> listBuku = cSRV.tampilkanBuku();
        int nomer = 1;
        for(buku buku : listBuku){
            System.out.print(nomer + "). ");
            System.out.println("Kode: " + buku.getKode() + "\tJudul: " + buku.getJudul() + 
                            "\tPengarang: " + buku.getPengarang() + "\tPenerbit: " + buku.getPenerbit() +
                            "\tTahun Terbit: " + buku.getThnTerbit());
            nomer++ ;
        }
    }

}