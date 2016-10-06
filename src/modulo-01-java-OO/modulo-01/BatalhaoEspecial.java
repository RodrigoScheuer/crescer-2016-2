import java.util.*;

public class BatalhaoEspecial{
    HashMap <String, Elfo> contingente;

    public BatalhaoEspecial(){
        contingente = new HashMap<>();
    }

    public Elfo[] getContingente(){
        return contingente.values().toArray(new Elfo[contingente.size()]);
    }

    public void alistar(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            contingente.put(elfo.getNome(), elfo);
        }
    }

    public Elfo buscarPeloNome(String nome){
        return contingente.get(nome);
    }

    public ArrayList<Elfo> buscar(Status status){
        ArrayList<Elfo> elfos = new ArrayList<Elfo>();
        // percorre map pelos valores contidos nele.
        for(Elfo elfo : contingente.values()){
            if(elfo.getStatus() == status){
                elfos.add(elfo);
            }
        }
        return elfos;
    }
}
