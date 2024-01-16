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
}