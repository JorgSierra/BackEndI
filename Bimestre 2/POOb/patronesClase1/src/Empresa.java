import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombreEmpresa;
    private List<Empleado> empleadoList;

    public Empresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.empleadoList = new ArrayList<>();
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void agregarEmpleado(Empleado empleado){
        this.empleadoList.add(empleado);
    }

    public double calcularTotalSueldos(int cantidadDias){
        double sueldoTotales = 0;
        for (Empleado empleado: empleadoList) {
            sueldoTotales += empleado.calcularSueldo(cantidadDias);
        }
        return sueldoTotales;
    }

}
