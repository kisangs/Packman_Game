package java_assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBconnection 
{
    public static Connection dbConn;
    
        public static Connection getConnection()
        {
            Connection conn = null;
            try {
                String user = "skystar1"; 
    			String pw = "yuhan1234";
    			String url = "jdbc:mysql://localhost:3306/java2?serverTimezone=UTC";
                
    			Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pw);
                
                System.out.println("Database�� ����Ǿ����ϴ�.\n");
                
            } catch (ClassNotFoundException cnfe) {
                System.out.println("DB ����̹� �ε� ���� :"+cnfe.toString());
            } catch (SQLException sqle) {
                System.out.println("DB ���ӽ��� : "+sqle.toString());
            } catch (Exception e) {
                System.out.println("Unkonwn error");
                e.printStackTrace();
            }
            return conn;     
        }
}
 


