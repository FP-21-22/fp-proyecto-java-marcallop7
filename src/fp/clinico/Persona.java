package fp.clinico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.*; //Necesario para usar Pattern y no se autocompleta
import fp.utiles.Checkers;

public record Persona(String nombre, String apellidos, String dni, 
        LocalDate fecha_nacimiento) implements Comparable<Persona> {
    
    public Persona{
        
        Pattern p = java.util.regex.Pattern.compile("[0-9]{7,8}[A-Z a-z]");
        Checkers.check("La fecha de nacimiento no puede ser posterior a la actual.", fecha_nacimiento.isBefore(LocalDate.now()));
        Checkers.check("El dni no puede tener mas de 8 dígitos y una letra", p.matcher(dni).matches());
        
    }
    
    public Integer edad() {
        LocalDate hoy = LocalDate.now();
        Integer edad = hoy.getYear()- fecha_nacimiento.getYear();
        return edad;
    }

    public static Persona of(String nombre, String apellidos, String dni, 
        LocalDate fecha_nacimiento) {
        
        Persona res = new Persona(nombre, apellidos, dni, fecha_nacimiento);
        return res;
    }
    
    public static Persona parse(String cadena) {
        String [] elemento = cadena.split(",");
        String nombre = elemento[0].trim();
        String apellidos = elemento[1].trim();
        String dni = elemento[2].trim();
        LocalDate fecha_nacimiento = LocalDate.parse(elemento[3].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    	return Persona.of(nombre, apellidos, dni, fecha_nacimiento);

    }


    @Override
    public String toString() {
        return "Persona [edad()=" + edad() + ", nombre()=" + nombre() + ", apellidos()=" + apellidos() + ", dni()="
                + dni() + ", fecha_nacimiento()=" + fecha_nacimiento() + "]";
    }
    



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (apellidos == null) {
            if (other.apellidos != null)
                return false;
        } else if (!apellidos.equals(other.apellidos))
            return false;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        if (fecha_nacimiento == null) {
            if (other.fecha_nacimiento != null)
                return false;
        } else if (!fecha_nacimiento.equals(other.fecha_nacimiento))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }
    
    
    public int compareTo(Persona p) {
        return this.dni().compareTo(p.dni());
    }
    
    public static void main(String[] args) {
    	Persona p1 = Persona.parse("Juan, García Rodríguez, 12755078Z, 20/03/1965");
    	System.out.println(p1);
    }

}