package presencial;

public class IP {
    private Integer numero1;
    private Integer numero2;
    private Integer numero3;
    private Integer numero4;

    public String getPais(){
        //dependiendo del numero1
        if (numero1<=49){
            return "Argentina";
        } else if (numero1<=99) {
            return "Brasil";
        } else if (numero1<=149) {
            return "Colombia";
        }else{
            return "Uruguay";
        }
    }
    
    public IP(Integer numero1, Integer numero2, Integer numero3, Integer numero4) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.numero3 = numero3;
        this.numero4 = numero4;
    }

    public Integer getNumero1() {
        return numero1;
    }

    public void setNumero1(Integer numero1) {
        this.numero1 = numero1;
    }

    public Integer getNumero2() {
        return numero2;
    }

    public void setNumero2(Integer numero2) {
        this.numero2 = numero2;
    }

    public Integer getNumero3() {
        return numero3;
    }

    public void setNumero3(Integer numero3) {
        this.numero3 = numero3;
    }

    public Integer getNumero4() {
        return numero4;
    }

    public void setNumero4(Integer numero4) {
        this.numero4 = numero4;
    }
}
