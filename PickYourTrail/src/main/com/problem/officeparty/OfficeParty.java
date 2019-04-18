package main.com.problem.officeparty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OfficeParty {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] cakeRadiusArray = new int[n];
		for (int i = 0; i < n; i++) {
			cakeRadiusArray[i] = scanner.nextInt();
		}
		int numberOfGuests = scanner.nextInt();
		scanner.close();
		double largestPiece = getLargestPiece(cakeRadiusArray, numberOfGuests);
		System.out.println(largestPiece);
	}

	// incomplete
	private static double getLargestPiece(int[] cakeRadiusArray, int numberOfGuests) {
		double pi = 3.14159265359;
		Arrays.sort(cakeRadiusArray);
		double largestCakeArea = 0;
		List<Integer> cakeRadiusList = new ArrayList<>();

		for (int radius : cakeRadiusArray) {
			cakeRadiusList.add(Integer.valueOf(radius));
		}

		int largestCakeRadius = getLargestCakeRadius(cakeRadiusArray);
		largestCakeArea = pi * largestCakeRadius * largestCakeRadius / numberOfGuests;

		return largestCakeArea;
	}

	private static int getLargestCakeRadius(int[] cakeRadiusArray) {
		return cakeRadiusArray[cakeRadiusArray.length - 1];

	}
}