package residueix.residueixapp.usuaris;

// Imports
import residueix.residueixapp.esdeveniments.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import residueix.residueixapp.principal.PantallaAdvertencia;
import residueix.residueixapp.principal.PantallaPrincipal;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.RenderitzatsImatges;
import residueix.residueixapp.utils.RenderitzatsTaules;
import residueix.residueixapp.utils.Utils;


/**
 * Classe per obrir la pantalla de transaccions d'usuari
 * @author Daniel Garcia Ruiz
 * @version 13/05/2023
 */
public class PantallaTransaccionsUsuari extends javax.swing.JFrame {
    
    
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
     * String per contenir els missatges de problemes
     */
    private String problemes;
    /**
     * Arraylist amb totes les dades d'esdeveniments
     */
    private ArrayList<HashMap<String,Object>> transaccions;
    /**
     * Id usuari a eliminar.
     */
    private static int idUsuari;  

    /**
     * Crea una nova instància de la classe PantallaTransaccionsUsuari
     * @param usuari: Usuari loginat a l'aplicació.
     * @param idUsuariSeleccionat (int) usuari selecciona per veure les seves transaccions
     */
    public PantallaTransaccionsUsuari(Usuari usuari, int idUsuariSeleccionat) {
        // Assignació de l'usuari
        this.usuari = usuari;
        this.idUsuari = idUsuariSeleccionat;
        // Inicialització dels components
        initComponents();
        // Centrem pantalla
        centrarPantalla();
        // Accions en funcio de l'usuari
        gestioUsuari();        
        // Recuperar totes les dades necesàries per la gestió d'esdeveniments.
        recuperarDades();
        // Omplir el formulari amb les dades de llistatEsdeveniments
        omplirFormulari();
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
        scrollPaneTipusResidu = new javax.swing.JScrollPane();
        jTableTransaccions = new javax.swing.JTable();
        panelOpcions = new javax.swing.JPanel();
        buttonLlistatUsuaris = new javax.swing.JButton();
        buttonLogOut = new javax.swing.JButton();
        buttonTornarPrincipal = new javax.swing.JButton();
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
        labelTitol.setText("Transaccions de l'usuari");
        labelTitol.setToolTipText("");
        panelTitol.add(labelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 30));

