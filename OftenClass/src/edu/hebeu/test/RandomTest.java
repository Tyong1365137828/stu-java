package edu.hebeu.test;

import edu.hebeu.sources.*;
public class RandomTest {

	public static void main(String[] args) {
		RandomStu randomStu = new RandomStu();
		
		int[] array = randomStu.getRandomNumbers(10, 0, 10);
		
		System.out.print("[");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if(i == array.length - 1) {
				System.out.print("]");
			} else {
				System.out.print(", ");
			}
		}
	}

}
