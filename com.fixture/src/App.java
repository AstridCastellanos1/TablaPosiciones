import java.io.FileWriter;

import java.io.IOException;

import org.json.simple.JSONArray;

public final class App {
    private App() {
    }

    static final int FILAS = 12;
    static final int COLUMNAS = 10;
    static String[][] tabla = new String[FILAS][COLUMNAS];
    static String[] mensajero = new String[72];

    public static void main(String[] args) {
        llenarTabla();
        ordenPorPuntos();
        imprimirTabla();
        guardarArray();

    }

    public static void ordenPorPuntos() {
        int a;
        int b;

        // Solo hay 3 equipos, ingresados, por eso solo es i < 3
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12 - i - 1; j++) {

                a = Integer.parseInt(tabla[j][Col.PUNTOS]);
                b = Integer.parseInt(tabla[j + 1][Col.PUNTOS]);

                if (a < b) {
                    // swap 2 filas
                    String[] filaTemporal = tabla[j];
                    tabla[j] = tabla[j + 1];
                    tabla[j + 1] = filaTemporal;

                }
            }
        }

    }

    public static void llenarTabla() {
        GuardarYLeer G = new GuardarYLeer();
        String nombre = "Info.json";
        G.Leer(nombre);

        String mensajero[] = G.devolver();


        int acum = 0;

        for (int i = 0; i < tabla.length; i++) {
            tabla[i][Col.NOMBRE] = mensajero[acum];
            acum++;
            tabla[i][Col.GANADOS] = mensajero[acum];
            acum++;
            tabla[i][Col.EMPATES] = mensajero[acum];
            acum++;
            tabla[i][Col.PERDIDOS] = mensajero[acum];
            acum++;
            tabla[i][Col.GOLES_FAVOR] = mensajero[acum];
            acum++;
            tabla[i][Col.GOLES_CONTRA] = mensajero[acum];
            acum++;
        }

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

        System.out.println("Pos  Club            J    Pts  G  E  P  GF  GC  DG");
        for (int i = 0; i < FILAS; i++) {
            System.out.print((i + 1) + ".  ");
            for (int j = 0; j < COLUMNAS; j++) {
                if (tabla[i][j] != null) {
                    System.out.print(tabla[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

    public static void guardarArray() {

        JSONArray equipos = new JSONArray();
        for (int i = 0; i < 12; i++) {
            equipos.add((i + 1) + ". ");
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

        try (FileWriter file = new FileWriter("Equipos.json")) {
            file.write(equipos.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
