package com.analisis;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LectorMatrices {


	public static ArrayList<int[][]> generarMatrices() throws IOException{
		ArrayList<File> archivos = new ArrayList<File>();
		for (int i = 0; i <8; i++) {
			File archivo = new File ("C:/Users/asus/Documents/Matrices/matriz" + i + ".txt");

			archivos.add(archivo);
		}

		ArrayList<Scanner> scanner = new ArrayList<Scanner>();

		for (int i = 0; i <8; i++) {

			scanner.add(new Scanner(archivos.get(i)));
		}

		ArrayList<int[][]> matriz = new ArrayList<int[][]>();
		for (int i = 0; i <8; i++) {
			while (scanner.get(i).hasNextLine()) {
				String linea = scanner.get(i).nextLine();
				if (linea.startsWith("M" + i)) {
					matriz.add(leerMatriz(scanner.get(i)));
				}
			}

			scanner.get(i).close();
		}
		return matriz;
	}

	public static ArrayList<int[][]> Matrices() throws IOException{
		ArrayList<File> archivos = new ArrayList<File>();
		ArrayList<int[][]> matrices = new ArrayList<int[][]>();
		for (int i = 0; i <8; i++) {
			File archivo = new File("C:/Users/asus/Documents/Matrices/matriz" + i + ".txt");
			archivos.add(archivo);
		}

		for (int i = 0; i < 8; i++) {
			matrices.add(leerMatriz(new Scanner(archivos.get(i))));
		}

		return matrices;
	}

	public static int[][] leerMatriz(Scanner scanner) {
			ArrayList<int[]> filas = new ArrayList<>();

			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();

				if (linea.isEmpty()) {
					break;
				}

				String[] valores = linea.split(",");
				int[] fila = new int[valores.length];

				for (int i = 0; i < valores.length; i++) {
					fila[i] = Integer.parseInt(valores[i]);
				}

				filas.add(fila);
			}

			int[][] matriz = new int[filas.size()][filas.get(0).length];

			for (int i = 0; i < matriz.length; i++) {
				matriz[i] = filas.get(i);
			}
			return matriz;
		}
}