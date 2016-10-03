import java.util.ArrayList;

public class Personagem
{
    protected String nome;
    private Status status;
    protected Inventario itens;
    
    public Personagem(String nome){
        this.nome = nome;
        this.status = Status.VIVO;
    }
    
    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }
    
    public void adicionarItem(Item item){
             itens.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        itens.removerItem(item);
    }
    
    public ArrayList<Item> getItens(){
        return this.itens.getItens(); 
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public void setStatus(Status status){
        this.status = status;
    }
}
