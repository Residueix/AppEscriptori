package residus;

// Imports
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.json.JSONObject;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.xifratParaulaClau;

/**
 * Classe TestModificarResidu per proves en la pantalla de modificació residu
 * @author Daniel Garcia Ruiz
 * @version 16/05/2023
 */
public class TestModificarResidu {

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
        TestModificarResidu.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
    }
    
    /**
     * Mètode before per executar abans de cada test
     * @throws IOException 
     */
    @Before
    public void before() throws IOException{
        JSONObject jsonObject = (JSONObject) Api.altaResidu(usuari,"1","jUnit Prova","jUnit prova","0.001",carregarImatge(), "1");
        id = jsonObject.getString("id");
    }
    
    /**
     * Mètode before per executar desrpés de cada test
     * @throws IOException 
     */
    @After
    public void after() throws IOException{
        if(id!=null){
            JSONObject jsonObject = (JSONObject) Api.eliminarRegistre("residu",id);
            id = null;
        }
    }
    
    /**
     * Mètode per carregar imatge per fer les crides a l'api
     * @return File
     * @throws IOException 
     */
    public File carregarImatge() throws IOException{
        ImageIcon img = new javax.swing.ImageIcon(getClass().getResource("/images/test.png"));   
        Image imagen = img.getImage();
        File arxiu = File.createTempFile("imagen", ".png");
        try (OutputStream out = new FileOutputStream(arxiu)) {
            BufferedImage bi = new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.createGraphics();
            g.drawImage(imagen, 0, 0, null);
            g.dispose();
            ImageIO.write(bi, "png", out);
            return arxiu;
        } catch (IOException e) {
            return null;
        }
    }
    
    /**
     * Mètode modificarResiduCorrecte quan modifiquem un residu correcte
     * @throws IOException
     */
    @Test
    public void modificarResiduCorrecte() throws IOException{
        JSONObject jsonObject = (JSONObject) Api.modificacioResidu(usuari,Integer.parseInt(id),"1","jUnit Prova 2","jUnit Prova 2","0.001", carregarImatge(),"1");
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode modificarResiduCorrecteSenseImatge quan modifiquem un residu correcte sense Imatge
     * @throws IOException
     */
    @Test
    public void modificarResiduCorrecteSenseImatge() throws IOException{
        JSONObject jsonObject = (JSONObject) Api.modificacioResidu(usuari,Integer.parseInt(id),"1","jUnit Prova 2","jUnit Prova 2","0.001", null,"1");
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode modificaResiduIncorrecteSenseParametres quan modifiquem un residu incorrecte sense algun paràmetre
     * @throws IOException
     */
    @Test
    public void modificaResiduIncorrecteSenseParametres() throws IOException{
        JSONObject jsonObject = (JSONObject) Api.modificacioResidu(usuari,Integer.parseInt(id),"1","","jUnit Prova 2","0.001", null,"1");
        String esp = "residu_13";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode llistatTipusResidusCorrecte quan demanem el llistat de tipus de residu per els combos
     * @throws IOException
     */
    @Test
    public void llistatTipusResidusCorrecte() throws IOException{
        JSONObject jsonObject = (JSONObject) Api.llistatTipusResidu(usuari);
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode consultaResiduCorrecte quan demanem la info del residu per omplir el formulari
     * @throws IOException
     */
    @Test
    public void consultaResiduCorrecte() throws IOException{
        JSONObject jsonObject = (JSONObject) Api.consultaResidu(usuari, Integer.parseInt(id));
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    
    
  
}