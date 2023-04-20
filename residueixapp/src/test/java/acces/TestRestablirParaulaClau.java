package acces;

// Imports
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import residueix.residueixapp.acces.PantallaRestablirParaulaClau;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.EnviamentCorreu;

/**
 * Classe TestRestablirParaulaClau per proves en la pantalla de restablir paraula clau.
 * @author Daniel Garcia Ruiz
 * @version 19/04/2023
 */
public class TestRestablirParaulaClau {
    
    /**
     * Instància de la classe PantallaLogin
     */
    static PantallaRestablirParaulaClau prpc;

    /**
     * Mètode before utilitzar per inicialitzar la PantallaLogin a cada prova.
     */
    @BeforeClass
    public static void before() {
        prpc = new PantallaRestablirParaulaClau();
    }
    
    /**
     * Mètode apiValidarExisteixCorreu utilitzat per validar que el email existeix
     */
    @Test
    public void apiValidarExisteixCorreu(){
        JSONObject json = Api.existeixCorreu("danisvh@gmail.com");
        String esp = "0";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode apiValidarExisteixCorreuIncorrecte utilitzat per validar que el email existeix però pasant-li correu que no existeix.
     */
    @Test
    public void apiValidarExisteixCorreuIncorrecte(){
        JSONObject json = Api.existeixCorreu("malament@gmail.com");
        String esp = "usuaris_26";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode enviamentCorreu que comprova si s'envia un correu.
     */
    @Test
    public void enviamentCorreu(){
        EnviamentCorreu ec = new EnviamentCorreu();
        boolean esp = true;
        boolean res = ec.enviament("Prova junit", "Prova junit", "danisvh@gmail.com");
        assertEquals(esp,res);
    }
      
    
}
