package week24.weekwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class AsteroidCollision {

	@Test
	public void test1() {
		int[] asteroids = { 5, 10, -5 };
		System.out.println(Arrays.toString(findAsteroidState(asteroids)));
	}

	@Test
	public void test2() {
		int[] asteroids = { 8, -8 };
		System.out.println(Arrays.toString(findAsteroidState(asteroids)));
	}

	@Test
	public void test3() {
		int[] asteroids = { 10, 2, -5 };
		System.out.println(Arrays.toString(findAsteroidState(asteroids)));
	}

	@Test
	public void test4() {
		int[] asteroids = { -2, -1, 1, 2 };
		System.out.println(Arrays.toString(findAsteroidState(asteroids)));
	}

	@Test
	public void test5() {
		int[] asteroids = { -2, 2, -1, 1 };
		System.out.println(Arrays.toString(findAsteroidState(asteroids)));
	}

	private int[] findAsteroidState(int[] asteroids) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = asteroids.length - 1; i >= 0; i--) {
			if (asteroids[i] > 0) {
				int len = stack.size();
				if (stack.isEmpty() || stack.peek() > 0) {
					stack.push(asteroids[i]);
					continue;
				}

				int prev = asteroids[i];
				for (int j = 0; j < len; j++) {
					if(stack.peek()>0)
						break;
					int pop = stack.pop();
					if (prev < Math.abs(pop)) {
						stack.push(pop);
						prev = 0;
						break;
					} else if (prev == Math.abs(pop)) {
						prev = 0;
						break;
					}
				}
				if (prev != 0) {
					stack.push(prev);
					prev = 0;
				}
			} else {
				stack.push(asteroids[i]);
			}
		}

		int len = stack.size();
		int[] output = new int[len];

		for (int i = 0; i < len; i++)
			output[i] = stack.pop();

		return output;

	}

	private int[] findAsteroidState2(int[] asteroids) {
		if (asteroids.length < 2)
			return asteroids;

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(asteroids[asteroids.length - 1]);

		for (int i = asteroids.length - 2; i >= 0; i--) {
			if (stack.isEmpty())
				stack.push(asteroids[i--]);

			int lastSurvied = stack.pop();
			if (lastSurvied < 0 && asteroids[i] > 0) {
				if (Math.abs(lastSurvied) < asteroids[i]) {
					stack.push(asteroids[i]);
				} else if (Math.abs(lastSurvied) > asteroids[i]) {
					stack.push(lastSurvied);
				}
			} else {
				stack.push(lastSurvied);
				stack.push(asteroids[i]);
			}

		}

		int len = stack.size();
		int[] output = new int[len];

		for (int i = 0; i < len; i++)
			output[i] = stack.pop();

		return output;
	}

	private Object[] findAsteroidState1(int[] asteroids) {
		int left = asteroids.length - 1;
		int right = left - 1;
		List<Integer> list = new ArrayList<Integer>();
		while (left >= 0 && right >= 0) {
			if (asteroids[left] < 0 && asteroids[right] > 0) {
				if (Math.abs(asteroids[left]) < asteroids[right]) {
					list.add(asteroids[right]);
					left = right;
					right--;
				} else if (Math.abs(asteroids[left]) > asteroids[right]) {
					list.add(asteroids[left]);
					right--;
				} else {
					left -= 2;
					right -= 2;
				}
			} else {
				list.add(asteroids[left]);
				list.add(asteroids[right]);
				left -= 2;
				right -= 2;
			}
		}

		return list.toArray();
	}
}
