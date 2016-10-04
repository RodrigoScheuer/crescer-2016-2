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
           for(int i = 0; i < this.itens.getItens().size() ; i++){ 
                this.itens.getItens().get(i).aumentaQuantidadeItens();
           }
        }
    }
    
}

