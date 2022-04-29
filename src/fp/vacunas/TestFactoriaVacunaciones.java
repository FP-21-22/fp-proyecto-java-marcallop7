package fp.vacunas;

import java.util.List;

public class TestFactoriaVacunaciones {
	
    public static void main(String[] args) {
        String ruta = "data/ccaa_vacunas_3.csv";
        List<Vacunacion> vacuna = FactoriaVacunaciones.leeFichero(ruta);
        for (Vacunacion e: vacuna) {
        	System.out.println(e);
        }
    }

}