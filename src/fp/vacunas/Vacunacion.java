package fp.vacunas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import fp.utiles.Checkers;

public record Vacunacion(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna, Integer astrazeneca, Integer janssen, Integer num_personas) {

	public Vacunacion {
		
		Checkers.check("La fecha no puede ser posterior al 01/02/2021", fecha.isBefore(LocalDate.of(2021, 2, 1)));
	}
	
	public Integer sum_total(Integer pfizer, Integer moderna, Integer astrazeneca, Integer janssen) {
		Integer suma = pfizer+moderna+astrazeneca+janssen;
		return suma;
	}

	public static Vacunacion of(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna, Integer astrazeneca, Integer janssen, Integer num_personas) {
		
		Vacunacion res = new Vacunacion(fecha, comunidad, pfizer, moderna, astrazeneca, janssen, num_personas);
		return res;
	}
	
	public static Vacunacion parse(String linea) {
		String [] elemento = linea.split(";");
		LocalDate fecha = LocalDate.parse(elemento[0].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String comunidad = elemento[1].trim();
		Integer pfizer = Integer.valueOf(elemento[2].trim());
		Integer moderna = Integer.valueOf(elemento[3].trim());
		Integer astrazeneca = Integer.valueOf(elemento[4].trim());
		Integer janssen = Integer.valueOf(elemento[5].trim());
		return new Vacunacion(fecha, comunidad, pfizer, moderna, astrazeneca, janssen, janssen);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(astrazeneca, comunidad, fecha, janssen, moderna, num_personas, pfizer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacunacion other = (Vacunacion) obj;
		return Objects.equals(astrazeneca, other.astrazeneca) && Objects.equals(comunidad, other.comunidad)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(janssen, other.janssen)
				&& Objects.equals(moderna, other.moderna) && Objects.equals(num_personas, other.num_personas)
				&& Objects.equals(pfizer, other.pfizer);
	}

	@Override
	public String toString() {
		return "Vacunacion [fecha()=" + fecha() + ", comunidad()=" + comunidad() + ", pfizer()=" + pfizer()
				+ ", moderna()=" + moderna() + ", astrazeneca()=" + astrazeneca() + ", janssen()=" + janssen()
				+ ", num_personas()=" + num_personas() + "]";
	}
	
	public int compareTo(Vacunacion v) {
		int o = this.comunidad().compareTo(v.comunidad());
		if (o==0) {
			o = this.fecha().compareTo(v.fecha());
		}
		return o;
	}
	
	public static void main(String[] args) {
		Vacunacion v1 = Vacunacion.parse("04/01/2021;Andalucía;140295;0;0;0;0");
		System.out.println(v1);
	}
}
