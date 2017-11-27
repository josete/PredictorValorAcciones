import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Escribir {
	
	public String fileName = "accionesBBVA.arff";
	
	 public void guardar(ArrayList<Accion> acciones) {
	        FileWriter fichero = null;
	        try {
	            String cabecera = "%Valores acciones BBVA\n"
	                    + "@attribute cierreAnterior Real\n"
	                    + "@attribute apertura Real\n"
	                    + "@attribute max Real\n"
	                    + "@attribute min Real\n"
	                    + "@data";
	            PrintWriter pw = null;
	            fichero = new FileWriter(fileName);
	            pw = new PrintWriter(fichero);
	            pw.println(cabecera);
	            for (Accion a : acciones) {
	                pw.println(a);
	            }
	        } catch (IOException ex) {
	            
	        } finally {
	            try {
	                if (null != fichero) {
	                    fichero.close();
	                }
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
	    }

}
