
public class Accion {
	
	double apertura;
	double max;
	double min;
	double cierreAnterior;
	
	public Accion(double apertura,double max,double min,double cierreAnterior){
		this.apertura = apertura;
		this.max = max;
		this.min = min;
		this.cierreAnterior = cierreAnterior;
	}

	@Override
	public String toString() {
		return this.cierreAnterior+","+this.apertura+","+this.max+","+this.min;
	}

	

}
