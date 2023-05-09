package residueix.residueixapp.utils;

// Imports
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Classe per el renderitzat de les taules JTable
 * @author Daniel Garcia Ruiz
 * @version 29/03/2023
 */
public class RenderitzatsTaules {
    
    /**
     * Contructor per defecte
     */
    public RenderitzatsTaules(){}
    
    /**
     * Mètode per definir la cella com centrada.
     * @return  el tablecellrendered
     */
    public static DefaultTableCellRenderer centrat(){
        DefaultTableCellRenderer render= new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);
        return render;
    }
    

    /**
     * Mètode per afegir la imatge a la cella que es vol renderitzar
     * @param imatge nom de la imatge
     * @param seccio codi de la secció on es vol utilitzar (per determinar la ruta)
     * @return JLabel que conté la imatge renderitzada.
     */
    public static JLabel cellaImatge(String imatge, int seccio){
        String url1 = "";
        try {
            switch(seccio){
                case 1 -> { url1 = "http://169.254.142.250/residueix/img/residus/tipus/" + imatge;}
                case 2 -> { url1 = "http://169.254.142.250/residueix/img/residus/" + imatge;}
                case 3 -> { url1 = "http://169.254.142.250/residueix/img/punts/" + imatge;}
                case 4 -> { url1 = "http://169.254.142.250/residueix/img/esdeveniments/" + imatge;}
            }
            
            URL url = new URL(url1);
            BufferedImage imagen = ImageIO.read(url);
            if(imagen!=null){
                //ImageIcon icono = new ImageIcon(new ImageIcon(imagen).getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                ImageIcon icono = new ImageIcon(imagen);
                Icon ico = new ImageIcon(icono.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                return new JLabel(ico);
            }else{
                return null;
            }
        } catch (MalformedURLException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
    
}

