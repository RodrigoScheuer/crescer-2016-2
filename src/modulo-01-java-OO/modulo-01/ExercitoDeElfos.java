import java.util.ArrayList;

public class ExercitoDeElfos
{
    ArrayList<Elfo> exercito = new ArrayList<>();
    
    public ExercitoDeElfos(){
        new ArrayList<>();
    }

    public void alistarElfo(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            exercito.add(elfo);
        }
    }

    public Elfo buscarPeloNome(String nome){
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

    public ArrayList<Elfo> getSoldados(){
        return this.exercito; 
    }
}
