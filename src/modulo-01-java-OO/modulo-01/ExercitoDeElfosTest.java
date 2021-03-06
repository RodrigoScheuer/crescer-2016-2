
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfosTest{

        @After
    // executa após cada cenário de testes.
    public void tearDown(){
        System.gc();
    }
    
    @Test
    public void AlistaElfoVerde(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfo = new ElfoVerde("Andre");
        exercito.alistar(elfo);
        assertEquals(elfo, exercito.buscar("Andre"));
    }

    @Test
    public void AlistaElfoNoturno(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo = new ElfoNoturno("Bernardo",2);
        exercito.alistar(elfo);
        assertEquals(elfo, exercito.buscar("Bernardo"));
    }

    @Test
    public void BuscarElfoNomeInvalido(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo = new ElfoNoturno("Rodrigo",2);
        exercito.alistar(elfo);
        assertEquals(null, exercito.buscar("Paulo"));
    }

    @Test
    public void BuscarPorStatusVivo(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo = new ElfoNoturno("Rodrigo",2);
        exercito.alistar(elfo);
        assertEquals(1, (exercito.buscar(Status.VIVO)).size());
    }

    @Test
    public void BuscarPorStatusMorto(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo = new ElfoNoturno("Rodrigo",90);
        exercito.alistar(elfo);
        for(int i = 0; i < 90; i++){
            exercito.buscar("Rodrigo").atirarFlecha(new Dwarf());
        }
        assertEquals(1, (exercito.buscar(Status.MORTO)).size());
    }

  
}
