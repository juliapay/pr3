package at.campus02.pr3.THREADS.Konto.positivMitLock;

public class Konto {
	private double wert;

	public Konto(double wert) {
		this.wert = wert;
	}
	
	public double getWert() {
		return this.wert;
	}

	public void setWert(double wert)  {
		this.wert = wert;
	}
	
	
}
