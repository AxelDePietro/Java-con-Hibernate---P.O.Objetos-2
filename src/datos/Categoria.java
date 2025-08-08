package datos;

public class Categoria {

	private int idCategoria;
	private String tipo;

	public Categoria() {
	}

	public Categoria(String tipo) {
		super();
		this.tipo = tipo;
		
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	protected void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", tipo=" + tipo + "]";
	}
	
}