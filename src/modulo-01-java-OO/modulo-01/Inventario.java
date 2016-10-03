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

    public void ordenarItens(){         // *talvez da pra otimizar
        Item itemAtual, proximoItem;
        boolean achou = true; // começa true pra entrar no metodo
        while(achou == true){
            achou = false;
            for(int i = 0; i < itens.size(); i++){
                itemAtual = getItens().get(i);
                for(int j = 1; j < itens.size(); j++){
                    proximoItem = getItens().get(j);
                    if(i < j){ // para não fazer troca errada
                        if(itemAtual.getQuantidade() > proximoItem.getQuantidade()){
                            getItens().set(j, itemAtual);
                            getItens().set(i, proximoItem);
                            achou = true;
                            break; // sai do for
                        }
                    }
                }
                if(achou == true){
                    break;  // sai do segundo for
                }
            }
        }
    }

    public void ordenarItens(TipoOrdenacao tipo){
        if(tipo == TipoOrdenacao.ASCENDENTE){
            ordenarItens();
        }else{
            Item itemAtual, proximoItem;
            boolean achou = true; // começa true pra entrar no metodo
            while(achou == true){
                achou = false;
                for(int i = 0; i < itens.size(); i++){
                    itemAtual = getItens().get(i);
                    for(int j = 1; j < itens.size(); j++){
                        proximoItem = getItens().get(j);
                        if(i < j){ // para não fazer troca errada
                            if(itemAtual.getQuantidade() < proximoItem.getQuantidade()){
                                getItens().set(j, itemAtual);
                                getItens().set(i, proximoItem);
                                achou = true;
                                break; // sai do for
                            }
                        }
                    }
                    if(achou == true){
                        break;  // sai do segundo for
                    }
                }
            }
        }

    }
}

