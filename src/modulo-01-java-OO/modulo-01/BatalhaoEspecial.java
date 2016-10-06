import java.util.*;

public class BatalhaoEspecial{
    HashMap <String, Elfo> contingente;

    public BatalhaoEspecial(){
        contingente = new HashMap<>();
    }

    public Elfo[] getContingente(){
        Elfo[] elfos = new Elfo[contingente.size()];
        if(contingente.isEmpty()){
            return null;
        }else{
            int i = 0;
            for(String key : contingente.keySet()){
                elfos[i] = contingente.get(key);
                i++;
            }
            return elfos;   
        }
    }

    public void alistar(Elfo elfo){
        contingente.put(elfo.getNome(), elfo);
    }

    public Elfo buscarPeloNome(String nome){
        if(contingente.containsKey(nome)){
            return contingente.get(nome);
        }
        return null;
    }

    public ArrayList<Elfo> buscar(Status status){
        ArrayList<Elfo> elfos = new ArrayList<Elfo>();
        for(String key : contingente.keySet()){
            if(contingente.get(key).getStatus() == status){
                elfos.add(contingente.get(key));
            }
        }
        return elfos;
    }
}
