package esdeveniments;

// Imports
import java.io.IOException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.esdeveniments.PantallaAssistentsEsdeveniment;
import residueix.residueixapp.esdeveniments.PantallaLlistatEsdeveniments;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.xifratParaulaClau;

/**
 * Classe TestAssistentsEsdeveniments per proves en la pantalla de llistat de esdeveniments
 * @author Daniel Garcia Ruiz
 * @version 09/05/2023
 */
public class TestAssistentsEsdeveniments {
    
    /**
     * Instància de la classe PantallaPrincipal
     */
    static PantallaAssistentsEsdeveniment pae;
    
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
        TestAssistentsEsdeveniments.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
        pae = new PantallaAssistentsEsdeveniment(usuari,1);
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
    
    /**
     * Mètode per consultar un esdevenimentcorrecte.
     * @throws IOException 
     */
    @Test
    public void consultaEsdevenimentCorrecte() throws IOException{
        JSONObject jsonObject = Api.consultaEsdeveniment(1);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per consultar un esdeveniment però incorrecte.
     * @throws IOException 
     */
    @Test
    public void consultaEsdevenimentIncorrecte() throws IOException{
        JSONObject jsonObject = Api.consultaEsdeveniment(2000);
        String esp = "esdeveniments_6";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per consultar assistens a esdeveniment correcte.
     * @throws IOException 
     */
    @Test
    public void consultaAssistentsCorrecte() throws IOException{
        JSONObject jsonObject = Api.llistatAssistents(1);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per consultar assistens a esdeveniment incorrecte.
     * @throws IOException 
     */
    @Test
    public void consultaAssistentsIncorrecte() throws IOException{
        JSONObject jsonObject = Api.llistatAssistents(2000);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    
  
}