package view.dialog;

import db.use.Connector;
import java.time.LocalDate;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class StatisticProductDialog extends javax.swing.JDialog {

    LocalDate startDate = null;
    LocalDate endDate = null;

    private String currentDateType = "Days";
    private String currentValueType = "Turnover";

    public StatisticProductDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setDate(LocalDate start, LocalDate end) {
        startDate = start;
        endDate = end;
    }

    private String handleQuery() {
        if (startDate == null || endDate == null) {
            return "";
        }
        String dateTypeQuery = "";
        String valueTypeQuery = "";

        switch (currentDateType) {
            case "Days":
                dateTypeQuery = "SellDate";
                break;
            case "Months":
                dateTypeQuery = "MONTH(SellDate)";
                break;
            case "Years":
                dateTypeQuery = "YEAR(SelLDate)";
                break;
            default:
                dateTypeQuery = "SellDate";
        }

        switch (currentValueType) {
            case "Turnover":
                valueTypeQuery = "SUM(SD.TotalPrice)";
                break;
            case "Quantity Of Product":
                valueTypeQuery = "SUM(SD.ProductQuantity)";
                break;
            default:
                valueTypeQuery = "SUM(SD.TotalPrice)";
        }

        String query = String.format("SELECT %s AS [Time], %s AS TotalPrice FROM Sells AS S "
                + "JOIN SellDetails AS SD ON S.SellID = SD.SellID "
                + "WHERE SellDate >= '%s' AND SellDate <= '%s' "
                + "GROUP BY %s "
                + "ORDER BY %s",
                    dateTypeQuery,
                    valueTypeQuery,
                    startDate.toString(),
                    endDate.toString(),
                    dateTypeQuery,
                    dateTypeQuery
                );
        
        return query;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateTimeTypeOptions = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        valueTypeOptions = new javax.swing.JComboBox<>();
        showBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(200, 255, 242));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Menu Statistics Chart");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(90, 90, 90));
        jLabel2.setText("Date time type");

        dateTimeTypeOptions.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dateTimeTypeOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Days", "Months", "Years" }));
        dateTimeTypeOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTimeTypeOptionsActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(90, 90, 90));
        jLabel3.setText("Value type");

        valueTypeOptions.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        valueTypeOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Turnover", "Quantity Of Product" }));
        valueTypeOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueTypeOptionsActionPerformed(evt);
            }
        });

        showBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        showBtn.setText("Show Chart");
        showBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleShowChart(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateTimeTypeOptions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(valueTypeOptions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 114, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateTimeTypeOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(valueTypeOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(showBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void handleShowChart(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleShowChart
        this.dispose();
        try {
            String query = handleQuery();
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(new Connector("SalesManagement").getConnection(), query);
            JFreeChart chart = ChartFactory.createLineChart("Turnover by date", "Date", "Value", dataset, PlotOrientation.VERTICAL, false, true, true);

            BarRenderer renderer = new BarRenderer();
            CategoryPlot plot = null;
            ChartFrame chartFrame = new ChartFrame("Chart", chart);

            chartFrame.setSize(900, 600);
            chartFrame.setLocationRelativeTo(null);
            chartFrame.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_handleShowChart

    private void dateTimeTypeOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTimeTypeOptionsActionPerformed
        currentDateType = (String) dateTimeTypeOptions.getSelectedItem();

    }//GEN-LAST:event_dateTimeTypeOptionsActionPerformed

    private void valueTypeOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueTypeOptionsActionPerformed
        currentValueType = (String) valueTypeOptions.getSelectedItem();
    }//GEN-LAST:event_valueTypeOptionsActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StatisticProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatisticProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatisticProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatisticProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StatisticProductDialog dialog = new StatisticProductDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> dateTimeTypeOptions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton showBtn;
    private javax.swing.JComboBox<String> valueTypeOptions;
    // End of variables declaration//GEN-END:variables
}
