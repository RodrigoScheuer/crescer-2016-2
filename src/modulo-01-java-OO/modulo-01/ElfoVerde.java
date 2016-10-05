
public class ElfoVerde extends Elfo {

    public ElfoVerde(String nome){
        super(nome);
    }
    
    public ElfoVerde(String nome, int quantidade){
        super(nome, quantidade);
    }

    public void atirarFlecha(Dwarf dwarf){
        super.atirarFlecha(dwarf);
        this.experiencia++;
    }
    
    @Override
    protected void inicializarInventario(int quantidadeFlechas) {
        this.adicionarItem(new Item("Arco de Vidro", 1));
        this.adicionarItem(new Item("Flecha de Vidro", quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
    }

    public void adicionarItem(Item item){
        if(item.getDescricao() == "Espada de aço valiriano" || 
        item.getDescricao() == "Arco e Flecha de Vidro"){
            this.itens.adicionarItem(item);
        }
    }
}
