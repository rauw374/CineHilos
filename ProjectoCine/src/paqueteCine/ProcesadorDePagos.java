package paqueteCine;

public class ProcesadorDePagos {
	private Cine cine;
	private final int costoEntrada = 10;
	
	
	
	public ProcesadorDePagos(Cine cine) {
		super();
		this.cine = cine;
	}
	
	public boolean procesarPago(String cuentaBancaria,int fondos) {
		System.out.println("Procesando pago....");
		//vamos a verificar que cumple con las condiciones
		if(fondos >= costoEntrada ) {
			System.out.println("el el pago ha sido exitoso");
			cine.recaudacion(costoEntrada);
			return true;
		}else {
			System.out.println("Fallo en el proceso de pago");
			return false;
		}
	}

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
