package Frames;

import javax.swing.table.AbstractTableModel;

class DropDownModel extends AbstractTableModel{
    Object data[][]={
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
 				{""},
    };
 		String[] columnNames={"List Entry (Type in ## for Current Year)"};
                    static int COLUMN_COUNT=1;
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}
    @Override
	public Class getColumnClass(int column) {
	     return (data[0][column]).getClass();
	  }

    @Override
	  public String getColumnName(int column) {
	    return columnNames[column];
	  }

    @Override
	  public boolean isCellEditable(int row, int column) {
	    return (column == 0);
	  }

    @Override
	  public void setValueAt(Object value, int row, int column) {
	    data[row][column] = value;
	      fireTableRowsUpdated(row, row);
	    }
}
