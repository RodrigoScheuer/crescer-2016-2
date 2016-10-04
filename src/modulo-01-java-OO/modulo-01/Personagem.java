import java.util.ArrayList;

public class Personagem
{
    protected String nome;
    protected Status status;
    protected Inventario itens;
    protected int experiencia;
    protected int vida;
    
    public Personagem(String nome){
        this.nome = nome;
        this.status = Status.VIVO;
        this.itens = new Inventario();
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
    
    public int getExperiencia() {
        return experiencia;
    }
    
        public int getVida() {
        return this.vida;
    }

}
