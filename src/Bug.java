
public class Bug {
    private String id;
    private String titulo;
    private String descripcion;

    public Bug (String id, String titulo, String descripcion){
        this.id = id;
       setTitulo(titulo);
        setDescripcion(descripcion);
    }
     public String getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        if (titulo.isBlank()){
            throw new IllegalArgumentException("Este campo es obligatorio, no puede ser vacio");
        }
        this.titulo = titulo;
    }
    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if(descripcion.length()>20){
            System.out.println("Maximo 10 caracteres");
            throw new IllegalArgumentException("el campo acepta maximo 20 caracteres");
        }
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "BUG" + " Id:" + id + "| Titulo: " + titulo + "| Descripcion: " + descripcion + ". ";
    }
}
