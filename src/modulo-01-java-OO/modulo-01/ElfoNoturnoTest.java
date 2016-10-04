

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @Test
    public void Atirar1Flecha(){
        ElfoNoturno elfo = new ElfoNoturno("lidi");
        Dwarf dwarf = new Dwarf();
        elfo.atirarFlecha(dwarf);
        assertEquals(95, elfo.getVidaElfoNoturno(), .0);
        assertEquals(3, elfo.getExperiencia());
    }
    
    @Test
    public void Atirar2Flecha(){
        ElfoNoturno elfo = new ElfoNoturno("lidi");
        Dwarf dwarf = new Dwarf();
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        assertEquals(90.25, elfo.getVidaElfoNoturno(), .0);
        assertEquals(6, elfo.getExperiencia());
    }
    
    @Test
    public void Atirar20Flecha(){
        ElfoNoturno elfo = new ElfoNoturno("lidi");
        Dwarf dwarf = new Dwarf();
        for(int i = 0; i < 90; i++){
            elfo.atirarFlecha(dwarf);
        }
        assertTrue(elfo.getVidaElfoNoturno() < 1);
        assertEquals(Status.MORTO, elfo.getStatus());
        assertEquals(222, elfo.getExperiencia());
    }
}
