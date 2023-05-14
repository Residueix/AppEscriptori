package usuaris;

// Imports
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.usuaris.PantallaLlistatUsuaris;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.usuaris.PantallaTransaccionsUsuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.xifratParaulaClau;

/**
 * Classe TestTransaccionsUsuari per proves en la pantalla transaccions
 * @author Daniel Garcia Ruiz
 * @version 14/05/2023
 */
public class TestTransaccionsUsuari {
    
    /**
     * Instància de la classe PantallaPrincipal
     */
    static PantallaTransaccionsUsuari ptu;
    
    /**
     * Instància d'usuari
     */
    static Usuari usuari;
    
    
    /**
     * Métode Beforeclass per inicialitzar les classes necessàries per les proves
     * @throws java.lang.InterruptedException
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void beforeClass() throws InterruptedException, Exception{
        JSONObject jsonUser = Api.login("danisvh@gmail.com", xifratParaulaClau.encrypt("danisvh1"));
        TestTransaccionsUsuari.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
        ptu = new PantallaTransaccionsUsuari(usuari,27);
    }
    
    
    /**
     * Mètode consultaTransaccionsCorrecte per demanar les transaccions d'un usuari
     */
    @Test
    public void consultaTransaccionsCorrecte() {
        JSONObject jsonObject = (JSONObject) Api.consultaTransaccions(27);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
     /**
     * Mètode consultaTransaccionsSense per demanar les transaccions d'un usuari sense
     */
    @Test
    public void consultaTransaccionsSense() {
        JSONObject jsonObject = (JSONObject) Api.consultaTransaccions(1);
        String esp = "transaccions_3";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
       
}