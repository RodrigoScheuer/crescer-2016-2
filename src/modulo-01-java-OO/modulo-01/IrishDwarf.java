import java.util.ArrayList;

public class IrishDwarf extends Dwarf{

    public IrishDwarf(String nome, DataTerceiraEra data){
        super(nome, data);
    }

    public IrishDwarf() {
        this(null, new DataTerceiraEra(1,1,1));
    }

    public void tentarSorte(){
        if(getNumeroSorte() == -3333.0){
            Item itemAtual;
            int total = 0, soma = 0, quantidade = 0;
                // faz para todos os itens do inventario
            for(int i = 0; i < itens.getItens().size(); i++){
                itemAtual = itens.getItens().get(i);
                quantidade = itemAtual.getQuantidade();
                if(quantidade < 0){
                    quantidade = quantidade * -1;   // transforma numero negativo em positivo
                }
                while(soma < quantidade){
                    soma += 1;
                    total += soma * 1000;   // dwarf mt sortudo
                }
                    // set quantidade ganha mais quantidade q tinha no inventario
                itemAtual.setQuantidade(total + itemAtual.getQuantidade());
            }
        }
    }
}

