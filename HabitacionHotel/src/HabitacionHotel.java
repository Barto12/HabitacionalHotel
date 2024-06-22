import java.util.ArrayList;
import java.util.List;

public class HabitacionHotel {
    private int numero;
    private String tipo;
    private double precio;
    private boolean disponible;
    private List<String> comodidades;

    // Constructor
    public HabitacionHotel(int numero, String tipo, double precio, boolean disponible, List<String> comodidades) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.disponible = disponible;
        this.comodidades = comodidades;
    }

    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public List<String> getComodidades() {
        return comodidades;
    }

    public void setComodidades(List<String> comodidades) {
        this.comodidades = comodidades;
    }

    // Método para verificar la disponibilidad de la habitación
    public boolean verificarDisponibilidad() {
        return disponible;
    }

    // Método para comparar precios entre dos habitaciones
    public int compararPrecio(HabitacionHotel otraHabitacion) {
        return Double.compare(this.precio, otraHabitacion.getPrecio());
    }

    // Método para obtener la mejor opción de habitación disponible
    public static HabitacionHotel obtenerMejorOpcion(List<HabitacionHotel> habitaciones) {
        HabitacionHotel mejorOpcion = null;
        for (HabitacionHotel habitacion : habitaciones) {
            if (habitacion.verificarDisponibilidad()) {
                if (mejorOpcion == null || habitacion.compararPrecio(mejorOpcion) < 0) {
                    mejorOpcion = habitacion;
                }
            }
        }
        return mejorOpcion;
    }

    // Método toString para imprimir información de la habitación
    @Override
    public String toString() {
        return "HabitacionHotel{" +
                "numero=" + numero +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", disponible=" + disponible +
                ", comodidades=" + comodidades +
                '}';
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        // Crear algunas habitaciones de ejemplo
        List<String> comodidades1 = new ArrayList<>();
        comodidades1.add("Wifi");
        comodidades1.add("TV");
        HabitacionHotel habitacion1 = new HabitacionHotel(101, "Doble", 100.0, true, comodidades1);

        List<String> comodidades2 = new ArrayList<>();
        comodidades2.add("Wifi");
        comodidades2.add("TV");
        comodidades2.add("Vista al mar");
        HabitacionHotel habitacion2 = new HabitacionHotel(102, "Suite", 200.0, true, comodidades2);

        List<String> comodidades3 = new ArrayList<>();
        comodidades3.add("TV");
        HabitacionHotel habitacion3 = new HabitacionHotel(103, "Individual", 80.0, false, comodidades3);

        // Crear una lista de habitaciones
        List<HabitacionHotel> habitaciones = new ArrayList<>();
        habitaciones.add(habitacion1);
        habitaciones.add(habitacion2);
        habitaciones.add(habitacion3);

        // Obtener la mejor opción disponible
        HabitacionHotel mejorOpcion = HabitacionHotel.obtenerMejorOpcion(habitaciones);
        if (mejorOpcion != null) {
            System.out.println("La mejor opción de habitación disponible es:");
            System.out.println(mejorOpcion);
        } else {
            System.out.println("No hay habitaciones disponibles.");
        }
    }
}
