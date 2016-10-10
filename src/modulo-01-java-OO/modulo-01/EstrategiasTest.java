
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

    @Test
    public void ataqueAlternado6Elfos() throws ContingenteDesproporcionalException {
        List<Elfo> lista = new ArrayList<>();
        List<Elfo> lista2 = new ArrayList<>();
        Estrategias estrategia = new Estrategias();
        Elfo elfo01 = new ElfoVerde("Legolas");
        Elfo elfo02 = new ElfoNoturno("Legolas1");
        Elfo elfo03 = new ElfoVerde("Legolas2");
        Elfo elfo04 = new ElfoNoturno("Legolas3");
        Elfo elfo05 = new ElfoVerde("Legolas4");
        Elfo elfo06 = new ElfoNoturno("Legolas5");
        lista.addAll(Arrays.asList(elfo01, elfo02, elfo03, elfo04, elfo05, elfo06));
        lista2.addAll(estrategia.ataqueIntercalado(lista));
        assertTrue(lista2.get(0) instanceof ElfoVerde);
        assertTrue(lista2.get(1) instanceof ElfoNoturno);
        assertTrue(lista2.get(2) instanceof ElfoVerde);
        assertTrue(lista2.get(3) instanceof ElfoNoturno);
        assertTrue(lista2.get(4) instanceof ElfoVerde);
        assertTrue(lista2.get(5) instanceof ElfoNoturno);
    }
    
    @Test
    public void ataqueAlternadoFalhando() throws ContingenteDesproporcionalException {
        List<Elfo> lista = new ArrayList<>();
        List<Elfo> lista2 = new ArrayList<>();
        Estrategias estrategia = new Estrategias();
        Elfo elfo01 = new ElfoVerde("Legolas");
        Elfo elfo02 = new ElfoVerde("Legolas1");
        Elfo elfo03 = new ElfoVerde("Legolas2");
        Elfo elfo04 = new ElfoNoturno("Legolas3");
        Elfo elfo05 = new ElfoVerde("Legolas4");
        Elfo elfo06 = new ElfoNoturno("Legolas5");
        lista.addAll(Arrays.asList(elfo01, elfo02, elfo03, elfo04, elfo05, elfo06));
        //lista2.addAll(estrategia.ataqueIntercalado(lista));
        assertEquals(null , estrategia.ataqueIntercalado(lista));
    }
    
    @Test
    public void estrategiaLittle4Elfos() {
        List<Elfo> lista = new ArrayList<>();
        List<Elfo> lista2 = new ArrayList<>();
        Estrategias estrategia = new Estrategias();
        int qtdNoturnos = 0;
        Elfo elfo01 = new ElfoVerde("Legolas");
        Elfo elfo02 = new ElfoVerde("Legolas1");
        Elfo elfo03 = new ElfoVerde("Legolas2");
        Elfo elfo04 = new ElfoNoturno("Legolas3");
        lista.addAll(Arrays.asList(elfo01, elfo02, elfo03, elfo04));
        lista2.addAll(estrategia.little(lista));
        for(Elfo elfo : lista2){
            if(elfo instanceof ElfoNoturno){
                qtdNoturnos++;
            }
        }
        assertEquals(4, lista2.size());
        assertEquals(1, qtdNoturnos);
    }
    
    @Test
    public void estrategiaLittle4Elfos2Noturnos() {
        List<Elfo> lista = new ArrayList<>();
        List<Elfo> lista2 = new ArrayList<>();
        Estrategias estrategia = new Estrategias();
        int qtdNoturnos = 0;
        Elfo elfo01 = new ElfoVerde("Legolas");
        Elfo elfo02 = new ElfoVerde("Legolas1");
        Elfo elfo03 = new ElfoNoturno("Legolas2");
        Elfo elfo04 = new ElfoNoturno("Legolas3");
        lista.addAll(Arrays.asList(elfo01, elfo02, elfo03, elfo04));
        lista2.addAll(estrategia.little(lista));
        for(Elfo elfo : lista2){
            if(elfo instanceof ElfoNoturno){
                qtdNoturnos++;
            }
        }
        assertEquals(3, lista2.size());
        assertEquals(1, qtdNoturnos);
    }
    
    @Test
    public void estrategiaLittle9Elfos3ElfosNoturnos6ElfosVerdes() {
        List<Elfo> lista = new ArrayList<>();
        List<Elfo> lista2 = new ArrayList<>();
        Estrategias estrategia = new Estrategias();
        int qtdNoturnos = 0;
        Elfo elfo00 = new ElfoVerde("Legolas00");
        Elfo elfo01 = new ElfoVerde("Legolas");
        Elfo elfo02 = new ElfoVerde("Legolas1");
        Elfo elfo03 = new ElfoNoturno("Legolas2");
        Elfo elfo04 = new ElfoNoturno("Legolas3");
        Elfo elfo05 = new ElfoNoturno("Legolas4");
        Elfo elfo06 = new ElfoVerde("Legolas5", 0);
        Elfo elfo07 = new ElfoVerde("Legolas6");
        Elfo elfo08 = new ElfoVerde("Legolas7");
        lista.addAll(Arrays.asList(elfo00, elfo01, elfo02, elfo03, elfo04, elfo05, elfo06, elfo07, elfo08));
        lista2.addAll(estrategia.little(lista));
        for(Elfo elfo : lista2){
            if(elfo instanceof ElfoNoturno){
                qtdNoturnos++;
            }
        }
        assertEquals(7, lista2.size());
        assertEquals(2, qtdNoturnos);
    }
    
    
}






