import java.util.ArrayList;

public class Elfo extends Personagem{
    
    private static int contador = 0;

    public Elfo(String n) {
        // Chamando construtor debaixo
        this(n, 42);
    }
    
    public Elfo(String nome, int quantidadeFlechas) {
        super(nome);
        this.contador ++;
        this.vida = 100;
        this.inicializarInventario(quantidadeFlechas);
    }

    public Item getArco() {
        return itens.getItens().get(0);
    }

    public Item getFlecha() {
        return itens.getItens().get(1);
    }

    public void atirarFlecha(Dwarf dwarf) {
        boolean temFlecha = getFlecha().getQuantidade() > 0;
        if (temFlecha) {
            getFlecha().setQuantidade(getFlecha().getQuantidade() - 1);
            experiencia++;
            dwarf.perderVida();
        }
    }

    public String toString() {
        //return "<nome> possui <flechas> flechas e <exp> níveis de experiência.";

        boolean flechaNoSingular = getFlecha().getQuantidade() == 1;
        boolean experienciaNoSingular = this.experiencia == 0 || this.experiencia == 1;

        return String.format("%s possui %d %s e %d %s de experiência.",
            this.nome,
            getFlecha().getQuantidade(),
            flechaNoSingular ? "flecha" : "flechas",
            this.experiencia,
            experienciaNoSingular ? "nível" : "níveis"
        );
    }
    
    protected void inicializarInventario(int quantidadeFlechas) {
        this.itens.adicionarItem(new Item("Arco", 1));
        this.itens.adicionarItem(new Item("Flechas", quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
    }
    
    public static int getContador(){
        return contador;
    }
    
    protected void finalize() throws Throwable{
        super.finalize();
        Elfo.contador--;
    }
}

