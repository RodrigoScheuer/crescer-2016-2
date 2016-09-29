public class Dwarf {
    private String nome;
    private int vida;
    private int experiencia;
    private DataTerceiraEra dataNascimento;
    
    // java type initializer
    // vai ser replicado para cada construtor
    {
        vida = 110;
    }
    
    public Dwarf(){
        this.nome = "dwarf";
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }
    
    public Dwarf(String nome, DataTerceiraEra data){
        this.nome = nome;
        this.dataNascimento = data;
    }

    public void perderVida() {
        if(getNumeroSorte() < 0)
            experiencia += 2;
            
        if(getNumeroSorte() > 100)
            this.vida -= 10;
    }

    public int getVida() {
        return vida;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }
    
    public double getNumeroSorte(){
        if(dataNascimento.ehBissexto(dataNascimento.getAno()) == true && getVida() >= 80 && getVida() <= 90)
            return -33 * 101;
        
        if(dataNascimento.ehBissexto(dataNascimento.getAno()) == false && getNome() == "Seixas" || getNome() == "Meireles")
            return (101.0 * 33) % 100;
            
        return 101.0;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
}


