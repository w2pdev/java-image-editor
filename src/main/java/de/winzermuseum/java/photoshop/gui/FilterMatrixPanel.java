package de.winzermuseum.java.photoshop.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.table.JTableHeader;
import java.util.ResourceBundle;


/**
 * GUI-Komponente zur Eingabe von Filterkoeffizienten
 */
public class FilterMatrixPanel extends JPanel {
  public static final int FILTER_SIZE_MIN = 2;
  public static final int FILTER_SIZE_MAX = 11;
  public static final int FILTER_SIZE_DEFAULT = 3;
  public static final int TABLE_ROW_HEIGHT = 32;
  private final SpinnerNumberModel filterSize = new SpinnerNumberModel(3, 2, 11, 1);
  private final JTextField scaleFactorField;
  private TableDoubleModel filter;
  private final JTable filterTable;

  public FilterMatrixPanel(ResourceBundle resources) {
    this.filterSize.addChangeListener(this::changeFilterSize);
    this.filter = new TableDoubleModel(3, 3);
    JLabel filterSizeLabel = new JLabel(resources.getString("label.filter.size"));
    JSpinner filterSizeSpinner = new JSpinner(this.filterSize);
    JLabel scaleFactorLabel = new JLabel(resources.getString("label.filter.factor"));
    this.scaleFactorField = new JTextField();
    this.scaleFactorField.setColumns(10);
    this.scaleFactorField.setText("1");
    JPanel filterSizePanel = new JPanel();
    filterSizePanel.add(filterSizeLabel);
    filterSizePanel.add(filterSizeSpinner);
    filterSizeLabel.setLabelFor(filterSizeSpinner);
    JPanel scaleFactorPanel = new JPanel();
    scaleFactorPanel.add(scaleFactorLabel);
    scaleFactorPanel.add(this.scaleFactorField);
    scaleFactorLabel.setLabelFor(scaleFactorLabel);
    this.filterTable = new JTable(this.filter);
    this.filterTable.setTableHeader((JTableHeader)null);
    this.filterTable.setDefaultEditor(Double.class, new TableDoubleCellEditor());
    this.filterTable.setRowHeight(32);
    this.setLayout(new BoxLayout(this, 1));
    this.add(filterSizePanel);
    this.add(scaleFactorPanel);
    this.add(new JScrollPane(this.filterTable));
  }

  private void changeFilterSize(ChangeEvent event) {
    int size = (Integer)this.filterSize.getValue();
    this.filter = new TableDoubleModel(size, size);
    this.filterTable.setModel(this.filter);
  }

  public double getScaleFactor() {
    double scaleFactor = 1.0;

    try {
      scaleFactor = Double.parseDouble(this.scaleFactorField.getText());
    } catch (Exception var4) {
      this.scaleFactorField.setText("1");
    }

    return scaleFactor;
  }

  public double[][] getFilterMatrix() {
    int numRows = this.filter.getRowCount();
    int numCols = this.filter.getColumnCount();
    double[][] data = new double[numRows][numCols];

    for(int i = 0; i < numRows; ++i) {
      for(int j = 0; j < numCols; ++j) {
        data[i][j] = this.filter.getValue(i, j);
      }
    }

    return data;
  }
}
