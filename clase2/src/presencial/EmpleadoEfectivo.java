package presencial;

public class EmpleadoEfectivo extends Empleado{
    private Double sueldoBasico;
    private Double premios;
    private Double descuentos;

    public EmpleadoEfectivo(String nombre, String apellido, String cuentaBancaria, Double sueldoBasico, Double premios, Double descuentos) {
        super(nombre, apellido, cuentaBancaria);
        this.sueldoBasico = sueldoBasico;
        this.premios = premios;
        this.descuentos = descuentos;
    }

    public Double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(Double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public Double getPremios() {
        return premios;
    }

    public void setPremios(Double premios) {
        this.premios = premios;
    }

    public Double getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(Double descuentos) {
        this.descuentos = descuentos;
    }
}
