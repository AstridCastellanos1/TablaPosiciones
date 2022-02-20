import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;


public final class App {
    private App() {
    }

    static final int FILAS = 12;
    static final int COLUMNAS = 10;
    static String[][] tabla = new String[FILAS][COLUMNAS];
    static String[] mensajero = new String[72];
    
   
    public static void main(String[] args) {
        llenarTabla();
        //imprimirTabla();
        ordenPorPuntos();
        imprimirTabla();
        guardarArray();
        
    }


    public static void ordenPorPuntos(){
        int a;
        int b; 

        //Solo hay 3 equipos, ingresados, por eso solo es i < 3
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12-i-1; j++) {

                a = Integer.parseInt(tabla[j][Col.PUNTOS]);
                b = Integer.parseInt(tabla[j+1][Col.PUNTOS]);

                if (a<b) {
                    //swap 2 filas
                    String[] filaTemporal = tabla[j];
                    tabla[j] = tabla[j+1];
                    tabla[j+1] = filaTemporal;

                }
            }
        }

    }

    public static void llenarTabla() {
        GuardarYLeer G = new GuardarYLeer();
        String nombre = "Info.json";
        G.Leer(nombre);

        String mensajero[] = G.devolver();
        
        // Primer equipo.
        tabla[0][Col.NOMBRE] = mensajero[0];
        tabla[0][Col.GANADOS] = mensajero[1];
        tabla[0][Col.EMPATES] = mensajero[2];
        tabla[0][Col.PERDIDOS] = mensajero[3];
        tabla[0][Col.GOLES_FAVOR] = mensajero[4];
        tabla[0][Col.GOLES_CONTRA] = mensajero[5];
        // tabla[0][Columnas.GOLES_DIFERENCIA] = "25";

        // Segundo equipo
        tabla[1][Col.NOMBRE] = mensajero[6];
        tabla[1][Col.GANADOS] = mensajero[7];
        tabla[1][Col.EMPATES] = mensajero[8];
        tabla[1][Col.PERDIDOS] = mensajero[9];
        tabla[1][Col.GOLES_FAVOR] = mensajero[10];
        tabla[1][Col.GOLES_CONTRA] = mensajero[11];
        // tabla[1][Columnas.GOLES_DIFERENCIA] = "-17";

        // Tercer equipo
        tabla[2][Col.NOMBRE] = mensajero[12];
        tabla[2][Col.GANADOS] = mensajero[13];
        tabla[2][Col.EMPATES] = mensajero[14];
        tabla[2][Col.PERDIDOS] = mensajero[15];
        tabla[2][Col.GOLES_FAVOR] = mensajero[16];
        tabla[2][Col.GOLES_CONTRA] = mensajero[17];
        // tabla[2][Columnas.GOLES_DIFERENCIA] = "23";

        // Cuarto equipo
        tabla[3][Col.NOMBRE] = mensajero[18];
        tabla[3][Col.GANADOS] = mensajero[19];
        tabla[3][Col.EMPATES] = mensajero[20];
        tabla[3][Col.PERDIDOS] = mensajero[21];
        tabla[3][Col.GOLES_FAVOR] = mensajero[22];
        tabla[3][Col.GOLES_CONTRA] = mensajero[23];
        // tabla[3][Columnas.GOLES_DIFERENCIA] = "-31";

        // Quinto equipo
        tabla[4][Col.NOMBRE] = mensajero[24];
        tabla[4][Col.GANADOS] = mensajero[25];
        tabla[4][Col.EMPATES] = mensajero[26];
        tabla[4][Col.PERDIDOS] = mensajero[27];
        tabla[4][Col.GOLES_FAVOR] = mensajero[28];
        tabla[4][Col.GOLES_CONTRA] = mensajero[29];
        // tabla[4][Columnas.GOLES_DIFERENCIA] = "17";

        // Sexto equipo
        tabla[5][Col.NOMBRE] = mensajero[30];
        tabla[5][Col.GANADOS] = mensajero[31];
        tabla[5][Col.EMPATES] = mensajero[32];
        tabla[5][Col.PERDIDOS] = mensajero[33];
        tabla[5][Col.GOLES_FAVOR] = mensajero[34];
        tabla[5][Col.GOLES_CONTRA] = mensajero[35];
        // tabla[5][Columnas.GOLES_DIFERENCIA] = "-7";

        // Septimo equipo
        tabla[6][Col.NOMBRE] = mensajero[36];
        tabla[6][Col.GANADOS] = mensajero[37];
        tabla[6][Col.EMPATES] = mensajero[38];
        tabla[6][Col.PERDIDOS] = mensajero[39];
        tabla[6][Col.GOLES_FAVOR] = mensajero[40];
        tabla[6][Col.GOLES_CONTRA] = mensajero[41];
        // tabla[6][Columnas.GOLES_DIFERENCIA] = "14";

        // Octavo equipo
        tabla[7][Col.NOMBRE] = mensajero[42];
        tabla[7][Col.GANADOS] = mensajero[43];
        tabla[7][Col.EMPATES] = mensajero[44];
        tabla[7][Col.PERDIDOS] = mensajero[45];
        tabla[7][Col.GOLES_FAVOR] = mensajero[46];
        tabla[7][Col.GOLES_CONTRA] = mensajero[47];
        // tabla[7][Columnas.GOLES_DIFERENCIA] = "-11";

        // Noveno equipo
        tabla[8][Col.NOMBRE] = mensajero[48];
        tabla[8][Col.GANADOS] = mensajero[49];
        tabla[8][Col.EMPATES] = mensajero[50];
        tabla[8][Col.PERDIDOS] = mensajero[51];
        tabla[8][Col.GOLES_FAVOR] = mensajero[52];
        tabla[8][Col.GOLES_CONTRA] = mensajero[53];
        // tabla[8][Columnas.GOLES_DIFERENCIA] = "5";

        // Decimo equipo
        tabla[9][Col.NOMBRE] = mensajero[54];
        tabla[9][Col.GANADOS] = mensajero[55];
        tabla[9][Col.EMPATES] = mensajero[56];
        tabla[9][Col.PERDIDOS] = mensajero[57];
        tabla[9][Col.GOLES_FAVOR] = mensajero[58];
        tabla[9][Col.GOLES_CONTRA] = mensajero[59];
        // tabla[9][Columnas.GOLES_DIFERENCIA] = "-2";

        // Onceavo equipo
        tabla[10][Col.NOMBRE] = mensajero[60];
        tabla[10][Col.GANADOS] = mensajero[61];
        tabla[10][Col.EMPATES] = mensajero[62];
        tabla[10][Col.PERDIDOS] = mensajero[63];
        tabla[10][Col.GOLES_FAVOR] = mensajero[64];
        tabla[10][Col.GOLES_CONTRA] = mensajero[65];
        // tabla[10][Columnas.GOLES_DIFERENCIA] = "-7";

        // Doceavo equipo
        tabla[11][Col.NOMBRE] = mensajero[66];
        tabla[11][Col.GANADOS] = mensajero[67];
        tabla[11][Col.EMPATES] = mensajero[68];
        tabla[11][Col.PERDIDOS] = mensajero[9];
        tabla[11][Col.GOLES_FAVOR] = mensajero[70];
        tabla[11][Col.GOLES_CONTRA] = mensajero[71];
        // tabla[11][Columnas.GOLES_DIFERENCIA] = "-9";

        for (int i = 0; i < 12; i++) {
            tabla[i][Col.JUEGOS] = "24";

            // Calcular la diferencia de goles
            if (tabla[i][Col.GOLES_FAVOR] != null && tabla[i][Col.GOLES_CONTRA] != null) {
                int golesFavor = Integer.parseInt(tabla[i][Col.GOLES_FAVOR]);
                int golesContra = Integer.parseInt(tabla[i][Col.GOLES_CONTRA]);

                int diferenciaGoles = golesFavor - golesContra;

                tabla[i][Col.GOLES_DIFERENCIA] = String.valueOf(diferenciaGoles);
            }

            // Calcular puntos
            if (tabla[i][Col.GANADOS] != null && tabla[i][Col.EMPATES] != null
                    && tabla[i][Col.PERDIDOS] != null) {

                int ptsGanados = Integer.parseInt(tabla[i][Col.GANADOS]) * 3;
                int ptsEmpates = Integer.parseInt(tabla[i][Col.EMPATES]);

                tabla[i][Col.PUNTOS] = String.valueOf(ptsGanados + ptsEmpates);

            }

        }
    }

    public static void imprimirTabla() {

        System.out.println("Pos Club                J   Pts   G   E   P   GF   GC   DG");
        for (int i = 0; i < FILAS; i++) {
            System.out.print((i+1)+".  ");
            for (int j = 0; j < COLUMNAS; j++) {
                if (tabla[i][j] != null){
                    System.out.print(tabla[i][j] + "   ");
                }    
            }
            System.out.println();
        }
    }
    

    public static void guardarArray(){
        
        JSONArray equipos = new JSONArray();
        for(int i=0; i<12;i++){
            equipos.add((i+1) +". ");
            equipos.add(tabla[i][Col.NOMBRE]);
            equipos.add(tabla[i][Col.JUEGOS]);
            equipos.add(tabla[i][Col.PUNTOS]);
            equipos.add(tabla[i][Col.GANADOS]);
            equipos.add(tabla[i][Col.EMPATES]);
            equipos.add(tabla[i][Col.PERDIDOS]);
            equipos.add(tabla[i][Col.GOLES_FAVOR]);
            equipos.add(tabla[i][Col.GOLES_CONTRA]);
            equipos.add(tabla[i][Col.GOLES_DIFERENCIA]);
            
        }
        
        try(FileWriter file = new FileWriter("Equipos.json")){
            file.write(equipos.toJSONString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }

}
