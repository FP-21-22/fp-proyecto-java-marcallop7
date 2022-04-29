package fp.vacunas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FactoriaVacunaciones {
    
    public static List<Vacunacion> leeFichero(String fichero){
        
        List<Vacunacion> res = new ArrayList<Vacunacion>();
        List<String> aux = null;
        try {
            aux = Files.readAllLines(Paths.get(fichero));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int cont = 0;
        for (String e: aux) {
            if (cont > 0) {
                Vacunacion v = parse(e);
                res.add(v);
            }
            cont++;
        }
        return res;
    }

    public static Vacunacion parse(String linea) {
    	String quitarEspacios = linea.trim();
		String [] elemento = quitarEspacios.split(";");
		if (elemento.length != 7) {
			throw new IllegalArgumentException("La cadena deva de estar formada `pr 7 elementos.");
		}
		LocalDate fecha = LocalDate.parse(elemento[0].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String comunidad = elemento[1].trim();
		Integer pfizer = Integer.valueOf(elemento[2].trim());
		Integer moderna = Integer.valueOf(elemento[3].trim());
		Integer astrazeneca = Integer.valueOf(elemento[4].trim());
		Integer janssen = Integer.valueOf(elemento[5].trim());
		return new Vacunacion(fecha, comunidad, pfizer, moderna, astrazeneca, janssen, janssen);
	}
}