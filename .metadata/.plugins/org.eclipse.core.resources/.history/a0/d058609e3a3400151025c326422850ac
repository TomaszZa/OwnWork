package com.capgemini.taxi;

import java.io.PrintWriter; //import klasy obslugi strumienia znakowego
import java.util.ArrayList; //importowanie bibliotek do list
import java.util.Date; //importowanie bibliotek z klasami daty
import java.util.List;

public class Wyszukanie_tax extends taxowki_polozenie { // klasa do wszukania i
														// wyswietlenia 5
														// wyselekcjonowanych
														// taxowek
	private final int SIZE_NEW = 5;
	private double tab_odl_tax_ws[] = new double[SIZE_NEW]; // tablice
															// wyselekcjonowanych
															// tablic
	private String nazwa_tax_ws[] = new String[SIZE_NEW];

	public Wyszukanie_tax() { // konstruktor klasy Wyszukanie_tax
		super();
	}

	private void wybor_tax() { // metoda wybierajaca 5 dostepnych taxowek w
								// odleglosci 1000 m
		List<Double> lista_totw = new ArrayList<Double>(); // utorzenie list
		List<String> lista_ntw = new ArrayList<String>();

		for (int i = 0; i < tab_odl_tax.length; i++) {
			if (tab_odl_tax[i] < 1000 && zaj_tax[i] == false) {
				lista_totw.add(tab_odl_tax[i]); // przepisywanie wartosci
												// spelniajacych wymagania z
												// tablic do list
				lista_ntw.add(nazwa_tax[i]);
			}
		}

		quicksort(lista_ntw, lista_totw, 0, lista_totw.size() - 1); // wywolanie
																	// sortowania

		for (int i = 0; i < SIZE_NEW; i++) { // wybranie 5 elementow od
												// najmniejszej odleglosci do
												// najwiekszej
			tab_odl_tax_ws[i] = lista_totw.get(i).doubleValue(); // wywolanie
																	// metody
																	// zamieniajacej
																	// klase
																	// opakowujaca
																	// Double na
																	// typ
																	// podstawowy
																	// double
			nazwa_tax_ws[i] = lista_ntw.get(i);
		}
	}

	private void quicksort(List<String> lista_ntw, List<Double> lista_totw, int left, int right) { // metoda
																									// qs
																									// sortujaca
																									// elementy
		int i, j;
		Double x, y;
		String z;
		i = left;
		j = right;
		x = lista_totw.get((left + right) / 2);
		do {
			while ((lista_totw.get(i) < x) && (i < right))
				i++;
			while ((x < lista_totw.get(j)) && (j > left))
				j--;
			if (i <= j) {
				y = lista_totw.get(i);
				z = lista_ntw.get(i);

				lista_totw.add(i, lista_totw.get(j)); // sortuje odleglosci
				lista_totw.remove(i + 1);
				lista_totw.add(j, y);
				lista_totw.remove(j + 1);

				lista_ntw.add(i, lista_ntw.get(j)); // sortuje nazwy odpowiednio
													// dla odleglosci
				lista_ntw.remove(i + 1);
				lista_ntw.add(j, z);
				lista_ntw.remove(j + 1);
				i++;
				j--;
			}
		} while (i <= j);
		if (left < j)
			quicksort(lista_ntw, lista_totw, left, j); // rekurencyjne
														// wywolywanie funkcji
		if (i < right)
			quicksort(lista_ntw, lista_totw, i, right);
	}

	public void wyswietl_tax() { // ? ma wywolywac obliczenia() a potem
									// wybor_tax() i wyswietlac tablice 5
									// elementow
		PrintWriter konsola = new PrintWriter(System.out, true); // inicjalizacja
																	// strumienia
																	// znakowego
																	// o nazwie
																	// konsola
		Date data = new Date();
		obliczenia();
		wybor_tax();
		konsola.println("Dostepne taxowki w promieniu 1 km( do 5 rekordow): ");
		konsola.println("Data i godzina(odswiezanie co 1 min): " + data.toString());
		for (int i = 0; i < SIZE_NEW; i++) {
			konsola.println("Taxowka: " + nazwa_tax_ws[i] + " Odleglosc: " + tab_odl_tax_ws[i] + " m.");
		}
	}
}
