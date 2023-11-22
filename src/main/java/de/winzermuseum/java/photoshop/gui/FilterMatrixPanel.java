package de.winzermuseum.java.photoshop.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.util.ResourceBundle;


/**
 * GUI-Komponente zur Eingabe von Filterkoeffizienten
 */
public class FilterMatrixPanel extends JPanel
{
  public static final int FILTER_SIZE_MIN = 2;
  public static final int FILTER_SIZE_MAX = 11;
  public static final int FILTER_SIZE_DEFAULT = 3;
  public static final int TABLE_ROW_HEIGHT = 32;

  private final SpinnerNumberModel filterSize;
  private TableDoubleModel filter;
  private final JTable filterTable;


  /**
   * Erzeugt eine GUI-Komponente zur Eingabe von Filterkoeffizienten.
   */
  public FilterMatrixPanel(final ResourceBundle resources)
  {
    filterSize = new SpinnerNumberModel(
        FILTER_SIZE_DEFAULT, FILTER_SIZE_MIN, FILTER_SIZE_MAX, 1);
    filterSize.addChangeListener(this::changeFilterSize);

    filter = new TableDoubleModel(FILTER_SIZE_DEFAULT, FILTER_SIZE_DEFAULT);

    final JLabel filterSizeLabel = new JLabel(resources.getString("label.filter.size"));
    final JSpinner filterSizeSpinner = new JSpinner(filterSize);

    final JPanel filterSizePanel = new JPanel();
    filterSizePanel.add(filterSizeLabel);
    filterSizePanel.add(filterSizeSpinner);
    filterSizeLabel.setLabelFor(filterSizeSpinner);

    filterTable = new JTable(filter);
    filterTable.setTableHeader(null);
    filterTable.setDefaultEditor(Double.class, new TableDoubleCellEditor());
    filterTable.setRowHeight(TABLE_ROW_HEIGHT);

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    add(filterSizePanel);
    add(new JScrollPane(filterTable));
  }


  /**
   * Passt die Größe der Filtermatrix an.
   *
   * @param event nicht verwendet
   */
  private void changeFilterSize(final ChangeEvent event)
  {
    final int size = (Integer) filterSize.getValue();
    filter = new TableDoubleModel(size, size);
    filterTable.setModel(filter);
  }


  /**
   * Gibt die Matrix mit den Filterkoeffizienten
   *
   * @return Matrix mit den Filterkoeffizienten
   */
  public double[][] getFilterMatrix()
  {
    final int numRows = filter.getRowCount();
    final int numCols = filter.getColumnCount();

    final double[][] data = new double[numRows][numCols];

    for (int i = 0; i < numRows; i++)
    {
      for (int j = 0; j < numCols; j++)
      {
        data[i][j] = filter.getValue(i, j);
      }
    }

    return data;
  }
}


/*

This file is part of the zone.informatik.java.graphics.gui package.

Copyright (C) 2023 Matthias Ebert

This package is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

The package is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with the package.  If not, see <http://www.gnu.org/licenses/>.

*/