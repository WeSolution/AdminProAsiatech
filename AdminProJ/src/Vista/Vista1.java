
package Vista;

import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
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
    
    public void llenarJTableCE(JTable tabla, String valorBuscado, JComboBox cmb ){
        List<Proyecto> datos = null;
        Proyecto p = null;
        if(cmb.getSelectedItem() == "Id Proyecto"){
            p = new Proyecto("%" + valorBuscado + "%", "", "");
            datos = p.consultaEspecial();
        }
        else if(cmb.getSelectedItem() == "Fecha del Proyecto") {
            p = new Proyecto("", "%" + valorBuscado + "%", "");
            datos = p.consultaEspecial();
        }
        else if(cmb.getSelectedItem() == "Descripción") {
            p = new Proyecto("", "", "%" + valorBuscado + "%");
            datos = p.consultaEspecial();
        }
        else {
            p = new Proyecto();
            datos = p.consulta();
        }
        
        if(datos != null){
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

}
