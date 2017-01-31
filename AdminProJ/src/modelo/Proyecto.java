
package modelo;
import bd.BD;
import interfaces.ABCM;
import java.sql.*;
import java.util.*;


public class Proyecto implements ABCM{
    private String id;
    private String fecha_proyecto;
    private String descripcion;
    private BD miConexion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha_proyecto() {
        return fecha_proyecto;
    }

    public void setFecha_proyecto(String fecha_proyecto) {
        this.fecha_proyecto = fecha_proyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripción) {
        this.descripcion = descripción;
    }

    public Proyecto(String id, String fecha_proyecto, String descripción) {
        this.id = id;
        this.fecha_proyecto = fecha_proyecto;
        this.descripcion = descripción;
        miConexion = new BD();
                
    }

    public Proyecto() {
        miConexion = new BD();
    }

    @Override
    public boolean alta() {
        boolean band = false;
        Connection con = null;
        PreparedStatement ps = null;
        String query = "";
        
        try {
            query = "INSERT INTO proyecto (id, fecha_proyecto, descripcion)"
                    + " values(?,?,?);";
            con = miConexion.conectar();
            ps = con.prepareStatement(query);
            ps.setString(1, this.id);
            ps.setString(2, this.fecha_proyecto);
            ps.setString(3, this.descripcion);
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
            query = "DELETE FROM proyecto WHERE proyecto.id = ?";
            con = miConexion.conectar();
            ps = con.prepareStatement(query);
            ps.setString(1, this.id);
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
    public List<Proyecto> consulta() {
        List<Proyecto> p = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "";
        
        try {
            query = "SELECT * FROM proyecto;";
            p = new ArrayList();
            con = miConexion.conectar();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                p.add(new Proyecto(rs.getString("id"), rs.getString("fecha_proyecto"), rs.getString("descripcion")));
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
        return p;
    }

    @Override
    public List<Proyecto> ver() {
        List<Proyecto> p = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "";
        
        try {
            query = "SELECT * FROM proyecto WHERE proyecto.id = ?;";
            p = new ArrayList();
            con = miConexion.conectar();
            ps = con.prepareStatement(query);
            ps.setString(1, this.id);
            rs = ps.executeQuery();
            while(rs.next()) {
                p.add(new Proyecto(rs.getString("id"), rs.getString("fecha_proyecto"), rs.getString("descripcion")));
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
        return p;
    }

    @Override
    public boolean modifiacion(String id) {
        boolean band = false;
        Connection con = null;
        PreparedStatement ps = null;
        String query = "";
        
        try {
            query = "UPDATE proyecto SET proyecto.id = ?, proyecto.fecha_proyecto = ?, "
                    + "proyecto.descripcion = ? WHERE proyecto.id = ?";
            con = miConexion.conectar();
            ps = con.prepareStatement(query);
            ps.setString(1, this.id);
            ps.setString(2, this.fecha_proyecto);
            ps.setString(3, this.descripcion);
            ps.setString(4, id);
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
    public boolean modifiacion(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
