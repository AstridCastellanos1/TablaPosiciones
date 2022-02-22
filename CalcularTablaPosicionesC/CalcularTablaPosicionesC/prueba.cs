using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CalcularTablaPosicionesC
{
    internal class prueba
    {
        String[,] eq = new String[12, 10];
        String[] name = new String[12];
        int[] J = new int[12];
        int[] Pts = new int[12];
        int[] G = new int[12];
        int[] E = new int[12];
        int[] P = new int[12];
        int[] GF = new int[12];
        int[] GC = new int[12];
        int[] DG = new int[12];
        public String[,] ordenar(String[,] clubs)
        {
            for (int i = 0; i < J.Length; i++)
            {
                name[i] = clubs[i, 1];
                J[i] = Convert.ToInt32(clubs[i, 2]);
                Pts[i] = Convert.ToInt32(clubs[i, 3]);
                G[i] = Convert.ToInt32(clubs[i, 4]);
                E[i] = Convert.ToInt32(clubs[i, 5]);
                P[i] = Convert.ToInt32(clubs[i, 6]);
                GF[i] = Convert.ToInt32(clubs[i, 7]);
                GC[i] = Convert.ToInt32(clubs[i, 8]);
                DG[i] = Convert.ToInt32(clubs[i, 9]);
            }

            int Jor, Puntos, Gan, Emp, Per, GolF, GolC, DifG;
            String nombre;
            for (int i = 0; i < (J.Length - 1); i++)
            {
                for (int j = 0; j < (J.Length - 1); j++)
                {
                    if (Pts[j] < Pts[j + 1])
                    {
                        Puntos = Pts[j];
                        nombre = name[j];
                        Jor = J[j];
                        Gan = G[j];
                        Emp = E[j];
                        Per = P[j];
                        GolF = GF[j];
                        GolC = GC[j];
                        DifG = DG[j];
                        Pts[j] = Pts[j + 1];
                        name[j] = name[j + 1];
                        J[j] = J[j + 1];
                        G[j] = G[j + 1];
                        E[j] = E[j + 1];
                        P[j] = P[j + 1];
                        GF[j] = GF[j + 1];
                        GC[j] = GC[j + 1];
                        DG[j] = DG[j + 1];
                        Pts[j + 1] = Puntos;
                        name[j + 1] = nombre;
                        J[j + 1] = Jor;
                        G[j + 1] = Gan;
                        E[j + 1] = Emp;
                        P[j + 1] = Per;
                        GF[j + 1] = GolF;
                        GC[j + 1] = GolC;
                        DG[j + 1] = DifG;

                        if (DG[j] < DG[j + 1])
                        {
                            Puntos = Pts[j];
                            nombre = name[j];
                            Jor = J[j];
                            Gan = G[j];
                            Emp = E[j];
                            Per = P[j];
                            GolF = GF[j];
                            GolC = GC[j];
                            DifG = DG[j];
                            Pts[j] = Pts[j + 1];
                            name[j] = name[j + 1];
                            J[j] = J[j + 1];
                            G[j] = G[j + 1];
                            E[j] = E[j + 1];
                            P[j] = P[j + 1];
                            GF[j] = GF[j + 1];
                            GC[j] = GC[j + 1];
                            DG[j] = DG[j + 1];
                            Pts[j + 1] = Puntos;
                            name[j + 1] = nombre;
                            J[j + 1] = Jor;
                            G[j + 1] = Gan;
                            E[j + 1] = Emp;
                            P[j + 1] = Per;
                            GF[j + 1] = GolF;
                            GC[j + 1] = GolC;
                            DG[j + 1] = DifG;


                            if (GF[j] < GF[j + 1])
                            {
                                Puntos = Pts[j];
                                nombre = name[j];
                                Jor = J[j];
                                Gan = G[j];
                                Emp = E[j];
                                Per = P[j];
                                GolF = GF[j];
                                GolC = GC[j];
                                DifG = DG[j];
                                Pts[j] = Pts[j + 1];
                                name[j] = name[j + 1];
                                J[j] = J[j + 1];
                                G[j] = G[j + 1];
                                E[j] = E[j + 1];
                                P[j] = P[j + 1];
                                GF[j] = GF[j + 1];
                                GC[j] = GC[j + 1];
                                DG[j] = DG[j + 1];
                                Pts[j + 1] = Puntos;
                                name[j + 1] = nombre;
                                J[j + 1] = Jor;
                                G[j + 1] = Gan;
                                E[j + 1] = Emp;
                                P[j + 1] = Per;
                                GF[j + 1] = GolF;
                                GC[j + 1] = GolC;
                                DG[j + 1] = DifG;


                            }
                        }
                    }
                }
            }
            for (int j = 0; j < clubs.GetLength(0); j++)
            {

                eq[j, 0] = (j + 1) + "";
                eq[j, 1] = name[j];
                eq[j, 2] = J[j] + "";
                eq[j, 3] = Pts[j] + "";
                eq[j, 4] = G[j] + "";
                eq[j, 5] = E[j] + "";
                eq[j, 6] = P[j] + "";
                eq[j, 7] = GF[j] + "";
                eq[j, 8] = GC[j] + "";
                eq[j, 9] = DG[j] + "";
            }

            return eq;

        }
    }
}