        panelContingut.add(panelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 51, 800, 50));

        scrollPaneTipusResidu.setBackground(new java.awt.Color(255, 255, 255));
        scrollPaneTipusResidu.setBorder(null);
        scrollPaneTipusResidu.setOpaque(false);

        jTableTransaccions.setAutoCreateRowSorter(true);
        jTableTransaccions.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        jTableTransaccions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableTransaccions.setToolTipText("LlistatTransaccions");
        jTableTransaccions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableTransaccions.setRowHeight(28);
        jTableTransaccions.setRowMargin(5);
        jTableTransaccions.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTableTransaccions.setShowGrid(true);
        jTableTransaccions.setShowVerticalLines(false);
        scrollPaneTipusResidu.setViewportView(jTableTransaccions);

        panelContingut.add(scrollPaneTipusResidu, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 120, 700, 600));

        panelPrincipal.add(panelContingut, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 798, 746));

        panelOpcions.setBackground(new java.awt.Color(255, 255, 255));
        panelOpcions.setOpaque(false);
        panelOpcions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonLlistatUsuaris.setBackground(new java.awt.Color(255, 204, 0));
        buttonLlistatUsuaris.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonLlistatUsuaris.setText("Llistat Usuaris");
        buttonLlistatUsuaris.setToolTipText("Tornar al llistat d'usuaris");
        buttonLlistatUsuaris.setBorderPainted(false);
        buttonLlistatUsuaris.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLlistatUsuaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLlistatUsuarisActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonLlistatUsuaris, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 150, 30));

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

        buttonTornarPrincipal.setBackground(new java.awt.Color(255, 204, 0));
        buttonTornarPrincipal.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonTornarPrincipal.setText("Pantalla principal");
        buttonTornarPrincipal.setToolTipText("Tornar a la pantalla principal");
        buttonTornarPrincipal.setBorderPainted(false);
        buttonTornarPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTornarPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTornarPrincipalActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonTornarPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 150, 30));

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
     * Mètode per recuperar dades via api i ficar-les a un arraylist per poder tractar-les posteriorment.
     */
    private void recuperarDades(){
        
        transaccions = new ArrayList();
        
        
        System.out.println(idUsuari);
        // Recuperem el llistat d'esdeveniments
        JSONObject jsonTransaccions = Api.consultaTransaccions(idUsuari);
        
        if(jsonTransaccions.getString("codi_error").equals("0")){
            
            JSONArray arrayTransaccions = new JSONArray(jsonTransaccions.getJSONArray("llistat"));
            
            // Recorrem l'array per ficar-ho a l'arraylist llistatEsdeveniments
            for(int i = 0; i < arrayTransaccions.length(); i++){
                
                JSONObject jsonTransaccio = arrayTransaccions.getJSONObject(i);
               
                HashMap<String,Object> trans = new HashMap<String,Object>();
                trans.put("id", jsonTransaccio.getString("id"));
                trans.put("data", jsonTransaccio.getString("data"));
                trans.put("nomEmisor", jsonTransaccio.getString("nomEmisor"));
                trans.put("nomReceptor", jsonTransaccio.getString("nomReceptor"));
                trans.put("total", jsonTransaccio.getString("total"));
                trans.put("tipus", jsonTransaccio.getString("tipus"));
                transaccions.add(trans);
                
            }
            
        }else{
            // Hi ha un error posem a null la variable i creem problemes.s
            this.problemes += " - " + jsonTransaccions.getString("error") + " ";
        }
        
    }
    
    /**
     * Mètode per omplir la taula amb les dades dels usuaris.
     */
    private void omplirFormulari(){
        
        // Afegim el model a la taula
        DefaultTableModel model = new DefaultTableModel(){
             @Override 
             public boolean isCellEditable(int row, int column){
                 return false;
             }
        };
        model.addColumn("Id");
        model.addColumn("Data");
        model.addColumn("Emisor");
        model.addColumn("Receptor");
        model.addColumn("Total");
        model.addColumn("Tipus");
        jTableTransaccions.setRowSelectionAllowed(true);
        jTableTransaccions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableTransaccions.setModel(model);
        jTableTransaccions.setRowHeight(80);
        jTableTransaccions.getTableHeader().setBackground(new Color(51,102,255));
        jTableTransaccions.getTableHeader().setForeground(new Color(255,255,255));
        jTableTransaccions.getColumnModel().getColumn(0).setCellRenderer(RenderitzatsTaules.centrat());
        jTableTransaccions.getColumnModel().getColumn(0).setMaxWidth(50);
        jTableTransaccions.getColumnModel().getColumn(0).setMinWidth(50);
        jTableTransaccions.getColumnModel().getColumn(4).setMaxWidth(70);
        jTableTransaccions.getColumnModel().getColumn(4).setMinWidth(70);
        jTableTransaccions.getColumnModel().getColumn(5).setMaxWidth(70);
        jTableTransaccions.getColumnModel().getColumn(5).setMinWidth(70);
        
        // Omplim la taula amb les dades
        if(transaccions != null){
            
           for(int i = 0; i < transaccions.size(); i++){
                HashMap<String,Object> element = transaccions.get(i);
                
                model.addRow( new Object[]{
                                element.get("id"),
                                element.get("data"),
                                element.get("nomEmisor"),  
                                element.get("nomReceptor"),  
                                element.get("total"),  
                                element.get("tipus")
                });
                       
            }
            
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
    private void buttonLlistatUsuarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLlistatUsuarisActionPerformed
        // Obre la pantalla principal
        PantallaLlistatUsuaris PantallaLlistatUsuaris = new PantallaLlistatUsuaris(usuari);
        PantallaLlistatUsuaris.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonLlistatUsuarisActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de logout per tancar la sessió.
     * @param evt ActionEvent: Pulsar el botó.
     */
    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogOutActionPerformed
        // Fem el logout
        Api.logout(usuari);
        System.exit( 0);
    }//GEN-LAST:event_buttonLogOutActionPerformed

    private void buttonTornarPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTornarPrincipalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonTornarPrincipalActionPerformed

   
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
            java.util.logging.Logger.getLogger(PantallaTransaccionsUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaTransaccionsUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaTransaccionsUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaTransaccionsUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new PantallaTransaccionsUsuari(usuari,idUsuari).setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonLlistatUsuaris;
    /**
    * Botó per desloginar-se i sortir de l'aplicació.
    */
    private javax.swing.JButton buttonLogOut;
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonTornarPrincipal;
    /**
    * Taula per contenir els esdeveniments
    */
    private javax.swing.JTable jTableTransaccions;
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
    * Scroll pane per contenir el jtable
    */
    private javax.swing.JScrollPane scrollPaneTipusResidu;
    // End of variables declaration//GEN-END:variables
}