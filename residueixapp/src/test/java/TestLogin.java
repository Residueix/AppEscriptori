import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import residueix.residueixapp.PantallaLogin;

/**
 * Classe TestLogin per proves en la pantalla de login.
 * @author Daniel Garcia Ruiz
 * @version 23/03/2023
 */
public class TestLogin {
    
    /**
     * Instància de la classe PantallaLogin
     */
    PantallaLogin pl;
    
    /**
     * Mètode before utilitzar per inicialitzar la PantallaLogin a cada prova.
     */
    @Before
    public void before() {
        pl = new PantallaLogin();
    }
    
    /**
     * Mètode formatEmailCorrecte utilitzat per validar que el format de l'email és el correcte.
     */
    @Test
    public void formatEmailCorrecte() {
        boolean res = pl.getApi().validarEmail("danisvh@gmail.com");
        boolean esp = true;
        assertEquals(esp,res);
    }
    
    /**
     * Mètode formatEmailIncorrecte utilitzat per validar que el format de l'email és incorrecte i tractar els errors.
     */
    @Test
    public void formatEmailIncorrecte() {
        boolean res = pl.getApi().validarEmail("malament");
        boolean esp = false;
        assertEquals(esp,res);
    }
    
    /**
     * Mètode cridaApiLoginCorrrecta utilitzat per validar que el json de resposta es correcte pasant-li dades bones.
     */
    @Test
    public void cridaApiLoginCorrecta(){
        JSONObject json = pl.getApi().login("danisvh@gmail.com", "danisvh1");
        String esp = "0";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode cridaApiLoginIncorrecteCredencialsErronees per comprovar que el json de resposta ens retorna l'error corresponent per poder tractar-ho.
     */
    @Test
    public void cridaApiLoginIncorrectaCredencialsErronees(){
        JSONObject json = pl.getApi().login("danisvh@gmail.com", "malament");
        String esp = "login_3";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode cridaApiLoginIncorrectaSenseEmail per comprovar que el json de resposta ens retorna l'error corresponet per poder tractar-ho.
     */
    @Test
    public void cridaApiLoginIncorrectaSenseEmail(){
        JSONObject json = pl.getApi().login("", "malament");
        String esp = "login_3";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode cridaApiLoginIncorrectaSensePassord per comprovar que el json de resposta ens retorna l'error corresponent per poder tractar-ho.
     */
    @Test
    public void cridaApiLoginIncorrectaSensePassword(){
        JSONObject json = pl.getApi().login("danisvh@gmail.com", "");
        String esp = "login_3";
        String res = json.getString("codi_error").toString();
        assertEquals(esp,res);
    }
    
    
    
}
