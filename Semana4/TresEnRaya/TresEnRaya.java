package TresEnRaya;

import java.util.Scanner;

public class TresEnRaya {
    public static void main(String[] args) {
        char[][] tablero = new char[3][3];
        Scanner sc = new Scanner(System.in);
        boolean finJuego = false;
        boolean turnoJugador = true;
        int fila;
        int columna;

        inicializarTablero(tablero);
        do{
            dibujarTablero(tablero);
            if (turnoJugador) {
                System.out.println("Es tu turno (X)");
                do {
                    System.out.print("Fila (1-3): ");
                    fila = sc.nextInt() - 1;
                    System.out.print("Columna (1-3): ");
                    columna = sc.nextInt() - 1;
                } while (!movimientoValido(tablero, fila, columna));
                tablero[fila][columna] = 'X';
                if (comprobarGanador(tablero, 'X')) {
                    dibujarTablero(tablero);
                    System.out.println("¡Has ganado!");
                    finJuego = true;
                }
                turnoJugador = false;
            } else {
                System.out.println("Turno de la máquina (O)");
                do {
                    //turnoDeLaMaquina(); Poda alfa-beta
                    fila = (int) (Math.random() * 3);
                    columna = (int) (Math.random() * 3);
                } while (!movimientoValido(tablero, fila, columna));
                tablero[fila][columna] = 'O';
                if (comprobarGanador(tablero, 'O')) {
                    dibujarTablero(tablero);
                    System.out.println("¡Has perdido!");
                    finJuego = true;
                }
                turnoJugador = true;
            }
            if (!hayMovimientosPosibles(tablero)) {
                dibujarTablero(tablero);
                System.out.println("¡Empate!");
                finJuego = true;
            }
        }while (!finJuego);
        //if (comprobarGanador)
    }

    public static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j  = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '~';
            }
        }
    }

    public static void dibujarTablero(char[][] tablero) {
        System.out.println("  1 2 3");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean movimientoValido(char[][] tablero, int fila, int columna) {
        if (fila < 0 || fila >= tablero.length || columna < 0 || columna >= tablero[fila].length) {
            System.out.println("Error. Ficha fuera del tablero.");
            System.out.println();
            return false;
        } else if (tablero[fila][columna] != '~') {
            System.out.println("Error. La casilla ya está ocupada.");
            System.out.println();
            return false;
        } else {
            return true;
        }
    }

    public static void turnoDeLaMaquina(char[][] tablero) {
        boolean seguirComprobando = true;
        int cont = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j  = 0; j < tablero[0].length; j++) {
                // PARA FACILITAR LA BUSQUEDA D FILAS COLUMNAS Y DIAGONEALES PUEDO PONERLES DE ID 1, 2, 3, 4, 5, 6, 7.
                // PONER EN METODOS LO DE ABAJO  Y OTRO METODO PARA CUANDO ME DE LA FILA COLUMNA... BUENA, QUE ME DIGA LA CASILLA VACIA DE ESA.
                
                // COMPROBAR LAS X DE LAS FILA
                if (tablero[i][j] == 'X') {
                    cont++;
                    if (cont == 2) {
                        seguirComprobando = false;
                        //MIRO DONDE ESTAN LAS 'X'
                    }
                }
                // COMPROBAR LAS X DE LAS COLUMNAS
                if (tablero[j][i] == 'X' && seguirComprobando) {
                    cont++;
                    if (cont == 2) {
                        seguirComprobando = false;
                        //MIRO DONDE ESTAN LAS 'X'
                    }
                }
                // COMPROBAR LAS X DE LA DIAGONAL PRINCIPAL
                if (tablero[j][i] == 'X' && seguirComprobando) {
                    cont++;
                    if (cont == 2) {
                        seguirComprobando = false;
                        //MIRO DONDE ESTAN LAS 'X'
                    }
                }
                // COMPROBAR LAS X DE LA DIAGONAL SECUNDARIA
                if (tablero[j][i] == 'X' && seguirComprobando) {
                    cont++;
                    if (cont == 2) {
                        seguirComprobando = false;
                        //MIRO DONDE ESTAN LAS 'X'
                    }
                }
            }
            cont = 0;
        }
    }

    /*public static int comprobarGanador(char[][] tablero) {
        if comprobarGanador("x")
        return 1;
        else if comprobarGanador("0")
        return -1;
        else
            return 0;
    }*/


        public static boolean comprobarGanador(char[][] tablero, char ficha) {
        // COMPROBAR FILA
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][0] == ficha && tablero[i][1] == ficha && tablero[i][2] == ficha) {
                return true;
            }
        }
        // COMPROBAR COLUMNA
        for (int j = 0; j < tablero[0].length; j++) {
            if (tablero[0][j] == ficha && tablero[1][j] == ficha && tablero[2][j] == ficha) {
                return true;
            }
        }
        // COMPROBAR DIAGONAL PRINCIPAL
        if (tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha) {
            return true;
        }
        // COMPROBAR DIAGONAL SECUNDARIA
        if (tablero[0][2] == ficha && tablero[1][1] == ficha && tablero[2][0] == ficha) {
            return true;
        }
        return false;
    }

    public static boolean hayMovimientosPosibles(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == '~') {
                    return true;
                }
            }
        }
        return false;
    }
}