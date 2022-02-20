import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class GuardarYLeer {
    
    static final int FILAS = 12;
    static final int COLUMNAS = 10;
    static String[][] tabla = new String[FILAS][COLUMNAS];
    static String[] mensajero = new String[72];

    public GuardarYLeer(){

    }
    public  void Leer(String nombre){
        JSONParser jsonParser = new JSONParser();

        try(FileReader r = new FileReader(nombre)){

            Object obj = jsonParser.parse(r);
            JSONArray infoEquipo = (JSONArray) obj;
            
            //Pasar el JSONArray a una arrayList
            List<String> lista = new ArrayList<String>();
            lista.add(infoEquipo.toJSONString());
        
            //Pasar la arrayList a una variable de tipo String
            String str = "";
		    for (String list : lista) {
			    str+= list+",";
    		}
            

            //Pasar el contenido de la variable a una matriz
            mensajero = str.split(",");
            String temp;
            for(int i=0; i<mensajero.length;i++){
                temp = mensajero[i];
                mensajero[i] = temp.replaceAll("\\p{Punct}", "");
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
    }
    public String[] devolver(){
        return mensajero;
    }
}
