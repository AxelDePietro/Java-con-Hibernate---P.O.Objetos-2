package test;

import negocio.EstadoAbm;

public class TestEstado {

	public static void main(String[] args) {

		EstadoAbm eABM = new EstadoAbm();
		
		try {
			int idEstadoAbierto = eABM.crearEstado("abierto");
			System.out.println("se creo estado 'abierto', id: " + idEstadoAbierto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			int idEstadoEnProceso = eABM.crearEstado("en proceso");
			System.out.println("se creo estado 'en proceso', id: " + idEstadoEnProceso);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			int idEstadoCerrado = eABM.crearEstado("cerrado");
			System.out.println("se creo estado 'cerrado', id: " + idEstadoCerrado);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(eABM.traerEstado(1));
		
		System.out.println(eABM.traerEstado(2));
		
		System.out.println(eABM.traerEstado(3));
		
		System.out.println(eABM.traerEstado(4));
		
	}

}
