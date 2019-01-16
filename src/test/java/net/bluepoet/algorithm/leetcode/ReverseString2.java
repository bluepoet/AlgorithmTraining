package net.bluepoet.algorithm.leetcode;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reverse-string-ii/
 * Created by bluepoet on 2019-01-08.
 * 규칙
 * 1. 스트링의 시작부터 매번 2k마다 첫 문자를 뒤집어라
 * 2. 남은 문자들이 k보다 작으면 모두 뒤집어라
 * 3. 만약 2k보단 작고 k보다 크면, 첫번째 k를 뒤집고 나머지는 그대로 둬라.
 * example
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * "abcdefg" => "dcbaefg", 4
 */
public class ReverseString2 {
	@Test
	public void leftedCharsLessThanK() {
		// Given
		String s = "abc";
		int k = 4;

		// When
		String result = reverseString(s, k);

		// Then
		assertThat(result).isEqualTo("cba");
	}

	@Test
	public void leftedCharsThanKAndLessThen2K() {
		// Given
		String s = "abcdefg";
		int k = 4;

		// When
		String result = reverseString(s, k);

		// Then
		assertThat(result).isEqualTo("dcbaefg");
	}


	@Test
	public void case3() {
		// Given
		String s = "abcdefg";
		int k = 2;

		// When
		String result = reverseString(s, k);

		// Then
		assertThat(result).isEqualTo("bacdfeg");
	}

	@Test
	public void case4() {
		// Given
		String s = "ba";
		int k = 1;

		// When
		String result = reverse3(s, k);

		// Then
		assertThat(result).isEqualTo("ba");
	}

	private String reverseString(String s, int k) {
		StringBuilder sb = new StringBuilder();

		if (s.length() < k) {
			return sb.append(s).reverse().toString();
		}

		if (s.length() > k && s.length() < 2 * k) {
			for (int i = 0; i < s.length(); i++) {
				sb.append(s.charAt(i));

				if ((i + 1) == k) {
					sb.reverse();
				}
			}

			return sb.toString();
		}

		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));

			if((i + 1) == 2 * k) {
				sb.delete(0, 2);
				sb.insert(0, s.charAt(i-2));
				sb.insert(1, s.charAt(i-3));
			}

			if(i == s.length() -1) {
				sb.delete(4, 6);
				sb.insert(4, s.charAt(i-1));
				sb.insert(5, s.charAt(i-2));
			}
		}

		return sb.toString();
	}

	private String reverseStr(String s, int k) {
		StringBuilder sb = new StringBuilder();

		if (s.length() <= k) {
			for (int i = s.length() - 1; i >= 0; i--) {
				sb.append(Character.toString(s.charAt(i)));
			}

			return sb.toString();
		}

		int count = 0;
		List<String> l = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			l.add(Character.toString(s.charAt(i)));
			count++;

			if (count == 2 * k) {
				count = 0;
				swapListElements(l, sb, k);
				l.clear();
			}

			if (i == s.length() - 1 && count != 0) {
				swapListElements(l, sb, k);
			}
		}

		return sb.toString();
	}

	private void swapListElements(List<String> l, StringBuilder sb, int pos) {
		StringBuilder newStr = new StringBuilder();
		if(l.size() < pos) {
			l.stream().forEach(s -> sb.append(s));
		}else {
			for (int i = 0; i < l.size(); i++) {
				if ((i + 1) == pos) {
					String initStr = l.get(0);
					String temp = l.get(i);
					newStr.append(temp);

					for (int j = 1; j < l.size(); j++) {
						if ((j + 1) == pos) {
							newStr.append(initStr);
						} else {
							newStr.append(l.get(j));
						}
					}
					sb.append(newStr);
					break;
				}
			}
		}
	}

	private String reverse3(String s, int k) {
		char[] a = s.toCharArray();
		for (int start = 0; start < a.length; start += 2 * k) {
			int i = start, j = Math.min(start + k - 1, a.length - 1);
			while (i < j) {
				char tmp = a[i];
				a[i++] = a[j];
				a[j--] = tmp;
			}
		}
		return new String(a);
	}
}
