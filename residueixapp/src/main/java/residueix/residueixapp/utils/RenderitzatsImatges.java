package residueix.residueixapp.utils;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Classe per la renderització d'imatges als JTables
 * @author Daniel Garcia Ruiz
 * @version 29/03/2023
 */
public class RenderitzatsImatges extends DefaultTableCellRenderer {
    
    /**
     * Mètode sobreescrit per retornar el component de tableCellRenderer
     * @param table jtable
     * @param value objecte que conté
     * @param isSelected si està seleccionat
     * @param hasFocus si té el focus
     * @param row número de fila
     * @param column número de columna
     * @return jLabel i heredats
     */
    @Override
     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof JLabel jLabel){
              return jLabel;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
    
}