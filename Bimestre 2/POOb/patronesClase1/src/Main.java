public class Main {
    public static void main(String[] args) {

        Empresa empresa = new Empresa("Camada1-Lamejor");
        EmpleadoFactory empleadoFactory = EmpleadoFactory.getInstance();
        empresa.agregarEmpleado(empleadoFactory.generarEmpleado("EMP-RD"));
        empresa.agregarEmpleado(empleadoFactory.generarEmpleado("EMP-RD"));
        empresa.agregarEmpleado(empleadoFactory.generarEmpleado("EMP-RD"));
        empresa.agregarEmpleado(empleadoFactory.generarEmpleado("EMP-RD"));
        empresa.agregarEmpleado(empleadoFactory.generarEmpleado("EMP-PH"));
        empresa.agregarEmpleado(empleadoFactory.generarEmpleado("EMP-PH"));
        empresa.agregarEmpleado(empleadoFactory.generarEmpleado("EMP-PH"));
        empresa.agregarEmpleado(empleadoFactory.generarEmpleado("EMP-PH"));

        for (Empleado empleado: empresa.getEmpleadoList()) {
            System.out.println(empleado.calcularSueldo(25));
        }

        System.out.println(empresa.calcularTotalSueldos(25));

        /*
        esto no se puede implementar.
        EmpleadoEnRelacionDependencia empleado = new EmpleadoEnRelacionDependencia();
        System.out.println(empleado.getSueldoMensual());
        */
    }
}