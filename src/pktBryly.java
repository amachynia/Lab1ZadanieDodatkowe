
public class pktBryly {
	private int m; //masa
	private int x; //wspó³rzêdne
	private int y;
	private int z;
	
	public pktBryly(int m, int x, int y, int z){ //konstruktor z parametrami
		if(m>0)
		{
			this.m=m;
			this.x=x;
			this.y=y;
			this.z=z;
		}else{
			System.out.println("Masa musi byc wieksza od zera, wyst¹pi b³¹d");
		}
	}
	
	public int getMasa(){ //akcesor
		return m;
	}
	public int getX(){ //akcesor
		return x;
	}
	public int getY(){ //akcesor
		return y;
	}
	public int getZ(){ //akcesor
		return z;
	}
}
