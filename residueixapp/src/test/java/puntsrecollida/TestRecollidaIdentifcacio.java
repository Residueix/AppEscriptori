package puntsrecollida;

// Imports
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.xifratParaulaClau;

/**
 * Classe TestLlistatPuntsRecollida per proves en la pantalla de llistat de punts de recollida
 * @author Daniel Garcia Ruiz
 * @version 19/04/2023
 */
public class TestRecollidaIdentifcacio {
   
    /**
     * Instància d'usuari
     */
    static Usuari usuari;
    
    
    /**
     * Métode Beforeclass per inicialitzar les classes necessàries per les proves
     * @throws java.lang.InterruptedException
     * @throws Exception
     */
    @BeforeClass
    public static void beforeClass() throws InterruptedException, Exception{
        JSONObject jsonUser = Api.login("treballador@residueix.com", xifratParaulaClau.encrypt("treballador"));
        TestRecollidaIdentifcacio.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
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
    
     /**
     * Mètode consultaUsuari per comprovar que l'usuari és residuent
     */
    @Test
    public void consultaUsuariCorrecte() {
        JSONObject jsonObject = Api.consultaUsuari(usuari, 27);
        String esp = "3";
        String res = jsonObject.getString("tipus");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode consultaUsuari per comprovar que l'usuari no es residuent i llavors no pot gestionar els residus
     */
    @Test
    public void consultaUsuariIncorrecte() {
        JSONObject jsonObject = Api.consultaUsuari(usuari, 2);
        String esp = "1";
        String res = jsonObject.getString("tipus");
        assertEquals(esp,res);
    }
  
}