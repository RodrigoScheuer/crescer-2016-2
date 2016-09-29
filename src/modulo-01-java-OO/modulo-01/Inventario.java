import java.util.ArrayList;

public class Inventario{

    private ArrayList<Item> itens = new ArrayList<>();
    
    public ArrayList<Item> getItens(){
        return this.itens; 
    }
    
    public void adicionarItem(Item item){
        /*for(int i = 0; i < itens.length; i++){
            if(itens[i] == null){
                itens[i].add(item);
            } 
        }*/
    }
    
    public void removerItem(Item item){
        /*for(int i = 0; i < itens.length; i++){
            if(itens[i].equals(item)){
                itens[i].remove(item);
            } 
        }*/
    }
}