

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
   public void ElfoNasceComNome(){
       // arrange
       String nomeEsperado = "Bruce Wayne";
       // act
       Elfo elfoDoTeste = new Elfo(nomeEsperado);
       // assert
       assertEquals(nomeEsperado, elfoDoTeste.getNome());
   }
   
   @Test
   public void ElfoNasceComArco(){
    // Arrange
    Item arco = new Item("Arco", 1);
    // Act
    Elfo elfoDoTeste = new Elfo("Elrond");
    // Assert
    assertEquals("Arco", elfoDoTeste.getArco().getDescricao());
    assertEquals(1, elfoDoTeste.getArco().getQuantidade());
    }
}











