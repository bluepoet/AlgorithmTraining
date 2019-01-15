package net.bluepoet.algorithm.leetcode;

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
	public static void main(String[] args) {
		String s = "abc";
		int k = 2;


		if (s.length() < 2 * k) {
			System.out.println(s.chars().collect(StringBuilder::new, (b, c) -> b.insert(0, (char) c), (b1, b2) -> b1.insert(0, b2)).toString());
		}
	}
}
