

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CestoDeLembasTest
{
    @Test
    public void criarCestoComUmPao(){
        // arrange
        CestoDeLembas cesto = new CestoDeLembas(2);
        // act & assert
        assertFalse(cesto.podeDividirEmPares());
    }
    
    @Test
    public void criarCestoComUmQuatroPaes(){
        // arrange
        CestoDeLembas cesto = new CestoDeLembas(4);
        // act & assert
        assertTrue(cesto.podeDividirEmPares());
    }

    @Test
    public void criarCestoComUm101Paes(){
        // arrange
        CestoDeLembas cesto = new CestoDeLembas(101);
        // act & assert
        assertFalse(cesto.podeDividirEmPares());
    }
    
    @Test
    public void criarCestoSemPaes(){
        // arrange
        CestoDeLembas cesto = new CestoDeLembas(0);
        // act & assert
        assertFalse(cesto.podeDividirEmPares());
    }
}
