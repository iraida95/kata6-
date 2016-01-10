package kata6;

import java.beans.Statement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MailReader {
    public static ArrayList <Person> read() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        ArrayList <Person> people = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection cn = DriverManager.getConnection("jdbc:sqlite:KATA.sDB");
        java.sql.Statement st =  cn.createStatement();
        ResultSet rs = st.executeQuery ("SELECT * from PEOPLE ");
        while(rs.next()){
            int id = rs.getInt("id");
            String mail = rs.getString("mail");
            String genero= rs.getString("genero");
            float peso = rs.getFloat("peso");
            people.add(new Person(id,mail, genero,peso));
        }
        return people;
    }
    
}
