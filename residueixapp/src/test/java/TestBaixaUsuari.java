import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.PantallaBaixaUsuari;
import residueix.residueixapp.PantallaLlistatUsuaris;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;

/**
 * Classe TestPerfil per proves en la pantalla perfil.
 * @author Daniel Garcia Ruiz
 * @version 23/03/2023
 */
public class TestBaixaUsuari {
    
    /**
     * Instància de la classe PantallaPrincipal
     */
    static PantallaBaixaUsuari pbu;
    
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
     */
    @BeforeClass
    public static void beforeClass(){
        TestBaixaUsuari.api = new Api();
        JSONObject jsonUser = api.login("danisvh@gmail.com", "danisvh1");
        TestBaixaUsuari.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        pbu = new PantallaBaixaUsuari(usuari,1);   
    }
    
    
    /**
     * Mètode consultaUsuari per demanar les daeds del usuari
    */
    @Test
    public void consultaUsuari() {
        JSONObject jsonUsuari = api.consultaUsuari(usuari,1);
        String esp = "0";
        String res = jsonUsuari.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode consultaUsuariNoExisteix per demanar les daeds del usuari pero que no existixi per la gestió d'errors.
    */
    @Test
    public void consultaUsuariNoExisteix() {
        JSONObject jsonUsuari = api.consultaUsuari(usuari,999);
        String esp = "usuaris_25";
        String res = jsonUsuari.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode baixaUsuari per donar de baixa l'usuari
     */
    @Test
    public void baixaUsuari(){
        JSONObject jsonUsuari = api.eliminarUsuari(usuari,1);
        String esp = "0";
        String res = jsonUsuari.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode baixaUsuariNoExisteix per donar de baixa l'usuari no existent
     */
    @Test
    public void baixaUsuariNoExisteix(){
        JSONObject jsonUsuari = api.eliminarUsuari(usuari,1);
        String esp = "0";
        String res = jsonUsuari.getString("codi_error");
        assertEquals(esp,res);
    }
    
    
    
       
}