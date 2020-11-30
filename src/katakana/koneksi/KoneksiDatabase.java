/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package katakana.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nana
 */

public class KoneksiDatabase {
   Connection con;
   Statement st;
    ResultSet rs;
    
   public Connection getConnection(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/katakana","root","");
            //JOptionPane.showMessageDialog(null, "Konesi ke Database BERHASIL");
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Konesi ke Database GAGAL");
        }
        return con;
    }
  
   
   public ArrayList<String[]> getWeights(String target) throws SQLException
    {
        ArrayList<String[]> weights = new ArrayList<>();
        con = this.getConnection();
        String sql = "SELECT * FROM bobot where target='" + target + "'";
        st = con.createStatement();
        rs = st.executeQuery(sql);

        String[] result;
        while (rs.next())
        {
            result = new String[] {
                rs.getString("layer"),
                rs.getString("bobot"),
                rs.getString("indexI"),
                rs.getString("indexJ")
            };
            weights.add(result);
        }
        
        return weights;
    }
   
   public ArrayList<String[]> getWeightsBP(String target) throws SQLException
    {
        ArrayList<String[]> weights = new ArrayList<>();
        con = this.getConnection();
        String sql = "SELECT * FROM bobotbp where target='" + target + "'";
        st = con.createStatement();
        rs = st.executeQuery(sql);

        String[] result;
        while (rs.next())
        {
            result = new String[] {
                rs.getString("layer"),
                rs.getString("bobot"),
                rs.getString("indexI"),
                rs.getString("indexJ")
            };
            weights.add(result);
        }
        return weights;
    }
   
   public ArrayList<String[]> getoutputtarget(String target) throws SQLException
    {
        ArrayList<String[]> outputs = new ArrayList<>();
        con = this.getConnection();
        String sql = "SELECT * FROM output_target where target='" + target + "'";
        st = con.createStatement();
        rs = st.executeQuery(sql);

        String[] result;
        while (rs.next())
        {
            result = new String[] {
                rs.getString("output_ernn"),
                rs.getString("indexI")
            };
            outputs.add(result);
        }
        return outputs;
    }
   
   public ArrayList<String[]> getoutputtargetBP(String target) throws SQLException
    {
        ArrayList<String[]> outputs = new ArrayList<>();
        con = this.getConnection();
        String sql = "SELECT * FROM output_targetbp where target='" + target + "'";
        st = con.createStatement();
        rs = st.executeQuery(sql);

        String[] result;
        while (rs.next())
        {
            result = new String[] {
                rs.getString("output_bp"),
                rs.getString("indexI")
            };
            outputs.add(result);
        }
        return outputs;
    }
}
