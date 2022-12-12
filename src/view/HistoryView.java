package view;

import controller.HistoryController;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import supports.Convert;
import supports.NumberFormat;
import supports.Validation;
import view.dialog.HistoryImportDetailDialog;
import view.dialog.HistorySellDetailsDialog;

public class HistoryView extends javax.swing.JPanel {

    private String currentHistory = "SELL_HISTORY";
    private final String SELL_HISTORY = "SELL_HISTORY";
    private final String IMPORT_HISTORY = "IMPORT_HISTORY";

    private LocalDate startDate = LocalDate.now().minusDays(365000);
    private LocalDate endDate = LocalDate.now();

    private int startPrice = 0;
    private int endPrice = 2100000000;

    private ArrayList<String[]> data = null;

    public HistoryView() {
        initComponents();
        renderSellTable();
    }

    private void renderSellTable() {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnCount(4);
        TableColumn col1 = table.getColumnModel().getColumn(0);
        TableColumn col2 = table.getColumnModel().getColumn(1);
        TableColumn col3 = table.getColumnModel().getColumn(2);
        TableColumn col4 = table.getColumnModel().getColumn(3);
        col1.setHeaderValue("Sell ID");
        col2.setHeaderValue("Customer Name");
        col3.setHeaderValue("Date");
        col4.setHeaderValue("Time");

        data = HistoryController.getHistorySell(startDate, endDate, startPrice, endPrice);

        for (String[] dataItem : data) {
            try {
                Date sellDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dataItem[2] + " " + dataItem[3].split("[.]")[0]);

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

                Object[] rowObjects = new Object[]{dataItem[0], dataItem[1], dateFormat.format(sellDateTime), NumberFormat.getHMSTime(timeFormat.format(sellDateTime))};
                tableModel.addRow(rowObjects);

            } catch (ParseException ex) {
                Logger.getLogger(HistoryView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void renderImportTable() {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnCount(3);
        TableColumn col1 = table.getColumnModel().getColumn(0);
        TableColumn col2 = table.getColumnModel().getColumn(1);
        TableColumn col3 = table.getColumnModel().getColumn(2);
        col1.setHeaderValue("Import ID");
        col2.setHeaderValue("Date");
        col3.setHeaderValue("Time");

        data = HistoryController.getHistoryImport(startDate, endDate, startPrice, endPrice);

        for (String[] dataItem : data) {
            try {
                Date sellDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dataItem[1] + " " + dataItem[2].split("[.]")[0]);

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

                Object[] rowObjects = new Object[]{dataItem[0], dateFormat.format(sellDateTime), NumberFormat.getHMSTime(timeFormat.format(sellDateTime))};
                tableModel.addRow(rowObjects);

            } catch (ParseException ex) {
                Logger.getLogger(HistoryView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void renderTableByType() {
        switch (currentHistory) {
            case SELL_HISTORY:
                renderSellTable();
                break;
            case IMPORT_HISTORY:
                renderImportTable();
                break;
            default:
                System.out.println("DEFAULT CASE HISTORY TYPE");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sellHistoryBtn = new javax.swing.JButton();
        importHistoryBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numOfProductDisplay = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        discountDisplay = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        priceToPayDisplay = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        startDateInput = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        endDateInput = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        timeOptions = new javax.swing.JComboBox<>();
        startPriceInput = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        endPriceInput = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();

        sellHistoryBtn.setBackground(new java.awt.Color(0, 255, 255));
        sellHistoryBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sellHistoryBtn.setForeground(new java.awt.Color(0, 0, 0));
        sellHistoryBtn.setText("Sell");
        sellHistoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleClickSellHistory(evt);
            }
        });

        importHistoryBtn.setBackground(new java.awt.Color(242, 243, 244));
        importHistoryBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        importHistoryBtn.setForeground(new java.awt.Color(0, 0, 0));
        importHistoryBtn.setText("Import");
        importHistoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleClickImportHistory(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setText("Details");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleViewDetail(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Date", "Time"
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                handleClickRowTable(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(90, 90, 90));
        jLabel15.setText("Voucher information: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Number of product");

        numOfProductDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        numOfProductDisplay.setText("---");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Discount value:");

        discountDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        discountDisplay.setText("---");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Price to pay:");

        priceToPayDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        priceToPayDisplay.setText("---");

        startDateInput.setBackground(new java.awt.Color(217, 217, 217));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("to");

        endDateInput.setBackground(new java.awt.Color(217, 217, 217));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(90, 90, 90));
        jLabel16.setText("Custom date:");

        timeOptions.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        timeOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Time", "Today", "7 Days Ago", "30 Days Ago" }));
        timeOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleChooseTime(evt);
            }
        });

        startPriceInput.setBackground(new java.awt.Color(217, 217, 217));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("to");

        endPriceInput.setBackground(new java.awt.Color(217, 217, 217));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(90, 90, 90));
        jLabel17.setText("Custom price:");

        cancelBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancelBtn.setText("Cancel Custom");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleCancelCustom(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleCustom(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sellHistoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(importHistoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(priceToPayDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(numOfProductDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(discountDisplay))))
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startPriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(endPriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(startDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(endDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel17))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(timeOptions, 0, 242, Short.MAX_VALUE)
                                    .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 41, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sellHistoryBtn)
                    .addComponent(importHistoryBtn)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numOfProductDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(discountDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(priceToPayDisplay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(startDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(endDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(timeOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17))
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startPriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(endPriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void handleClickRowTable(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_handleClickRowTable
        int viewIndex = table.getSelectedRow();
        int priceToPay = 0;
        int discountValue = 0;
        int numOfProduct = 0;

        switch (currentHistory) {
            case SELL_HISTORY:
                priceToPay = Integer.parseInt(data.get(viewIndex)[4]);
                discountValue = Integer.parseInt(data.get(viewIndex)[5] == null ? "0" : data.get(viewIndex)[5]);
                numOfProduct = Integer.parseInt(data.get(viewIndex)[6]);
                break;
            case IMPORT_HISTORY:
                priceToPay = Integer.parseInt(data.get(viewIndex)[3]);
                discountValue = Integer.parseInt(data.get(viewIndex)[4] == null ? "0" : data.get(viewIndex)[4]);
                numOfProduct = Integer.parseInt(data.get(viewIndex)[5]);
                break;
            default:
        }

        numOfProductDisplay.setText(numOfProduct + "");
        discountDisplay.setText(NumberFormat.getMoneyFormat(discountValue) + " VNĐ");
        priceToPayDisplay.setText(NumberFormat.getMoneyFormat(priceToPay - discountValue < 0 ? 0 : priceToPay - discountValue) + " VNĐ");
    }//GEN-LAST:event_handleClickRowTable

    private void handleChooseTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleChooseTime
        String itemChoosing = (String) timeOptions.getSelectedItem();
        switch (itemChoosing) {
            case "All Time":
                startDate = LocalDate.now().minusDays(365000);
                endDate = LocalDate.now();
                break;
            case "Today":
                startDate = LocalDate.now();
                endDate = LocalDate.now();
                break;
            case "7 Days Ago":
                startDate = LocalDate.now().minusDays(6);
                endDate = LocalDate.now();
                break;
            case "30 Days Ago":
                startDate = LocalDate.now().minusDays(29);
                endDate = LocalDate.now();
                break;
            default:
                System.out.println("DEFAULT CASE OPTIONS");
        }

        renderTableByType();
    }//GEN-LAST:event_handleChooseTime

    private void handleClickSellHistory(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleClickSellHistory
        sellHistoryBtn.setBackground(Color.decode("#00ffff"));
        importHistoryBtn.setBackground(Color.decode("#f2f3f4"));

        currentHistory = SELL_HISTORY;
        renderSellTable();
    }//GEN-LAST:event_handleClickSellHistory

    private void handleClickImportHistory(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleClickImportHistory
        sellHistoryBtn.setBackground(Color.decode("#f2f3f4"));
        importHistoryBtn.setBackground(Color.decode("#00ffff"));

        currentHistory = IMPORT_HISTORY;
        renderImportTable();
    }//GEN-LAST:event_handleClickImportHistory

    private void handleCustom(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleCustom
        String startDateCustom = startDateInput.getText().trim();
        String endDateCustom = endDateInput.getText().trim();
        String startPriceCustom = startPriceInput.getText().trim();
        String endPriceCustom = endPriceInput.getText().trim();

        if (startDateCustom.isBlank() && endDateCustom.isBlank() && startPriceCustom.isBlank() && endPriceCustom.isBlank()) {
            JOptionPane.showMessageDialog(null, "Nothing to custom, please enter date (dd/MM/yyyy) or price (number) to custom history");
            return;
        }
        if (!startDateCustom.isBlank() || !endDateCustom.isBlank()) {
            if (!startDateCustom.matches("\\d{1,2}/\\d{1,2}/\\d{4}") || !endDateCustom.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
                JOptionPane.showMessageDialog(null, "Please enter with format dd/MM/yyyy, example: 12/12/2000");
                return;
            }
            Object[] isValidStartDate = Validation.isDate(startDateCustom);
            Object[] isValidEndDate = Validation.isDate(endDateCustom);

            if (!(boolean) isValidStartDate[0]) {
                JOptionPane.showMessageDialog(null, isValidStartDate[1]);
                return;
            }
            if (!(boolean) isValidEndDate[0]) {
                JOptionPane.showMessageDialog(null, isValidEndDate[1]);
                return;
            }

            startDate = Convert.toLocalDate(Convert.toDate(startDateCustom));
            endDate = Convert.toLocalDate(Convert.toDate(endDateCustom));
        }

        if (!startPriceCustom.isBlank() || !endPriceCustom.isBlank()) {
            if (!startPriceCustom.matches("[0-9]+") || !endPriceCustom.matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "Price only accept number and must be greater than or equals 0, let enter number");
                return;
            }
            if (Integer.parseInt(startPriceCustom) < 0 || Integer.parseInt(endPriceCustom) < Integer.parseInt(startPriceCustom)) {
                JOptionPane.showMessageDialog(null, "Invalid price custom, first price >= 0, second price >= first price");
                return;
            }

            startPrice = Integer.parseInt(startPriceCustom);
            endPrice = Integer.parseInt(endPriceCustom);
        }

        renderTableByType();
    }//GEN-LAST:event_handleCustom

    private void handleCancelCustom(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleCancelCustom
        startDate = LocalDate.now().minusDays(365000);
        endDate = LocalDate.now();

        startPrice = 0;
        endPrice = 2100000000;

        timeOptions.setSelectedIndex(0);
        
        // Clear input
        startDateInput.setText("");
        endDateInput.setText("");
        startPriceInput.setText("");
        endPriceInput.setText("");

        renderTableByType();
    }//GEN-LAST:event_handleCancelCustom

    private void handleViewDetail(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleViewDetail
        switch (currentHistory) {
            case SELL_HISTORY: {
                HistorySellDetailsDialog dialog = new HistorySellDetailsDialog(new javax.swing.JFrame(), true);
                int viewIndex = table.getSelectedRow();
                if (viewIndex == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row in table and click me again");
                    return;
                }
                int sellID;
                try {
                    sellID = Integer.parseInt(data.get(viewIndex)[0]);
                    dialog.setSellID(sellID);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Can not get index 0 of data array list handle view detail");
                }
            }
            break;
            case IMPORT_HISTORY: {
                HistoryImportDetailDialog dialog = new HistoryImportDetailDialog(new javax.swing.JFrame(), true);
                int viewIndex = table.getSelectedRow();
                if (viewIndex == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row in table and click me again");
                    return;
                }
                int importID;
                try {
                    importID = Integer.parseInt(data.get(viewIndex)[0]);
                    dialog.setImportID(importID);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Can not get index 0 of data array list handle view detail");
                }
                break;
            }
        }

    }//GEN-LAST:event_handleViewDetail


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel discountDisplay;
    private javax.swing.JTextField endDateInput;
    private javax.swing.JTextField endPriceInput;
    private javax.swing.JButton importHistoryBtn;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel numOfProductDisplay;
    private javax.swing.JLabel priceToPayDisplay;
    private javax.swing.JButton sellHistoryBtn;
    private javax.swing.JTextField startDateInput;
    private javax.swing.JTextField startPriceInput;
    private javax.swing.JTable table;
    private javax.swing.JComboBox<String> timeOptions;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
