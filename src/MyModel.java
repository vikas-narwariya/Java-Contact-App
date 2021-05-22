
import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;


public class MyModel extends AbstractTableModel {

    private String[] columns;
    private Object[][] rows;
    
    public MyModel(){}
    public MyModel(Object[][] data, String[] columnsName){
        this.columns=columnsName;
        this.rows=data;
    }
    
    public Class getColumnClass(int col)
    {
        if(col==8){
            return Icon.class;
        }
        else
        {
            return getValueAt(0,col).getClass();
        }
    }
    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools |
        return this.rows.length;
    }

    @Override
    public int getColumnCount() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   return this.rows[rowIndex][columnIndex];
    }
    @Override
    public String getColumnName(int col)
    {
        return this.columns[col];
    }
}
