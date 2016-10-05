

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
        @After
    // executa após cada cenário de testes.
    public void tearDown(){
        System.gc();
    }
    
    @Test
    public void Atirar1Flecha(){
        ElfoNoturno elfo = new ElfoNoturno("lidi",10);
        Dwarf dwarf = new Dwarf();
        elfo.atirarFlecha(dwarf);
        assertEquals(95.0, elfo.getVida(), .0);
        assertEquals(3, elfo.getExperiencia());
    }
    
    @Test
    public void Atirar2Flecha(){
        ElfoNoturno elfo = new ElfoNoturno("lidi",10);
        Dwarf dwarf = new Dwarf();
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        assertEquals(90.25, elfo.getVida(), .0);
        assertEquals(6, elfo.getExperiencia());
    }
    
    @Test
    public void Atirar90Flecha(){
        ElfoNoturno elfo = new ElfoNoturno("lidi",90);
        Dwarf dwarf = new Dwarf();
        for(int i = 0; i < 90; i++){
            elfo.atirarFlecha(dwarf);
        }
        assertTrue(elfo.getVida() < 1);
        assertEquals(Status.MORTO, elfo.getStatus());
        assertEquals(270, elfo.getExperiencia());
    }
}
