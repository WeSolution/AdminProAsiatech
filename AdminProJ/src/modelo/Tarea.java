
package modelo;

import bd.BD;
import interfaces.ABCM;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Tarea implements ABCM {
    private int id;
    private String nombre;
    private String fecha_tarea;
    private String descripcion;
    private String id_proyecto;
    private BD miConexion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_tarea() {
        return fecha_tarea;
    }

    public void setFecha_tarea(String fecha_tarea) {
        this.fecha_tarea = fecha_tarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(String id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public Tarea(int id, String nombre, String fecha_tarea, String descripcion, String id_proyecto) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_tarea = fecha_tarea;
        this.descripcion = descripcion;
        this.id_proyecto = id_proyecto;
        miConexion = new BD();
    }

    public Tarea() {
        miConexion = new BD();
    }

    @Override
    public boolean alta() {
        boolean band = false;
        Connection con = null;
        PreparedStatement ps = null;
        String query = "";
        
        try {
            query = "INSERT INTO tarea (id,nombre,fecha_tarea,descripcion,id_proyecto)"
                    + " values(?,?,?,?,?)";
            con = miConexion.conectar();
            ps = con.prepareStatement(query);
            ps.setInt(1, this.id);
            ps.setString(2, this.nombre);
            ps.setString(3, this.fecha_tarea);
            ps.setString(4, this.descripcion);
            ps.setString(5, this.id_proyecto);
            ps.executeUpdate();
            band = true;   
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return band;
    }

    @Override
    public boolean baja() {
        boolean band = false;
        Connection con = null;
        PreparedStatement ps = null;
        String query = "";
        
        try {
            query = "DELETE FROM tarea WHERE tarea.id = ?";
            con = miConexion.conectar();
            ps = con.prepareStatement(query);
            ps.setInt(1, this.id);
            ps.executeUpdate();
            band = true;   
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return band;        
    }

    @Override
    public List<Tarea> consulta() {
        List<Tarea> t = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "";
        
        try {
            query = "SELECT * FROM tarea;";
            t = new ArrayList();
            con = miConexion.conectar();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                t.add(new Tarea(rs.getInt("id"),rs.getString("id_proyecto"), rs.getString("fecha_tarea"), rs.getString("descripcion"),rs.getString("id_proyecto")));
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    @Override
    public List<Tarea> ver() {
        List<Tarea> t = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "";
        
        try {
            query = "SELECT * FROM tarea WHERE tarea.id = ?;";
            t = new ArrayList();
            con = miConexion.conectar();
            ps = con.prepareStatement(query);
            ps.setInt(1, this.id);
            rs = ps.executeQuery();
            while(rs.next()) {
                t.add(new Tarea(rs.getInt("id"),rs.getString("id_proyecto"), rs.getString("fecha_tarea"), rs.getString("descripcion"),rs.getString("id_proyecto")));
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    @Override
    public boolean modifiacion(int id) {
        boolean band = false;
        Connection con = null;
        PreparedStatement ps = null;
        String query = "";
        
        try {
            query = "UPDATE tarea SET tarea.id = ?, tarea.nombre = ?, "
                    + "tarea.fecha_tarea = ?, tarea.descripcion = ?, "
                    + "tarea.id_proyecto = ? WHERE tarea.id = ?";
            con = miConexion.conectar();
            ps = con.prepareStatement(query);
            ps.setInt(1, this.id);
            ps.setString(2, this.nombre);
            ps.setString(3, this.fecha_tarea);
            ps.setString(4, this.descripcion);
            ps.setString(5, this.id_proyecto);
            ps.setInt(6, id);
            ps.executeUpdate();
            band = true;   
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return band;
    }

    @Override
    public boolean modifiacion(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> consultaEspecial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
