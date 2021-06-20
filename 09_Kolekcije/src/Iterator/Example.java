package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example {

	public static void main(String[] args) {

		List<String> lista = new ArrayList<>();

		lista.add("aaa");
		lista.add("bbb");
		lista.add("ccc");
		lista.add("ddd");
		lista.add("eee");
		lista.add("fff");

//		for (int i = 0; i < lista.size(); i++) {
//			System.out.println("Brišem element " + lista.get(i));
//			lista.remove(i);
//		}
		// Sa svaim removom dolazi do pomaka i promjene indexa
		// Zato sa ovom for petljom ne funkcionira brisanje
//		System.out.println(lista);

//		for (String s : lista) {
//			System.out.println("Brišem element " + s);
//			lista.remove(s);
//		}
		// Za vrijeme iteriranja ne mozemo brisati elemente

		Iterator<String> it = lista.iterator();
		// Sučelju Iterator pridruzujem implementirati iterator liste

		while (it.hasNext()) {
			String s = it.next();
			System.out.println("Brišem element " + s);
			it.remove();
		}

	}

}
