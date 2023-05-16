package usuaris;

// Imports
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import residueix.residueixapp.utils.Api;

/**
 * Classe TestTransaccionsUsuari per proves en la pantalla transaccions
 * @author Daniel Garcia Ruiz
 * @version 15/05/2023
 */
public class TestTransaccionsUsuari {
    
    /**
     * Mètode consultaTransaccionsCorrecte per demanar les transaccions d'un usuari
     */
    @Test
    public void consultaTransaccionsCorrecte() {
        JSONObject jsonObject = (JSONObject) Api.consultaTransaccions(27);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
     /**
     * Mètode consultaTransaccionsSense per demanar les transaccions d'un usuari sense elles
     */
    @Test
    public void consultaTransaccionsSense() {
        JSONObject jsonObject = (JSONObject) Api.consultaTransaccions(1);
        String esp = "transaccions_3";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
       
}