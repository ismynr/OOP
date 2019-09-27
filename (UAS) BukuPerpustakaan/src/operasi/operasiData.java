package operasi;

import entity.buku;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import koneksi.knk;

public class operasiData {
    private knk koneksi;
    private String sql;
    private List<buku> dataBuku;
    
    public void insert(buku buku) throws SQLException{
        koneksi = new knk();
        sql = "INSERT INTO buku(kode, judul, pengarang, penerbit, thn_terbit) "
                + "VALUES('"+buku.getKode()+"', '"+buku.getJudul()+"', '"+buku.getPengarang()+"', "
                + "'"+buku.getPenerbit()+"', '"+buku.getThnTerbit()+"')";
        koneksi.eksekusiUpdate(sql);
        koneksi.tutupKoneksi();
    }
    public void delete(int row) throws SQLException{
        koneksi = new knk();
        sql = "DELETE FROM buku WHERE id="+row;
        koneksi.eksekusiUpdate(sql);
        koneksi.tutupKoneksi();
    }
    public void update(int id, buku buku) throws SQLException{
        koneksi = new knk();
        sql = "UPDATE buku SET kode='"+buku.getKode()+"', judul='"+buku.getJudul()+"', pengarang='"+buku.getPengarang()+"', "
                + "penerbit='"+buku.getPenerbit()+"', thn_terbit='"+buku.getThnTerbit()+"' "
                + "WHERE id="+id;
        
        koneksi.eksekusiUpdate(sql);
        koneksi.tutupKoneksi();
    }
    public void operationGetData(String key) throws SQLException{
        koneksi = new knk();
        dataBuku = new ArrayList<>();
        String W = "";
        if(!key.equals("")){
            W = "WHERE id LIKE '%"+key+"%' OR kode LIKE '%"+key+"%' OR judul LIKE '%"+key+"%' OR "
                + "pengarang LIKE '%"+key+"%' OR penerbit LIKE '%"+key+"%' OR thn_terbit LIKE '%"+key+"%'";
        }
        ResultSet rs = koneksi.eksekusiSelect("SELECT * FROM buku " + W);
        while(rs.next()){
            dataBuku.add(new buku(rs.getInt(1), rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getString(5), rs.getInt(6)));
        }
        koneksi.tutupKoneksi();
    }
    public List<buku> getData(){
        return dataBuku;
    }
    public int getId() throws SQLException{
        koneksi = new knk();
        int id = 0;
        sql = "SELECT MAX(id) FROM buku";
        ResultSet rs = koneksi.eksekusiSelect(sql);
        while (rs.next()) { 
            id = rs.getInt(1)+1; 
            //RESET ID TERAKHIR DITAMBAHKAN
            koneksi.eksekusiUpdate("ALTER TABLE buku AUTO_INCREMENT="+id);
        }
        koneksi.tutupKoneksi();
        return id;
    }
}
