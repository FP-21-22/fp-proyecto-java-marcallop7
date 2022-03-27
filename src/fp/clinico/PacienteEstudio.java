package fp.clinico;

import java.util.Objects;

import fp.utiles.Checkers;

public record PacienteEstudio(String id, String genero, Double edad, Boolean hipertension, Boolean enfermedad_corazon, TipoResidencia tipo, Double nivel_medio_glucosa) {

	public PacienteEstudio{
		
		Checkers.check("La edad tiene que ser mayor o igual que cero y menor o igual que 130", edad>=0 && edad<=130);
		Checkers.check("El nivel medio de glucosa tiene que ser mayor o igual que 0", nivel_medio_glucosa>=0);
	}
	
	private Boolean factor_riesgo() {
		if (hipertension == true && edad > 40) {
			return true;
		} else {
			return false;
		}
	}

	public static PacienteEstudio of(String id, String genero, Double edad, Boolean hipertension, Boolean enfermedad_corazon, TipoResidencia tipo, Double nivel_medio_glucosa) {
		
		PacienteEstudio res = new PacienteEstudio(id, genero, edad, hipertension, enfermedad_corazon, tipo, nivel_medio_glucosa);
		return res;
		
	}
	
	public static PacienteEstudio parse(String linea) {
		String [] elemento = linea.split(";");
		String id = elemento[0].trim();
		String genero = elemento[1].trim();
		Double edad = Double.valueOf(elemento[2].trim());
		Boolean hipertension = Boolean.valueOf(elemento[3].trim());
		Boolean enfermedad_corazon = Boolean.valueOf(elemento[4].trim());
		TipoResidencia tipo = TipoResidencia.valueOf(elemento[5].trim());
		Double nivel_medio_glucosa = Double.valueOf(elemento[6].trim());
		return PacienteEstudio.of(id, genero, edad, hipertension, enfermedad_corazon, tipo, nivel_medio_glucosa);
	}

	@Override
	public String toString() {
		return "PacienteEstudio [id()=" + id() + ", edad()=" + edad() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PacienteEstudio other = (PacienteEstudio) obj;
		return Objects.equals(edad, other.edad) && Objects.equals(enfermedad_corazon, other.enfermedad_corazon)
				&& Objects.equals(genero, other.genero) && Objects.equals(hipertension, other.hipertension)
				&& Objects.equals(id, other.id) && Objects.equals(nivel_medio_glucosa, other.nivel_medio_glucosa)
				&& tipo == other.tipo;
	}
	
	public int compareTo(PacienteEstudio p) {
		int e = this.edad().compareTo(p.edad());
		if (e == 0) {
			e = this.id().compareTo(p.id());
		}
		return e;
	}
	
	public static void main(String[] args) {
		PacienteEstudio p1 = PacienteEstudio.parse("6306;Male;80;false;false;URBANA;83.84");
		System.out.println(p1);
	}
}
