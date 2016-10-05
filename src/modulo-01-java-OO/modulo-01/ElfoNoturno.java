
public class ElfoNoturno extends Elfo{

    /* Atualmente os Elfos Noturnos podem morrer atirando flechas? Justifique.
    não, pois nao possui nem um metodo que altere o status do elfo.*/
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    public ElfoNoturno(String nome, int quantidadeFlechas){
        super(nome, quantidadeFlechas);
        this.vida = super.vida;
    }

    public void atirarFlecha(Dwarf dwarf){
        if(this. vida > 0){
            super.atirarFlecha(dwarf);
            this.experiencia += 2;
            this.vida = this.vida - (this.vida * 0.05);
            if (new Double(this.vida).toString().startsWith("0.")) {
                this.status = Status.MORTO;
            }
        }
    }

}
