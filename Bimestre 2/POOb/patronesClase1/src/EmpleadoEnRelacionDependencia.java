public class EmpleadoEnRelacionDependencia extends Empleado {
    private double sueldoMensual;

    public EmpleadoEnRelacionDependencia(String nombre, String apellido, int legajo, double sueldoMensual) {
        super(nombre, apellido, legajo);
        this.sueldoMensual = sueldoMensual;
    }


    public double getSueldoMensual() {
        return sueldoMensual;
    }

    @Override
    public double calcularSueldo(int dias) {
        return sueldoMensual * dias / 30;
    }
}
