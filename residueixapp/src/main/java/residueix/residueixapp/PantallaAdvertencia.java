package residueix.residueixapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Classe per obrir la finestra per Restablir paraula clau.
 * @author Daniel Garcia Ruiz
 * @version 12/03/2023
 */
public class PantallaAdvertencia extends javax.swing.JFrame {

    // Atributs
    /**
     * Posició x del ratolí.
     */
    private int xMouse;
    /** 
     * Posició y del ratolí.
     */
    private int yMouse;
    /**
     * Missatge per mostrar
     */
    private static String missatge;
    
    /**
     * Crea una nova instpancia de la classe PantallaRestablirParaulaClau.
     * @param missatge (String) : missatge a mostrar.
     */
    public PantallaAdvertencia(String missatge) {
        // Iniciem els atributs
        this.missatge = missatge;
        // Iniciem els components
        initComponents();
        // Centrar pantalla
        centrarPantalla();
        // Característiques del textarea.
        definicioTextArea(missatge);
    }

    /**
     * Mètode critad per el constructor per inicialitzar el formulari.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        buttonTancar = new javax.swing.JButton();
        scrollPaneMissatge = new javax.swing.JScrollPane();
        textAreaMissatge = new javax.swing.JTextArea();
        labelFons = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(400, 300));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonTancar.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        buttonTancar.setText("X");
        buttonTancar.setToolTipText("Tancar");
        buttonTancar.setBorder(null);
        buttonTancar.setBorderPainted(false);
        buttonTancar.setContentAreaFilled(false);
        buttonTancar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTancarActionPerformed(evt);
            }
        });
        panelPrincipal.add(buttonTancar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        scrollPaneMissatge.setBorder(null);
        scrollPaneMissatge.setOpaque(false);

        textAreaMissatge.setColumns(20);
        textAreaMissatge.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        textAreaMissatge.setRows(5);
        textAreaMissatge.setText("prueba de texto.");
        textAreaMissatge.setBorder(null);
        textAreaMissatge.setOpaque(false);
        scrollPaneMissatge.setViewportView(textAreaMissatge);

        panelPrincipal.add(scrollPaneMissatge, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 340, 170));

        labelFons.setBackground(new java.awt.Color(255, 255, 255));
        labelFons.setIcon(new javax.swing.ImageIcon("C:\\Users\\isard\\Downloads\\logo_pantalles_petites.png")); // NOI18N
        panelPrincipal.add(labelFons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Mètode per centrar la pantalla
     */
    private void centrarPantalla(){
        // Centrar pantalla.
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(((pantalla.width)-this.getWidth())/2,((pantalla.height)-this.getHeight())/2);
    }
    
    /**
     * Mètode per donar estil al textarea
     */
    private void definicioTextArea(String missatge){
        scrollPaneMissatge.setOpaque(false);
        scrollPaneMissatge.getViewport().setOpaque(false);
        scrollPaneMissatge.setBorder(null);
        scrollPaneMissatge.setViewportBorder(null);
        textAreaMissatge.setBorder(null);
        textAreaMissatge.setBackground(new Color(0,0,0,0));
        textAreaMissatge.setText(missatge);
    }
    
    /**
     * Mètode executat quan premem el botó per tancar finestra
     * @param evt Action Event: Event de prémer botó
     */
    private void buttonTancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTancarActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonTancarActionPerformed

    /**
     * Mètode per capturar la x i y del mouse quan el deixem pulsat sobre el frame principal.
     * @param evt MouseEvent: event de deixar pulsat el botó del ratolí.
     */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed
    
    /**
     * Mètode executat quan movem el mouse amb el formulari pulsat. 
     * @param evt MouseEvent: event quan arroseguem amb el ratolí.
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_formMouseDragged
    
    /**
     * Mètode principal de la classe.
     * @param args arguments de la linia de comandament
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaAdvertencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaAdvertencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaAdvertencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaAdvertencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaAdvertencia(missatge).setVisible(true);
            }
        });
    }                     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Botó per tancar la finestra.
    */
    private javax.swing.JButton buttonTancar;
    /**
    * Label que conté la imatge de fons de la pantalla.
    */
    private javax.swing.JLabel labelFons;
    /**
    * Panel principal per contenir la pantalla.
    */
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane scrollPaneMissatge;
    private javax.swing.JTextArea textAreaMissatge;
    // End of variables declaration//GEN-END:variables
}
