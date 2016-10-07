import java.util.ArrayList;

public class ExercitoDeElfos implements Exercito {
    ArrayList<Elfo> exercito;

    public ExercitoDeElfos(){
        exercito = new ArrayList<>();
    }

    public void alistar(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            exercito.add(elfo);
        }
    }

    public Elfo buscar(String nome){
        for(Elfo elfo : exercito){
            if(nome.equals(elfo.getNome())){
                return elfo;
            }
        }
        return null;
    }

    public ArrayList<Elfo> buscar(Status status){
        ArrayList<Elfo> elfos = new ArrayList<>();
        for(Elfo elfo : exercito){
            if(elfo.getStatus() == status){
                elfos.add(elfo);
            }
        }
        return elfos;
    }

    public Elfo[] getContingente(){
        return exercito.toArray(new Elfo[exercito.size()]); 
    }

    public void atacar(){
    }
}
