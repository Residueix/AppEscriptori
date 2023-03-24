import static java.lang.Thread.sleep;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.PantallaLlistatUsuaris;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;

/**
 * Classe TestPerfil per proves en la pantalla perfil.
 * @author Daniel Garcia Ruiz
 * @version 24/03/2023
 */
public class TestLlistatUsuaris {
    
    /**
     * Instància de la classe PantallaPrincipal
     */
    static PantallaLlistatUsuaris plu;
    
    /**
     * Instància d'usuari
     */
    static Usuari usuari;
    
    /**
     * Instància d'Api
     */
    static Api api;
    
    /**
     * Métode Beforeclass per inicialitzar les classes necessàries per les proves
     * @throws java.lang.InterruptedException
     */
    @BeforeClass
    public static void beforeClass() throws InterruptedException{
        TestLlistatUsuaris.api = new Api();
        JSONObject jsonUser = api.login("danisvh@gmail.com", "danisvh1");
        TestLlistatUsuaris.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
        plu = new PantallaLlistatUsuaris(usuari);
    }
    
    
    /**
     * Mètode llistatUsuaris per demanar els usaris de l'aplicació
     */
    @Test
    public void llistatUsuaris() {
        JSONObject jsonObject = (JSONObject) api.llistatUsuaris(usuari,0,0);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode llistatUsuaris amb filtre per tipus per demanar els usaris de l'aplicació
     */
    @Test
    public void llistatUsuarisFiltreTipus() {
        JSONObject jsonObject = (JSONObject) api.llistatUsuaris(usuari,4,0);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode llistatUsuaris amb filtre per actiu per demanar els usaris de l'aplicació
     */
    @Test
    public void llistatUsuarisFiltreActiu() {
        JSONObject jsonObject = (JSONObject) api.llistatUsuaris(usuari,0,1);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode llistatUsuaris amb filtres incorrectes per demanar els usaris de l'aplicació i veure si controlem aquest errors
     */
    @Test
    public void llistatUsuarisFiltresIncorrectes() {
        JSONObject jsonObject = (JSONObject) api.llistatUsuaris(usuari,6,6);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
   
    
    
       
}