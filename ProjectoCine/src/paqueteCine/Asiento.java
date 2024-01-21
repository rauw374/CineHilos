package paqueteCine;

/**
 * Clase que representa un asiento en un cine.
 */
public class Asiento {

    private int fila;
    private int columna;
    private boolean ocupado;

    /**
     * Constructor de la clase Asiento.
     *
     * @param fila    Número de fila del asiento.
     * @param columna Número de columna del asiento.
     */
    public Asiento(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.ocupado = false;
    }

    /**
     * Obtiene el número de fila del asiento.
     *
     * @return Número de fila del asiento.
     */
    public int getFila() {
        return fila;
    }

    /**
     * Establece el número de fila del asiento.
     *
     * @param fila Número de fila del asiento.
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Obtiene el número de columna del asiento.
     *
     * @return Número de columna del asiento.
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Establece el número de columna del asiento.
     *
     * @param columna Número de columna del asiento.
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * Verifica si el asiento está ocupado.
     *
     * @return true si el asiento está ocupado, false de lo contrario.
     */
    public boolean isOcupado() {
        return ocupado;
    }

    /**
     * Establece el estado de ocupación del asiento.
     *
     * @param ocupado true si se desea marcar el asiento como ocupado, false de lo contrario.
     */
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}