package paqueteCine;

public class Cine {

    Asiento[][] asientos;
    private int recaudacionTotal;
    private String cuentaCine;

    public Cine(String cuentaCine) {
        this.recaudacionTotal = 0;
        this.cuentaCine = cuentaCine;
    }

    public Asiento[][] inicializarAsientos(int filas, int columnas) {
        Asiento[][] asientos = new Asiento[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                asientos[i][j] = new Asiento(i + 1, j + 1);
            }
        }

        return asientos;
    }

    public boolean verificarDisponibilidad(int fila, int columna) {
        return !this.asientos[fila][columna].isOcupado();
    }

    public void reservarAsiento(int fila, int columna) {
        this.asientos[fila][columna].setOcupado(true);
    }

    public boolean estaLleno(int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!this.asientos[i][j].isOcupado()) {
                    return false;
                }
            }
        }
        return true;
    }
    public void recaudacion(int pago) {
    	this.recaudacionTotal += pago;
    }
    public void resetAsientos(int filas, int columnas) {
    	for(int i=0;i < filas;i++) {
    		for (int j = 0; j < columnas; j++) {
				this.asientos[i][j].setOcupado(false);
			}
    	}
    }

	public Cine(Asiento[][] asientos, int recaudacionTotal, String cuentaCine) {
		super();
		this.asientos = asientos;
		this.recaudacionTotal = recaudacionTotal;
		this.cuentaCine = cuentaCine;
	}

	public Asiento[][] getAsientos() {
		return asientos;
	}

	public void setAsientos(Asiento[][] asientos) {
		this.asientos = asientos;
	}

	public int getRecaudacionTotal() {
		return recaudacionTotal;
	}

	public void setRecaudacionTotal(int recaudacionTotal) {
		this.recaudacionTotal = recaudacionTotal;
	}

	public String getCuentaCine() {
		return cuentaCine;
	}

	public void setCuentaCine(String cuentaCine) {
		this.cuentaCine = cuentaCine;
	}
    
    
}