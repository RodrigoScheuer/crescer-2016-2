public class Elfo{

    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;
    
    public Elfo(String nome){
        this.nome = nome;
        arco = new Item("Arco",1);
        flecha = new Item("Flechas", 42);
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void atiraFlecha(){
        flecha.setQuantidade(flecha.getQuantidade() - 1);
        experiencia++;
    }
    
    public Item getArco(){
        return this.arco;
    }
    
    /*public void atirarFlechaRefactory(){
        flecha.setQuantidade(flecha.getQuantidade() - 1);
        experiencia++;
    }*/
    
    

}