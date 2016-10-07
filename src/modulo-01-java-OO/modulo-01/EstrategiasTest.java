
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiasTest
{
    @Test
    public void OrdenaListaElfos(){
        List<Elfo> lista = new ArrayList<>();
        List<Elfo> lista2 = new ArrayList<>();
        Estrategias estrategia = new Estrategias();
        Elfo elfo01 = new ElfoVerde("Legolas");
        Elfo elfo02 = new ElfoNoturno("Legolas1");
        Elfo elfo03 = new ElfoVerde("Legolas2");
        Elfo elfo04 = new ElfoNoturno("Legolas3");
        Elfo elfo05 = new ElfoVerde("Legolas4");
        lista.add(elfo01);
        lista.add(elfo02);
        lista.add(elfo03);
        lista.add(elfo04);
        lista.add(elfo05);
        lista2.addAll(0 ,estrategia.getOrdemDeAtaque(lista));
        assertTrue(lista2.get(0) instanceof ElfoVerde);
        assertTrue(lista2.get(1) instanceof ElfoVerde);
        assertTrue(lista2.get(2) instanceof ElfoVerde);
        assertTrue(lista2.get(3) instanceof ElfoNoturno);
        assertTrue(lista2.get(4) instanceof ElfoNoturno);
        
    }
    
    
}
