package esdeveniments;

// Imports
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.esdeveniments.PantallaLlistatEsdeveniments;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.puntsrecollida.PantallaLlistatPuntsRecollida;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.xifratParaulaClau;

/**
 * Classe TestLlistatEsdeveniments per proves en la pantalla de llistat de esdeveniments
 * @author Daniel Garcia Ruiz
 * @version 09/05/2023
 */
public class TestLlistatEsdeveniments {
    
    /**
     * Instància de la classe PantallaPrincipal
     */
    static PantallaLlistatEsdeveniments ple;
    
    /**
     * Instància d'usuari
     */
    static Usuari usuari;
    
    
    /**
     * Métode Beforeclass per inicialitzar les classes necessàries per les proves
     * @throws java.lang.InterruptedException
     */
    @BeforeClass
    public static void beforeClass() throws InterruptedException, Exception{
        JSONObject jsonUser = Api.login("danisvh@gmail.com", xifratParaulaClau.encrypt("danisvh1"));
        TestLlistatEsdeveniments.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
        ple = new PantallaLlistatEsdeveniments(usuari);
    }
    
    
    /**
     * Mètode llistatEsdeveniments per demanar els esdeveniments disponibles
     */
    @Test
    public void llistatEsdeveniments() {
        JSONObject jsonObject = (JSONObject) Api.llistatEsdeveniments();
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
  
}