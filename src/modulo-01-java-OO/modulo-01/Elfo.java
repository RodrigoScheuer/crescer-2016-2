public class Elfo{

    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;
    
<<<<<<< HEAD
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
=======
    public Elfo(String n) {
        // Chamando construtor debaixo
        this(n, 42);
    }
    
    public Elfo(String nome, int quantidadeFlechas) {
        this.nome = nome;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", quantidadeFlechas >= 0 ? quantidadeFlechas : 42);
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }

    public Item getArco() {
        return arco;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public Item getFlecha() {
        return flecha;
    }

    public void atirarFlecha(Dwarf dwarf) {
        boolean temFlecha = flecha.getQuantidade() > 0;
        if (temFlecha) {
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            experiencia++;
            dwarf.perderVida();
        }
    }

    public String toString() {
        //return "<nome> possui <flechas> flechas e <exp> níveis de experiência.";

        boolean flechaNoSingular = this.flecha.getQuantidade() == 1;
        boolean experienciaNoSingular = this.experiencia == 0 || this.experiencia == 1;

        return String.format("%s possui %d %s e %d %s de experiência.",
            this.nome,
            this.flecha.getQuantidade(),
            // ?:
            flechaNoSingular ? "flecha" : "flechas",
            this.experiencia,
            experienciaNoSingular ? "nível" : "níveis"
        );
    }

    /*public void atirarFlechaRefactory() {
    experiencia++;
    flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
}

>>>>>>> master
