package com.analisis;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Generar {

	public static void main(String[] args) {
		generarMatrices();
    }

	private static void generarMatrices() {
		try {
			ArrayList<File> archivos = new ArrayList<File>();
			for (int i = 0; i<8;i++) {

			archivos.add( new File("C:/Users/asus/Documents/Matrices/matriz" + i + ".txt"));
			}
			
			for (int k = 0; k<8	;k++) {
				PrintWriter writer = new PrintWriter(archivos.get(k));
				int elevado=2;
				int t1= (int) Math.pow(elevado, k+1);

				int[][] m1 = new int[t1][t1];

				Random random = new Random(); // inicializar generador de n�meros aleatorios

				for (int i = 0; i < m1.length; i++) {
					for (int j = 0; j < m1[i].length; j++) {
						int valor = random.nextInt(9000000) + 1000; // generar valor aleatorio entre 1000 y 9999
						if(j < m1[i].length - 1) {
							writer.print((m1[i][j] = valor) + ",");
						}else {
							writer.print((m1[i][j] = valor));
						}
					}
					writer.println();
				}
				writer.close();
				System.out.println("Matriz guardada en el archivo " + archivos.get(k).getName());
			}} catch (IOException e) {
				System.err.println("Error al escribir en el archivo: " + e.getMessage());
			}
		}
}