package residueix.residueixapp.residus;

import residueix.residueixapp.principal.PantallaPrincipal;
import residueix.residueixapp.principal.PantallaAdvertencia;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.JSONObject;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.Utils;
import residueix.residueixapp.utils.SelectorImatge;

/**
 * Classe per obrir la pantalla per donar d'alta un tipus de residu
 * @author Daniel Garcia Ruiz
 * @version 24/03/2023
 */
public class PantallaModificarTipusResidu extends javax.swing.JFrame { 
    
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
     * Tipus de residu id
     */
    private static int idTipusResidu;    
    
    /**
     * Crea una nova instància de la classe PantallaPrincipal.
     * @param usuari (Usuari) loginat a l'aplicació.
     * @param idTipusResidu (int) id tipus residu
     */
    public PantallaModificarTipusResidu(Usuari usuari, int idTipusResidu) {
        // Assignació de l'usuari i el tipus de residu
        this.usuari = usuari;
        this.idTipusResidu = idTipusResidu;
        this.imatge = null;
        // Inicialització dels components
        initComponents();
        // Centrem pantalla
        centrarPantalla();
        // Accions en funcio de l'usuari
        gestioUsuari();
        // Accions per carregar la info del tipus de producte
        carregarFormulari();        
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
        labelPathImatge = new javax.swing.JLabel();
        buttonSeleccionarImatge = new javax.swing.JButton();
        buttonModificacio = new javax.swing.JButton();
        labelImatge = new javax.swing.JLabel();
        labelNom = new javax.swing.JLabel();
        textFieldNom = new javax.swing.JTextField();
        labelImatgeSeleccionada = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();
        panelOpcions = new javax.swing.JPanel();
        buttonLogOut = new javax.swing.JButton();
        buttonTornarLlistatResisdus = new javax.swing.JButton();
        buttonTornarPantallaPrincipal = new javax.swing.JButton();
        buttonTornarLlistatTipusResidus = new javax.swing.JButton();
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
        labelTitol.setText("Modificació tipus residu");
        labelTitol.setToolTipText("Modificació tipus residu");
        panelTitol.add(labelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 30));

