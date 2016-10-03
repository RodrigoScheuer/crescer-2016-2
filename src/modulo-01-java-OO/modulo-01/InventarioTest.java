import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
 @Test
 public void adicionarItemInventario(){
     Item item01 = new Item("Espada", 1);
     Inventario mochila = new Inventario();
     mochila.adicionarItem(item01);
     assertEquals(1, mochila.getItens().size());
 }
 
 @Test
 public void adicionar2ItensInventario(){
     Item item01 = new Item("Espada", 1);
     Item item02 = new Item("Escudo", 1);
     Inventario mochila = new Inventario();
     mochila.adicionarItem(item01);
     mochila.adicionarItem(item01);
     assertEquals(2, mochila.getItens().size());
 }
 
  @Test
 public void removerItemInventario(){
     Item item01 = new Item("Espada", 1);
     Inventario mochila = new Inventario();
     mochila.adicionarItem(item01);
     mochila.removerItem(item01);
     assertEquals(0, mochila.getItens().size());
 }
 
  @Test
 public void remover2ItensInventario(){
     Item item01 = new Item("Espada", 1);
     Item item02 = new Item("Escudo", 1);
     Inventario mochila = new Inventario();
     mochila.adicionarItem(item01);
     mochila.adicionarItem(item02);
     mochila.removerItem(item01);
     mochila.removerItem(item02);
     assertEquals(0, mochila.getItens().size());
 }
 
 @Test
 public void verItensInventario(){
     Item item01 = new Item("Espada", 1);
     Item item02 = new Item("Escudo", 1);
     Inventario mochila = new Inventario();
     mochila.adicionarItem(item01);
     mochila.adicionarItem(item02);
     assertEquals(" Espada, Escudo, ", mochila.getDescricoesItens());
 }
 
 @Test
 public void verificaItemMaiorQuantidade(){
     Item item01 = new Item("Espada", 2);
     Item item02 = new Item("Escudo", 1);
     Inventario mochila = new Inventario();
     mochila.adicionarItem(item01);
     mochila.adicionarItem(item02);
     assertEquals(2, mochila.getItemMaiorQuantidade().getQuantidade());
 }
 
 @Test
 public void ordena4ItensAscendentes(){
     Item item01 = new Item("Espada", 2);
     Item item02 = new Item("Escudo", 1);
     Item item03 = new Item("poção vida", 20);
     Item item04 = new Item("poção mana", 10);
     Inventario mochila = new Inventario();
     mochila.adicionarItem(item01);
     mochila.adicionarItem(item02);
     mochila.adicionarItem(item03);
     mochila.adicionarItem(item04);
     mochila.ordenarItens();
     assertEquals(1, mochila.getItens().get(0).getQuantidade());
     assertEquals(2, mochila.getItens().get(1).getQuantidade());
     assertEquals(10, mochila.getItens().get(2).getQuantidade());
     assertEquals(20, mochila.getItens().get(3).getQuantidade());
 } 
 
  @Test
 public void ordena5ItensAscendentesMenorNaUltimaPosicao(){
     Item item01 = new Item("Espada", 2);
     Item item02 = new Item("Escudo", 1);
     Item item03 = new Item("poção vida", 20);
     Item item04 = new Item("poção mana", 10);
     Item item05 = new Item("Capacete", 0);
     Inventario mochila = new Inventario();
     mochila.adicionarItem(item01);
     mochila.adicionarItem(item02);
     mochila.adicionarItem(item03);
     mochila.adicionarItem(item04);
     mochila.adicionarItem(item05);
     mochila.ordenarItens();
     assertEquals(0, mochila.getItens().get(0).getQuantidade());
     assertEquals(1, mochila.getItens().get(1).getQuantidade());
     assertEquals(2, mochila.getItens().get(2).getQuantidade());
     assertEquals(10, mochila.getItens().get(3).getQuantidade());
     assertEquals(20, mochila.getItens().get(4).getQuantidade());
 }
 
 @Test
 public void ordena10ItensAscendentes(){
     Item item01 = new Item("Espada", 2);
     Item item02 = new Item("Escudo", 1);
     Item item03 = new Item("poção vida", 20);
     Item item04 = new Item("poção mana", 10);
     Item item05 = new Item("Capacete", 0);
     Item item06 = new Item("Espada", 2);
     Item item07 = new Item("Escudo", 1);
     Item item08 = new Item("poção vida", 20);
     Item item09 = new Item("poção mana", 10);
     Item item10 = new Item("Capacete", 0);
     Inventario mochila = new Inventario();
     mochila.adicionarItem(item01);
     mochila.adicionarItem(item02);
     mochila.adicionarItem(item03);
     mochila.adicionarItem(item04);
     mochila.adicionarItem(item05);
     mochila.adicionarItem(item06);
     mochila.adicionarItem(item07);
     mochila.adicionarItem(item08);
     mochila.adicionarItem(item09);
     mochila.adicionarItem(item10);
     mochila.ordenarItens();
     assertEquals(0, mochila.getItens().get(0).getQuantidade());
     assertEquals(0, mochila.getItens().get(1).getQuantidade());
     assertEquals(1, mochila.getItens().get(2).getQuantidade());
     assertEquals(1, mochila.getItens().get(3).getQuantidade());
     assertEquals(2, mochila.getItens().get(4).getQuantidade());
     assertEquals(2, mochila.getItens().get(5).getQuantidade());
     assertEquals(10, mochila.getItens().get(6).getQuantidade());
     assertEquals(10, mochila.getItens().get(7).getQuantidade());
     assertEquals(20, mochila.getItens().get(8).getQuantidade());
     assertEquals(20, mochila.getItens().get(9).getQuantidade());
 }

 @Test
 public void ordena10ItensDescendentes(){
     Item item01 = new Item("Espada", 2);
     Item item02 = new Item("Escudo", 1);
     Item item03 = new Item("poção vida", 20);
     Item item04 = new Item("poção mana", 10);
     Item item05 = new Item("Capacete", 0);
     Item item06 = new Item("Espada", 2);
     Item item07 = new Item("Escudo", 1);
     Item item08 = new Item("poção vida", 20);
     Item item09 = new Item("poção mana", 10);
     Item item10 = new Item("Capacete", 0);
     Inventario mochila = new Inventario();
     mochila.adicionarItem(item01);
     mochila.adicionarItem(item02);
     mochila.adicionarItem(item03);
     mochila.adicionarItem(item04);
     mochila.adicionarItem(item05);
     mochila.adicionarItem(item06);
     mochila.adicionarItem(item07);
     mochila.adicionarItem(item08);
     mochila.adicionarItem(item09);
     mochila.adicionarItem(item10);
     mochila.ordenarItens(TipoOrdenacao.DESCENDENTE);
     assertEquals(20, mochila.getItens().get(0).getQuantidade());
     assertEquals(20, mochila.getItens().get(1).getQuantidade());
     assertEquals(10, mochila.getItens().get(2).getQuantidade());
     assertEquals(10, mochila.getItens().get(3).getQuantidade());
     assertEquals(2, mochila.getItens().get(4).getQuantidade());
     assertEquals(2, mochila.getItens().get(5).getQuantidade());
     assertEquals(1, mochila.getItens().get(6).getQuantidade());
     assertEquals(1, mochila.getItens().get(7).getQuantidade());
     assertEquals(0, mochila.getItens().get(8).getQuantidade());
     assertEquals(0, mochila.getItens().get(9).getQuantidade());
    }
}
