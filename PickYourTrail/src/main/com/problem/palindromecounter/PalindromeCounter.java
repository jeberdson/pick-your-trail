package main.com.problem.palindromecounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromeCounter {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();

		List<String> subStringList = new ArrayList<>();

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				subStringList.add(str.substring(i, j));
			}
		}
		scanner.close();
		int palindromeCount = getPalidromeCount(subStringList);

		System.out.println(palindromeCount);
	}

	private static int getPalidromeCount(List<String> subStringList) {

		int palindromeCount = 0;

		String actualString = "";

		for (int index = 0; index < subStringList.size(); index++) {
			actualString = subStringList.get(index);
			int n = actualString.length();
			String reversedString = "";
			for (int i = n - 1; i >= 0; i--) {
				reversedString = reversedString + actualString.charAt(i);
			}
			if (actualString.equalsIgnoreCase(reversedString)) {
				palindromeCount++;
			}
		}

		return palindromeCount;
	}
}