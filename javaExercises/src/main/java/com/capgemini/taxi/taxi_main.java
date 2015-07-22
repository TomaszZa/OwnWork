package com.capgemini.taxi;
import java.util.Random;
// polozenie uzytkownika oraz taxowek jest opisane we wspolzednych x-y
// program jest odswierzany co minute(zmienia sie polozenie symulowanych taxowek)
// wyswietla po 5 taxowek

class taxi_main {
	public static void main(String args[]){
		Wyszukanie_tax taxy = new Wyszukanie_tax(); //tworzenie obiektu klasy taxowki_polozenie
		for(;;){
			taxy.wyswietl_tax();  //wyswietlanie informacji o taxowkach
			try{                                             //*
				Thread.sleep(60000);    //60000 ms = 1min (podajemy w ms)
			}catch(InterruptedException exc){               // Opoznienie okolo 1 min
				System.out.println("Blad opoznienia.");     //*
			}
			
		}
	}

}
