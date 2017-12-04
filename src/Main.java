
public class Main {
	public static void main(String args[]){
		Leer l = new Leer();
		GenerarModelo g = new GenerarModelo();
		g.leerArchivoArff();
		System.out.println(g.leerModelo());
	}
}
