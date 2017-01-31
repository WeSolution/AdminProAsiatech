
package Vista;

import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Proyecto;

public class Vista1 {
        
    public void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public void llenarJTable(JTable tabla, List<Proyecto> datos) {
        tabla.removeAll();
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Id Proyecto");
        modelo.addColumn("Fecha del Proyecto");
        modelo.addColumn("Descripción");
        for (Proyecto dato : datos) {
            Object[] o = new Object[3];
            o[0] = dato.getId();
            o[1] = dato.getFecha_proyecto();
            o[2] = dato.getDescripcion();
            modelo.addRow(o);
        }
    }

}
