package datos;

public class Empleado extends Usuario {
	
	private String rol;
	private String legajo; 
	
	public Empleado() {}
	
	public Empleado(String nombre, String apellido, int dni, Contacto contacto, String rol, String legajo) {
		super(nombre, apellido, dni, contacto);
		this.rol = rol; 
		this.legajo = legajo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	@Override
	public String toString() {
	    return "Empleado {\n" +
	           "  rol: " + rol + ",\n" +
	           "  legajo: " + legajo + "\n" +
	           "}";
	}
}
