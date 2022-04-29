package fp.farmaceutico;

import java.time.LocalDate;
import java.util.Objects;

import fp.utiles.Checkers;

public class Medicamento implements Comparable<Medicamento>{
	
	private String nombre_medicamento;
	private TipoMedicamento tipo;
	private String codigo_enfermedad;
	private String farmaceutica;
	private Double puntuacion;
	private Integer indice_sintomatico;
	private LocalDate fecha_catalogo;
	
	public Medicamento (String nombre_medicamento, TipoMedicamento tipo, String codigo_enfermedad, String farmaceutica, Double puntuacion, 
			Integer indice_sintomatico, LocalDate fecha_catalogo) {
		
		Checkers.check("La puntuacion tiene que ser mayor estricta que cero.", puntuacion > 0);
		Checkers.check("El índice somático tiene que ser mayor o igual que 1000", indice_sintomatico>=1000);
		Checkers.check("La fecha de catálogo tiene que ser posterior al 01/01/2015.", fecha_catalogo.isBefore(LocalDate.of(2021, 2, 1)));
		
		this.nombre_medicamento = nombre_medicamento;
		this.tipo = tipo;
		this.codigo_enfermedad = codigo_enfermedad;
		this.farmaceutica = farmaceutica;
		this.puntuacion = puntuacion;
		this.indice_sintomatico = indice_sintomatico;
		this.fecha_catalogo = fecha_catalogo;
		
	}

	public String getNombre_medicamento() {
		return nombre_medicamento;
	}

	public void setNombre_medicamento(String nombre_medicamento) {
		this.nombre_medicamento = nombre_medicamento;
	}

	public TipoMedicamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMedicamento tipo) {
		this.tipo = tipo;
	}

	public String getCodigo_enfermedad() {
		return codigo_enfermedad;
	}

	public void setCodigo_enfermedad(String codigo_enfermedad) {
		this.codigo_enfermedad = codigo_enfermedad;
	}

	public String getFarmaceutica() {
		return farmaceutica;
	}

	public void setFarmaceutica(String farmaceutica) {
		this.farmaceutica = farmaceutica;
	}

	public Double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Integer getIndice_sintomatico() {
		return indice_sintomatico;
	}

	public void setIndice_sintomatico(Integer indice_sintomatico) {
		this.indice_sintomatico = indice_sintomatico;
	}

	public LocalDate getFecha_catalogo() {
		return fecha_catalogo;
	}

	public void setFecha_catalogo(LocalDate fecha_catalogo) {
		this.fecha_catalogo = fecha_catalogo;
	}

	public Boolean tratar_enfermedad() {
		if (codigo_enfermedad.equals(this.codigo_enfermedad)) {
			return true;
		} else {
			return false;
		}
	}



	@Override
	public String toString() {
		return "Medicamento [nombre_medicamento=" + nombre_medicamento + ", tipo=" + tipo + ", codigo_enfermedad="
				+ codigo_enfermedad + ", farmaceutica=" + farmaceutica + ", puntuacion=" + puntuacion
				+ ", indice_sintomatico=" + indice_sintomatico + ", fecha_catalogo=" + fecha_catalogo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(farmaceutica, nombre_medicamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		return Objects.equals(farmaceutica, other.farmaceutica)
				&& Objects.equals(nombre_medicamento, other.nombre_medicamento);
	}
	
	@Override
	public int compareTo(Medicamento m) {
		Integer res = this.getNombre_medicamento().compareTo(m.getNombre_medicamento());
		if (res==0) {
			res = this.getFarmaceutica().compareTo(m.getFarmaceutica());
		}
		return res;
	}
}
