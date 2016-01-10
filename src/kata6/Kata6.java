
package kata6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Kata6 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
       
        ArrayList <Person> people = MailReader.read();
        HistogramBuilder <Person> builder = new HistogramBuilder <>(people);
        Histogram <String> domains= builder.build(new Attribute <Person, String>(){
        
        @Override
        public String get(Person person){
            return person.getMail().split("@")[1];
        }
        
        });
       Histogram <Character> letters= builder.build(new Attribute <Person, Character>(){
        
        @Override
        public Character get(Person person){
            return person.getMail().charAt(0);
        }
       });
        Histogram <String> genero= builder.build(new Attribute <Person, String>(){
        
        @Override
        public String get(Person person){
            return person.getGenero();
        }
        
        });
         Histogram <Float> peso = builder.build(new Attribute <Person, Float>(){
        
        @Override
        public Float get(Person person){
            return person.getPeso();
        }
        
        });
        
        new HistogramDisplay(domains).execute();
        new HistogramDisplay(letters).execute();
        new HistogramDisplay(genero).execute();
        new HistogramDisplay(peso).execute();
        
    }  
}
