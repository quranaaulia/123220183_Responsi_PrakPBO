/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Lab Informatika
 */
public class modeltabeldatas extends AbstractTableModel {

    List<datas> ds;
    public modeltabeldatas(List<datas>ds){
        this.ds =ds;
        
    }   
    @Override
    public int getRowCount() {
        return ds.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Nama";
            case 1:
                return "Nama Buku";
            case 2:
                return "Jenis Buku";
            case 3:
                return "Telepon";
            case 4:
                return "Durasi";
            case 5:
                return "Total";
            default :
            return null;
                
        }
    }
    

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return ds.get(row).getNama();
            case 1:
                return ds.get(row).getNamaBuku();
            case 2:
                return ds.get(row).getJenisBuku();
            case 3:
                return ds.get(row).getTelepon();
            case 4:
                return ds.get(row).getDurasi();
            case 5:
                return ds.get(row).getTotal();
            default :
            return null;
                
        }
    }
}
