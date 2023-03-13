public class EmpleadoFactory {

    // singelton
    private static EmpleadoFactory instance;

    private EmpleadoFactory(){}

    public static EmpleadoFactory getInstance(){
        if (instance == null){
            instance = new EmpleadoFactory();
        }
        return instance;
    }
    // termina singelton

    // Factory

    public Empleado generarEmpleado(String codigo){
        switch (codigo){
            case "EMP-RD":
                return new EmpleadoEnRelacionDependencia("Nombre1","Apellido1",1234,1000);
            case "EMP-PH":
                return new EmpleadoContratado("empleadoContratad1", "apellido2", 4343, 7.0, 0.14);
            case "EMP-PH-Ss":
                return new EmpleadoContratado("empleadoContratad1", "apellido2", 4343, 14.0, 0.14);
        }
        return null;
    }


}
