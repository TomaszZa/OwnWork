package testzqs;

import java.util.List;
import java.util.ArrayList;
class QS {
	public static void main(String args[]){
		quick kl = new quick();
		List<Double> lista_totw = new ArrayList<Double>();
		List<String> lista_ntw = new ArrayList<String>();
		lista_totw.add(1.0);
		lista_totw.add(3.0);
		lista_totw.add(5.0);
		lista_totw.add(2.0);
		lista_totw.add(4.0);
		lista_ntw.add("jeden");
		lista_ntw.add("trzy");
		lista_ntw.add("piec");
		lista_ntw.add("dwa");
		lista_ntw.add("cztery");
		System.out.println("Pierwotna lista: ");
		for(int i = 0; i<5; i++){
			System.out.println(lista_ntw.get(i)+"   "+lista_totw.get(i));
		}
		kl.quicksort(lista_ntw,lista_totw,0,lista_totw.size()-1);
		System.out.println("Posortowana lista: ");
		for(int i = 0; i<5; i++){
			System.out.println(lista_ntw.get(i)+"   "+lista_totw.get(i));
		}
	}
}

class quick{
void quicksort(List<String> lista_ntw, List<Double> lista_totw, int left, int right){ // metoda qs sortujaca elementy
	int i,j;
	Double x,y;
	String z;
	i = left;
	j = right;
	x = lista_totw.get((left+right)/2);
	do{
		while((lista_totw.get(i) < x) && (i < right)) i++;
		while((x < lista_totw.get(j)) && (j > left)) j--;
		if(i <= j){
			y = lista_totw.get(i);
			z = lista_ntw.get(i);
			
			
			lista_totw.add(i, lista_totw.get(j));  //sortuje odleglosci
			lista_totw.remove(i+1);
			lista_totw.add(j, y);
			lista_totw.remove(j+1);
			
			
			lista_ntw.add(i, lista_ntw.get(j));   //sortuje nazwy odpowiednio dla odleglosci
			lista_ntw.remove(i+1);
			lista_ntw.add(j, z);
			lista_ntw.remove(j+1);
			i++;j--;
		}
	}while(i <= j); 
	if(left < j) quicksort(lista_ntw,lista_totw,left,j);  //rekurencyjne wywolywanie funkcji
	if(i < right) quicksort(lista_ntw,lista_totw, i, right);
}
}