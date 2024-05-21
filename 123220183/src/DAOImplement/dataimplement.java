/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;
import java.util.List;
import model.*;

/**
 *
 * @author Lab Informatika
 */
public interface dataimplement {
    public void insert(datas s);
    public void update (datas s);
    public void delete (String Telepon);
    
    public List<datas> getAll();
}
