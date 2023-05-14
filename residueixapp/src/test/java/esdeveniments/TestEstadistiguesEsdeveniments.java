package esdeveniments;

// Imports
import java.io.IOException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import residueix.residueixapp.utils.Api;

/**
 * Classe TestEstadistiguesEsdeveniments per proves en la pantalla de estadistiques de esdeveniments
 * @author Daniel Garcia Ruiz
 * @version 14/05/2023
 */
public class TestEstadistiguesEsdeveniments {
    
   
    /**
     * Mètode llistatEsdeveniments per demanar els esdeveniments disponibles
     */
    @Test
    public void llistatEsdeveniments() {
        JSONObject jsonObject = (JSONObject) Api.llistatEsdeveniments();
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per consultar un esdevenimentcorrecte.
     * @throws IOException 
     */
    @Test
    public void consultaEsdevenimentCorrecte() throws IOException{
        JSONObject jsonObject = Api.consultaEsdeveniment(1);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per consultar un esdeveniment però incorrecte.
     * @throws IOException 
     */
    @Test
    public void consultaEsdevenimentIncorrecte() throws IOException{
        JSONObject jsonObject = Api.consultaEsdeveniment(2000);
        String esp = "esdeveniments_6";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per consultar assistens a esdeveniment correcte.
     * @throws IOException 
     */
    @Test
    public void consultaAssistentsCorrecte() throws IOException{
        JSONObject jsonObject = Api.llistatAssistents(1);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per consultar assistens a esdeveniment incorrecte.
     * @throws IOException 
     */
    @Test
    public void consultaAssistentsIncorrecte() throws IOException{
        JSONObject jsonObject = Api.llistatAssistents(2000);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
     
  
}