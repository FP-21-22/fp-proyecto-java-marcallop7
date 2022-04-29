package fp.clinico;


public class TestEstudioClinicoBucles {

	public static void main(String[] args) {
		String ruta = "data/estudio_clinico.csv";
		EstudioClinico aux = new EstudioClinicoBucles();
		aux = aux.of(ruta);
		for (PacienteEstudio e: aux.leeFichero(ruta)) {
	       	System.out.println(e);
	    }
		
		PacienteEstudio p1 = PacienteEstudio.of("19823", "Female", 20., true, false, TipoResidencia.RURAL, 65.9);
		PacienteEstudio p2 = PacienteEstudio.of("56871", "Male", 13., false, false, TipoResidencia.URBANA, 89.3);
		PacienteEstudio p3 = PacienteEstudio.of("19823", "Female", 80., true, true, TipoResidencia.RURAL, 106.3);
		
		System.out.println("\nNumero de Pacientes: " + aux.numeroPacientes() + "\n");
		aux.incluyePaciente(p1); //Incluye al paciente p1 
		aux.incluyePaciente(p3); //Incluye al paciente p3 
		System.out.println("Existe paciente p1: " + aux.estaPaciente(p1));
		System.out.println("Existe paciente p2: " + aux.estaPaciente(p2));
		System.out.println("Existe paciente p3: " + aux.estaPaciente(p3));
		aux.eliminaPaciente(p1);
		System.out.println("\n-Se ha eliminado el paciente p1");
		System.out.println("Comprobamos si se ha borrado p1: " + aux.estaPaciente(p1));
		  

	}

}
