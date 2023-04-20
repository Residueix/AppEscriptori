package acces;

// Imports
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import residueix.residueixapp.acces.PantallaLogin;
import residueix.residueixapp.utils.Api;

/**
 * Classe TestLogin per proves en la pantalla de login.
 * @author Daniel Garcia Ruiz
 * @version 19/04/2023
 */
public class TestLogin {
    
    /**
     * Instància de la classe PantallaLogin
     */
    static PantallaLogin pl;
    
    /**
     * Mètode before utilitzar per inicialitzar la PantallaLogin a cada prova.
     */
    @BeforeClass
    public static void before() {
        pl = new PantallaLogin();
    }
    
    /**
     * Mètode cridaApiLoginCorrectaAdmin utilitzat per validar que el json de resposta es correcte pasant-li dades bones.
     */
    @Test
    public void cridaApiLoginCorrectaAdmin(){
        JSONObject json = Api.login("danisvh@gmail.com", "danisvh1");
        String esp = "0";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode cridaApiLoginCorrectaTreballador utilitzat per validar que el json de resposta es correcte pasant-li dades bones.
     */
    @Test
    public void cridaApiLoginCorrectaTreballador(){
        JSONObject json = Api.login("treballador@residueix.com", "treballador");
        String esp = "0";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode cridaApiLoginCorrectaResiduent utilitzat per validar que el json de resposta es correcte pasant-li dades dolentes.
     */
    @Test
    public void cridaApiLoginCorrectaResiduent(){
        JSONObject json = Api.login("residuent@residueix.com", "residuent");
        String esp = "3";
        String res = json.getString("tipus");
        String esp2 = "0";
        String res2 = json.getString("codi_error");
        assertEquals(esp,res);
        assertEquals(esp2,res2);
    }
    
    /**
     * Mètode cridaApiLoginCorrectaAdherit utilitzat per validar que el json de resposta es correcte pasant-li dades bones.
     */
    @Test
    public void cridaApiLoginCorrectaAdherit(){
        JSONObject json = Api.login("adherit@residueix.com", "adherit");
        String esp = "4";
        String res = json.getString("tipus");
        String esp2 = "0";
        String res2 = json.getString("codi_error");
        assertEquals(esp,res);
        assertEquals(esp2,res2);
    }
    
    /**
     * Mètode cridaApiLoginIncorrecteCredencialsErronees per comprovar que el json de resposta ens retorna l'error corresponent per poder tractar-ho.
     */
    @Test
    public void cridaApiLoginIncorrectaCredencialsErronees(){
        JSONObject json = Api.login("danisvh@gmail.com", "malament");
        String esp = "login_3";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode cridaApiLoginIncorrectaSenseEmail per comprovar que el json de resposta ens retorna l'error corresponet per poder tractar-ho.
     */
    @Test
    public void cridaApiLoginIncorrectaSenseEmail(){
        JSONObject json = Api.login("", "malament");
        String esp = "login_3";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode cridaApiLoginIncorrectaSensePassord per comprovar que el json de resposta ens retorna l'error corresponent per poder tractar-ho.
     */
    @Test
    public void cridaApiLoginIncorrectaSensePassword(){
        JSONObject json = Api.login("danisvh@gmail.com", "");
        String esp = "login_3";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }   
    
    
}
