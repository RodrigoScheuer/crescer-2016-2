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
        //arrange
        Elfo elfoDoTeste = new Elfo("Rodrigo");
        //act
        elfoDoTeste.atiraFlecha();
        //assert
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(1, elfoDoTeste.getExperiencia());
    }
    
    @Test
    public void elfoAtiraFlechasFogo(){
        //arrange
        Elfo elfoDoTeste = new Elfo("Rodrigo");
        //act
        elfoDoTeste.atiraFlecha();
        elfoDoTeste.atiraFlecha();
        //assert
        assertEquals(40, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(2, elfoDoTeste.getExperiencia());
    }
    
    @Test
    public void elfoAtiraMultiplasFlechas(){
        //arrange
        Elfo elfoDoTeste = new Elfo("Rodrigo");
        //act
        elfoDoTeste.atiraFlecha();
        elfoDoTeste.atiraFlecha();
        elfoDoTeste.atiraFlecha();
        elfoDoTeste.atiraFlecha();
        //assert
        assertEquals(38, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(4, elfoDoTeste.getExperiencia());
    }
    
    @Test
    public void elfoAtiraEmDwarves(){
        // arrange
        Elfo elfoDoTeste = new Elfo("Legolas");
        Dwarves DwarvesDoTeste = new Dwarves();
        // act
        elfoDoTeste.atiraFlechaEmDwarves();
        DwarvesDoTeste.levaFlechada();
        // assert
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(100, DwarvesDoTeste.getVida());
        assertEquals(1, elfoDoTeste.getExperiencia());
    }
    
}

