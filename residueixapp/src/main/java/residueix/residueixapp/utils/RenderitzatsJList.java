package residueix.residueixapp.utils;

import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 * Classe per donar estils a les celles del jList
 * @author Daniel Garcia Ruiz
 * @version 12/04/2023
 */
public class RenderitzatsJList extends DefaultListCellRenderer {
    
   /**
    * SobreEscriptura del mètode getListCellRendererComponent per personalitzar-ho
    * @param list
    * @param value
    * @param index
    * @param isSelected
    * @param cellHasFocus
    * @return Component amb els nous estils
    */
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        // Cridem al render per defecte per obtenir el component base.
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        // Apliquem els estils
        ((javax.swing.JLabel) c).setHorizontalAlignment(javax.swing.JLabel.CENTER);
        
        // retornem el component estilitzat
        return c;
    }
    
}

