package interfaces;

import java.util.List;


public interface ABCM {
    public boolean alta();
    public boolean baja();
    public List<?> consulta();
    public List<?> consultaEspecial();
    public List<?> ver();
    public boolean modifiacion(int id);
    public boolean modifiacion(String id);
}
