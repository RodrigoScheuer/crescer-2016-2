import java.util.ArrayList;

public class ExercitoDeElfos
{
    ArrayList<Elfo> exercito = new ArrayList<>();
    
    public ExercitoDeElfos(){
        Elfo elfo01 = new ElfoVerde("Legolas");
        Elfo elfo02 = new ElfoNoturno("Rodrigo",100);
        Elfo elfo03 = new ElfoVerde("Rambo");
        Elfo elfo04 = new ElfoNoturno("Hitman",5);
        Elfo elfo05 = new ElfoVerde("Legolas");
        exercito.add(elfo01);
        exercito.add(elfo02);
        exercito.add(elfo03);
        exercito.add(elfo04);
        exercito.add(elfo05);
    }

    public void alistarElfo(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            exercito.add(elfo);
        }
    }

    public Elfo buscarPeloNome(String nome){
        if(exercito != null){
            for(int i = 0; i < exercito.size(); i++){
                if(exercito.get(i).getNome().equals(nome)){
                    return exercito.get(i);
                }
            }
        }
        return null;
    }

    public ArrayList<Elfo> buscar(Status status){
        ArrayList<Elfo> elfos = new ArrayList<>();
        for(int i = 0; i < exercito.size(); i++){
            if(exercito.get(i).getStatus() == status){
                elfos.add(exercito.get(i));
            }
        }
        return elfos;
    }
    
    public ArrayList<Elfo> getSoldados(){
        return this.exercito; 
    }
}
