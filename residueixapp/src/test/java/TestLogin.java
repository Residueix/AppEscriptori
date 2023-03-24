import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import residueix.residueixapp.PantallaLogin;
import residueix.residueixapp.utils.Api;

/**
 * Classe TestLogin per proves en la pantalla de login.
 * @author Daniel Garcia Ruiz
 * @version 24/03/2023
 */
public class TestLogin {
    
    /**
     * Instància de la classe PantallaLogin
     */
    static PantallaLogin pl;
    /**
     * Instància d'Api
     */
    static Api api;
    
    /**
     * Mètode before utilitzar per inicialitzar la PantallaLogin a cada prova.
     */
    @BeforeClass
    public static void before() {
        TestLogin.api = new Api();
        pl = new PantallaLogin();
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
     * Mètode cridaApiLoginCorrrecta utilitzat per validar que el json de resposta es correcte pasant-li dades bones.
     */
    @Test
    public void cridaApiLoginCorrecta(){
        JSONObject json = api.login("danisvh@gmail.com", "danisvh1");
        String esp = "0";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode cridaApiLoginIncorrecteCredencialsErronees per comprovar que el json de resposta ens retorna l'error corresponent per poder tractar-ho.
     */
    @Test
    public void cridaApiLoginIncorrectaCredencialsErronees(){
        JSONObject json = api.login("danisvh@gmail.com", "malament");
        String esp = "login_3";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode cridaApiLoginIncorrectaSenseEmail per comprovar que el json de resposta ens retorna l'error corresponet per poder tractar-ho.
     */
    @Test
    public void cridaApiLoginIncorrectaSenseEmail(){
        JSONObject json = api.login("", "malament");
        String esp = "login_3";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode cridaApiLoginIncorrectaSensePassord per comprovar que el json de resposta ens retorna l'error corresponent per poder tractar-ho.
     */
    @Test
    public void cridaApiLoginIncorrectaSensePassword(){
        JSONObject json = api.login("danisvh@gmail.com", "");
        String esp = "login_3";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    
    
}
