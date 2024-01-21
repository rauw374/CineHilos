package paqueteCine;

/**
 * Clase que gestiona las reservas en un cine.
 */
public class GestorDeReservas {
    private Cine cine;
    private ProcesadorDePagos procesadorDePagos;

    /**
     * Constructor de la clase GestorDeReservas.
     *
     * @param cine             Instancia del cine para el cual se gestionarán las reservas.
     * @param procesadorDePagos Instancia del procesador de pagos asociado al cine.
     */
    public GestorDeReservas(Cine cine, ProcesadorDePagos procesadorDePagos) {
        this.cine = cine;
        this.procesadorDePagos = procesadorDePagos;
    }

    /**
     * Método para realizar una reserva de asiento para un cliente en el cine.
     *
     * @param cliente          Cliente que realiza la reserva.
     * @param filaDeseada      Fila deseada por el cliente.
     * @param columnaDeseada   Columna deseada por el cliente.
     */
    public synchronized void reservar(Cliente cliente, int filaDeseada, int columnaDeseada) {
        System.out.println(cliente.getNombre() + " quiere reservar el asiento de la fila " + filaDeseada +
                " en la columna " + columnaDeseada);

        if (cine.verificarDisponibilidad(filaDeseada, columnaDeseada)) {
            procesarReserva(cliente, filaDeseada, columnaDeseada);
        } else {
            System.out.println("El asiento no está disponible. Buscando asientos alternativos...");

            int[] asientoAlternativo = buscarAsientoAlternativo(filaDeseada, columnaDeseada, cine.getColumn(), cine.getRow());

            if (asientoAlternativo != null) {
                System.out.println("Asiento alternativo encontrado en la fila " + asientoAlternativo[0] +
                        " y columna " + asientoAlternativo[1]);
                procesarReserva(cliente, asientoAlternativo[0], asientoAlternativo[1]);
            } else {
                System.out.println("No hay asientos alternativos disponibles.");
            }
        }
    }

    /**
     * Busca un asiento alternativo cercano al deseado por el cliente.
     *
     * @param filaDeseada    Fila deseada por el cliente.
     * @param columnaDeseada Columna deseada por el cliente.
     * @param filas          Número total de filas en el cine.
     * @param columnas       Número total de columnas en el cine.
     * @return Arreglo con las coordenadas [fila, columna] del asiento alternativo o null si no hay asientos disponibles.
     */
    public int[] buscarAsientoAlternativo(int filaDeseada, int columnaDeseada, int filas, int columnas) {
        int[] filaColumna = new int[2];
        double distanciaMinima = Double.POSITIVE_INFINITY;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (cine.verificarDisponibilidad(i, j) && !(i == filaDeseada && j == columnaDeseada)) {
                    double distanciaTotal = calcularDistancia(filaDeseada, columnaDeseada, i, j);

                    if (distanciaTotal < distanciaMinima) {
                        distanciaMinima = distanciaTotal;
                        filaColumna[0] = i;
                        filaColumna[1] = j;
                    }
                }
            }
        }

        return (distanciaMinima != Double.POSITIVE_INFINITY) ? filaColumna : null;
    }

    /**
     * Calcula la distancia entre dos puntos en la sala del cine utilizando el teorema de Pitágoras.
     *
     * @param filaDeseada    Fila del asiento deseado.
     * @param columnaDeseada Columna del asiento deseado.
     * @param fila           Fila del asiento alternativo.
     * @param columna        Columna del asiento alternativo.
     * @return Distancia entre los dos puntos.
     */
    private double calcularDistancia(int filaDeseada, int columnaDeseada, int fila, int columna) {
        double distanciaFilas = Math.abs(filaDeseada - fila);
        double distanciaColumnas = Math.abs(columnaDeseada - columna);
        return Math.sqrt(distanciaFilas * distanciaFilas + distanciaColumnas * distanciaColumnas);
    }

    /**
     * Procesa la reserva del cliente, verificando fondos y actualizando el estado del cine.
     *
     * @param cliente Cliente que realiza la reserva.
     * @param fila    Fila del asiento reservado.
     * @param columna Columna del asiento reservado.
     */
    public void procesarReserva(Cliente cliente, int fila, int columna) {
        if (procesadorDePagos.procesarPago(cliente.getCuentaBancaria(), cliente.getFondos())) {
            cliente.setFondos(cliente.getFondos() - procesadorDePagos.getCostoEntrada());
            cine.reservarAsiento(fila, columna);
            System.out.println("Reserva realizada con éxito para " + cliente.getNombre() + " " + cliente.getApellido());
        } else {
            System.out.println("Reserva rechazada para " + cliente.getNombre() + " " + cliente.getApellido() +
                    " por fondos insuficientes");
        }
    }

    /**
     * Obtiene la instancia del cine asociada al gestor de reservas.
     *
     * @return Instancia del cine.
     */
    public Cine getCine() {
        return cine;
    }
}