package datos;



public class Contacto {

 
    private int idContacto;
    private int numero;
    private String email;
    private Usuario usuario;

    public Contacto() {
    }

    public Contacto(int numero, String email, Usuario usuario) {
        this.numero = numero;
        this.email = email;
        this.usuario = usuario;
    }
    
    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public int getNumero() {
        return numero;
    }

    public String getEmail() {
        return email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", numero=" + numero + ", email=" + email + ", usuario=" + usuario
				+ "]";
	}
    
    
}