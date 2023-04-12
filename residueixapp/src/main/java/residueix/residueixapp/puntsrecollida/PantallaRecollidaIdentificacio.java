package residueix.residueixapp.puntsrecollida;

import residueix.residueixapp.residus.*;
import residueix.residueixapp.principal.PantallaPrincipal;
import residueix.residueixapp.principal.PantallaAdvertencia;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.JSONArray;
import org.json.JSONObject;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.RenderitzatsJList;
import residueix.residueixapp.utils.Utils;
import residueix.residueixapp.utils.SelectorImatge;

/**
 * Classe per obrir la pantalla per donar d'alta un tipus de residu
 * @author Daniel Garcia Ruiz
 * @version 24/03/2023
 */
public class PantallaRecollidaIdentificacio extends javax.swing.JFrame { 
    
    // Atributs
    /**
     * Uusari loginat.
    */
    private static Usuari usuari;
    /**
     * Posició x del ratolí.
     */
    private int xMouse;
    /**
     * Posició y del ratolí.
     */
    private int yMouse;  
    /**
     * Imatge del residu.
     */
    private File imatge;
    
    /**
     * Crea una nova instància de la classe PantallaPrincipal.
     * @param usuari: Usuari loginat a l'aplicació.
     */
    public PantallaRecollidaIdentificacio(Usuari usuari) {
        // Assignació de l'usuari
        this.usuari = usuari;
        // Inicialització dels components
        initComponents();
        // Centrem pantalla
        centrarPantalla();
        // Accions en funcio de l'usuari
        gestioUsuari();
        // Carregar la llista de punts de recollida al jList
        carregaPunts();
    }

     /**
     * Mètode critad per el constructor per inicialitzar el formulari.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelContingut = new javax.swing.JPanel();
        panelBar = new javax.swing.JPanel();
        labelUsuari = new javax.swing.JLabel();
        panelTitol = new javax.swing.JPanel();
        labelTitol = new javax.swing.JLabel();
        scollPanelPunts = new javax.swing.JScrollPane();
        listPunts = new javax.swing.JList<>();
        labelPunts = new javax.swing.JLabel();
        textFieldIdUsuari = new javax.swing.JTextField();
        labelUsuariRecollida = new javax.swing.JLabel();
        buttonRecollir = new javax.swing.JButton();
        panelOpcions = new javax.swing.JPanel();
        buttonLogOut = new javax.swing.JButton();
        buttonTornarPantallaPrincipal1 = new javax.swing.JButton();
        labelPrincipal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(200, 100));
        setName("framePrincipal"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 750));
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
        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelContingut.setOpaque(false);
        panelContingut.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBar.setOpaque(false);

        labelUsuari.setFont(new java.awt.Font("Sansation", 0, 12)); // NOI18N
        labelUsuari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsuari.setPreferredSize(new java.awt.Dimension(600, 30));
        panelBar.add(labelUsuari);

        panelContingut.add(panelBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        panelTitol.setOpaque(false);
        panelTitol.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitol.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        labelTitol.setText("Recollida identificació");
        labelTitol.setToolTipText("Recollida identificació");
        panelTitol.add(labelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 30));

        panelContingut.add(panelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 51, 800, 50));

        scollPanelPunts.setBackground(new java.awt.Color(255, 255, 255));
        scollPanelPunts.setBorder(null);
        scollPanelPunts.setToolTipText("Punts de recollida");
        scollPanelPunts.setOpaque(false);

        listPunts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listPunts.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        listPunts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listPunts.setToolTipText("Punts de recollida");
        listPunts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listPunts.setOpaque(false);
        listPunts.setSelectionBackground(new java.awt.Color(255, 204, 51));
        listPunts.setVisibleRowCount(4);
        scollPanelPunts.setViewportView(listPunts);

        panelContingut.add(scollPanelPunts, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 250, -1));

        labelPunts.setFont(new java.awt.Font("Sansation", 0, 16)); // NOI18N
        labelPunts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPunts.setText("Punts de recollida");
        labelPunts.setToolTipText("Punts de recollida");
        labelPunts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelContingut.add(labelPunts, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 250, 30));

        textFieldIdUsuari.setFont(new java.awt.Font("Sansation", 0, 16)); // NOI18N
        textFieldIdUsuari.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldIdUsuari.setToolTipText("Identificació de l'usuari");
        panelContingut.add(textFieldIdUsuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, 140, 50));

        labelUsuariRecollida.setFont(new java.awt.Font("Sansation", 0, 16)); // NOI18N
        labelUsuariRecollida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsuariRecollida.setText("Usuari");
        labelUsuariRecollida.setToolTipText("Usuari");
        labelUsuariRecollida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelContingut.add(labelUsuariRecollida, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 140, 30));

        buttonRecollir.setBackground(new java.awt.Color(51, 204, 0));
        buttonRecollir.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonRecollir.setForeground(new java.awt.Color(255, 255, 255));
        buttonRecollir.setText("Recollir");
        buttonRecollir.setToolTipText("Recollir");
        buttonRecollir.setBorderPainted(false);
        buttonRecollir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonRecollir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRecollirActionPerformed(evt);
            }
        });
        panelContingut.add(buttonRecollir, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 690, 150, 30));

        panelPrincipal.add(panelContingut, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 798, 746));

        panelOpcions.setBackground(new java.awt.Color(255, 255, 255));
        panelOpcions.setOpaque(false);
        panelOpcions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonLogOut.setBackground(new java.awt.Color(153, 0, 0));
        buttonLogOut.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonLogOut.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogOut.setText("Sortir");
        buttonLogOut.setToolTipText("Sortir de l'aplicació");
        buttonLogOut.setBorderPainted(false);
        buttonLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogOutActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 150, 30));

        buttonTornarPantallaPrincipal1.setBackground(new java.awt.Color(255, 204, 0));
        buttonTornarPantallaPrincipal1.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonTornarPantallaPrincipal1.setText("Pantalla principal");
        buttonTornarPantallaPrincipal1.setToolTipText("Tornar pantalla principal");
        buttonTornarPantallaPrincipal1.setBorderPainted(false);
        buttonTornarPantallaPrincipal1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTornarPantallaPrincipal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTornarPantallaPrincipal1ActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonTornarPantallaPrincipal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 150, 30));

        panelPrincipal.add(panelOpcions, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 2, 200, 746));

        labelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        labelPrincipal.setIcon(new javax.swing.ImageIcon("C:\\Users\\isard\\Downloads\\fons_general.png")); // NOI18N
        labelPrincipal.setOpaque(true);
        panelPrincipal.add(labelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 996, 746));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    private void carregaPunts(){
        
        // Creem el model i l'assignem al jlist
        DefaultListModel<String> model = new DefaultListModel();
        listPunts.setModel(model);
        
        // Fem una crida a l'api per recuperar el llistat de punts de recollida
        JSONObject jsonLlistatPunts = (JSONObject) Api.llistatPunts(Api.token,"1");
        
        // Comprovem la resposta de l'api i omplim la taula amb les dades
        if(jsonLlistatPunts.get("codi_error").toString().equals("0")) {
            // Agafem les dades del camp llistat
            JSONArray arrayLlistatPunts = new JSONArray(jsonLlistatPunts.getJSONArray("llistat"));
            // Recorrem l'array per ficar-ho a la taula
            for(int i = 0; i < arrayLlistatPunts.length(); i++){
                JSONObject jsonPunt = arrayLlistatPunts.getJSONObject(i);
                model.addElement(jsonPunt.getString("nom_punt"));
                listPunts.setCellRenderer(new RenderitzatsJList());
                listPunts.setFixedCellHeight(50);
            }
        }else{
            // Missatge error
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonLlistatPunts.get("codi_error").toString() + " - " + jsonLlistatPunts.get("error").toString());
            pantallaAdvertencia.setVisible(true);
        }
        
        
        
    }
    
    /**
     * Mètode per gestionar accions en funció de l'usuari
     */
    private void gestioUsuari(){
        // Posem el nom de l'usuari a la part superior
        labelUsuari.setText( usuari.getNom() + " " + usuari.getCognom1() + " " + usuari.getCognom2() );   
    }
    
