package puntsrecollida;

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
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.puntsrecollida.PantallaAltaPuntRecollida;
import residueix.residueixapp.utils.Api;

/**
 * Classe TestAltaPuntRecollida per proves en la pantalla de alta punts de recolida
 * @author Daniel Garcia Ruiz
 * @version 19/04/2023
 */
public class TestAltaPuntRecollida {
    
    /**
     * Instància de la classe PantallaPrincipal
     */
    static PantallaAltaPuntRecollida papr;
    
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
    String id = null;
    
    /**
     * Métode Beforeclass per inicialitzar les classes necessàries per les proves
     * @throws java.lang.InterruptedException
     */
    @BeforeClass
    public static void beforeClass() throws InterruptedException{
        JSONObject jsonUser = Api.login("danisvh@gmail.com", "danisvh1");
        
        System.out.println("JSON USER" + jsonUser.toString());
        TestAltaPuntRecollida.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
        papr = new PantallaAltaPuntRecollida(usuari);
    }
    
    /**
     * Mètode before per executar desrpés de cada test
     * @throws IOException 
     */
    @After
    public void after() throws IOException{
        if(id!=null){
            JSONObject jsonObject = (JSONObject) Api.eliminarRegistre("punt",id);
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
     * Mètode llistatPoblacions per carregar les poblacions al combobox
     */
    @Test
    public void llistatPoblacions() throws IOException{
        JSONObject jsonObject = (JSONObject) Api.llistatPoblacions();
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    
    /**
     * Mètode altaResiduCorrecte quan donem d'alta un residu correcte
     */
    @Test
    public void altaPuntCorrecte() throws IOException{
        JSONObject jsonObject = Api.altaPunt(usuari, "jUnit prova", "jUnit prova", "42.0001", "2.891", "jUnit prova", "08080", "18", "jUnit prova",carregarImatge(), "1");
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        id = jsonObject.getString("id");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode altaPuntCorrecteCampsObligatoris quan donem d'alta un residu correcte però només amb les dades obligatories.
     */
    @Test
    public void altaPuntCorrecteCampsObligatoris() throws IOException{
        JSONObject jsonObject = Api.altaPunt(usuari, "jUnit prova", "jUnit prova", "", "", "", "", "", "",carregarImatge(), "1");
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        System.out.println("JSON!!" + jsonObject.toString());
        id = jsonObject.getString("id");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode altaResiduCorrecte quan donem d'alta un residu incorrecte (sense paràmetres)
     */
    @Test
    public void altaIncorrecte() throws IOException{
        JSONObject jsonObject = Api.altaPunt(usuari, "", "", "42.0001", "2.891", "jUnit prova", "08080", "18", "jUnit prova",carregarImatge(), "1");
        String esp = "punts_recollida_5";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    
}