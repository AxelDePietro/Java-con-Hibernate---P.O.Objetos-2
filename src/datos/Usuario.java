package datos;

public abstract class Usuario {

	private int idUsuario;
	private String nombre;
	private String apellido;
	private int dni; 
	
	private Contacto contacto;

	public Usuario() {
	}

	public Usuario(String nombre, String apellido, int dni, Contacto contacto) {
		super();
		this.nombre = nombre;
		this.apellido = apellido; 
		this.dni = dni;
		this.contacto = contacto;
	}


	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	@Override
	public String toString() {
	    return "Usuario {\n" +
	           "  idUsuario: " + idUsuario + ",\n" +
	           "  nombre: \"" + nombre + "\",\n" +
	           "  apellido: \"" + apellido + "\",\n" +
	           "  dni: " + dni + "\n" +
	           "}";
	}
	
}