package paqueteCine;

/**
 * Clase principal que contiene el método main para la simulación del cine.
 */
public class Main {

    /**
     * Método principal que inicia la simulación del cine.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Inicializamos las clases
        Cine cine = new Cine(generarCuentas("cine"));
        ProcesadorDePagos pg = new ProcesadorDePagos(cine);
        GestorDeReservas gr = new GestorDeReservas(cine, pg);
        Visualizador visualizador = new Visualizador(cine);

        // Pasamos la instancia de Visualizador al constructor del Thread
        Thread thVisualizador = new Thread(visualizador);
        thVisualizador.start();

        // Este bucle hace que la simulación no finalice
        while (true) {
            String nombre = nombreAleatorio();
            String apellido = apellidoAleatorio();
            Cliente cliente = new Cliente(nombre, apellido, generarCorreo(nombre, apellido),
                    generarCuentas(nombre), generarFondos(), generarFila(cine.getRow()),
                    generarColumna(cine.getColumn()), gr);

            // Pasamos la instancia de Cliente al constructor del Thread
            Thread thCliente = new Thread(cliente);
            thCliente.start();

            try {
                // Hacemos que espere para que al visualizador le dé tiempo a mostrarse
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Cuando el cine esté lleno, lo vaciamos, y hacemos que el bucle vuelva a empezar con nuevos clientes
            if (cine.estaLleno()) {
                System.out.println("El cine está lleno, el cine ha recaudado " + cine.getRecaudacionTotal() + "€");
                System.out.println("Vaciando la sala para que comience la siguiente película");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cine.resetAsientos();
            }
        }
    }

    /**
     * Genera una cuenta a partir del nombre proporcionado.
     *
     * @param nombre Nombre para generar la cuenta.
     * @return La cuenta generada.
     */
    public static String generarCuentas(String nombre) {
        StringBuilder cuenta = new StringBuilder();
        for (int i = 0; i < nombre.length(); i++) {
            cuenta.append(nombre.charAt(i));
        }
        return cuenta.toString() + nombre.charAt(0);
    }

    /**
     * Genera un nombre aleatorio a partir de una lista predefinida.
     *
     * @return El nombre generado.
     */
    public static String nombreAleatorio() {
        String[] nombres = {
                "Lucía", "Martín", "Valentina", "Emilio", "Victoria",
                "Daniel", "Renata", "Alejandro", "Camila", "David",
                "Marina", "Simón", "Julia", "Adrián", "Sofía",
                "Mateo", "Carolina", "Joaquín", "Aurora", "Sebastián"
        };
        int numero = (int) Math.floor(Math.random() * 19);
        return nombres[numero];
    }

    /**
     * Genera un apellido aleatorio a partir de una lista predefinida.
     *
     * @return El apellido generado.
     */
    public static String apellidoAleatorio() {
        String[] apellidos = {
                "López", "García", "Gómez", "Fernández", "Pérez",
                "Martínez", "Rodríguez", "Sánchez", "Díaz", "Romero",
                "Ruiz", "Torres", "Jiménez", "Gutiérrez", "Núñez",
                "Hernández", "Serrano", "Castro", "Vargas", "Molina",
                "Ramírez", "Navarro", "Alvarez", "González", "Silva",
                "Ramos", "Flores", "Herrera", "Guerrero", "Ortega"
        };
        int numero = (int) Math.floor(Math.random() * 19);
        return apellidos[numero];
    }

    /**
     * Genera un correo electrónico a partir del nombre y apellido proporcionados.
     *
     * @param nombre   Nombre del cliente.
     * @param apellido Apellido del cliente.
     * @return El correo electrónico generado.
     */
    public static String generarCorreo(String nombre, String apellido) {
        return nombre + "." + apellido + "@gmail.com";
    }

    /**
     * Genera una cantidad aleatoria de fondos para el cliente.
     *
     * @return La cantidad de fondos generada.
     */
    public static int generarFondos() {
        return (int) Math.floor(Math.random() * 1000);
    }

    /**
     * Genera una fila aleatoria para la ubicación del cliente en el cine.
     *
     * @param nFila Número total de filas en el cine.
     * @return La fila generada.
     */
    public static int generarFila(int nFila) {
        return (int) Math.floor(Math.random() * nFila);
    }

    /**
     * Genera una columna aleatoria para la ubicación del cliente en el cine.
     *
     * @param nColumna Número total de columnas en el cine.
     * @return La columna generada.
     */
    public static int generarColumna(int nColumna) {
        return (int) Math.floor(Math.random() * nColumna);
    }
}