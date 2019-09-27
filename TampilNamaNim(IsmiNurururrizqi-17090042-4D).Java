import javax.swing.*;
import java.awt.*;

public class Aplikasi{

    public static void main(String[] args){
        JFrame frame = new JFrame("Menampilkan Data");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        
        Font FontJudul = new Font("Arial", Font.BOLD, 20);
        Font FontBiasa = new Font("Arial", Font.BOLD, 14);
        Color biruNom = Color.decode("#70C3D8");
        Color putih = Color.decode("#ffffff");

        JPanel panelKiri = new JPanel();
        panelKiri.setBackground(biruNom);
        frame.add(panelKiri, BorderLayout.WEST);

        JPanel panelKanan = new JPanel();
        panelKanan.setBackground(biruNom);
        frame.add(panelKanan, BorderLayout.EAST);

        JTextArea txta = new JTextArea();
        txta.setFont(FontBiasa);
        txta.append("\n\n\tNama : Ismi Nururrizqi\n");
        txta.append("\tNim  : 17090042");
        txta.setEditable(false);

        JPanel panelJudul = new JPanel();
        panelJudul.setBackground(biruNom);
        JLabel labelJudul = new JLabel("Menampilkan nama dan nim");
        labelJudul.setForeground(putih);
        labelJudul.setFont(FontJudul);
        
        panelJudul.add(labelJudul);

        frame.add(panelJudul, BorderLayout.NORTH);
        frame.add(txta, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
