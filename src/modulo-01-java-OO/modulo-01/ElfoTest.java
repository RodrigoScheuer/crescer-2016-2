import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
   public void elfoNasceComNome(){
       // arrange
       String nomeEsperado = "Bruce Wayne";
       // act
       Elfo elfoDoTeste = new Elfo(nomeEsperado);
       // assert
       assertEquals(nomeEsperado, elfoDoTeste.getNome());
   }
   
   @Test
   public void elfoNasceComArco(){
    // Act
    Elfo elfoDoTeste = new Elfo("Elrond");
    // Assert
    assertEquals("Arco", elfoDoTeste.getArco().getDescricao());
    assertEquals(1, elfoDoTeste.getArco().getQuantidade());
    }
    
    @Test
    public void elfoNasceComFlechas(){
    // act
    Elfo elfoDoTeste = new Elfo("Rodrigo");
    // assert
    assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraFlecha(){
        //act
        Elfo elfoDoTeste = new Elfo("Rodrigo");
        //assert
        elfoDoTeste.atiraFlecha();
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraFlechasFogo(){
        //act
        Elfo elfoDoTeste = new Elfo("Rodrigo");
        //assert
        elfoDoTeste.atiraFlecha();
        elfoDoTeste.atiraFlecha();
        assertEquals(40, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraMultiplasFlechas(){
        //act
        Elfo elfoDoTeste = new Elfo("Rodrigo");
        //assert
        elfoDoTeste.atiraFlecha();
        elfoDoTeste.atiraFlecha();
        elfoDoTeste.atiraFlecha();
        elfoDoTeste.atiraFlecha();
        assertEquals(38, elfoDoTeste.getFlecha().getQuantidade());
        
    }
    
    @Test
    public void elfoAtiraEmDwarves(){
        // act
        Elfo elfoDoTeste = new Elfo("Legolas");
        Dwarves DwarvesDoTeste = new Dwarves();
        // assert
        elfoDoTeste.atiraFlechaEmDwarves();
        DwarvesDoTeste.levaFlechada();
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(100, DwarvesDoTeste.getVida());
    }
    
}

