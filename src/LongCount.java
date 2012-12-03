
public class LongCount {
	private int baktuns;	//20 - 144000
	private int katuns;		//20 - 7200
	private int tuns;		//18 - 360
	private int winals;		//20 - 20
	private int kin;		//1  - 1
	
	public LongCount(int bak, int kat, int tun, int win, int ki)
	{
		baktuns = bak;
		katuns = kat;
		tuns = tun;
		winals = win;
		kin = ki;
	}
	
	public int subtractDates(LongCount lc)
	{
		return Math.abs(this.convertLongCountToDays() - lc.convertLongCountToDays());
	}
	
	public LongCount addToDate(int days)
	{
		return convertDaysToLongCount(days + this.convertLongCountToDays());
	}
	
	public LongCount subtractFromDate(int days)
	{
		return convertDaysToLongCount(this.convertLongCountToDays() - days);
	}
	
	public boolean equals(LongCount lc)
	{
		return (this.baktuns == lc.baktuns
				&& this.katuns == lc.katuns
				&& this.tuns == lc.tuns
				&& this.winals == lc.winals
				&& this.kin == lc.kin);
	}
	
	public int convertLongCountToDays()
	{
		return (baktuns * 144000 + katuns * 7200 + tuns * 360 + winals * 20 + kin);
	}
	
	public LongCount convertDaysToLongCount(int days)
	{
		int nextKin = days % 20;
		days -= days % 20;
		
		int nextWinals = (days % 360) / 20;
		days -= days % 360;
		
		int nextTuns = (days % 7200) / 360;
		days -= days % 7200;
		
		int nextKatuns = (days % 144000) / 7200;
		days -= days % 144000;
		
		int nextBaktuns = days / 144000;
		
		return new LongCount(nextBaktuns, nextKatuns, nextTuns, nextWinals, nextKin);
	}
	
	public int getBaktuns() {
		return baktuns;
	}
	
	public int getKatuns() {
		return katuns;
	}
	
	public int getTuns() {
		return tuns;
	}
	
	public int getWinals() {
		return winals;
	}
	
	public int getKin() {
		return kin;
	}
}