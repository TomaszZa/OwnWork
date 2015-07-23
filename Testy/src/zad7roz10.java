import java.io.*;
class zad7roz10 {
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
		FileInputStream plik_odczytywany = null;
		FileOutputStream plik_zapisu = null;
		try{
			plik_odczytywany = new FileInputStream("pierwszy.txt");
			plik_zapisu = new FileOutputStream("drugi.txt");
			do{
				znak = plik_odczytywany.read();
				if((char)znak == ' ') znak = '-';
				if(znak != -1) plik_zapisu.write(znak);
			}while(znak != -1);
			
		}catch(IOException exc){
			System.out.println("Blad I/O");
		}
		finally{
			try{
			plik_odczytywany.close();
			plik_zapisu.close();
			}catch(IOException exc){
				System.out.println("Blad zamykania pliku !"+ exc);
			}
		}
	}
}
