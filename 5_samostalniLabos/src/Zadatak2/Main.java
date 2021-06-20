package Zadatak2;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws Exception {
		Iterator<Integer> iterator = new FactorialIterator(10);
		while (iterator.hasNext())
			System.out.println(iterator.next());

	}

}
