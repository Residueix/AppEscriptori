package puntsrecollida;

// Imports
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.puntsrecollida.PantallaLlistatPuntsRecollida;
import residueix.residueixapp.utils.Api;

/**
 * Classe TestLlistatPuntsRecollida per proves en la pantalla de llistat de punts de recollida
 * @author Daniel Garcia Ruiz
 * @version 19/04/2023
 */
public class TestLlistatPuntsRecollida {
    
    /**
     * Instància de la classe PantallaPrincipal
     */
    static PantallaLlistatPuntsRecollida plpr;
    
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
        TestLlistatPuntsRecollida.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
        plpr = new PantallaLlistatPuntsRecollida(usuari);
    }
    
    
    /**
     * Mètode llistatPunsRecolida per demanar els punts de recollida
     */
    @Test
    public void llistatPunsRecolida() {
        JSONObject jsonObject = (JSONObject) Api.llistatPunts(Api.token,"1");
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
  
}