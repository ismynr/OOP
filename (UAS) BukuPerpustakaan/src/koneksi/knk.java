package koneksi;

import java.sql.*;

public class knk {
    private Connection conn;
    private Statement st;
    
    public knk() throws SQLException, SQLTimeoutException{
        bukaKoneksi();
    }
    public void bukaKoneksi() throws SQLException, SQLTimeoutException{
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phboop_perpus", "root", "");
        st = conn.createStatement();
    }
    public ResultSet eksekusiSelect(String sql) throws SQLException, SQLTimeoutException{
        bukaKoneksi();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }
    public int eksekusiUpdate(String sql) throws SQLException, SQLTimeoutException{
        bukaKoneksi();
        int result = st.executeUpdate(sql);
        return result;
    }
    public void tutupKoneksi() throws SQLException, SQLTimeoutException{
        conn.close();
    }
}
