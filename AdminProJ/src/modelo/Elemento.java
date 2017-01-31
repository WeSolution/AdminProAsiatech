
package modelo;

import bd.BD;
import interfaces.ABCM;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Elemento implements ABCM{
    private int id;
    private String nombre;
    private String descripcion;
    private int id_tarea;
    private String imagen;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Elemento(int id, String nombre, String descripcion, int id_tarea, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id_tarea = id_tarea;
        this.imagen = imagen;
        miConexion = new BD();
    }

    public Elemento() {
        miConexion = new BD();
    }

    @Override
    public boolean alta() {
        boolean band = false;
        Connection con = null;
        PreparedStatement ps = null;
        String query = "";
        
        try {
            query = "INSERT INTO elemento(id,nombre,descripcion,id_tarea,imagen) "
                    + "VALUES(?,?,?,?,?);";
            con = miConexion.conectar();
            ps = con.prepareStatement(query);
            ps.setInt(1, this.id);
            ps.setString(2, this.nombre);
            ps.setString(3, this.descripcion);
            ps.setInt(4, this.id_tarea);
            ps.setString(5, this.imagen);
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
            query = "DELETE FROM elemento WHERE elemento.id = ?";
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
    public List<Elemento> consulta() {
        List<Elemento> el = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "";
        
        try {
            query = "SELECT * FROM elemento;";
            el = new ArrayList();
            con = miConexion.conectar();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                el.add(new Elemento(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("id_tarea"), rs.getString("imagen")));
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
        return el;
    }

    @Override
    public List<Elemento> ver() {
        List<Elemento> el = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "";
        
        try {
            query = "SELECT * FROM elemento WHERE elemento.id = ?;";
            el = new ArrayList();
            con = miConexion.conectar();
            ps = con.prepareStatement(query);
            ps.setInt(1, this.id);
            rs = ps.executeQuery();
            while(rs.next()) {
                el.add(new Elemento(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("id_tarea"), rs.getString("imagen")));
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
        return el;
    }

    @Override
    public boolean modifiacion(int id) {
        boolean band = false;
        Connection con = null;
        PreparedStatement ps = null;
        String query = "";
        
        try {
            query = "UPDATE elemento SET elemento.id = ?, elemento.nombre = ?,"
                    + " elemento.descripcion = ?, "
                    + " elemento.id_tarea = ?, elemento.imagen = ?"
                    + " WHERE elemento.id = ?";
            con = miConexion.conectar();
            ps = con.prepareStatement(query);
            ps.setInt(1, this.id);
            ps.setString(2, this.nombre);
            ps.setString(3, this.descripcion);
            ps.setInt(4, this.id_tarea);
            ps.setString(5, this.imagen);
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
    

}
