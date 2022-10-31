package mesa;

import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
    public static final String TIPO1 = "Ornamentales";
    public static final String TIPO2 = "Frutales";
    public static final String TIPO3 = "Florales";
    private static Map<String , Arbol> arbolMap;

    public ArbolFactory() {
        this.arbolMap = new HashMap<>();
    }

    public Arbol getArbol(String tipo){
        switch (tipo){
            case TIPO1:
                if (!arbolMap.containsKey(TIPO1)){
                    arbolMap.put(tipo,new Arbol(200, 400, "verde"));
                }
                break;
            case TIPO2:
                if (!arbolMap.containsKey(TIPO2)){
                    arbolMap.put(tipo,new Arbol(500, 300, "rojo"));
                }
                break;
            case TIPO3:
                if (!arbolMap.containsKey(TIPO3)){
                    arbolMap.put(tipo,new Arbol(100, 200, "celeste"));
                }
                break;
        }
        return  arbolMap.get(tipo);
    }
}
