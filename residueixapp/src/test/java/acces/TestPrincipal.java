package acces;

import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;
import residueix.residueixapp.PantallaPrincipal;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;

/**
 * Classe TestPrincipal per proves en la pantalla principal.
 * @author Daniel Garcia Ruiz
 * @version 24/03/2023
 */
public class TestPrincipal {
    
    /**
     * Instància de la classe PantallaPrincipal
     */
    PantallaPrincipal pp;
    
    
    /**
     * Mètode inicialitzacioPrincipial utilitzat per entrar en la pantalla Principal.
     */
    @Test
    public void inicialitzacioPrincipal() throws InterruptedException {
        Api api = new Api();
        JSONObject jsonUser = api.login("danisvh@gmail.com", "danisvh1");
        String esp = "0";
        String res = jsonUser.get("codi_error").toString();
        Usuari usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token"));
        Thread.sleep(1000);
        pp = new PantallaPrincipal(usuari);
        assertEquals(esp,res);
        
    }
    
       
}