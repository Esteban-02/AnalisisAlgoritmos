package com.analisis;

import java.io.IOException;
import java.util.ArrayList;

public class NaivOnArray {

	public static void NaivOnArray(int[][] A, int[][] B, int[][] Result, int N, int P, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Result[i][j] = 0;
				for (int k = 0; k < P; k++) {
					Result[i][j] += A[i][k]*B[k][j];
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(obtenerTiempos());
	}

	public static ArrayList<Long> obtenerTiempos(){
		long t = 0;
		ArrayList<int[][]> matriz = new ArrayList<int[][]>();
		ArrayList<Long> tiempos = new ArrayList<>();
		try {
			matriz = LectorMatrices.Matrices();
		} catch (IOException e) {
			e.printStackTrace();
		}

		

		for (int i = 0; i < matriz.size(); i++) {
			int[][] result = new int [matriz.get(i).length][matriz.get(i)[0].length] ;
			
			long inicioEjecucion = System.nanoTime();
			NaivOnArray(matriz.get(i), matriz.get(i), result, matriz.get(i).length, matriz.get(i)[0].length, matriz.get(i)[0].length);
			long finEjecucion = System.nanoTime();
			t=finEjecucion-inicioEjecucion;
			tiempos.add(t);
		}
		return tiempos;
	}
	
	public static void imprimirMatriz(int[][] A){
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				System.out.print(A[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
