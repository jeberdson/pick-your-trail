package main.com.problem.mudwalls;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MudWalls {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] stickPositions = new int[n];
		for (int i = 0; i < n; i++) {
			stickPositions[i] = scanner.nextInt();
		}
		n = scanner.nextInt();
		int[] stickHeights = new int[n];
		for (int i = 0; i < n; i++) {
			stickHeights[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.println(getMaxHeight(stickPositions, stickHeights));
	}

	public static int getMaxHeight(int[] stickPositions, int[] stickHeights) {
		int n = stickPositions.length;
		int max = 0;

		for (int i = 0; i < n - 1; i++) {
			if (stickPositions[i] < stickPositions[i + 1] - 1) {
				int heightDiff = Math.abs(stickHeights[i + 1] - stickHeights[i]);
				int gapLength = stickPositions[i + 1] - stickPositions[i] - 1;
				int localMax = 0;
				if (gapLength > heightDiff) {
					int low = Math.max(stickHeights[i + 1], stickHeights[i]) + 1;
					int remainingGap = gapLength - heightDiff - 1;
					localMax = low + remainingGap / 2;

				} else {
					localMax = Math.min(stickHeights[i + 1], stickHeights[i]) + gapLength;
				}

				max = Math.max(max, localMax);
			}
		}

		return max;
	}
}