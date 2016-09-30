import java.util.ArrayList;

public class Inventario{

    private ArrayList<Item> itens = new ArrayList<>();
    
    public ArrayList<Item> getItens(){
        return this.itens; 
    }
    
    public void adicionarItem(Item item){
             itens.add(item);
    }
    
    public void removerItem(Item item){
        itens.remove(item);
    }
    
    public String getDescricoesItens(){
        String s = " ";
        for(int i = 0; i < itens.size(); i++){
            s += this.getItens().get(i).getDescricao() +", "; 
        }
        return s;
    }
    
    public Item getItemMaiorQuantidade(){
        Item itemMaior = itens.get(0);
        for(int i = 1; i < itens.size(); i++){
            if(getItens().get(i).getQuantidade() > itemMaior.getQuantidade()){
                itemMaior = getItens().get(i);
            }
        }
        return itemMaior;
    }
    
}