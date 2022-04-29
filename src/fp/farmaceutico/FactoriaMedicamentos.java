package fp.farmaceutico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FactoriaMedicamentos { 
	
    public static List<Medicamento> leeFichero(String fichero){
        
        List<Medicamento> res = new ArrayList<Medicamento>();
        List<String> aux = null;
        try {
            aux = Files.readAllLines(Paths.get(fichero));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int cont = 0;
        for (String e: aux) {
            if (cont > 0) {
                Medicamento m = parseaMedicamento(e);
                res.add(m);
            }
            cont++;
        }
        return res;
    }

	public static Medicamento parseaMedicamento(String linea) {
		String quitarEspacios = linea.trim();
		String [] elemento = quitarEspacios.split(";");
		if (elemento.length != 7) {
			throw new IllegalArgumentException("La cadena deva de estar formada por 7 elementos.");
		}
		String nombre_medicamento = elemento[0].trim();
		TipoMedicamento tipo = TipoMedicamento.valueOf(elemento[1].trim().toUpperCase());
		String codigo_enfermedad = elemento[2].trim();
		String farmaceutica = elemento[3].trim();
		Double puntuacion = Double.valueOf(elemento[4].trim());
		Integer indice_sintomatico = Integer.valueOf(elemento[5].trim());
		LocalDate fecha_catalogo = LocalDate.parse(elemento[6].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new Medicamento(nombre_medicamento, tipo, codigo_enfermedad, farmaceutica, puntuacion, indice_sintomatico, fecha_catalogo);
	}

}
