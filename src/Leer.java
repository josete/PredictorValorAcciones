
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Leer {
	
	private static final String file = "historica.xls";
	
	public Leer(){
		ArrayList<Accion> acciones = new ArrayList<>();	
		try{
			FileInputStream excelFile = new FileInputStream(new File(file));
			Workbook workbook = new HSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			int currentRowNumber = 0;
			while (iterator.hasNext()) {
				double[] valores = new double[4];
				int pos = 0;
				if(currentRowNumber>0){
	                Row currentRow = iterator.next();
	                Iterator<Cell> cellIterator = currentRow.iterator();
	                int currentCellNumber = 0; 
	                while (cellIterator.hasNext()) {
	                    Cell currentCell = cellIterator.next();
	                    currentCellNumber++;
	                    if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
	                    	if(currentCellNumber==2||currentCellNumber==3||currentCellNumber==5||currentCellNumber==6){
	                    		valores[pos] = currentCell.getNumericCellValue();
	                    		pos++;
	                    	}
	                    }	
	                }
	                acciones.add(new Accion(valores[1],valores[2],valores[3],valores[0]));
				}else{
					currentRowNumber++;
				}
            }
		}catch(FileNotFoundException e){
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Escribir escribir = new Escribir();
		escribir.guardar(acciones);
		
	
	}

}
