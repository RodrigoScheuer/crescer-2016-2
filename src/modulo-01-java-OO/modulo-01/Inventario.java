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

    public void ordenarItens() {
        ordenarItens(TipoOrdenacao.ASCENDENTE);
    }

    public void ordenarItens(TipoOrdenacao tipoOrdenacao) {
        // Versão mais estável do Bubblesort - Melhor caso O(n), Pior caso O(n^2)
        // homenagem ao do-while: para forçar entrada na lógica
        boolean posicoesSendoTrocadas;
        boolean ascendente = tipoOrdenacao == TipoOrdenacao.ASCENDENTE;
        do {
            posicoesSendoTrocadas = false;
            for (int j = 0; j < this.itens.size() - 1; j++) {
                Item itemAtual = this.itens.get(j);
                Item proximo = this.itens.get(j + 1);

                boolean precisaTrocar = 
                    ascendente ? itemAtual.getQuantidade() > proximo.getQuantidade() : itemAtual.getQuantidade() < proximo.getQuantidade();

                if (precisaTrocar) {
                    this.itens.set(j, proximo);
                    this.itens.set(j + 1, itemAtual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);

    }
}

