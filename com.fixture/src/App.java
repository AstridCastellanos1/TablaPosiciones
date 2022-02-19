public final class App {
    private App() {
    }

    static final int FILAS = 12;
    static final int COLUMNAS = 10;
    static String[][] tabla = new String[FILAS][COLUMNAS];

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        llenarTabla();
        //imprimirTabla();
        ordenPorPuntos();
        imprimirTabla();
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
        

        // Primer equipo.
        tabla[0][Col.NOMBRE] = "Antigua GFC";
        tabla[0][Col.GANADOS] = "15";
        tabla[0][Col.EMPATES] = "5";
        tabla[0][Col.PERDIDOS] = "4";
        tabla[0][Col.GOLES_FAVOR] = "37";
        tabla[0][Col.GOLES_CONTRA] = "12";
        // tabla[0][Columnas.GOLES_DIFERENCIA] = "25";

        // Segundo equipo
        tabla[1][Col.NOMBRE] = "Achuapa";
        tabla[1][Col.GANADOS] = "3";
        tabla[1][Col.EMPATES] = "7";
        tabla[1][Col.PERDIDOS] = "14";
        tabla[1][Col.GOLES_FAVOR] = "11";
        tabla[1][Col.GOLES_CONTRA] = "28";
        // tabla[1][Columnas.GOLES_DIFERENCIA] = "-11";

        // Tercer equipo
        tabla[2][Col.NOMBRE] = "Comunicaciones";
        tabla[2][Col.GANADOS] = "14";
        tabla[2][Col.EMPATES] = "5";
        tabla[2][Col.PERDIDOS] = "5";
        tabla[2][Col.GOLES_FAVOR] = "44";
        tabla[2][Col.GOLES_CONTRA] = "21";
        // tabla[2][Columnas.GOLES_DIFERENCIA] = "23";

        // Cuarto equipo
        tabla[3][Col.NOMBRE] = "Nueva Concepcion";
        tabla[3][Col.GANADOS] = "4";
        tabla[3][Col.EMPATES] = "5";
        tabla[3][Col.PERDIDOS] = "15";
        tabla[3][Col.GOLES_FAVOR] = "15";
        tabla[3][Col.GOLES_CONTRA] = "46";
        // tabla[3][Columnas.GOLES_DIFERENCIA] = "-31";

        // Quinto equipo
        tabla[4][Col.NOMBRE] = "Municipal";
        tabla[4][Col.GANADOS] = "12";
        tabla[4][Col.EMPATES] = "7";
        tabla[4][Col.PERDIDOS] = "5";
        tabla[4][Col.GOLES_FAVOR] = "32";
        tabla[4][Col.GOLES_CONTRA] = "15";
        // tabla[4][Columnas.GOLES_DIFERENCIA] = "17";

        // Sexto equipo
        tabla[5][Col.NOMBRE] = "Coban Imperial";
        tabla[5][Col.GANADOS] = "6";
        tabla[5][Col.EMPATES] = "6";
        tabla[5][Col.PERDIDOS] = "12";
        tabla[5][Col.GOLES_FAVOR] = "24";
        tabla[5][Col.GOLES_CONTRA] = "31";
        // tabla[5][Columnas.GOLES_DIFERENCIA] = "-7";

        // Septimo equipo
        tabla[6][Col.NOMBRE] = "Malacateco";
        tabla[6][Col.GANADOS] = "11";
        tabla[6][Col.EMPATES] = "7";
        tabla[6][Col.PERDIDOS] = "6";
        tabla[6][Col.GOLES_FAVOR] = "40";
        tabla[6][Col.GOLES_CONTRA] = "26";
        // tabla[6][Columnas.GOLES_DIFERENCIA] = "14";

        // Octavo equipo
        tabla[7][Col.NOMBRE] = "Solola";
        tabla[7][Col.GANADOS] = "6";
        tabla[7][Col.EMPATES] = "9";
        tabla[7][Col.PERDIDOS] = "9";
        tabla[7][Col.GOLES_FAVOR] = "23";
        tabla[7][Col.GOLES_CONTRA] = "34";
        // tabla[7][Columnas.GOLES_DIFERENCIA] = "-11";

        // Noveno equipo
        tabla[8][Col.NOMBRE] = "Santa Lucia";
        tabla[8][Col.GANADOS] = "9";
        tabla[8][Col.EMPATES] = "12";
        tabla[8][Col.PERDIDOS] = "3";
        tabla[8][Col.GOLES_FAVOR] = "30";
        tabla[8][Col.GOLES_CONTRA] = "24";
        // tabla[8][Columnas.GOLES_DIFERENCIA] = "5";

        // Decimo equipo
        tabla[9][Col.NOMBRE] = "Guastatoya";
        tabla[9][Col.GANADOS] = "6";
        tabla[9][Col.EMPATES] = "9";
        tabla[9][Col.PERDIDOS] = "9";
        tabla[9][Col.GOLES_FAVOR] = "20";
        tabla[9][Col.GOLES_CONTRA] = "22";
        // tabla[9][Columnas.GOLES_DIFERENCIA] = "-2";

        // Onceavo equipo
        tabla[10][Col.NOMBRE] = "Xelaju MC";
        tabla[10][Col.GANADOS] = "8";
        tabla[10][Col.EMPATES] = "7";
        tabla[10][Col.PERDIDOS] = "9";
        tabla[10][Col.GOLES_FAVOR] = "18";
        tabla[10][Col.GOLES_CONTRA] = "25";
        // tabla[10][Columnas.GOLES_DIFERENCIA] = "-7";

        // Doceavo equipo
        tabla[11][Col.NOMBRE] = "Iztapa";
        tabla[11][Col.GANADOS] = "8";
        tabla[11][Col.EMPATES] = "5";
        tabla[11][Col.PERDIDOS] = "11";
        tabla[11][Col.GOLES_FAVOR] = "32";
        tabla[11][Col.GOLES_CONTRA] = "41";
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
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (tabla[i][j] != null)
                    System.out.print(tabla[i][j] + " ");
            }
            System.out.println();
        }
    }
}
