package usuaris;

// Imports
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.xifratParaulaClau;

/**
 * Classe TestBaixaUsuari per proves en la pantalla Baixa usuari.
 * @author Daniel Garcia Ruiz
 * @version 16/05/2023
 */
public class TestBaixaUsuari {
    
    /**
     * Instància d'usuari
     */
    static Usuari usuari;
    /**
     * Id del tipus creat.
     */
    String id = null;
    
    /**
     * Métode Beforeclass per inicialitzar les classes necessàries per les proves
     * @throws java.lang.InterruptedException
     * @throws Exception
     */
    @BeforeClass
    public static void beforeClass() throws InterruptedException, Exception{
        JSONObject jsonUser = Api.login("danisvh@gmail.com", xifratParaulaClau.encrypt("danisvh1"));
        TestBaixaUsuari.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000); 
    }    
    
    /**
     * Mètode consultaUsuari per demanar les daeds del usuari
    */
    @Test
    public void consultaUsuari() {
        JSONObject jsonUsuari = Api.consultaUsuari(usuari,1);
        String esp = "0";
        String res = jsonUsuari.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode consultaUsuariNoExisteix per demanar les daeds del usuari pero que no existixi per la gestió d'errors.
    */
    @Test
    public void consultaUsuariNoExisteix() {
        JSONObject jsonUsuari = Api.consultaUsuari(usuari,999);
        String esp = "usuaris_25";
        String res = jsonUsuari.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode baixaUsuari per donar de baixa l'usuari
     */
    @Test
    public void baixaUsuari(){
        JSONObject jsonUsuari = Api.eliminarUsuari(usuari,1);
        String esp = "0";
        String res = jsonUsuari.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode baixaUsuariNoExisteix per donar de baixa l'usuari no existent
     */
    @Test
    public void baixaUsuariNoExisteix(){
        JSONObject jsonUsuari = Api.eliminarUsuari(usuari,999);
        String esp = "0";
        String res = jsonUsuari.getString("codi_error");
        assertEquals(esp,res);
    }
    
      
}