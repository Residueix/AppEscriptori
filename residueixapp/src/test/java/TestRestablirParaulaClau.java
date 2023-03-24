import javax.mail.MessagingException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import residueix.residueixapp.PantallaRestablirParaulaClau;
import residueix.residueixapp.utils.EnviamentCorreu;

/**
 * Classe TestRestablirParaulaClau per proves en la pantalla de restablir paraula clau.
 * @author Daniel Garcia Ruiz
 * @version 23/03/2023
 */
public class TestRestablirParaulaClau {
    
    /**
     * Instància de la classe PantallaLogin
     */
    PantallaRestablirParaulaClau prpc;
    
    /**
     * Mètode before utilitzar per inicialitzar la PantallaLogin a cada prova.
     */
    @Before
    public void before() {
        prpc = new PantallaRestablirParaulaClau();
    }
    
    /**
     * Mètode formatEmailCorrecte utilitzat per validar que el format de l'email és el correcte.
     */
    @Test
    public void formatEmailCorrecte() {
        boolean res = prpc.getApi().validarEmail("danisvh@gmail.com");
        boolean esp = true;
        assertEquals(esp,res);
    }
    
    /**
     * Mètode formatEmailIncorrecte utilitzat per validar que el format de l'email és incorrecte i tractar els errors.
     */
    @Test
    public void formatEmailIncorrecte() {
        boolean res = prpc.getApi().validarEmail("malament");
        boolean esp = false;
        assertEquals(esp,res);
    }
    
    /**
     * Mètode apiValidarExisteixCorreu utilitzat per validar que el email existeix
     */
    @Test
    public void apiValidarExisteixCorreu(){
        JSONObject json = prpc.getApi().existeixCorreu("danisvh@gmail.com");
        String esp = "0";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode apiValidarExisteixCorreuIncorrecte utilitzat per validar que el email existeix però pasant-li correu que no existeix.
     */
    @Test
    public void apiValidarExisteixCorreuIncorrecte(){
        JSONObject json = prpc.getApi().existeixCorreu("malament@gmail.com");
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
    
    /**
     * Mètode enviamentCorreuErroni que comprova si s'envia un correu.
     */
    /*
    @Test
    public void enviamentCorreuErroni(){
        EnviamentCorreu ec = new EnviamentCorreu();
        boolean esp = false;
        boolean res = ec.enviament("Prova junit", "Prova junit", "danisvh@gmail.com");
        assertEquals(esp,res);
    }
    */
    
    
}
