package paqueteCine;

public class Cliente {
	private String nombre;
	private String apellido;
	private String correo;
	private String cuentaBancaria;
	private int fondos;
	private int filaDeseada;
	private int columnaDeseada;
	
	private GestorDeReservas gestorDeReservas;

	public Cliente(String nombre, String apellido, String correo, String cuentaBancaria, int fondos, int filaDeseada,
			int columnaDeseada, GestorDeReservas gestorDeReservas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.cuentaBancaria = cuentaBancaria;
		this.fondos = fondos;
		this.filaDeseada = filaDeseada;
		this.columnaDeseada = columnaDeseada;
		this.gestorDeReservas = gestorDeReservas;
	}
	/*
	 * inicializamos el run 
	 * 
	 * 
	 * */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public int getFondos() {
		return fondos;
	}

	public void setFondos(int fondos) {
		this.fondos = fondos;
	}

	public int getFilaDeseada() {
		return filaDeseada;
	}

	public void setFilaDeseada(int filaDeseada) {
		this.filaDeseada = filaDeseada;
	}

	public int getColumnaDeseada() {
		return columnaDeseada;
	}

	public void setColumnaDeseada(int columnaDeseada) {
		this.columnaDeseada = columnaDeseada;
	}

	public GestorDeReservas getGestorDeReservas() {
		return gestorDeReservas;
	}

	public void setGestorDeReservas(GestorDeReservas gestorDeReservas) {
		this.gestorDeReservas = gestorDeReservas;
	}
		
}
