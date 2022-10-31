package mesa;

public abstract class AnalistaCalidad {
    protected AnalistaCalidad sigAnalista;

    public void setSigAnalista(AnalistaCalidad sigAnalista) {
        this.sigAnalista = sigAnalista;
    }

    public abstract void  analizar(Articulo articulo);

}
