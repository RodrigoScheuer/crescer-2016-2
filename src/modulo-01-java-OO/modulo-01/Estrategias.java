import java.util.*;

public class Estrategias implements ContratoDeEstrategias{

    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes){
        List<Elfo> ordenados = new ArrayList<>();
        for(Elfo elfo : atacantes){
            if(elfo.getStatus() == Status.VIVO){
                if(elfo instanceof ElfoVerde){
                    ordenados.add(0, elfo);
                }else if(elfo instanceof ElfoNoturno){
                    ordenados.add(elfo);
                }
            }
        }
        return ordenados;
    }

    public List<Elfo> ataqueIntercalado(List<Elfo> atacantes) throws ContingenteDesproporcionalException{
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

        try{
            if(contadorElfoVerde == contadorElfoNoturno) {
                List<Elfo> alternados = new ArrayList<>();
                List<Elfo> ordenados = getOrdemDeAtaque(atacantes);
                boolean elfoVerdePrimeiro;
                int inicio = 0;
                int fim = atacantes.size() - 1;
                
                for(int i = 0; i < ordenados.size(); i++){
                    if(i % 2 == 0){
                        alternados.add(ordenados.get(inicio));
                        inicio++;
                    }else{
                        alternados.add(ordenados.get(fim));
                        fim --;
                    }
                }
                return alternados;
            }else{
                throw new ContingenteDesproporcionalException("Contingente Desproporcional!");
            }
            
        }catch(ContingenteDesproporcionalException ce){
            System.out.println(ce.getMessage());
            return null;
        }
    }
    
    public List<Elfo> little(List<Elfo> atacantes){
        List<Elfo> aptos = new ArrayList<>();
        for(Elfo elfo : atacantes){
            if(elfo.getStatus() == Status.VIVO && elfo.getFlecha().getQuantidade() > 0){
                aptos.add(elfo);
            }
        }
        
        double qtd = aptos.size() * 0.3;
        int qtdNoturnos = (int) qtd;
        List<Elfo> efetivo = new ArrayList<>();
        for(Elfo elfo : aptos){
            if(elfo instanceof ElfoNoturno && qtdNoturnos > 0){
                efetivo.add(elfo);
                qtdNoturnos --;
            }else if(elfo instanceof ElfoVerde){
                efetivo.add(elfo);
            }
        }
        return efetivo;
    }
}
