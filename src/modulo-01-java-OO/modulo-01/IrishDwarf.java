import java.util.ArrayList;

public class IrishDwarf {
    private int vida, experiencia;
    private DataTerceiraEra dataNascimento;
    private String nome;
    private Status status;
    private Inventario itens = new Inventario();

    // java type initializer
    // vai ser replicado para cada construtor
    {
        vida = 110;
        this.status = Status.VIVO;
    }

    public IrishDwarf(String nome, DataTerceiraEra data){
        this.nome = nome;
        this.dataNascimento = data;
    }

    public IrishDwarf() {
        this(null, new DataTerceiraEra(1,1,1));
    }

    public void perderVida() {
        if(status == Status.VIVO){
            double numero = this.getNumeroSorte();
            if (numero < 0) {
                this.experiencia += 2;
            }
            if (numero > 100) {
                vida -= 10;
                if(vida == 0){
                    status = Status.MORTO;
                }
            }
        }
    }

    public int getVida() {
        return vida;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public String getNome() {
        return this.nome;
    }
    
    public Status getStatus(){
        return status;
    }

    public DataTerceiraEra getDataNascimento() {
        return this.dataNascimento;
    }

    public double getNumeroSorte() {
        double resultado = 101.;
        boolean ehBissexto = dataNascimento.ehBissexto();

        if (ehBissexto && this.vida >= 80 && this.vida <= 90) {
            resultado *= -33.0;
        }
        //if (!dataNascimento.ehBissexto() && this.nome != null && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))) {
        if (!ehBissexto && ("Seixas".equals(this.nome) || "Meireles".equals(this.nome))) {
            resultado = resultado * 33 % 100;
        }

        return resultado;
    }
    
    public void ganharItem(Item item){
             itens.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        itens.removerItem(item);
    }
    
    public ArrayList<Item> getItens(){
        return this.itens.getItens(); 
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

