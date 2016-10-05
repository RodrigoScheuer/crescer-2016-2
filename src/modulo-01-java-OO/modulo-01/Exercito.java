import java.util.ArrayList;

public abstract class Exercito{
    
    public abstract void alistarElfo(Elfo elfo);
    
    public abstract Elfo buscarPeloNome(String nome);
    
    public abstract ArrayList<Elfo> buscar(Status status);
    
}
