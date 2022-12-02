package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


import javax.swing.JPanel;

public class StartView extends javax.swing.JFrame {

    private String currentContent = "";

    private final String SELL = "SELL";
    private final String IMPORT = "IMPORT";


    private SellView sell = null;
    private ImportView imports = null;


    private final String STATISTIC_PRODUCT = "STATISTIC_PRODUCT";
    
    
    private StatisticProductsView statisticProducts = null;
    

    public StartView() {
        this.setTitle("Thanh Tao Store Management");
        initComponents();
        settingIcon();
        this.setLocationRelativeTo(null);
        Creeping();
    }
    
    private  void Creeping(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                 String txt = lblName.getText() + " ";
                 while (true) {                    
                    txt = txt.substring(1,txt.length()) + txt.charAt(0);
                     try {
                         sleep(150);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(StartView.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                     lblName.setText(txt);
                }
            }
            
        };
        thread.start();
        
    }
    
    private void settingIcon() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/main-icon.png")));
    }

    private void setActiveButton(String buttonContent) {
        switch (currentContent) {
            case SELL -> sellBtn.setForeground(Color.BLACK);
            case IMPORT -> importBtn.setForeground(Color.BLACK);
            case STATISTIC_PRODUCT -> statisticsProductBtn.setForeground(Color.BLACK);
            default -> {
            }
        }
        switch (buttonContent) {
            case SELL -> sellBtn.setForeground(Color.decode("#0075FF"));
            case IMPORT -> importBtn.setForeground(Color.decode("#0075FF"));
            case STATISTIC_PRODUCT -> statisticsProductBtn.setForeground(Color.decode("#0075FF"));
            default -> {
            }
        }
        currentContent = buttonContent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sidebar = new javax.swing.JPanel();
        customerbtn = new javax.swing.JButton();
        viewbtn = new javax.swing.JButton();
        statisticsProductBtn = new javax.swing.JButton();
        apllybtn = new javax.swing.JButton();
        searchbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sellBtn = new javax.swing.JButton();
        voucherbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        prodyctbtn = new javax.swing.JButton();
        spendbtn = new javax.swing.JButton();
        importBtn = new javax.swing.JButton();
        JPMain = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        sidebar.setPreferredSize(new java.awt.Dimension(234, 658));

        customerbtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        customerbtn.setText("Suppliers");

        viewbtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        viewbtn.setText("History");

        statisticsProductBtn.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        statisticsProductBtn.setText("Products/ Category");
        statisticsProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticsProductBtnActionPerformed(evt);
            }
        });

        apllybtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        apllybtn.setText("Customer");

        searchbtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        searchbtn.setText("Search");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setText("About");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel3.setText("Statistics");

        sellBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sellBtn.setText("Sell");
        sellBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleSellContent(evt);
            }
        });

        voucherbtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        voucherbtn.setText("Spending");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel1.setText("Function");

        prodyctbtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        prodyctbtn.setText("Best/ Worst products");

        spendbtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        spendbtn.setText("Vouchers");

        importBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        importBtn.setText("Import");
        importBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleImportContent(evt);
            }
        });

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sidebarLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(prodyctbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(viewbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(voucherbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(importBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sellBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(apllybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(statisticsProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spendbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sellBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(importBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(apllybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(prodyctbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(voucherbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(statisticsProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(spendbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(customerbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(sidebar);

        JPMain.setPreferredSize(new java.awt.Dimension(727, 656));
        JPMain.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel5.setText("                               Thanh Tao Store");
        jLabel5.setPreferredSize(new java.awt.Dimension(20, 100));
        JPMain.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ban-hang.jpg"))); // NOI18N
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel4.setPreferredSize(new java.awt.Dimension(700, 500));
        JPMain.add(jLabel4, java.awt.BorderLayout.CENTER);

        lblName.setFont(new java.awt.Font("Tw Cen MT", 0, 30)); // NOI18N
        lblName.setForeground(new java.awt.Color(0, 204, 204));
        lblName.setText("                               Come to Thanh Tao store, buy so more");
        lblName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblName.setPreferredSize(new java.awt.Dimension(38, 90));
        JPMain.add(lblName, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JPMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void handleSellContent(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleSellContent
        setActiveButton(SELL);
        sell = new SellView();
        JPMain.removeAll();
        JPMain.add(sell);
        JPMain.validate();
    }//GEN-LAST:event_handleSellContent

    private void handleImportContent(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleImportContent
        setActiveButton(IMPORT);
        imports = new ImportView();
        JPMain.removeAll();
        JPMain.add(imports);
        JPMain.validate();
    }//GEN-LAST:event_handleImportContent

    private void statisticsProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticsProductBtnActionPerformed
        setActiveButton(STATISTIC_PRODUCT);
        statisticProducts = new StatisticProductsView();
        JPMain.removeAll();
        JPMain.add(statisticProducts);
        JPMain.validate();
    }//GEN-LAST:event_statisticsProductBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Linux".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            @Override
            public void run() {
                new StartView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPMain;
    private javax.swing.JButton apllybtn;
    private javax.swing.JButton customerbtn;
    private javax.swing.JButton importBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblName;
    private javax.swing.JButton prodyctbtn;
    private javax.swing.JButton searchbtn;
    private javax.swing.JButton sellBtn;
    private javax.swing.JPanel sidebar;
    private javax.swing.JButton spendbtn;
    private javax.swing.JButton statisticsProductBtn;
    private javax.swing.JButton viewbtn;
    private javax.swing.JButton voucherbtn;
    // End of variables declaration//GEN-END:variables

    
}
