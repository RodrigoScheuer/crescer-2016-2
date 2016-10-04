import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
    @Test
    public void testaExperiencia(){
        ElfoVerde elfo = new ElfoVerde("Lidiane");
        Dwarf dwarf = new Dwarf();
        elfo.atirarFlecha(dwarf);
        assertEquals(2, elfo.getExperiencia());
    }

    @Test
    public void testaExperiencia2Flechas(){
        ElfoVerde elfo = new ElfoVerde("Lidiane");
        Dwarf dwarf = new Dwarf();
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        assertEquals(4, elfo.getExperiencia());
    }

    @Test
    public void testaExperiencia10Flechas(){
        ElfoVerde elfo = new ElfoVerde("Lidiane");
        Dwarf dwarf = new Dwarf();
        for(int i = 0; i < 10; i++){
            elfo.atirarFlecha(dwarf);
        }
        assertEquals(20, elfo.getExperiencia());
    }

    @Test
    public void AdicionarItemCorreto(){
        ElfoVerde elfo = new ElfoVerde("Lidiane");
        Item item01 = new Item("Espada de aço valiriano", 1);
        Item item02 = new Item("Arco e Flecha de Vidro", 1);
        elfo.adicionarItem(item01);
        elfo.adicionarItem(item02);
        assertEquals("Espada de aço valiriano", elfo.getItens().get(2).getDescricao());
        assertEquals("Arco e Flecha de Vidro", elfo.getItens().get(3).getDescricao());
    }

    @Test
    public void AdicionarItemInvalido(){
        ElfoVerde elfo = new ElfoVerde("Lidiane");
        Item item01 = new Item("Espada de aço valiriano", 1);
        Item item02 = new Item("Arco Madeira", 1);
        elfo.adicionarItem(item01);
        elfo.adicionarItem(item02);
        assertEquals("Espada de aço valiriano", elfo.getItens().get(2).getDescricao());
        assertEquals(3, elfo.getItens().size()); // tem dois do construtor Elfo.
    }
    
}
