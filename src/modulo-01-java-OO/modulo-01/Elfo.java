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
        if(flecha.getQuantidade() > 0){
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            experiencia++;
        }else{
            System.out.println("Acabou as flechas!");
        }
    }
    
    public Item getArco(){
        return this.arco;
    }
    
    public Item getFlecha(){
        return this.flecha;
    }
    
    public void atiraFlechaEmDwarves(){
        atiraFlecha();
    }
    
    /*public void atirarFlechaRefactory(){
        flecha.setQuantidade(flecha.getQuantidade() - 1);
        experiencia++;
    }*/
}