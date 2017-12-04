
public class Accion {
	
	double apertura;
	double max;
	double min;
	double cierreActual;
    String diferencial;
	
	public Accion(double apertura,double max,double min,double cierreActual,double diferencialDiaSiguiente){
		System.out.println(diferencialDiaSiguiente);
		this.apertura = apertura;
		this.max = max;
		this.min = min;
		this.cierreActual = cierreActual;
		if(diferencialDiaSiguiente>0){
			diferencial = "sube"; 
		}else{
			diferencial = "alta";
		}
	}

	@Override
	public String toString() {
		return this.cierreActual+","+this.apertura+","+this.max+","+this.min+","+this.diferencial;
	}

	

}
