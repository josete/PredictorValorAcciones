import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Logger;

import weka.classifiers.Classifier;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.lazy.KStar;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.core.pmml.jaxbbindings.Level;

public class GenerarModelo {

	public void leerArchivoArff() {
            // create J4
            Classifier cls = new MultilayerPerceptron();
            // train
            Instances inst;
			try {
				inst = new Instances(
				        new BufferedReader(
				                new FileReader("accionesBBVA.arff")));
				inst.setClassIndex(inst.numAttributes() - 1);
	            cls.buildClassifier(inst);
	            // serialize model
	            ObjectOutputStream oos = new ObjectOutputStream(
	                    new FileOutputStream("acciones.model"));
	            oos.writeObject(cls);
	            oos.flush();
	            oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }

    public String leerModelo() {
            String[] valoresAtributos = {"sube", "baja"};
            Classifier clasificador;
			try {
				clasificador = (Classifier) weka.core.SerializationHelper.read("acciones.model");
				ConverterUtils.DataSource source = new ConverterUtils.DataSource("test.arff");
	            Instances data = source.getDataSet();
	            data.setClassIndex(4);
	            return valoresAtributos[(int) clasificador.classifyInstance(data.instance(0))];
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
    }
}
