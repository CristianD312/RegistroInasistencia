package logical;

public class Usuario {
private int id_usuario;
private String nombre;
private String contraseña;
private boolean es_admin;
private String pregunta_secreta;
private String respuesta_secreta;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre, String contraseña, boolean es_admin, String pregunta_secreta, String respuesta_secreta) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.es_admin = es_admin;
        this.pregunta_secreta = pregunta_secreta;
        this.respuesta_secreta = respuesta_secreta;
    }



    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isEs_admin() {
        return es_admin;
    }

    public void setEs_admin(boolean es_admin) {
        this.es_admin = es_admin;
    }

    public String getPregunta_secreta() {
        return pregunta_secreta;
    }

    public void setPregunta_secreta(String pregunta_secreta) {
        this.pregunta_secreta = pregunta_secreta;
    }

    public String getRespuesta_secreta() {
        return respuesta_secreta;
    }

    public void setRespuesta_secreta(String respuesta_secreta) {
        this.respuesta_secreta = respuesta_secreta;
    }


}
