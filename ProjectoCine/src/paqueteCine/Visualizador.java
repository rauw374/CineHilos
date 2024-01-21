package paqueteCine;

/**
 * Clase que visualiza el estado de los asientos en un cine de manera periódica.
 */
public class Visualizador implements Runnable {

    private Cine cine;

    /**
     * Constructor de la clase Visualizador.
     *
     * @param cine Instancia del cine cuyo estado se visualizará.
     */
    public Visualizador(Cine cine) {
        this.cine = cine;
    }

    /**
     * Método principal del hilo de ejecución del visualizador.
     */
    @Override
    public void run() {
        while (true) {
            try {
                // Espera un corto período de tiempo antes de mostrar el estado de los asientos
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Sincronización con el objeto cine para evitar conflictos con otros hilos
            synchronized (cine) {
                mostrarEstadoAsientos();
                // Notifica a cualquier hilo que esté esperando en el objeto cine
                cine.notifyAll();
            }
        }
    }

    /**
     * Muestra el estado de los asientos en la consola, utilizando "[1]" para asientos ocupados y "[0]" para libres.
     */
    public void mostrarEstadoAsientos() {
        Asiento[][] asientos = cine.getAsientos();
        for (int fila = 0; fila < cine.getRow(); fila++) {
            for (int columna = 0; columna < cine.getColumn(); columna++) {
                if (asientos[fila][columna].isOcupado()) {
                    System.out.print("[1]");
                } else {
                    System.out.print("[0]");
                }
            }
            System.out.print("\n");
        }
        System.out.println("-------------------------------");
    }
}