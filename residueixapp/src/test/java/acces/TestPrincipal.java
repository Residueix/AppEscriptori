package acces;

// Imports
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.xifratParaulaClau;

/**
 * Classe TestPrincipal per proves en la pantalla principal.
 * @author Daniel Garcia Ruiz
 * @version 15/05/2023
 */
public class TestPrincipal {
    
    /**
     * Mètode inicialitzacioPrincipial utilitzat per entrar en la pantalla Principal.
     * @throws InterruptedException
     * @throws Exception
     */
    @Test
    public void inicialitzacioPrincipal() throws InterruptedException, Exception {
        JSONObject jsonUser = Api.login("danisvh@gmail.com", xifratParaulaClau.encrypt("danisvh1"));
        String esp = "0";
        String res = jsonUser.get("codi_error").toString();
        Usuari usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token"));
        Thread.sleep(1000);
        assertEquals(esp,res); 
    }
    
       
}