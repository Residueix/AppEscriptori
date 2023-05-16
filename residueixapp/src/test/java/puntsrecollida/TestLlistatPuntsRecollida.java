package puntsrecollida;

// Imports
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import residueix.residueixapp.utils.Api;

/**
 * Classe TestLlistatPuntsRecollida per proves en la pantalla de llistat de punts de recollida
 * @author Daniel Garcia Ruiz
 * @version 16/05/2023
 */
public class TestLlistatPuntsRecollida {
     
    /**
     * Mètode llistatPunsRecolida per demanar els punts de recollida
     */
    @Test
    public void llistatPunsRecolida() {
        JSONObject jsonObject = (JSONObject) Api.llistatPunts(Api.token,"1");
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
  
}