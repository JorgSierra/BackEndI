public class ExamenFinal extends Examen implements Comparable{

    private int notaOral;
    private String descripcion;

    public ExamenFinal(String titulo, String enunciado, int nota, Alumno alumno, int notaOral, String descripcion ){
        super(titulo, enunciado, nota, alumno);
        this.notaOral = notaOral;
        this.descripcion = descripcion;
    }

    public int getNotaOral() {
        return notaOral;
    }

    @Override
    public boolean aprobado() {
        if(super.getNota()>= 4 && this.notaOral >=4){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int compareTo(Object objeto) {
        ExamenFinal examenXParametro = (ExamenFinal)objeto;
        double promedioLocal = (super.getNota() + this.notaOral) / 2;
        double promedioParametro = (examenXParametro.getNota() + examenXParametro.getNotaOral()) / 2;
        if (promedioLocal > promedioParametro){
            return 1;
        }else if (promedioLocal < promedioParametro){
            return -1;
        }else{
            return 0;
        }
    }
}
