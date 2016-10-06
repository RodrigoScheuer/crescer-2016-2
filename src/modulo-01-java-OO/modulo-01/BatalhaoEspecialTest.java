
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class BatalhaoEspecialTest{

    @Test
    public void alistarElfo(){
        BatalhaoEspecial POE = new BatalhaoEspecial();
        Elfo elfo = new ElfoVerde("Legolas");
        POE.alistar(elfo);
        Elfo[] elfos = new Elfo[5];
        elfos = POE.getContingente();
        assertEquals(1, elfos.length);
        assertTrue(elfos[0].equals(elfo));
    }

    @Test
    public void alistar5Elfo(){
        BatalhaoEspecial POE = new BatalhaoEspecial();
        POE.alistar(new ElfoVerde("Legolas1"));
        POE.alistar(new ElfoNoturno("Legolas2"));
        POE.alistar(new ElfoVerde("Legolas3"));
        POE.alistar(new ElfoNoturno("Legolas4"));
        POE.alistar(new ElfoVerde("Legolas5"));
        Elfo[] elfos = new Elfo[5];
        elfos = POE.getContingente();
        assertEquals("Legolas1", elfos[0].getNome());
        assertEquals("Legolas2", elfos[1].getNome());
        assertEquals("Legolas3", elfos[2].getNome());
        assertEquals("Legolas4", elfos[3].getNome());
        assertEquals("Legolas5", elfos[4].getNome());
    }
    
    /*@Test
    public void ContingenteVazio();*/
    
    @Test
    public void BuscarPeloNome(){
        BatalhaoEspecial POE = new BatalhaoEspecial();
        Elfo elfo = new ElfoVerde("Legolas");
        POE.alistar(elfo);
        Elfo[] elfos = new Elfo[5];
        elfos = POE.getContingente();
        assertEquals(1, elfos.length);
        assertEquals(elfos[0], POE.buscarPeloNome("Legolas"));
    }
    
    @Test
    public void BuscarPeloNomeDuplicado(){
        BatalhaoEspecial POE = new BatalhaoEspecial();
        Elfo elfo = new ElfoVerde("Legolas");
        Elfo elfo2 = new ElfoVerde("Legolas");
        POE.alistar(elfo);
        POE.alistar(elfo2);
        // elfo2 substitui elfo pq tem a chave igual
        assertEquals(elfo, POE.buscarPeloNome("Legolas"));
    }    
    
    @Test
    public void BuscarPeloNomeInvalido(){
        BatalhaoEspecial POE = new BatalhaoEspecial();
        Elfo elfo = new ElfoVerde("Pedro");
        POE.alistar(elfo);
        Elfo[] elfos = new Elfo[5];
        elfos = POE.getContingente();
        assertEquals(1, elfos.length);
        assertEquals(null, POE.buscarPeloNome("Legolas"));
    }
    
    @Test
    public void BuscarPeloStatusVIVO(){
        BatalhaoEspecial POE = new BatalhaoEspecial();
        Elfo elfo = new ElfoVerde("Legolas");
        POE.alistar(elfo);
        ArrayList<Elfo> elfosVivos = POE.buscar(Status.VIVO);
        assertEquals(1, elfosVivos.size());
        assertTrue(elfosVivos.contains(elfo));
    }
    
    @Test
    public void BuscarPeloStatusMORTO(){
        BatalhaoEspecial POE = new BatalhaoEspecial();
        Elfo elfo = new ElfoNoturno("Legolas", 90);
        POE.alistar(elfo);
        for(int i = 0; i < 90; i++){
            elfo.atirarFlecha(new Dwarf());
        }
        ArrayList<Elfo> elfosMortos = POE.buscar(Status.MORTO);
        assertEquals(1, elfosMortos.size());
        assertTrue(elfosMortos.contains(elfo));
    }
    
}
