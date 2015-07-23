import java.io.*;
class zad8roz10 {
	public static void main(String args[]){
		int znak;
		try{
			File plik = new File("pierwszy.txt");
			File plik1 = new File("drugi.txt");
			plik.createNewFile();
			plik1.createNewFile();
		}catch(IOException exc){
			System.out.println("Blad tworzenia pliku: "+ exc);
		}
		
		try(FileWriter plik_zapis = new FileWriter ("drugi.txt");
				BufferedReader plik_odczyt = new BufferedReader(new FileReader("pierwszy.txt"))){
			do{
			znak = plik_odczyt.read();
			if(znak == ' ') znak = '-';
			if(znak != -1) plik_zapis.write(znak);
			}while(znak != -1);
		}catch(IOException exc){
			System.out.println("Blad wejscia-wyjscia: "+ exc);
		}
		
	
	}
}
