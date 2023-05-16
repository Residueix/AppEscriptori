package acces;

// Imports
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.xifratParaulaClau;

/**
 * Classe TestLogin per proves en la pantalla de login.
 * @author Daniel Garcia Ruiz
 * @version 15/05/2023
 */
public class TestLogin {
    
    /**
     * Mètode cridaApiLoginCorrectaAdmin utilitzat per validar que el json de resposta es correcte pasant-li dades bones.
     * @throws Exception excepcions d'encriptament
     */
    @Test
    public void cridaApiLoginCorrectaAdmin() throws Exception{
        JSONObject json = Api.login("danisvh@gmail.com",xifratParaulaClau.encrypt("danisvh1"));
        String esp = "1";
        String res = json.getString("tipus");
        String esp2 = "0";
        String res2 = json.getString("codi_error");
        assertEquals(esp,res);
        assertEquals(esp2,res2);
    }
    
    /**
     * Mètode cridaApiLoginCorrectaTreballador utilitzat per validar que el json de resposta es correcte pasant-li dades bones.
     * @throws Exception excepcions d'encriptament
     */
    @Test
    public void cridaApiLoginCorrectaTreballador() throws Exception{
        JSONObject json = Api.login("treballador@residueix.com", xifratParaulaClau.encrypt("treballador"));
        String esp = "2";
        String res = json.getString("tipus");
        String esp2 = "0";
        String res2 = json.getString("codi_error");
        assertEquals(esp,res);
        assertEquals(esp2,res2);
    }
    
    /**
     * Mètode cridaApiLoginCorrectaResiduent utilitzat per validar que el json de resposta es correcte pasant-li dades dolentes.
     * @throws Exception excepcions d'encriptament
     */
    @Test
    public void cridaApiLoginCorrectaResiduent() throws Exception{
        JSONObject json = Api.login("residuent@residueix.com", xifratParaulaClau.encrypt("residuent"));
        String esp = "3";
        String res = json.getString("tipus");
        String esp2 = "0";
        String res2 = json.getString("codi_error");
        assertEquals(esp,res);
        assertEquals(esp2,res2);
    }
    
    /**
     * Mètode cridaApiLoginCorrectaAdherit utilitzat per validar que el json de resposta es correcte pasant-li dades bones.
     * @throws Exception excepcions d'encriptament
     */
    @Test
    public void cridaApiLoginCorrectaAdherit() throws Exception{
        JSONObject json = Api.login("adherit@residueix.com", xifratParaulaClau.encrypt("adheritpass"));
        String esp = "4";
        String res = json.getString("tipus");
        String esp2 = "0";
        String res2 = json.getString("codi_error");
        assertEquals(esp,res);
        assertEquals(esp2,res2);
    }
    
    /**
     * Mètode cridaApiLoginIncorrecteCredencialsErronees per comprovar que el json de resposta ens retorna l'error corresponent per poder tractar-ho.
     * @throws Exception excepcions d'encriptament
     */
    @Test
    public void cridaApiLoginIncorrectaCredencialsErronees() throws Exception{
        JSONObject json = Api.login("danisvh@gmail.com", xifratParaulaClau.encrypt("malament"));
        String esp = "login_3";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode cridaApiLoginIncorrectaSenseEmail per comprovar que el json de resposta ens retorna l'error corresponet per poder tractar-ho.
     * @throws Exception excepcions d'encriptament
     */
    @Test
    public void cridaApiLoginIncorrectaSenseEmail() throws Exception{
        JSONObject json = Api.login("", xifratParaulaClau.encrypt("malament"));
        String esp = "login_3";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode cridaApiLoginIncorrectaSensePassord per comprovar que el json de resposta ens retorna l'error corresponent per poder tractar-ho.
     * @throws Exception excepcions d'encriptament
     */
    @Test
    public void cridaApiLoginIncorrectaSensePassword() throws Exception{
        JSONObject json = Api.login("danisvh@gmail.com", xifratParaulaClau.encrypt(""));
        String esp = "login_3";
        String res = json.getString("codi_error");
        assertEquals(esp,res);
    }   
    
    
}
