package fp.clinico;

public class TestEstudioClinicoStram {

	public static void main(String[] args) {
		String ruta = "data/estudio_clinico.csv";
		EstudioClinico aux = new EstudioClinicoStream();
		aux = aux.of(ruta);
		for (PacienteEstudio e: aux.leeFichero(ruta)) {
	       	System.out.println(e);
	    }
	}

}
