package Frames;


import java.util.List;
import javax.swing.table.AbstractTableModel;

class ComboModel extends AbstractTableModel{
static String year,y1,y2,y3;
        public ComboModel(String s){
                    year=s;
                 y1=previous(year);
                if(y1.equals("Year out of range")){
                    y2="Year out of range";
                    y3="Year out of range";
                }
 else{
     y2=previous(y1);
                if(y2.equals("Year out of range"))
                    y3="Year out of range";
                else
                    y3=previous(y2);
    } 
 }
    Object data[][]={
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""}
                                ,{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""}
                                ,{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""}
                                ,{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""}
                                ,{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""},
 				{"","","","","",""}

 		};
 		String[] columnNames={"S.No.","Field","Amount",y1,y2,y3};
                    static int COLUMN_COUNT=6;

    ComboModel() {
    }
                   public String previous(String year1){
                       if(year1.equals("Year out of Range")||year1==null)
                           return "Year out of Range";
                int left=Integer.parseInt(year1.substring(0, year1.indexOf("-")))-1;
                int right=Integer.parseInt(year1.substring(year1.indexOf("-")+1, year1.length()))-1;
                if(left<0){
                    return "Year out of range";
                }
                String y0 = "";
                if(left<10)
                    y0="0";
                y0=y0+String.valueOf(left)+"-";
                if(right<10)
                    y0+="0";
                y0+=String.valueOf(right);
                return y0;

                }
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
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
	    return (column == 1||column==2);
	  }

    @Override
	  public void setValueAt(Object value, int row, int column) {
              if (column == 2 && value != null && !(value + "").isEmpty())
              {
                  try
                  {
                      Integer.parseInt(value + "");
                  } catch (Exception e)
                  {
                      return;
                  }
              }
	    data[row][column] = value;
	      fireTableRowsUpdated(row, row);
 
	    }
public static String[] getdrop(String k,String year){
    DropDownList list=new DropDownList();
    List l=list.getListItems(k);
        int i=0;
        StringBuffer r=null;
        String[] s=new String[l.size()];
        while(i<s.length){
            r=new StringBuffer((String)l.get(i));
            while(r.indexOf("##")!=-1)
                r.replace(r.indexOf("##"), r.indexOf("##")+2, year);
            s[i]=r.toString();
            i++;
        }
        return s;
}
/*static String[][] dropdown={
    {"Fee for IT Return for the Assessment Year " ,"Fee for F.B.T. Return for the Assessment Year ","Fee for filing of Form No. 15G & 15H","Fee for LTCG/STCG work","Fee for Partnership Deed dated ","Fee for Retirement Deed dated ","Fee for Dissolution Deed dated ","Fee for Gift Deed dated ","Fee for Service Tax Return for the Period ","Fee for registration with R.O.F.","Expenses"},
    {"Fee for Tax Audit for the Assessment Year " ,"Expenses"},
    {"Fee for VAT Audit for the Assessment Year " ,"Expenses"},
    {"Fee for IT Return for the Assessment Year " ,"Fee for VAT Audit for the Assessment Year " ,"Fee for Tax Audit for the Assessment Year " ,"Expenses"},
    {"A"}
 	};
 * 
 */

}
