package datos;

public class Estado {

	private int idEstado;
	private String tipo;

	public Estado() {
	}

	public Estado(String tipo) {
		super();
		this.tipo = tipo;
	}

	public int getIdEstado() {
		return idEstado;
	}

	protected void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "Estado [idEstado=" + idEstado + ", tipo=" + tipo + "]";
	}
	
}
