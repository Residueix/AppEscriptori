package usuaris;

// Imports
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.usuaris.PantallaLlistatUsuaris;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;

/**
 * Classe TestLlistatUsuaris per proves en la pantalla Llistat usuaris.
 * @author Daniel Garcia Ruiz
 * @version 19/04/2023
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
     * Métode Beforeclass per inicialitzar les classes necessàries per les proves
     * @throws java.lang.InterruptedException
     */
    @BeforeClass
    public static void beforeClass() throws InterruptedException{
        JSONObject jsonUser = Api.login("danisvh@gmail.com", "danisvh1");
        TestLlistatUsuaris.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
        plu = new PantallaLlistatUsuaris(usuari);
    }
    
    
    /**
     * Mètode llistatUsuaris per demanar els usaris de l'aplicació
     */
    @Test
    public void llistatUsuaris() {
        JSONObject jsonObject = (JSONObject) Api.llistatUsuaris(usuari,0,0);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode llistatUsuaris amb filtre per tipus per demanar els usaris de l'aplicació
     */
    @Test
    public void llistatUsuarisFiltreTipus() {
        JSONObject jsonObject = (JSONObject) Api.llistatUsuaris(usuari,4,0);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode llistatUsuaris amb filtre per actiu per demanar els usaris de l'aplicació
     */
    @Test
    public void llistatUsuarisFiltreActiu() {
        JSONObject jsonObject = (JSONObject) Api.llistatUsuaris(usuari,0,1);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode llistatUsuaris amb filtres incorrectes per demanar els usaris de l'aplicació i veure si controlem aquest errors
     */
    @Test
    public void llistatUsuarisFiltresIncorrectes() {
        JSONObject jsonObject = (JSONObject) Api.llistatUsuaris(usuari,6,6);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
   
    
    
       
}