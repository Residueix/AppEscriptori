package residueix.residueixapp.residus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import residueix.residueixapp.principal.PantallaAdvertencia;
import residueix.residueixapp.usuaris.PantallaBaixaUsuari;
import residueix.residueixapp.usuaris.PantallaModificarUsuari;
import residueix.residueixapp.principal.PantallaPrincipal;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.RenderitzatsImatges;
import residueix.residueixapp.utils.RenderitzatsTaules;
import residueix.residueixapp.utils.Utils;

/**
 * Classe per obrir la pantalla principal de l'aplicació.
 * @author Daniel Garcia Ruiz
 * @version 24/03/2023
 */
public class PantallaLlistatResidus extends javax.swing.JFrame {
    
    
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
     * Crea una nova instància de la classe PantallaPrincipal.
     * @param usuari: Usuari loginat a l'aplicació.
     */
    public PantallaLlistatResidus(Usuari usuari) {
        // Assignació de l'usuari
        this.usuari = usuari;
        // Inicialització dels components
        initComponents();
        // Centrem pantalla
        centrarPantalla();
        // Accions en funcio de l'usuari
        gestioUsuari();        
        // omplir taula
        omplirTaula();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResidus = new javax.swing.JTable();
        panelOpcions = new javax.swing.JPanel();
        buttonLlistatTipusResidus = new javax.swing.JButton();
        buttonTornar = new javax.swing.JButton();
        buttonAlta = new javax.swing.JButton();
        buttonLogOut = new javax.swing.JButton();
        buttonModificacio = new javax.swing.JButton();
        buttonBaixa = new javax.swing.JButton();
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
        labelTitol.setText("Llistat residus");
        labelTitol.setToolTipText("");
        panelTitol.add(labelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 30));

