package paqueteCine;

public class Asiento {

	 private int fila;
	 private int columna;
	 private boolean ocupado;
	public Asiento(int fila, int columna) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.ocupado = false;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
}
