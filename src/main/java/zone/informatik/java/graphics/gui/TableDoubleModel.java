package zone.informatik.java.graphics.gui;

import javax.swing.table.AbstractTableModel;


/**
 * Modell für eine Tabelle, welche ausschließlich Zellen
 * vom Typ double enthält
 */
public class TableDoubleModel extends AbstractTableModel
{
  private final String[] columnNames;
  private final double[][] data;


  /**
   * Erzeugt ein Modell für eine Tabelle, welche ausschließlich Zellen
   * vom Typ double enthält.
   *
   * @param numRows Anzahl der Zeilen
   * @param numCols Anzahl der Spalten
   */
  public TableDoubleModel(final int numRows, final int numCols)
  {
    this.columnNames = new String[numCols];
    this.data = new double[numRows][numCols];

    for (int i = 0; i < numRows; i++)
    {
      for (int j = 0; j < numCols; j++)
      {
        data[i][j] = 1.0;
      }
    }

    for (int j = 0; j < numCols; j++)
    {
      columnNames[j] = String.valueOf(j);
    }
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public int getColumnCount()
  {
    return columnNames.length;
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public int getRowCount()
  {
    return data.length;
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public String getColumnName(final int col)
  {
    return columnNames[col];
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public Object getValueAt(final int row, final int col)
  {
    return data[row][col];
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public Class<?> getColumnClass(final int col)
  {
    return Double.class;
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public void setValueAt(final Object value, final int row, final int col)
  {
    data[row][col] = (Double)  value;
    fireTableCellUpdated(row, col);
  }


  /**
   * {@inheritDoc}
   */
  public double getValue(final int row, final int col)
  {
    return data[row][col];
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isCellEditable(final int row, final int col)
  {
    return true;
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