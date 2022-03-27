package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import fp.utiles.Checkers;

public record Paciente(Persona persona, String codigo_ingreso, LocalDateTime fecha_hora_ingreso) {

	private String formatear_fecha(LocalDateTime f) {
		return f.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
	}
	
	private String formatear_hora(LocalDateTime f) {
		return f.format(DateTimeFormatter.ofPattern("hh:MM"));
	}
	
	public Paciente{
		
		Checkers.check("La fecha de nacimiento no puede ser posterior a la actual.", fecha_hora_ingreso.isBefore(LocalDateTime.now()));
		
	}
	public static Paciente of(String nombre, String apellidos, String dni, LocalDate fecha_nacimiento, String codigo, LocalDateTime fecha_hora_ingreso) {
		
		Paciente res = new Paciente(Persona.of(nombre, apellidos, dni, fecha_nacimiento), codigo, fecha_hora_ingreso);
		return res;
	}

	public static Paciente of(Persona persona, String codigo, LocalDateTime fecha_hora_ingreso) {
		
		Paciente res = new Paciente(persona, codigo, fecha_hora_ingreso);
		return res;
	}
	
	public Persona persona() {
		return persona;
	}

	public String codigo_ingreso() {
		return codigo_ingreso;
	}

	public LocalDateTime fecha_hora_ingreso() {
		return fecha_hora_ingreso;
	}

	@Override
	public String toString() {
		return "Paciente [persona()=" + persona() + ", codigo_ingreso()=" + codigo_ingreso() + ", fecha_hora_ingreso()="
				+ fecha_hora_ingreso() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(codigo_ingreso, other.codigo_ingreso)
				&& Objects.equals(fecha_hora_ingreso, other.fecha_hora_ingreso)
				&& Objects.equals(persona, other.persona);
	}
	
	
	
}
