import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110Vida() {
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }

    @Test
    public void dwarfPerdeVidaUmaVez() {
        Dwarf gimli = new Dwarf();
        gimli.perderVida();
        assertEquals(100, gimli.getVida());
    }

    @Test
    public void dwarfPerdeVidaDuasVezes() {
        Dwarf gimli = new Dwarf();
        gimli.perderVida();
        gimli.perderVida();
        assertEquals(90, gimli.getVida());
    }

    @Test
    public void dwarfPerdeVidaVinteVezes() {
        Dwarf gimli = new Dwarf();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        assertEquals(-90, gimli.getVida());
    }
    
     @Test
    public void dwarfNasceComNomeEDataNascimento() {
        DataTerceiraEra data = new DataTerceiraEra(30,12,1992);
        Dwarf gimli = new Dwarf("Rodrigo", data);
        assertEquals("Rodrigo", gimli.getNome());
        assertEquals(data, gimli.getDataNascimento());
    }
    
     @Test
    public void dwarfNasce() {
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
        assertEquals("dwarf", gimli.getNome());
        assertEquals(1, gimli.getDataNascimento().getDia());
        assertEquals(1, gimli.getDataNascimento().getMes());
        assertEquals(1, gimli.getDataNascimento().getAno());
    }
    
    @Test
    public void dwarfGetNumeroSorteAnoEhBissexto() {
        double Epsilon = 0.001;
        DataTerceiraEra data = new DataTerceiraEra(30,12,2012);
        Dwarf gimli = new Dwarf("Rodrigo", data);
        gimli.perderVida();
        gimli.perderVida();
        assertEquals(-3333.0, gimli.getNumeroSorte(),Epsilon); // não sei se esta correto, calculadora exibe valor diferente
    }
    
    @Test
    public void dwarfGetNumeroSorteAnoNaoEhBissexto() {
        double Epsilon = 0.001;
        DataTerceiraEra data = new DataTerceiraEra(30,12,2013);
        Dwarf gimli = new Dwarf("Seixas", data);
        gimli.perderVida();
        gimli.perderVida();
        assertEquals(33, gimli.getNumeroSorte(),Epsilon);
    }
    
    @Test
    public void dwarfSemSorte() {
        double Epsilon = 0.001;
        DataTerceiraEra data = new DataTerceiraEra(30,12,2013);
        Dwarf gimli = new Dwarf("Rodrigo", data);
        assertEquals(101, gimli.getNumeroSorte(), Epsilon);
    }
    
    @Test
    public void DwarfNaoLevaFlechada(){
                                        // ano nao é bissexto
        DataTerceiraEra data = new DataTerceiraEra(30,12,2013);
        Dwarf gimli = new Dwarf("Seixas", data);
        gimli.perderVida();
        assertEquals(110, gimli.getVida());
        assertEquals(0, gimli.getExperiencia());
    }
    
    @Test
    public void DwarfLevaFlechada(){
                                        // ano não é bissexto
        DataTerceiraEra data = new DataTerceiraEra(30,12,2013);
        Dwarf gimli = new Dwarf("Rodrigo", data);
        gimli.perderVida();
        assertEquals(100, gimli.getVida());
        assertEquals(0, gimli.getExperiencia());
    }
    
     @Test
    public void DwarfNaoLevaFlechadaEGanhaExperiencia(){
                                        // ano não é bissexto
        DataTerceiraEra data = new DataTerceiraEra(30,12,2012);
        Dwarf gimli = new Dwarf("Rodrigo", data);
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        assertEquals(90, gimli.getVida());
        assertEquals(2, gimli.getExperiencia());
    }
        
}



