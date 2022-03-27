package fp.farmaceutico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FactoriaMedicamentos { 

	public static Medicamento parseaMedicamento(String linea) {
		String [] elemento = linea.split(",");
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
