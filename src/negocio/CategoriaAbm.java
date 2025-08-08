package negocio;

import dao.CategoriaDao;
import datos.Categoria;

public class CategoriaAbm {
    private CategoriaDao dao = new CategoriaDao();

    public int agregarCategoria(String tipo) {
    	if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de categoría no puede estar vacío");
        }
    	Categoria categoria = new Categoria();
    	categoria.setTipo(tipo);
        return dao.agregar(categoria);
    }

    public Categoria traerCategoria(int idCategoria) {
    	if (idCategoria <= 0) {
            throw new IllegalArgumentException("ID de categoría no valido");
        }
        return dao.traer(idCategoria);
    }

    public void modificarCategoria(Categoria categoria) {
    	if (categoria == null) {
            throw new IllegalArgumentException("La categoría a modificar no existe");
    	}
        if (dao.estaAsociadaATickets(categoria.getIdCategoria())) {
            throw new RuntimeException("No se puede modificar la categoría porque está asociada a tickets");
        }
        dao.actualizar(categoria);
    }

    public void eliminarCategoria(int idCategoria) throws Exception {
        if (dao.estaAsociadaATickets(idCategoria)) {
            throw new RuntimeException("No se puede eliminar la categoría porque está asociada a tickets");
        }
        Categoria categoria = dao.traer(idCategoria);
        if (categoria == null) {
            throw new Exception("Categoría no encontrada");
        }
        dao.eliminar(categoria);
    }
}