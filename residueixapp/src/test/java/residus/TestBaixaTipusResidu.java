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
import residueix.residueixapp.residus.PantallaBaixaTipusResidu;
import residueix.residueixapp.residus.PantallaModificarTipusResidu;
import residueix.residueixapp.utils.Api;

/**
 * Classe TestBaixaTipusResidu per proves en la pantalla de baixa tipus residu
 * @author Daniel Garcia Ruiz
 * @version 19/04/2023
 */
public class TestBaixaTipusResidu {
    
    /**
     * Instància de la classe PantallaPrincipal
     */
    static PantallaBaixaTipusResidu pbtr;
    
    /**
     * Instància d'usuari
     */
    static Usuari usuari;
    /**
     * File per les proves d'alta d'imatges
     */
    static File imatge;
    /**
     * Id del tipus creat.
     */
    String idTipus = null;
    
    /**
     * Métode Beforeclass per inicialitzar les classes necessàries per les proves
     * @throws java.lang.InterruptedException
     */
    @BeforeClass
    public static void beforeClass() throws InterruptedException, IOException{
        JSONObject jsonUser = Api.login("danisvh@gmail.com", "danisvh1");
        TestBaixaTipusResidu.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
    }
    
    /**
     * Mètode before per executar abans de cada test
     * @throws IOException 
     */
    @Before
    public void before() throws IOException{
        JSONObject jsonObject = (JSONObject) Api.altaTipusResidu(usuari, "jUnit Prova", carregarImatge());
        idTipus = jsonObject.getString("id");
    }
    
    /**
     * Mètode after per executar després de cada test
     * @throws IOException 
     */
    @After
    public void after() throws IOException{
        if(idTipus!=null){
            JSONObject jsonObject = (JSONObject) Api.eliminarRegistre("tipusresidus",idTipus);
            idTipus = null;
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
     * Mètode baixaTipusResiduCorrecte quan donem de baixa un tipus residu correcte
     */
    @Test
    public void baixaTipusResiduCorrecte() throws IOException{
        pbtr = new PantallaBaixaTipusResidu(usuari,Integer.parseInt(idTipus));
        JSONObject jsonObject = (JSONObject) Api.baixaTipusResidu(usuari, Integer.parseInt(idTipus));
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        System.out.println(jsonObject.getString("codi_error"));
        assertEquals(esp,res);
    }
    
    /**
     * Mètode modificarTipusResiduIncorrecte quan donem de baixa un tipus residu incorrecte
     */
    @Test
    public void baixaTipusResiduIncorrecte() throws IOException{
        pbtr = new PantallaBaixaTipusResidu(usuari,Integer.parseInt(idTipus));
        JSONObject jsonObject = (JSONObject) Api.baixaTipusResidu(usuari, -1);
        String esp = "tipus_residu_10";
        String res = jsonObject.getString("codi_error");
        System.out.println(jsonObject.getString("codi_error"));
        assertEquals(esp,res);
    }
    
  
}