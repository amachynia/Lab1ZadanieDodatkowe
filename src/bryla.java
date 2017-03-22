import java.util.Scanner;

public class bryla {
	

	private pktBryly[] tab;
	private double xS=0; //wspó³rzêdne punktu srodka masy 
	private double yS=0;
	private double zS=0;
	
	public bryla(){
		
		int ilosc; //ilosc pkt
	    Scanner wczytaj = new Scanner(System.in); //obiekt do odebrania danych od u¿ytkownika
	    System.out.println("Podaj ilosc punktow, a nastepnie mase i wspolrzedne kolejnych punktow w kolejnosci x, y, z");
	    ilosc = wczytaj.nextInt(); //Wczytanie ilosci punktow
	    //Wczytanie danych punktow
	    tab = new pktBryly[ilosc];
	    for (int i=0; i<ilosc; i++){
	    	pktBryly pkt = new pktBryly(wczytaj.nextInt(), wczytaj.nextInt(), wczytaj.nextInt(), wczytaj.nextInt());
	      	tab[i]=pkt;
	      }
	    System.out.println("Wczytano");
	}
	
	//Obliczanie wspó³rzêdnych œrodka masy, kolejno x,y,z.
	public void srodekX(){
		double licznik=0, mianownik=0, iloczyn;
		for(pktBryly a : tab){
	        iloczyn=a.getMasa()*a.getX();  
			licznik=licznik+iloczyn;
	        mianownik=mianownik+a.getMasa();
		}
		this.xS=licznik/mianownik;
	}
	
	public void srodekY(){
		double licznik=0, mianownik=0, iloczyn;
		for(pktBryly a : tab){
			iloczyn=a.getMasa()*a.getY();  
			licznik=licznik+iloczyn;
	        mianownik=mianownik+a.getMasa();
		}
		this.yS=licznik/mianownik;
	}
	
	public void srodekZ(){
		double licznik=0, mianownik=0, iloczyn;
		for(pktBryly a : tab){
			iloczyn=a.getMasa()*a.getZ();  
			licznik=licznik+iloczyn;
	        mianownik=mianownik+a.getMasa();
		}
		this.zS=licznik/mianownik;
	}
	
	//metoda wywo³uj¹ca obliczenie wszystkiech wspó³rzêdnych œrodka masy 
	public void srodekMasyLicz(){
		srodekX();
		srodekY();
		srodekZ();
	}
	
	//Wypisanie wspó³rzêdnych œrodka masy 
	public void srodekMasyWypisz(){
		srodekMasyLicz();
		System.out.println("Wspolrzedne srodka masy x=" + xS + " y=" + yS + " z=" + zS);
	}
	
	//Obliczanie momentów bezw³¹dnoœci kolejno wzglêdem osi równoleg³ych do osi x,y,z.
	public double momentX(){
		double r, iloczyn=0, moment=0;
		for(pktBryly a : tab){
			r=Math.sqrt(a.getY()*a.getY()+a.getZ()*a.getZ());
			iloczyn=a.getMasa()*r*r;  
			moment=moment+iloczyn;
		}
		return moment;
	}
	public double momentY(){
		double r, iloczyn=0, moment=0;
		for(pktBryly a : tab){
			r=Math.sqrt(a.getX()*a.getX()+a.getZ()*a.getZ());
			iloczyn=a.getMasa()*r*r;  
			moment=moment+iloczyn;
		}
		return moment;
	}
	public double momentZ(){
		double r, iloczyn=0, moment=0;
		for(pktBryly a : tab){
			r=Math.sqrt(a.getY()*a.getY()+a.getX()*a.getX());
			iloczyn=a.getMasa()*r*r;  
			moment=moment+iloczyn;
		}
		return moment;
	}
	
	//Wypisanie momentów bezw³adnoœci
	public void momentyWypisz(){
		System.out.println("Momenty bezwladnosci: x=" + momentX() + " y=" + momentY() + " z=" + momentZ());
	}
}