        panelContingut.add(panelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 51, 800, 50));

        labelPathImatge.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelPathImatge.setToolTipText("Imatge del residu");
        panelContingut.add(labelPathImatge, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 450, 30));

        buttonSeleccionarImatge.setBackground(new java.awt.Color(51, 102, 255));
        buttonSeleccionarImatge.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonSeleccionarImatge.setForeground(new java.awt.Color(255, 255, 255));
        buttonSeleccionarImatge.setText("Seleccionar...");
        buttonSeleccionarImatge.setToolTipText("Seleccionar imatge");
        buttonSeleccionarImatge.setBorderPainted(false);
        buttonSeleccionarImatge.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonSeleccionarImatge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSeleccionarImatgeActionPerformed(evt);
            }
        });
        panelContingut.add(buttonSeleccionarImatge, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 150, 30));

        buttonModificacio.setBackground(new java.awt.Color(51, 204, 0));
        buttonModificacio.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonModificacio.setForeground(new java.awt.Color(255, 255, 255));
        buttonModificacio.setText("Modificar");
        buttonModificacio.setToolTipText("Modificar tipus residu");
        buttonModificacio.setBorderPainted(false);
        buttonModificacio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonModificacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificacioActionPerformed(evt);
            }
        });
        panelContingut.add(buttonModificacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 690, 150, 30));

        labelImatge.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelImatge.setText("Imatge");
        labelImatge.setToolTipText("Imatge del residu");
        panelContingut.add(labelImatge, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 100, 30));

        labelNom.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelNom.setText("Nom");
        labelNom.setToolTipText("Nom del residu");
        panelContingut.add(labelNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 100, 30));

        textFieldNom.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldNom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldNom.setToolTipText("Email");
        textFieldNom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContingut.add(textFieldNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 620, 30));

        labelImatgeSeleccionada.setToolTipText("Imatge seleccionada");
        panelContingut.add(labelImatgeSeleccionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 150, 140));
        panelContingut.add(labelId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

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

        buttonTornarLlistatResisdus.setBackground(new java.awt.Color(255, 204, 0));
        buttonTornarLlistatResisdus.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonTornarLlistatResisdus.setText("Llistat residus");
        buttonTornarLlistatResisdus.setToolTipText("Tornar al llistat de residus");
        buttonTornarLlistatResisdus.setBorderPainted(false);
        buttonTornarLlistatResisdus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTornarLlistatResisdus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTornarLlistatResisdusActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonTornarLlistatResisdus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 150, 30));

        buttonTornarPantallaPrincipal.setBackground(new java.awt.Color(255, 204, 0));
        buttonTornarPantallaPrincipal.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonTornarPantallaPrincipal.setText("Pantalla principal");
        buttonTornarPantallaPrincipal.setToolTipText("Tornar pantalla principal");
        buttonTornarPantallaPrincipal.setBorderPainted(false);
        buttonTornarPantallaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTornarPantallaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTornarPantallaPrincipalActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonTornarPantallaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 150, 30));

        buttonTornarLlistatTipusResidus.setBackground(new java.awt.Color(255, 204, 0));
        buttonTornarLlistatTipusResidus.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonTornarLlistatTipusResidus.setText("Ll. tipus residu");
        buttonTornarLlistatTipusResidus.setToolTipText("Tornar al llistat de tipus de residu");
        buttonTornarLlistatTipusResidus.setBorderPainted(false);
        buttonTornarLlistatTipusResidus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTornarLlistatTipusResidus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTornarLlistatTipusResidusActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonTornarLlistatTipusResidus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 150, 30));

        panelPrincipal.add(panelOpcions, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 2, 200, 746));

        labelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        labelPrincipal.setIcon(new javax.swing.ImageIcon("C:\\Users\\isard\\Downloads\\fons_general.png")); // NOI18N
        labelPrincipal.setOpaque(true);
        panelPrincipal.add(labelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 996, 746));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Mètode per carregar les dades del formulari
     */
    private void carregarFormulari(){
        
        // Fem la petició a  l'api per les dades del tipus de residu.
        JSONObject tipusResidu = Api.consultaTipusResidu(usuari,idTipusResidu);
        
        // Comprovem si el retornat es correcte 
        if(tipusResidu.getString("codi_error").equals("0")){
            // Omplim les dades dels elements del formulari amb la informació del json
            labelId.setVisible(false);
            labelId.setText(String.valueOf(idTipusResidu));
            textFieldNom.setText(tipusResidu.getString("nom"));
            labelPathImatge.setText(tipusResidu.getString("imatge"));
            // Carreguem la imatge
            ImageIcon imatgeTipusResidu = Utils.carregaImatge(1,tipusResidu.getString("imatge"));
            labelImatgeSeleccionada.setIcon(imatgeTipusResidu);
             
        }else{
            // Missatge d'error.
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia("Error: " + tipusResidu.getString("codi_erro") + " - " + tipusResidu.getString("error"));
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
        // Guardem x i y del ratolí
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    /**
     * Mètode executat quan movem el mouse amb el formulari pulsat. 
     * @param evt MouseEvent: event quan arroseguem amb el ratolí.
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // Asignem la nova posició a la finestra
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_formMouseDragged

    /**
     * Mètode utilitzat quan es prem el botó de donar d'alta un residu
     * @param evt ActionEvent: Pulsar el botó.
     */
    private void buttonModificacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificacioActionPerformed
         
        // Variables de control
        boolean enviament = true;
        String missatge = "Error: - ";
        
        // Comprovem les dades del nom
        if(!Utils.validarText(textFieldNom.getText(),3,255)){
            enviament = false;
            missatge += "El nom ha de tenir com a mínim 3 i com a màxim 255 caràcters.";
        }
        
        // Comprovem la imatge
        if(!Utils.validarText(labelPathImatge.getText(),8,255)){
            if(imatge != null){
                if(!imatge.isFile()){
                    enviament = false;
                    missatge += "No hi ha una imatge vàlida seleccionada.";
                }
            }
        }
         
        // Si no hi ha problemes enviem, si no mostrem errors
        if(enviament){
            // Fem la petició a l'api per modificar el tipus de residu
            JSONObject jsonModificacioTipusResidu = Api.modificacioTipuResidu(usuari, labelId.getText(), textFieldNom.getText(), imatge);
            
            if(jsonModificacioTipusResidu.getString("codi_error").equals("0")){
                // Missatge ok
                PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonModificacioTipusResidu.getString("descripcio"));
                pantallaAdvertencia.setVisible(true);                
            }else{
                // Missatge error
                PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia("Error: " + jsonModificacioTipusResidu.getString("codi_error") + " - " + jsonModificacioTipusResidu.getString("error") );
                pantallaAdvertencia.setVisible(true);                
            }
        }else{
            // Missatge error
             PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(missatge);
             pantallaAdvertencia.setVisible(true);
         }
         
    }//GEN-LAST:event_buttonModificacioActionPerformed
    
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
     * Mètode utilitzat quan es prem el botó de Tornar a la pantalla principal
     * @param evt (ActionEvent) : event al pulsar el botó.
     */
    private void buttonTornarPantallaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTornarPantallaPrincipalActionPerformed
        // Obrir pantalla principal
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(usuari);
        pantallaPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonTornarPantallaPrincipalActionPerformed
   
    /** 
     * Mètode utilitzar quan es vol seleccionar una imatge
     * @param evt (ActionEvent) Pulsar botó.
     */
    private void buttonSeleccionarImatgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSeleccionarImatgeActionPerformed
        
        // Per controlar el resultat
        int resultat;
        
        // Iniciem el selector d'imatges
        SelectorImatge selector =  new SelectorImatge();
        
        // Determinem les extensions permitides
        FileNameExtensionFilter format = new FileNameExtensionFilter("JPG,PNG y GIF", "jpg","png","gif");
        
        // Asignem el format al selector
        selector.selectorImatge.setFileFilter(format);
        
        // Obrim el selector i recuperem el resultat
        resultat = selector.selectorImatge.showOpenDialog(null);
        
        // Comprovem el resultat
        if(JFileChooser.APPROVE_OPTION == resultat){
            
            // Triem la imatge que s'ha seleccionat i la guardem en l'atribut imatge.
            imatge = selector.selectorImatge.getSelectedFile();
            
            // Posem la ruta en el label.
            labelPathImatge.setText(imatge.getAbsolutePath());
            
            // Posem la imatge en el label
            try{
                ImageIcon imatgeSeleccionada = new ImageIcon(imatge.toString());
                Icon icona = new ImageIcon(imatgeSeleccionada.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
                labelImatgeSeleccionada.setIcon(icona);
            } catch (Exception ex){
                PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia("Error: " + ex.getMessage());
                pantallaAdvertencia.setVisible(true);
            }
           
        }
        
    }//GEN-LAST:event_buttonSeleccionarImatgeActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de tornar al llistat de residus
     * @param evt (ActionEvent) : pulsar el botó.
     */
    private void buttonTornarLlistatResisdusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTornarLlistatResisdusActionPerformed
        // Obrir pantalla llistat residus
        PantallaLlistatResidus pantallaLlistatResidus = new PantallaLlistatResidus(usuari);
        pantallaLlistatResidus.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonTornarLlistatResisdusActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de tornar al llistat de tipus de residus
     * @param evt (ActionEvent) : pulsar el botó.
     */
    private void buttonTornarLlistatTipusResidusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTornarLlistatTipusResidusActionPerformed
        // Obrir pantalla llistat tipus residu
        PantallaLlistatTipusResidus pantallaLlistatTipusResidus = new PantallaLlistatTipusResidus(usuari);
        pantallaLlistatTipusResidus.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonTornarLlistatTipusResidusActionPerformed
  
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
            java.util.logging.Logger.getLogger(PantallaModificarTipusResidu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaModificarTipusResidu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaModificarTipusResidu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaModificarTipusResidu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new PantallaModificarTipusResidu(usuari,idTipusResidu).setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Botó per desloginar-se i sortir de l'aplicació.
    */
    private javax.swing.JButton buttonLogOut;
    /**
    * Botó per donar d'alta l'usuari
    */
    private javax.swing.JButton buttonModificacio;
    /**
    * Botó per seleccionar imatge
    */
    private javax.swing.JButton buttonSeleccionarImatge;
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonTornarLlistatResisdus;
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonTornarLlistatTipusResidus;
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonTornarPantallaPrincipal;
    /**
    * Label ocult amb l'id del tipus de residu.
    */
    private javax.swing.JLabel labelId;
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
    * label imatge seleccionada path
    */
    private javax.swing.JLabel labelPathImatge;
    /**
    * Label per contenir el logo de l'aplicació.
    */
    private javax.swing.JLabel labelPrincipal;
    /**
    * Label per el títol de la pantalla.
    */
    private javax.swing.JLabel labelTitol;
    /**
    * Label per tenir les dades de l'usuari loginat
    */
    private javax.swing.JLabel labelUsuari;
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
    * Text Field nom residu
    */
    private javax.swing.JTextField textFieldNom;
    // End of variables declaration//GEN-END:variables
}