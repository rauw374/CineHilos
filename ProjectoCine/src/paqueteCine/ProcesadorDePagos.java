package paqueteCine;

/**
 * Clase que representa un procesador de pagos para el cine.
 */
public class ProcesadorDePagos {
    private Cine cine;
    private final int costoEntrada = 10;

    /**
     * Constructor de la clase ProcesadorDePagos.
     *
     * @param cine Instancia del cine al que pertenece el procesador de pagos.
     */
    public ProcesadorDePagos(Cine cine) {
        this.cine = cine;
    }

    /**
     * Procesa el pago de un cliente y verifica si tiene fondos suficientes para la entrada.
     *
     * @param cuentaBancaria La cuenta bancaria del cliente.
     * @param fondos         Los fondos disponibles en la cuenta del cliente.
     * @return `true` si el pago fue exitoso, `false` si falló por fondos insuficientes.
     */
    public boolean procesarPago(String cuentaBancaria, int fondos) {
        System.out.println("Procesando pago....");
        // Verificamos que cumpla con las condiciones
        if (fondos >= costoEntrada) {
            System.out.println("El pago ha sido exitoso");
            cine.recaudacion(costoEntrada);
            return true;
        } else {
            System.out.println("Fallo en el proceso de pago: Fondos insuficientes");
            return false;
        }
    }

    // Getters y setters

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }

    public int getCostoEntrada() {
        return costoEntrada;
    }
}