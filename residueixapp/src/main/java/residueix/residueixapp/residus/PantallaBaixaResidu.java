package residueix.residueixapp.residus;

import residueix.residueixapp.principal.PantallaAdvertencia;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.JSONArray;
import org.json.JSONObject;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.Utils;
import residueix.residueixapp.utils.SelectorImatge;

/**
 * Classe per obrir la pantalla per donar de baixa un Residu
 * @author Daniel Garcia Ruiz
 * @version 03/04/2023
 */
public class PantallaBaixaResidu extends javax.swing.JFrame {
    
    
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
     * Tipus de residu id
     */
    private static int idResidu;       
    
    /**
     * Crea una nova instància de la classe PantallaPrincipal.
     * @param usuari (Usuari) Usuari loginat a l'aplicació.
     * @param idResidu (int) identifciador del residu a donar de baixa.
     */
    public PantallaBaixaResidu(Usuari usuari, int idResidu) {
        // Assignació de l'usuari
        this.usuari = usuari;
        // Assignació del residu a modificar
        this.idResidu = idResidu;
        // Inicialització dels components
        initComponents();
        // Centrem pantalla
        centrarPantalla();
        // Accions en funcio de l'usuari
        gestioUsuari();
        // Càrrega inicial del formulari.
        carregaFormulari();
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
        labelActiuSeleccionat = new javax.swing.JLabel();
        labelTipus = new javax.swing.JLabel();
        labelValor = new javax.swing.JLabel();
        labelActiu = new javax.swing.JLabel();
        labelDescripcio = new javax.swing.JLabel();
        buttonBaixa = new javax.swing.JButton();
        labelImatge = new javax.swing.JLabel();
        labelNom = new javax.swing.JLabel();
        labelImatgeSeleccionada = new javax.swing.JLabel();
        labelIdSeleccionat = new javax.swing.JLabel();
        labelPathImatge = new javax.swing.JLabel();
        labelValorSeleccionat = new javax.swing.JLabel();
        labelTipusSeleccionat = new javax.swing.JLabel();
        labelNomSeleccionat = new javax.swing.JLabel();
        scrollPaneDescripcio = new javax.swing.JScrollPane();
        textAreaDescripcioSeleccionat = new javax.swing.JTextArea();
        panelOpcions = new javax.swing.JPanel();
        buttonLogOut = new javax.swing.JButton();
        buttonTornar = new javax.swing.JButton();
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
        labelTitol.setText("Baixa Residu");
        labelTitol.setToolTipText("");
        panelTitol.add(labelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 30));

