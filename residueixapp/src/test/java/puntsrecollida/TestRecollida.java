package puntsrecollida;

// Imports
import java.io.IOException;
import org.json.JSONObject;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.xifratParaulaClau;

/**
 * Classe TestRecollida per proves en la pantalla on es genera el carretó de residuent per deixar residus
 * @author Daniel Garcia Ruiz
 * @version 16/05/2023
 */
public class TestRecollida {
    
    /**
     * Instància d'usuari
     */
    static Usuari usuari;
    /**
     * Id de la transacció creada
     */
    String id = null;
    
    
    /**
     * Métode Beforeclass per inicialitzar les classes necessàries per les proves
     * @throws java.lang.InterruptedException
     * @throws Exception
     */
    @BeforeClass
    public static void beforeClass() throws InterruptedException, Exception{
        JSONObject jsonUser = Api.login("treballador@residueix.com", xifratParaulaClau.encrypt("treballador"));
        TestRecollida.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
    }
    
    /**
     * Mètode before per executar desrpés de cada test
     * @throws IOException 
     */
    @After
    public void after() throws IOException{
        if(id!=null){
            JSONObject jsonObject = (JSONObject) Api.eliminarRegistre("recollida",id);
            id = null;
        }
    }  
    
    /**
     * Mètode llistatTipusResiduCorrecte per demanar els tipus de residus per omplir el combo
     */
    @Test
    public void llistatTipusResiduCorrecte() {
        JSONObject jsonObject = Api.llistatTipusResidu(usuari);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
      * Mètode llistatResidusCorrecte per demanar els residus per omplir el combo
    */
    @Test
    public void llistatResidusCorrecte() {
        JSONObject jsonObject = Api.llistatResidus(usuari);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode enviamentCarretoCorrecte per enviar el carretó a l'api i crear la recollida
     */
    @Test
    public void enviamentCarretoCorrecte(){
        String json = "{\"usuari\":\"27\",\"punt\":\"17\",\"total\":\"0.85\",\"llistat\":[{\"id_residu\":\"5\",\"quantitat\":\"4\",\"valor\":\"0.002\"},{\"id_residu\":\"5\",\"quantitat\":\"4\",\"valor\":\"0.002\"}]}";
        JSONObject jsonObject = Api.recollida(usuari, json);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        id = jsonObject.getString("id_transaccio");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode enviamentCarretoIncorrecte per enviar el carretó a l'api i crear la recollida
     */
    
    @Test
    public void enviamentCarretoIncorrecte(){
        String json = "";
        JSONObject jsonObject = Api.recollida(usuari, json);
        String esp = "recollida_2";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
  
}