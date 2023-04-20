package residus;

// Imports
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.residus.PantallaLlistatResidus;
import residueix.residueixapp.residus.PantallaLlistatTipusResidus;
import residueix.residueixapp.utils.Api;

/**
 * Classe TestLListatTipusResidu per proves en la pantalla de llistat de tipus residus
 * @author Daniel Garcia Ruiz
 * @version 19/04/2023
 */
public class TestLListatTipusResidu {
    
    /**
     * Instància de la classe PantallaPrincipal
     */
    static PantallaLlistatTipusResidus pltr;
    
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
        TestLListatTipusResidu.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
        pltr = new PantallaLlistatTipusResidus(usuari);
    }
    
    
    /**
     * Mètode llistatResidus per demanar els residus
     */
    @Test
    public void llistatResidus() {
        JSONObject jsonObject = (JSONObject) Api.llistatTipusResidu(usuari);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
  
}