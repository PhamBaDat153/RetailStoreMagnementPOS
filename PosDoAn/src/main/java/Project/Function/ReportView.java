/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Project.Function;
/**
 *
 * @author wow
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import java.awt.Container;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.*;

import Project.Database.DatabaseConnector;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import Project.Database.DatabaseConnector;



public class ReportView extends JFrame
{
    public ReportView(String fileName) throws SQLException {
        this(fileName, null);
    }
   
    
    
    public ReportView(String fileName, HashMap para) throws SQLException {
        super("Xem báo cáo");

        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection con = databaseConnector.connectDatabase();
                
                
//        
//        Dbcon dba;
//        dba = new Dbcon();
//        java.sql.Connection con;
//        con = Dbcon.mycon();
//       

        try
        {
            JasperPrint print = JasperFillManager.fillReport(fileName, para, con);
            JRViewer viewer = new JRViewer(print);
            Container c = getContentPane();
            c.add(viewer);            
        } 
        catch (JRException jRException)
        {
            System.out.println(jRException);
        }
        setBounds(2, 2, 900, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
