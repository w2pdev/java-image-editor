package de.winzermuseum.java.photoshop.gui;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;


/**
 * Editor für JTable-Zellen vom Typ double
 */
public class TableDoubleCellEditor extends AbstractCellEditor implements TableCellEditor
{
  private final JTextField editor;


  /**
   * Erzeugt einen Editor für JTable-Zellen vom Typ double.
   */
  public TableDoubleCellEditor()
  {
    editor = new JTextField();
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public Object getCellEditorValue()
  {
    try
    {
      return Double.parseDouble(editor.getText());
    }
    catch (final NumberFormatException e)
    {
      return null;
    }
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
  {
    editor.setText(value == null ? "" : value.toString());
    return editor;
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public boolean stopCellEditing()
  {
    try
    {
      Double.parseDouble(editor.getText());
    }
    catch (final NumberFormatException e)
    {
      return false;
    }

    return super.stopCellEditing();
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