    /**
     * Mètode per centrar la pantalla
     */
    private void centrarPantalla(){
        // Centrar pantalla.
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(((pantalla.width)-this.getWidth())/2,((pantalla.height)-this.getHeight())/2);
    }
    
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
     * Mètode utilitzat quan es prem el botó de logout per tancar la sessió.
     * @param evt (ActionEvent) : event al pulsar el botó.
     */
    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogOutActionPerformed
        // Fem el logout
        Api.logout(usuari);
        System.exit( 0);
    }//GEN-LAST:event_buttonLogOutActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de tornar a la pantalla principal
     * @param evt (ActionEvent) : event al pulsar el botó. 
     */
    private void buttonTornarPantallaPrincipal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTornarPantallaPrincipal1ActionPerformed
        // Obre la pantalla principal
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(usuari);
        pantallaPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonTornarPantallaPrincipal1ActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de recollir
     * @param evt (ActionEvent) : event al pulsar el botó. 
     */
    private void buttonRecollirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRecollirActionPerformed

       System.out.println(listPunts.getSelectedValue());
       
       System.out.println(textFieldIdUsuari.getText());

    }//GEN-LAST:event_buttonRecollirActionPerformed
   
 
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
            java.util.logging.Logger.getLogger(PantallaRecollidaIdentificacio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaRecollidaIdentificacio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaRecollidaIdentificacio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaRecollidaIdentificacio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaRecollidaIdentificacio(usuari).setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Botó per donar d'alta punt de recollida
    */
    private javax.swing.JButton buttonAlta;
    /**
    * Botó per desloginar-se i sortir de l'aplicació.
    */
    private javax.swing.JButton buttonLogOut;
    /**
    * Botó per recollir
    */
    private javax.swing.JButton buttonRecollir;
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonTornarPantallaPrincipal1;
    /**
    * Label per contenir el logo de l'aplicació.
    */
    private javax.swing.JLabel labelPrincipal;
    /**
    * Label punts de recollida
    */
    private javax.swing.JLabel labelPunts;
    /**
    * Label per el títol de la pantalla.
    */
    private javax.swing.JLabel labelTitol;
    /**
    * Label per tenir les dades de l'usuari loginat
    */
    private javax.swing.JLabel labelUsuari;
    /**
    * Label usuari recollida
    */
    private javax.swing.JLabel labelUsuariRecollida;
    /**
    * list punts de recollida
    */
    private javax.swing.JList<String> listPunts;
    /**
    * Panel per contenir la informació de l'usuari loginat
    */
    private javax.swing.JPanel panelBar;
    /**
    * Panel per tenir el contingut de la pantalla.
    */
    private javax.swing.JPanel panelContingut;
    /**
    * Panel per tenir les opcions.
    */
    private javax.swing.JPanel panelOpcions;
    /**
    * Panel principal per contenir la distribució de la pantalla.
    */
    private javax.swing.JPanel panelPrincipal;
    /**
    * Panel per contenir el títol de la pantalla
    */
    private javax.swing.JPanel panelTitol;
    /**
    * Scroll pane punts de recollida
    */
    private javax.swing.JScrollPane scollPanelPunts;
    /**
    * Text field per l'id d'usuari
    */
    private javax.swing.JTextField textFieldIdUsuari;
    // End of variables declaration//GEN-END:variables
}