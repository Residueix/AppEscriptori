import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import residueix.residueixapp.PantallaRestablirParaulaClau;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.EnviamentCorreu;

/**
 * Classe TestRestablirParaulaClau per proves en la pantalla de restablir paraula clau.
 * @author Daniel Garcia Ruiz
 * @version 24/03/2023
 */
public class TestRestablirParaulaClau {
    
    /**
     * Instància de la classe PantallaLogin
     */
    static PantallaRestablirParaulaClau prpc;
    /**
     * Instància d'Api
     */
    static Api api;
    
    /**
     * Mètode before utilitzar per inicialitzar la PantallaLogin a cada prova.
     */
    @BeforeClass
    public static void before() {
        TestRestablirParaulaClau.api = new Api();
        prpc = new PantallaRestablirParaulaClau();
    }
    
    /**
     * Mètode formatEmailCorrecte utilitzat per validar que el format de l'email és el correcte.
     */
    @Test
    public void formatEmailCorrecte() {
        boolean res = api.validarEmail("danisvh@gmail.com");
        boolean esp = true;
        assertEquals(esp,res);
    }
    
    /**
     * Mètode formatEmailIncorrecte utilitzat per validar que el format de l'email és incorrecte i tractar els errors.
     */
    @Test
    public void formatEmailIncorrecte() {
        boolean res = api.validarEmail("malament");
        boolean esp = false;
        assertEquals(esp,res);
    }
    
    /**
     * Mètode apiValidarExisteixCorreu utilitzat per validar que el email existeix
     */
    @Test
    public void apiValidarExisteixCorreu(){
        JSONObject json = api.existeixCorreu("danisvh@gmail.com");
        String esp = "0";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode apiValidarExisteixCorreuIncorrecte utilitzat per validar que el email existeix però pasant-li correu que no existeix.
     */
    @Test
    public void apiValidarExisteixCorreuIncorrecte(){
        JSONObject json = api.existeixCorreu("malament@gmail.com");
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
