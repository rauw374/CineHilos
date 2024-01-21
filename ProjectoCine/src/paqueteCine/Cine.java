package paqueteCine;

/**
 * La clase Cine representa un cine con una disposición de asientos en forma de matriz.
 */
public class Cine {
    private final int column = 10;  // Número de columnas de asientos
    private final int row = 10;     // Número de filas de asientos
    private Asiento[][] asientos = new Asiento[row][column];  // Matriz de asientos en el cine
    private int recaudacionTotal;  // Almacena la recaudación total del cine
    private String cuentaCine;     // Cuenta bancaria asociada al cine

    /**
     * Constructor de la clase Cine.
     *
     * @param cuentaCine Cuenta bancaria asociada al cine.
     */
    public Cine(String cuentaCine) {
        this.recaudacionTotal = 0;
        this.cuentaCine = cuentaCine;
        inicializarAsientos(); // Llamada al método para inicializar los asientos
    }

    /**
     * Inicializa la matriz de asientos con instancias de la clase Asiento.
     */
    public void inicializarAsientos() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                asientos[i][j] = new Asiento(i, j);
            }
        }
    }

    /**
     * Verifica la disponibilidad de un asiento en la fila y columna especificadas.
     *
     * @param fila    Número de fila del asiento.
     * @param columna Número de columna del asiento.
     * @return true si el asiento está disponible, false si está ocupado.
     */
    public boolean verificarDisponibilidad(int fila, int columna) {
        return !this.asientos[fila][columna].isOcupado();
    }

    /**
     * Reserva un asiento en la fila y columna especificadas.
     *
     * @param fila    Número de fila del asiento.
     * @param columna Número de columna del asiento.
     */
    public void reservarAsiento(int fila, int columna) {
        this.asientos[fila][columna].setOcupado(true);
    }

    /**
     * Verifica si todos los asientos del cine están ocupados.
     *
     * @return true si todos los asientos están ocupados, false si hay al menos uno disponible.
     */
    public boolean estaLleno() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!this.asientos[i][j].isOcupado()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Agrega una cantidad específica a la recaudación total del cine.
     *
     * @param pago Monto a agregar a la recaudación total.
     */
    public void recaudacion(int pago) {
        this.recaudacionTotal += pago;
    }

    /**
     * Restablece todos los asientos del cine a un estado no ocupado.
     */
    public void resetAsientos() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                this.asientos[i][j].setOcupado(false);
            }
        }
    }

    /**
     * Obtiene la recaudación total del cine.
     *
     * @return La cantidad total recaudada.
     */
    public int getRecaudacionTotal() {
        return recaudacionTotal;
    }

    /**
     * Obtiene el número de columnas de asientos en el cine.
     *
     * @return Número de columnas.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Obtiene el número de filas de asientos en el cine.
     *
     * @return Número de filas.
     */
    public int getRow() {
        return row;
    }

    /**
     * Obtiene la matriz de asientos del cine.
     *
     * @return La matriz de asientos.
     */
    public Asiento[][] getAsientos() {
        return asientos;
    }

    /**
     * Establece la matriz de asientos del cine.
     *
     * @param asientos Nueva matriz de asientos.
     */
    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }

    /**
     * Obtiene la cuenta bancaria asociada al cine.
     *
     * @return La cuenta bancaria del cine.
     */
    public String getCuentaCine() {
        return cuentaCine;
    }

    /**
     * Establece la cuenta bancaria asociada al cine.
     *
     * @param cuentaCine Nueva cuenta bancaria del cine.
     */
    public void setCuentaCine(String cuentaCine) {
        this.cuentaCine = cuentaCine;
    }
}