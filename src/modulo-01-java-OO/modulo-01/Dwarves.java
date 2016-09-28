
public class Dwarves
{
    int vida;
    
    public Dwarves(){
        this.vida = 110;
    }
    
    public void levaFlechada(){
        vida = vida - 10;
    }
    
    public int getVida(){
        return vida;
    }
}
