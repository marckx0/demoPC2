public class Administrativo implements Teacher{
    private String _Nombre;
    private int _Tipo;
    private int _salarioBaseMensual =2000;
    private int _comision = 500;
    private int _bonus = 100;
    static final int ProfesorTP = 0;
    static final int ProfesorTC = 1;
    static final int Administrativo = 2;
    Administrativo(int type, String nombre) {
        _Tipo = type;
        _Nombre = nombre;
    }
    public int Sueldo() {
        return _salarioBaseMensual + _bonus;

    }

    public String Name(){
        return _Nombre;
    }
}

