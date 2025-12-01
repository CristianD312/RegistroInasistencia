package logical;

public class Personal {
    private int id;
    private String Nombre;
    private String Apellido;
    private int Cuil;
    private String cargo;

    public Personal() {

    }

    public Personal(String Nombre, String Apellido, int Cuil) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Cuil = Cuil;
    }

    public Personal(int id, String Nombre, String Apellido, int Cuil) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Cuil = Cuil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getCuil() {
        return Cuil;
    }

    public void setCuil(int cuil) {
        Cuil = Cuil;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
