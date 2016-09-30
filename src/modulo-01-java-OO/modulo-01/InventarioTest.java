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

}
