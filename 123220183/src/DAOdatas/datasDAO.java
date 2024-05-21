/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdatas;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAOImplement.dataimplement;
/**
 *
 * @author Lab Informatika
 */
public class datasDAO implements dataimplement{
    Connection connection;
    
    final String select = "SELECT * FROM data_sewa";
    final String insert = "INSERT INTO data_sewa(Nama,NamaBuku,JenisBuku,Telepon,Durasi,Total) VALUES (?,?,?,?,?);";
    final String update = "UPDATE data_sewa set NamaBuku=?, JenisBuku=?, Telepon=?, Durasi=?, Total=? where Nama=?;";
    final String delete = "DELETE from data_sewa where Telepon=?;";
    
    public datasDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(datas s) {
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, s.getNama());
            statement.setString(2, s.getNamaBuku());
            statement.setString(3, s.getJenisBuku());
            statement.setString(2, s.getTelepon());
            statement.setInt(4, s.getDurasi());
            int biayaDasar = 10000;
            int tambahanhari = 5000;
            int total;
            
            if(s.getDurasi() <= 2){
                total = s.getDurasi()*biayaDasar;
            }
            else{
                int biayaAwal = 2 * biayaDasar;
                int Tambahan = s.getDurasi() - 2;
                int biayaTambahan = Tambahan * (biayaDasar + tambahanhari);
                total = biayaAwal + biayaTambahan;
            }
            statement.setInt(5, total);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                s.setTelepon(rs.getString(1));
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();  
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datas s) {
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(update);
            
            statement.setString(1, s.getNamaBuku());
            statement.setString(2, s.getJenisBuku());
            statement.setString(3, s.getTelepon());
            statement.setInt(4, s.getDurasi());
            int biayaDasar = 10000;
            int tambahanhari = 5000;
            int total;
            
            if(s.getDurasi() <= 2){
                total = s.getDurasi()*biayaDasar;
            }
            else{
                int biayaAwal = 2 * biayaDasar;
                int Tambahan = s.getDurasi() - 2;
                int biayaTambahan = Tambahan * (biayaDasar + tambahanhari);
                total = biayaAwal + biayaTambahan;
            }
            statement.setInt(4, total);
            statement.setString(5, s.getNama());
            statement.executeUpdate();
          
        }catch(SQLException ex){
            ex.printStackTrace();  
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String Plat) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, Plat);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();  
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<datas> getAll() {
        List<datas> ds = null;
        try{
            ds = new ArrayList<datas>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datas s = new datas();
                s.setNama(rs.getString("Nama"));
                s.setNamaBuku(rs.getString("Nama Buku"));
                s.setJenisBuku(rs.getString("Jenis Buku"));
                s.setTelepon(rs.getString("Telepon"));
                s.setDurasi(rs.getInt("Durasi"));
                s.setTotal(rs.getInt("Total"));
                ds.add(s);
            }
        }catch(SQLException ex){
            Logger.getLogger(datasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ds;
    }

}
