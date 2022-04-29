package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class EstudioClinicoBucles implements EstudioClinico {

	private List<PacienteEstudio> pacienteEstudio;
	
	public EstudioClinicoBucles () {
		pacienteEstudio = new ArrayList<PacienteEstudio>();
	}
	
	public EstudioClinicoBucles (List<PacienteEstudio> p) {
		this.pacienteEstudio = p;
	}
	
	@Override
	public Integer numeroPacientes() {
		return pacienteEstudio.size();
	}

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		pacienteEstudio.add(paciente);
	}

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		pacienteEstudio.addAll(pacientes);

	}

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		pacienteEstudio.remove(paciente);

	}

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		return pacienteEstudio.contains(paciente);
	}

	@Override
	public void borraEstudio() {
		//Tengo dudas sobre este metodo.

	}

	@Override
	public EstudioClinico of(String nombreFichero) {
		List<PacienteEstudio> aux = leeFichero(nombreFichero);
		pacienteEstudio = aux;
		EstudioClinico res = new EstudioClinicoBucles(aux);
		return res;
		
	}

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
		List<PacienteEstudio> res = new ArrayList<PacienteEstudio>();
        List<String> aux = null;
        try {
            aux = Files.readAllLines(Paths.get(nombreFichero));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int cont = 0;
        for (String e: aux) {
            if (cont > 0) {
                PacienteEstudio m = PacienteEstudio.parse(e);
                res.add(m);
            }
            cont++;
        }
        return res;
	}

	@Override
	public Boolean todosPacienteSonDelTipo(TipoResidencia tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

}
