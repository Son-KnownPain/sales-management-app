package view;

import controller.StatisticsProductController;
import db.use.Connector;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import supports.Convert;
import supports.MoneyFormat;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class StatisticProductsView extends javax.swing.JPanel {
    private boolean isCustom = false;
    
    private LocalDate startDate = null;
    private LocalDate endDate = null;

    private String currentType = "BEST";
    private String time = "All Time";
    
    private ArrayList<Integer> listProductID = new ArrayList<>();

    public StatisticProductsView() {
        initComponents();
        renderTable();
        handleDate(time);
        handleSelectRow();
    }
    
    private void handleDate(String time) {
        LocalDate now = LocalDate.now();
        LocalDate oneWeekAgo = now.minusDays(6);
        LocalDate oneMonthAgo = now.minusDays(29);
        switch (time) {
            case "All Time":
                startDate = now.minusDays(99999);
                endDate = now;
                break;
            case "Today":
                startDate = now;
                endDate = now;
                break;
            case "7 Days Ago":
                startDate = oneWeekAgo;
                endDate = now;
                break;
            case "30 Days Ago":
                startDate = oneMonthAgo;
                endDate = now;
                break;
            default:
        }
    }

    private void renderTable() {
        listProductID.clear();
        DefaultTableModel tableModel = (DefaultTableModel) productsTable.getModel();
        tableModel.setRowCount(0);
        ArrayList<String[]> data = StatisticsProductController.getStatisticProduct(currentType, time);
        for (String[] rowData : data) {
            listProductID.add(Integer.parseInt(rowData[4]));
            rowData[1] = MoneyFormat.getMoneyFormat(rowData[1]);
            rowData[2] = MoneyFormat.getMoneyFormat(rowData[2]);
            tableModel.addRow(rowData);
        }
    }

    private void renderTable(LocalDate startTime, LocalDate endTime) {
        listProductID.clear();
        DefaultTableModel tableModel = (DefaultTableModel) productsTable.getModel();
        tableModel.setRowCount(0);
        ArrayList<String[]> data = StatisticsProductController.customDateStatistics(currentType, startTime, endTime);
        for (String[] rowData : data) {
            listProductID.add(Integer.parseInt(rowData[4]));
            rowData[1] = MoneyFormat.getMoneyFormat(rowData[1]);
            rowData[2] = MoneyFormat.getMoneyFormat(rowData[2]);
            tableModel.addRow(rowData);
        }
    }

    private void handleSelectRow() {
        ListSelectionModel listSelectionModel = productsTable.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int index = listSelectionModel.getMinSelectionIndex();
                    if (index != -1) {
                        displayInfo(index);
                    }
                }
            }
        });
    }
    
    private void displayInfo(int index) {
        String[] customersInfo = StatisticsProductController.getBestCustomer(listProductID.get(index), startDate, endDate);
        String priceForOne = StatisticsProductController.getPriceForOne(listProductID.get(index));
        
        bestCustomerDisplay.setText(customersInfo[0] + " - " + customersInfo[1] + ", bought " + customersInfo[2]);
        
        int totalPrice = Convert.toInt(productsTable.getValueAt(index, 1) + "");
        totalPriceDisplay.setText(MoneyFormat.getMoneyFormat(totalPrice) + " VNĐ");
        
        pricePerProductDisplay.setText(MoneyFormat.getMoneyFormat(priceForOne) + " VNĐ");
        
        int quantity = Integer.parseInt(productsTable.getValueAt(index, 2) + "");
        int totalCost = Integer.parseInt(priceForOne) * quantity;
        totalCostDisplay.setText(MoneyFormat.getMoneyFormat(totalCost) + " VNĐ");
        
        benefitsDisplay.setText(MoneyFormat.getMoneyFormat((totalPrice - totalCost)) + " VNĐ");
    }

    // ------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionsTime = new javax.swing.JComboBox<>();
        bestBtn = new javax.swing.JButton();
        worseBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        startTimeInput = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        endTimeInput = new javax.swing.JTextField();
        updateTimeBtn = new javax.swing.JButton();
        bestCustomerDisplay = new javax.swing.JLabel();
        totalPriceDisplay = new javax.swing.JLabel();
        pricePerProductDisplay = new javax.swing.JLabel();
        totalCostDisplay = new javax.swing.JLabel();
        benefitsDisplay = new javax.swing.JLabel();
        viewChartBtn = new javax.swing.JButton();

        optionsTime.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        optionsTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Time", "Today", "7 Days Ago", "30 Days Ago" }));
        optionsTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleChangeOptionsTime(evt);
            }
        });

        bestBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bestBtn.setText("Best");
        bestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleClickBest(evt);
            }
        });

        worseBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        worseBtn.setText("Worse");
        worseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleClickWorse(evt);
            }
        });

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Total Price", "Quantity", "UnitPerQuantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productsTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Best customer:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Total Price:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Most recent price per product: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Total cost:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Benefits:");

        startTimeInput.setBackground(new java.awt.Color(217, 217, 217));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("to");

        endTimeInput.setBackground(new java.awt.Color(217, 217, 217));

        updateTimeBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        updateTimeBtn.setText("Update");
        updateTimeBtn.setPreferredSize(new java.awt.Dimension(80, 32));
        updateTimeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleCustomDate(evt);
            }
        });

        bestCustomerDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bestCustomerDisplay.setText("Select a row");

        totalPriceDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalPriceDisplay.setText("0");

        pricePerProductDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pricePerProductDisplay.setText("0");

        totalCostDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalCostDisplay.setText("0");

        benefitsDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        benefitsDisplay.setText("0");

        viewChartBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        viewChartBtn.setText("View Chart");
        viewChartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleViewChart(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(optionsTime, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(worseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pricePerProductDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(benefitsDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startTimeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(endTimeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateTimeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewChartBtn))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(totalPriceDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bestCustomerDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalCostDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optionsTime, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(worseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bestCustomerDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalPriceDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pricePerProductDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(totalCostDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(benefitsDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(endTimeInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(startTimeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(updateTimeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(viewChartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents
    // ------------------------------------------
    private void handleClickBest(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleClickBest
        currentType = "BEST";
        if (isCustom && startDate != null && endDate != null) {
            renderTable(startDate, endDate);
        } else {
            
            renderTable();
        }
    }//GEN-LAST:event_handleClickBest

    private void handleClickWorse(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleClickWorse
        currentType = "WORSE";
        if (isCustom && startDate != null && endDate != null) {
            renderTable(startDate, endDate);
        } else {
            renderTable();
        }
    }//GEN-LAST:event_handleClickWorse

    private void handleChangeOptionsTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleChangeOptionsTime
        isCustom = false;
        time = (String) optionsTime.getSelectedItem();
        handleDate(time);
        renderTable();
    }//GEN-LAST:event_handleChangeOptionsTime

    private void handleCustomDate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleCustomDate
        String startTime = startTimeInput.getText();
        String endTime = endTimeInput.getText();
        if (!startTime.matches("\\d{2}/\\d{1,2}/\\d{4}") || !endTime.matches("\\d{2}/\\d{1,2}/\\d{4}")) {
            JOptionPane.showMessageDialog(null, "Invalid input, value must be format dd/MM/yyyy, example: 11/11/2022", "Message", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        isCustom = true;
        startDate = Convert.toLocalDate(Convert.toDate(startTime));
        endDate = Convert.toLocalDate(Convert.toDate(endTime));
        renderTable(startDate, endDate);

    }//GEN-LAST:event_handleCustomDate

    private void handleViewChart(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleViewChart
        try {
            String query 
                    = "SELECT SellDate, SUM(TotalPrice) AS TotalValue FROM Sells "
                    + "JOIN SellDetails ON Sells.SellID = SellDetails.SellID GROUP BY SellDate";
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(new Connector("SalesManagement").getConnection(), query);
            JFreeChart chart = ChartFactory.createLineChart("Turnover by date", "Date", "Total Value (VNĐ)", dataset, PlotOrientation.VERTICAL, false, true, true);
            
            BarRenderer renderer = new BarRenderer();
            CategoryPlot plot = null;
            ChartFrame chartFrame = new ChartFrame("Chart", chart);
            
            chartFrame.setSize(900, 600);
            chartFrame.setLocationRelativeTo(null);
            chartFrame.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_handleViewChart
    // ------------------------------------------

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel benefitsDisplay;
    private javax.swing.JButton bestBtn;
    private javax.swing.JLabel bestCustomerDisplay;
    private javax.swing.JTextField endTimeInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> optionsTime;
    private javax.swing.JLabel pricePerProductDisplay;
    private javax.swing.JTable productsTable;
    private javax.swing.JTextField startTimeInput;
    private javax.swing.JLabel totalCostDisplay;
    private javax.swing.JLabel totalPriceDisplay;
    private javax.swing.JButton updateTimeBtn;
    private javax.swing.JButton viewChartBtn;
    private javax.swing.JButton worseBtn;
    // End of variables declaration//GEN-END:variables
}
