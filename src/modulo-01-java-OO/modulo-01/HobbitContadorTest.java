
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest
{
    @Test
    public void CalcularDiferenca(){
        Integer Arrays = 0;
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        ArrayList<Integer> arrays = new ArrayList<>();
        ArrayList<Integer> arrays1 = new ArrayList<>();
        ArrayList<Integer> arrays2 = new ArrayList<>();
        arrays.add(15);
        arrays.add(18);
        arrayDePares.add(arrays);
        arrays1.add(4);
        arrays1.add(5);
        arrayDePares.add(arrays1);
        arrays2.add(12);
        arrays2.add(60);
        arrayDePares.add(arrays2);
        HobbitContador hobbit = new HobbitContador();
        Integer resultado = 840;
        assertEquals(resultado, hobbit.calcularDiferenca(arrayDePares));
    }
}
