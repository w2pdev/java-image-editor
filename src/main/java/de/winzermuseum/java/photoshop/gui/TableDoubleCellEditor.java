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


