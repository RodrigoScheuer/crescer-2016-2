import java.util.*;

public class Estrategias implements ContratoDeEstrategias{

    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes){
        List<Elfo> ordenados = new ArrayList<>();
        for(Elfo elfo : atacantes){
            if(elfo.getStatus() == Status.VIVO){
                if(ordenados.size() > 0){
                    if(elfo instanceof ElfoVerde){
                        ordenados.add(0, elfo);
                    }else{
                        ordenados.add(elfo);
                    }
                }
            }
        }
        return ordenados;
    }

    /*public List<Elfo> ataqueIntercalado(List<Elfo> atacantes){
        List<Elfo> alternados = new ArrayList<>();
        int contadorElfoVerde = 0;
        int contadorElfoNoturno = 0;
        for(Elfo elfo : atacantes){
            if(elfo.getStatus() == Status.VIVO){
                if(elfo instanceof ElfoVerde){
                    contadorElfoVerde++;
                }else{
                    contadorElfoNoturno++;
                }
            }
        }

        if(contadorElfoVerde != contadorElfoNoturno){
            // throw ContingenteDesproporcionalException;
        }else{
            List<Elfo> alternados = new ArrayList<>();
            boolean elfoVerdePrimeiro;
            if(atacantes.get(0) instanceof ElfoVerde){
                elfoVerdePrimeiro = true;
            }else{
                elfoVerdePrimeiro = false;
            }

            // terminar método

        }
        return alternados;
    }*/
}
