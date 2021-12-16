public interface Teacher {
    String _Nombre = null;
    int _Tipo = 0;
    int _salarioBaseMensual =2000;
    int _comision = 500;
    int _bonus = 100;
    static final int ProfesorTP = 0;
    static final int ProfesorTC = 1;
    static final int Administrativo = 2;
    int Sueldo();
    String Name();

}



