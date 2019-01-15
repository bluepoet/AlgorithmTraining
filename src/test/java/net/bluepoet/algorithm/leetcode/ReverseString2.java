package net.bluepoet.algorithm.leetcode;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

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

		return null;
	}
}
