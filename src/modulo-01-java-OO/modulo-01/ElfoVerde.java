
public class ElfoVerde extends Elfo {

    public ElfoVerde(String nome){
        super(nome);
    }

    public void atirarFlecha(Dwarf dwarf){
        super.atirarFlecha(dwarf);
        this.experiencia++;
    }

    public void adicionarItem(Item item){
        if(item.getDescricao() == "Espada de aço valiriano" || 
        item.getDescricao() == "Arco e Flecha de Vidro"){
            this.itens.adicionarItem(item);
        }
    }
}