        panelContingut.add(panelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 51, 800, 50));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        jTableResidus.setAutoCreateRowSorter(true);
        jTableResidus.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        jTableResidus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Tipus", "Nom", "Valor", "Actiu", "Imatge"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableResidus.setToolTipText("Llistat d'usuaris");
        jTableResidus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableResidus.setRowHeight(28);
        jTableResidus.setRowMargin(5);
        jTableResidus.setShowGrid(true);
        jTableResidus.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTableResidus);

        panelContingut.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 250, 700, 470));

        panelPrincipal.add(panelContingut, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 798, 746));

        panelOpcions.setBackground(new java.awt.Color(255, 255, 255));
        panelOpcions.setOpaque(false);
        panelOpcions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonLlistatTipusResidus.setBackground(new java.awt.Color(51, 102, 255));
        buttonLlistatTipusResidus.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonLlistatTipusResidus.setForeground(new java.awt.Color(255, 255, 255));
        buttonLlistatTipusResidus.setText("Ll. Tipus Residus");
        buttonLlistatTipusResidus.setToolTipText("Llistat tipus residus");
        buttonLlistatTipusResidus.setBorderPainted(false);
        buttonLlistatTipusResidus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLlistatTipusResidus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLlistatTipusResidusActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonLlistatTipusResidus, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 150, 150, 30));

        buttonTornar.setBackground(new java.awt.Color(255, 204, 0));
        buttonTornar.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonTornar.setText("Pantalla principal");
        buttonTornar.setToolTipText("Tornar a la pantalla principal");
        buttonTornar.setBorderPainted(false);
        buttonTornar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTornarActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonTornar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 150, 30));

        buttonAlta.setBackground(new java.awt.Color(51, 102, 255));
        buttonAlta.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonAlta.setForeground(new java.awt.Color(255, 255, 255));
        buttonAlta.setText("Alta");
        buttonAlta.setToolTipText("Alta residu");
        buttonAlta.setBorderPainted(false);
        buttonAlta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAltaActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, 150, 30));

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

        buttonModificacio.setBackground(new java.awt.Color(51, 102, 255));
        buttonModificacio.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonModificacio.setForeground(new java.awt.Color(255, 255, 255));
        buttonModificacio.setText("Modificar");
        buttonModificacio.setToolTipText("Modificació residu");
        buttonModificacio.setBorderPainted(false);
        buttonModificacio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonModificacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificacioActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonModificacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 70, 150, 30));

        buttonBaixa.setBackground(new java.awt.Color(51, 102, 255));
        buttonBaixa.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonBaixa.setForeground(new java.awt.Color(255, 255, 255));
        buttonBaixa.setText("Baixa");
        buttonBaixa.setToolTipText("Baixa residu");
        buttonBaixa.setBorderPainted(false);
        buttonBaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBaixaActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonBaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 110, 150, 30));

        panelPrincipal.add(panelOpcions, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 2, 200, 746));

        labelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        labelPrincipal.setIcon(new javax.swing.ImageIcon("C:\\Users\\isard\\Downloads\\fons_general.png")); // NOI18N
        labelPrincipal.setOpaque(true);
        panelPrincipal.add(labelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 996, 746));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
     * Mètode per omplir la taula amb les dades dels usuaris.
     * @param llistatUsuaris (JSONArray) json amb el llistat d'usuaris.
     */
    private void omplirTaula(){
        
        // Petició a l'Api llistat residus
        JSONObject jsonResidus = (JSONObject) Api.llistatResidus(usuari);
        
        // Afegim el model a la taula
        DefaultTableModel model = new DefaultTableModel(){
             @Override 
             public boolean isCellEditable(int row, int column){
                 return false;
             }
        };
        model.addColumn("Id");
        model.addColumn("Tipus");
        model.addColumn("Nom");
        model.addColumn("valor");
        model.addColumn("actiu");
        model.addColumn("Imatge");
        
        // Donem estils a les columnes
        jTableResidus.setRowSelectionAllowed(true);
        jTableResidus.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableResidus.setModel(model);
        jTableResidus.setRowHeight(80);
        jTableResidus.getTableHeader().setPreferredSize(new java.awt.Dimension(40,40));
        jTableResidus.getTableHeader().setBackground(new Color(51,102,255));
        jTableResidus.getTableHeader().setForeground(new Color(255,255,255));
        jTableResidus.getColumnModel().getColumn(0).setCellRenderer(RenderitzatsTaules.centrat());
        jTableResidus.getColumnModel().getColumn(0).setMaxWidth(50);
        jTableResidus.getColumnModel().getColumn(0).setMinWidth(50);
        jTableResidus.getColumnModel().getColumn(1).setCellRenderer(RenderitzatsTaules.centrat());
        jTableResidus.getColumnModel().getColumn(2).setCellRenderer(RenderitzatsTaules.centrat());
        jTableResidus.getColumnModel().getColumn(3).setCellRenderer(RenderitzatsTaules.centrat());
        jTableResidus.getColumnModel().getColumn(3).setMaxWidth(80);
        jTableResidus.getColumnModel().getColumn(3).setMinWidth(80);
        jTableResidus.getColumnModel().getColumn(4).setCellRenderer(RenderitzatsTaules.centrat());
        jTableResidus.getColumnModel().getColumn(4).setMaxWidth(50);
        jTableResidus.getColumnModel().getColumn(4).setMinWidth(50);
        jTableResidus.getColumnModel().getColumn(5).setCellRenderer(new RenderitzatsImatges());
        jTableResidus.getColumnModel().getColumn(5).setMinWidth(150);
        jTableResidus.getColumnModel().getColumn(5).setMaxWidth(150);
        
        
        // Comprovem la resposta de l'api i omplim la taula amb les dades
        if(jsonResidus.get("codi_error").toString().equals("0")) {
            // Agafem les dades del camp llistat
            JSONArray arrayLlistatResidus = new JSONArray(jsonResidus.getJSONArray("llistat"));
            // Recorrem l'array per ficar-ho a la taula
            for(int i = 0; i < arrayLlistatResidus.length(); i++){
                JSONObject jsonResidu = arrayLlistatResidus.getJSONObject(i);
                model.addRow( new Object[]{
                    jsonResidu.get("id_residu").toString(),
                    jsonResidu.get("nom_tipus_residu").toString(),
                    jsonResidu.get("nom_residu").toString(),
                    jsonResidu.get("valor_residu").toString(),
                    jsonResidu.get("actiu_residu").toString(),
                    RenderitzatsTaules.cellaImatge(jsonResidu.getString("imatge_residu"),2)
                });
            }
        }else{
            // Missatge error
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonResidus.get("codi_error").toString() + " - " + jsonResidus.get("error").toString());
            pantallaAdvertencia.setVisible(true);
        }
    }
    
    /**
     * Mètode per capturar la x i y del mouse quan el deixem pulsat sobre el frame principal.
     * @param evt MouseEvent: event de deixar pulsat el botó del ratolí.
     */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // Assignem Coordenades del ratolí
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    /**
     * Mètode executat quan movem el mouse amb el formulari pulsat. 
     * @param evt MouseEvent: event quan arroseguem amb el ratolí.
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // Capturem  x i y i assignem la nova localització
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_formMouseDragged

    /**
     * Mètode utilitzat quan es prem el botó de tornar a la pantalla principal.
     * @param evt ActionEvent: Pulsar el botó.
     */
    private void buttonTornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTornarActionPerformed
        // Obrir pantalla principal 
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(usuari);
         pantallaPrincipal.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_buttonTornarActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de logout per tancar la sessió.
     * @param evt ActionEvent: Pulsar el botó.
     */
    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogOutActionPerformed
        // Fem el logout
        Api.logout(usuari);
        System.exit( 0);
    }//GEN-LAST:event_buttonLogOutActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó d'alta residu.
     * @param evt ActionEvent: Pulsar el botó.
     */
    private void buttonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAltaActionPerformed
        // Obrir alta residu
        PantallaAltaResidu pantallaAltaResidu = new PantallaAltaResidu(usuari);
        pantallaAltaResidu.setVisible(true);
        this.dispose();
                
    }//GEN-LAST:event_buttonAltaActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó baixa residu
     * @param evt  (ActionEvent) : Pulsar el botó.
     */
    private void buttonBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBaixaActionPerformed
        // Mirem si tenim seleccionat fila del llistat 
        int filaSeleccionada = jTableResidus.getSelectedRow();
        if(filaSeleccionada != -1){
            // Agafem el seleccionat
            int idResidu = Integer.parseInt(jTableResidus.getModel().getValueAt(filaSeleccionada, 0).toString());
            // Obrir pantalla baixa residu
            PantallaBaixaResidu pantallaBaixaResidu = new PantallaBaixaResidu(usuari,idResidu);
            pantallaBaixaResidu.setVisible(true);
            this.dispose();
        }else{
            // Missatge error
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia("Has de seleccionar una fila de la taula de residus.");
            pantallaAdvertencia.setVisible(true);
        }
        
    }//GEN-LAST:event_buttonBaixaActionPerformed

    /**
     * Métode utilitzat quan es prem el botó de modificar residu.
     * @param evt (ActionEvent) : pulsar el botó.
     */
    private void buttonModificacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificacioActionPerformed
        // Mirem si tenim seleccionat fila del llistat 
        int filaSeleccionada = jTableResidus.getSelectedRow();
        if(filaSeleccionada != -1){
            int idUsuari = Integer.parseInt(jTableResidus.getModel().getValueAt(filaSeleccionada, 0).toString());
           // Obrir pantalla modificacio residu
            PantallaModificarResidu pantallaModificarResidu = new PantallaModificarResidu(usuari,idUsuari);
            pantallaModificarResidu.setVisible(true);
            this.dispose();
        }else{
            // Missatge error
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(Utils.error(8));
            pantallaAdvertencia.setVisible(true);
        }
    }//GEN-LAST:event_buttonModificacioActionPerformed

    /**
     * Mètode utilitzar quan es prem el botó de llistat de tipus de residus
     * @param evt (ActionEvent) : pulsar el botó.
     */
    private void buttonLlistatTipusResidusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLlistatTipusResidusActionPerformed
        // Obrir pantalla llistat tipus residu
        PantallaLlistatTipusResidus pantallaLlistatTipusResidus = new PantallaLlistatTipusResidus(usuari);
        pantallaLlistatTipusResidus.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonLlistatTipusResidusActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaLlistatResidus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaLlistatResidus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaLlistatResidus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaLlistatResidus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new PantallaLlistatResidus(usuari).setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Botó per donar d'alta un usuari
    */
    private javax.swing.JButton buttonAlta;
    /**
    * Botó per donar de baixa un usuari.
    */
    private javax.swing.JButton buttonBaixa;
    /**
    * Botó per donar de baixa un usuari.
    */
    private javax.swing.JButton buttonLlistatTipusResidus;
    /**
    * Botó per desloginar-se i sortir de l'aplicació.
    */
    private javax.swing.JButton buttonLogOut;
    /**
    * Botó per modificar un usuari.
    */
    private javax.swing.JButton buttonModificacio;
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonTornar;
    /**
    * Scroll pane per contenir el jtable
    */
    private javax.swing.JScrollPane jScrollPane1;
    /**
    * Taula per contenir als usuaris
    */
    private javax.swing.JTable jTableResidus;
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
    // End of variables declaration//GEN-END:variables
}