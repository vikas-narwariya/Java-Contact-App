import java.sql.Connection;
import java.awt.Image;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;
import javax.swing.JFrame;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class contactQuery {
    
    public void insertContact(contacts cont)
    {
      //  boolean contactIsCreated=true;
        Connection con = myConnection.getConnection();
				PreparedStatement ps;
                                
        try {
          ps = con.prepareStatement("INSERT INTO `mycontact`( `Fname`, `Lname`, `groupc`, `phone`, `email`, `address`, `pic`, `userid`) VALUES (?,?,?,?,?,?,?,?)");
           // ps=con.prepareStatement ("INSERT INTO `mycontact`( `Fname`, `Lname`, `groupc`, `phone`, `email`, `address`, `pic`, `userid`) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, cont.getFname());
             ps.setString(2, cont.getLname());
              ps.setString(3, cont.getGroupc());
               ps.setString(4, cont.getPhone());
                ps.setString(5, cont.getEmail());
                 ps.setString(6, cont.getAddress());
                  ps.setBytes(7, cont.getPic());
                   ps.setInt(8, cont.getUid());
                   
                   if(ps.executeUpdate() != 0) {
					
					JOptionPane.showMessageDialog(null, "New contact Added !");
                               //         contactIsCreated=true;
				}
                                    else {
					JOptionPane.showMessageDialog(null, "Something Wrong");
                                      //  contactIsCreated=false;
				}
                 
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

      //  return contactIsCreated;
    }
    
    
    
        public void updateContact(contacts cont,boolean withImage)
    {
      //  boolean contactIsCreated=true;
        Connection con = myConnection.getConnection();
				PreparedStatement ps;
       String updateQuery="";
         
       if(withImage==true)
       {
           updateQuery="UPDATE `mycontact` SET `Fname`=?,`Lname`=?,`groupc`=?,`phone`=?,`email`=?,`address`=?,`pic`=? WHERE `id`=?";
       try {
          ps = con.prepareStatement(updateQuery);
           // ps=con.prepareStatement ("INSERT INTO `mycontact`( `Fname`, `Lname`, `groupc`, `phone`, `email`, `address`, `pic`, `userid`) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, cont.getFname());
             ps.setString(2, cont.getLname());
              ps.setString(3, cont.getGroupc());
               ps.setString(4, cont.getPhone());
                ps.setString(5, cont.getEmail());
                 ps.setString(6, cont.getAddress());
                  ps.setBytes(7, cont.getPic());
                   ps.setInt(8, cont.getCid());
                   
                   if(ps.executeUpdate() != 0) {
					
					JOptionPane.showMessageDialog(null, "Contact Data Edited !");
                               //         contactIsCreated=true;
				}
                                    else {
					JOptionPane.showMessageDialog(null, "Something Wrong");
                                      //  contactIsCreated=false;
				}
                 
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       else{
             updateQuery="UPDATE `mycontact` SET `Fname`=?,`Lname`=?,`groupc`=?,`phone`=?,`email`=?,`address`=?,`pic`=? WHERE `id`=?";
 try {
          ps = con.prepareStatement(updateQuery);
           // ps=con.prepareStatement ("INSERT INTO `mycontact`( `Fname`, `Lname`, `groupc`, `phone`, `email`, `address`, `pic`, `userid`) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, cont.getFname());
             ps.setString(2, cont.getLname());
              ps.setString(3, cont.getGroupc());
               ps.setString(4, cont.getPhone());
                ps.setString(5, cont.getEmail());
                 ps.setString(6, cont.getAddress());
                //  ps.setBytes(7, cont.getPic());
                   ps.setInt(7, cont.getCid());
                   
                   if(ps.executeUpdate() != 0) {
					
					JOptionPane.showMessageDialog(null, "Contact Data Edited !");
                               //         contactIsCreated=true;
				}
                                    else {
					JOptionPane.showMessageDialog(null, "Something Wrong");
                                      //  contactIsCreated=false;
				}
                 
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       }    
}
      //  return contactIsCreated;
    
    
    public ArrayList<contacts> contactList(){
        ArrayList<contacts> clist=new ArrayList<contacts>();
        
        Connection con=myConnection.getConnection();
        Statement st;
        ResultSet rs;
        try {
            st=con.createStatement();
              rs=st.executeQuery("SELECT `id`, `Fname`, `Lname`, `groupc`, `phone`, `email`, `address`, `pic`  FROM `mycontact` " );
              
              contacts ct;
              while(rs.next()){
                  ct=new contacts(rs.getInt("id"),
                          rs.getString("Fname"),
                        rs.getString("Lname"),
                       rs.getString("groupc"),
                         rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                          rs.getBytes("pic"),
                          0);
                  clist.add(ct);
              }
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
      //  rs=st.executeQuery("SELECT `id`, `Fname`, `Lname`, `groupc`, `phone`, `email`, `address`, `pic`  FROM `mycontact`");
        
//        try{
//      st=con.createStatement();
//         rs=st.executeQuery("SELECT `id`, `Fname`, `Lname`, `groupc`, `phone`, `email`, `address`, `pic`  FROM `mycontact` ")
//
//      catch(SQLException ex){
//              Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
//              }
     //   rs=st.executeQuery("SELECT `id`, `Fname`, `Lname`, `groupc`, `phone`, `email`, `address`, `pic`  FROM `mycontact` ")
        return clist;
    }
}