        panelContingut.add(panelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 51, 800, 50));

        labelActiuSeleccionat.setBackground(new java.awt.Color(255, 255, 255));
        labelActiuSeleccionat.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelActiuSeleccionat.setToolTipText("Imatge del residu");
        labelActiuSeleccionat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelActiuSeleccionat.setOpaque(true);
        panelContingut.add(labelActiuSeleccionat, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 220, 30));

        labelTipus.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelTipus.setText("Tipus");
        panelContingut.add(labelTipus, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 100, 30));

        labelValor.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelValor.setText("Valor");
        labelValor.setToolTipText("Valor del residu");
        panelContingut.add(labelValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 100, 30));

        labelActiu.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelActiu.setText("Actiu");
        labelActiu.setToolTipText("");
        panelContingut.add(labelActiu, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 50, 30));

        labelDescripcio.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelDescripcio.setText("Descripció");
        labelDescripcio.setToolTipText("Descripció del residu");
        panelContingut.add(labelDescripcio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 100, 30));

        buttonBaixa.setBackground(new java.awt.Color(51, 204, 0));
        buttonBaixa.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonBaixa.setForeground(new java.awt.Color(255, 255, 255));
        buttonBaixa.setText("Donar de baixa");
        buttonBaixa.setToolTipText("Baixa Residu");
        buttonBaixa.setBorderPainted(false);
        buttonBaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBaixaActionPerformed(evt);
            }
        });
        panelContingut.add(buttonBaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 690, 150, 30));

        labelImatge.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelImatge.setText("Imatge");
        labelImatge.setToolTipText("Imatge del residu");
        panelContingut.add(labelImatge, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 100, 30));

        labelNom.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelNom.setText("Nom");
        labelNom.setToolTipText("Nom del residu");
        panelContingut.add(labelNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 100, 30));

        labelImatgeSeleccionada.setToolTipText("Imatge seleccionada");
        panelContingut.add(labelImatgeSeleccionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 120, 120));
        panelContingut.add(labelIdSeleccionat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        labelPathImatge.setBackground(new java.awt.Color(255, 255, 255));
        labelPathImatge.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelPathImatge.setToolTipText("Imatge del residu");
        labelPathImatge.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelPathImatge.setOpaque(true);
        panelContingut.add(labelPathImatge, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 660, 30));

        labelValorSeleccionat.setBackground(new java.awt.Color(255, 255, 255));
        labelValorSeleccionat.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelValorSeleccionat.setToolTipText("Imatge del residu");
        labelValorSeleccionat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelValorSeleccionat.setOpaque(true);
        panelContingut.add(labelValorSeleccionat, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 660, 30));

        labelTipusSeleccionat.setBackground(new java.awt.Color(255, 255, 255));
        labelTipusSeleccionat.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelTipusSeleccionat.setToolTipText("Imatge del residu");
        labelTipusSeleccionat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelTipusSeleccionat.setOpaque(true);
        panelContingut.add(labelTipusSeleccionat, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 220, 30));

        labelNomSeleccionat.setBackground(new java.awt.Color(255, 255, 255));
        labelNomSeleccionat.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelNomSeleccionat.setToolTipText("Imatge del residu");
        labelNomSeleccionat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelNomSeleccionat.setOpaque(true);
        panelContingut.add(labelNomSeleccionat, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 320, 30));

        scrollPaneDescripcio.setBackground(new java.awt.Color(255, 255, 255));
        scrollPaneDescripcio.setBorder(null);
        scrollPaneDescripcio.setFocusable(false);
        scrollPaneDescripcio.setOpaque(false);

        textAreaDescripcioSeleccionat.setEditable(false);
        textAreaDescripcioSeleccionat.setBackground(new java.awt.Color(255, 255, 255));
        textAreaDescripcioSeleccionat.setColumns(20);
        textAreaDescripcioSeleccionat.setRows(5);
        textAreaDescripcioSeleccionat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPaneDescripcio.setViewportView(textAreaDescripcioSeleccionat);

        panelContingut.add(scrollPaneDescripcio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 760, -1));

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

        buttonTornar.setBackground(new java.awt.Color(255, 204, 0));
        buttonTornar.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonTornar.setText("Llistat residus");
        buttonTornar.setToolTipText("Tornar al llistat d'usuaris");
        buttonTornar.setBorderPainted(false);
        buttonTornar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTornarActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonTornar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 150, 30));

        panelPrincipal.add(panelOpcions, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 2, 200, 746));

        labelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        labelPrincipal.setIcon(new javax.swing.ImageIcon("C:\\Users\\isard\\Downloads\\fons_general.png")); // NOI18N
        labelPrincipal.setOpaque(true);
        panelPrincipal.add(labelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 996, 746));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Mètode per carregar dades necesàries del formulari
     */
    private void carregaFormulari(){
       
        String problemes = "";
        
        // Demanem la info del residu
        JSONObject jsonResidu = Api.consultaResidu(usuari, idResidu);
        if(jsonResidu.getString("codi_error").equals("0")){
            // Tenim la info i carreguem els elements.
            labelIdSeleccionat.setVisible(false);
            labelIdSeleccionat.setText(jsonResidu.getString("id_residu"));
            labelNomSeleccionat.setText(jsonResidu.getString("nom_residu"));
            textAreaDescripcioSeleccionat.setText(jsonResidu.getString("descripcio_residu"));
            labelValorSeleccionat.setText(jsonResidu.getString("valor_residu"));
            labelTipusSeleccionat.setText(jsonResidu.getString("nom_tipus_residu"));
            labelActiuSeleccionat.setText(jsonResidu.getString("actiu_residu"));
            labelPathImatge.setText(jsonResidu.getString("imatge_residu"));
            // Carreguem la imatge
            ImageIcon imatgeResidu = Utils.carregaImatge(2,jsonResidu.getString("imatge_residu"));
            labelImatgeSeleccionada.setIcon(imatgeResidu);
        }else{
            problemes += "Hi ha problemes amb l'api de consulta de residu: " + jsonResidu.get("codi_error").toString() + " - " + jsonResidu.get("error").toString();
        }
        
        // Si hi ha problemes amb la càrrega del combo advertim i amaguem el botó.
        if(!problemes.equals("")){
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(problemes);
            pantallaAdvertencia.setVisible(true); 
            buttonBaixa.setVisible(false);
            System.out.println(problemes);
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
     * Mètode per resetejar el formulari
     */
    private void resetFormulari(){
        // Tenim la info i carreguem els elements.
            labelIdSeleccionat.setVisible(false);
            labelIdSeleccionat.setText("");
            labelNomSeleccionat.setText("");
            textAreaDescripcioSeleccionat.setText("");
            labelValorSeleccionat.setText("");
            labelTipusSeleccionat.setText("");
            labelActiuSeleccionat.setText("");
            labelPathImatge.setText("");
            // Carreguem la imatge
            labelImatgeSeleccionada.setIcon(null);
            buttonBaixa.setVisible(false);
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
     * Mètode utilitzat quan es prem el botó de donar d'alta un residu
     * @param evt ActionEvent: Pulsar el botó.
     */
    private void buttonBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBaixaActionPerformed
         
        JSONObject jsonRetorn = Api.baixaResidu(usuari, idResidu);
        if(jsonRetorn.getString("codi_error").equals("0")){
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonRetorn.get("descripcio").toString());
            pantallaAdvertencia.setVisible(true);
            resetFormulari();
        }else{
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonRetorn.get("codi_error").toString() + " - " +jsonRetorn.get("error").toString());
            pantallaAdvertencia.setVisible(true);
        }
         
    }//GEN-LAST:event_buttonBaixaActionPerformed
    
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
     * Mètode utilitzat quan es prem el botó de Tornar per tornar al llistat d'usuaris
     * @param evt (ActionEvent) : event al pulsar el botó.
     */
    private void buttonTornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTornarActionPerformed
        PantallaLlistatResidus pantallaLlistatResidus = new PantallaLlistatResidus(usuari);
        pantallaLlistatResidus.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonTornarActionPerformed
    
   
   
   
   
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
            java.util.logging.Logger.getLogger(PantallaBaixaResidu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaBaixaResidu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaBaixaResidu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaBaixaResidu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new PantallaBaixaResidu(usuari,idResidu).setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Botó per donar d'alta l'usuari
    */
    private javax.swing.JButton buttonBaixa;
    /**
    * Botó per desloginar-se i sortir de l'aplicació.
    */
    private javax.swing.JButton buttonLogOut;
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonTornar;
    /**
    * Label actiu
    */
    private javax.swing.JLabel labelActiu;
    /**
    * label actiu
    */
    private javax.swing.JLabel labelActiuSeleccionat;
    /**
    * label descripció
    */
    private javax.swing.JLabel labelDescripcio;
    /**
    * Label que conté id residu
    */
    private javax.swing.JLabel labelIdSeleccionat;
    /**
    * label imatge
    */
    private javax.swing.JLabel labelImatge;
    /**
    * Label per contenir la imatge seleccionada
    */
    private javax.swing.JLabel labelImatgeSeleccionada;
    /**
    * label nom
    */
    private javax.swing.JLabel labelNom;
    /**
    * label nom
    */
    private javax.swing.JLabel labelNomSeleccionat;
    /**
    * label imatge seleccionada path
    */
    private javax.swing.JLabel labelPathImatge;
    /**
    * Label per contenir el logo de l'aplicació.
    */
    private javax.swing.JLabel labelPrincipal;
    /**
    * Label tipus residu
    */
    private javax.swing.JLabel labelTipus;
    /**
    * label tipus
    */
    private javax.swing.JLabel labelTipusSeleccionat;
    /**
    * Label per el títol de la pantalla.
    */
    private javax.swing.JLabel labelTitol;
    /**
    * Label per tenir les dades de l'usuari loginat
    */
    private javax.swing.JLabel labelUsuari;
    /**
    * label valor
    */
    private javax.swing.JLabel labelValor;
    /**
    * label valor
    */
    private javax.swing.JLabel labelValorSeleccionat;
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
    * Scroll panel per el camp de la descripció.
    */
    private javax.swing.JScrollPane scrollPaneDescripcio;
    /**
    * textArea per la descripció
    */
    private javax.swing.JTextArea textAreaDescripcioSeleccionat;
    // End of variables declaration//GEN-END:variables
}