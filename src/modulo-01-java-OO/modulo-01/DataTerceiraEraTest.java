

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DataTerceiraEraTest{

    @Test
    public void iniciaDataTerceiraEra(){        
        DataTerceiraEra data = new DataTerceiraEra(30,12,1992);
        
        assertEquals(30, data.getDia());
        assertEquals(12, data.getMes());
        assertEquals(1992, data.getAno());
    }

    @Test
    public void DataTerceiraEraFimDaGuerraDoAnel(){        
        DataTerceiraEra data = new DataTerceiraEra(1, 10, 3019);
        
        assertEquals(1, data.getDia());
        assertEquals(10, data.getMes());
        assertEquals(3019, data.getAno());
    }
    
    @Test
    public void DataTerceiraEraEhBissexto(){        
        DataTerceiraEra data = new DataTerceiraEra(25,12,2016);
        assertEquals(true, data.ehBissexto(2016));
    }
    
    @Test
    public void DataTerceiraEraNaoEhBissexto(){        
        DataTerceiraEra data = new DataTerceiraEra(25,10,2010);
        assertEquals(false, data.ehBissexto(2010));
    }
    
    @Test
    public void DataTerceiraEraNaoEhBissextoAntesDeMil(){        
        DataTerceiraEra data = new DataTerceiraEra(25,10,300);
        assertEquals(false, data.ehBissexto(300));
    }
   
    @Test
    public void DataTerceiraEraEhBissextoAntesDeMil(){        
        DataTerceiraEra data = new DataTerceiraEra(25,10,400);
        assertEquals(true, data.ehBissexto(400));
    }
}
