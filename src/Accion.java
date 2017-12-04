
public class Accion {
	
	double apertura;
	double max;
	double min;
	double cierreAnterior;
        String fluctuacion;
	
	public Accion(double apertura,double max,double min,double cierreAnterior){
		this.apertura = apertura;
		this.max = max;
		this.min = min;
		this.cierreAnterior = cierreAnterior;
                if(apertura-cierreAnterior>0){
                    fluctuacion = "sube";
                }else{
                    fluctuacion = "baja";
                }
	}

	@Override
	public String toString() {
		return this.cierreAnterior+","+this.apertura+","+this.max+","+this.min+","+this.fluctuacion;
	}

	

}
