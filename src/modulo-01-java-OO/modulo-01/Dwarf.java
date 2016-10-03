import java.util.ArrayList;

public class Dwarf extends Personagem{
    protected int vida, experiencia;
    protected DataTerceiraEra dataNascimento;

    // java type initializer
    // vai ser replicado para cada construtor
    {
        vida = 110;
    }

    public Dwarf(String nome, DataTerceiraEra data){
        super(nome);
        this.dataNascimento = data;
    }

    public Dwarf() { // recebe ainda o java type initializer
        this(null, new DataTerceiraEra(1,1,1));
    }

    public void perderVida() {
        if(getStatus() == Status.VIVO){
            double numero = this.getNumeroSorte();
            if (numero < 0) {
                this.experiencia += 2;
            }
            if (numero > 100) {
                vida -= 10;
                if(vida == 0){
                    setStatus(Status.MORTO);
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
    
    public void tentarSorte(){
        if(getNumeroSorte() == -3333.0){
            Item itemAtual;
            for(int i = 0; i < itens.getItens().size(); i++){
                itemAtual = itens.getItens().get(i); 
                itemAtual.setQuantidade(itemAtual.getQuantidade() + 1000);
            }
        }
    }
}