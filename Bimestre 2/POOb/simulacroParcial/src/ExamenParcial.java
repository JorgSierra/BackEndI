public class ExamenParcial extends Examen {
    private int nroUnidad;
    private int nroReintentos;

    public ExamenParcial(String titulo, String enunciado, int nota, Alumno alumno, int nroUnidad) {
        super(titulo, enunciado, nota, alumno);
        this.nroUnidad = nroUnidad;
        this.nroReintentos = 0;
    }

    @Override
    public boolean aprobado() {
        if (super.getNota() >= 4){
            return true;
        }else{
            return false;
        }
    }

    public boolean esRecuperable(){
        if (this.nroUnidad <=3 && this.nroReintentos < 3){
            this.nroReintentos ++;
            return true;
        }else if(this.nroUnidad >3 && this.nroReintentos <2){
            this.nroReintentos = this.nroReintentos + 1;
            return true;
        }else{
            return false;
        }
    }

}
