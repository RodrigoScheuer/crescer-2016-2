
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfosTest{

    @Test
    public void AlistaElfoVerde(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfo = new ElfoVerde("Andre");
        exercito.alistarElfo(elfo);
        assertEquals(elfo, exercito.buscarPeloNome("Andre"));
    }

    @Test
    public void AlistaElfoNoturno(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo = new ElfoNoturno("Bernardo",2);
        exercito.alistarElfo(elfo);
        assertEquals(elfo, exercito.buscarPeloNome("Bernardo"));
    }

    @Test
    public void BuscarElfoNomeInvalido(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo = new ElfoNoturno("Rodrigo",2);
        exercito.alistarElfo(elfo);
        assertEquals(null, exercito.buscarPeloNome("Paulo"));
    }

    @Test
    public void BuscarPorStatusVivo(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo = new ElfoNoturno("Rodrigo",2);
        exercito.alistarElfo(elfo);
        assertEquals(1, (exercito.buscar(Status.VIVO)).size());
    }

    @Test
    public void BuscarPorStatusMorto(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo = new ElfoNoturno("Rodrigo",90);
        exercito.alistarElfo(elfo);
        for(int i = 0; i < 90; i++){
            exercito.buscarPeloNome("Rodrigo").atirarFlecha(new Dwarf());
        }
        assertEquals(1, (exercito.buscar(Status.MORTO)).size());
    }

  
}
