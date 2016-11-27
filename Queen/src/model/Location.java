package model;

public class Location {
	private int col;
	private int pols;
	Location(int c,int p){
		this.pols=p;
		this.col=c;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getPols() {
		return pols;
	}
	public void setPols(int pols) {
		this.pols = pols;
	}
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Location)){
			return false;
		}
		Location next=(Location)o;
		if(next.col==this.col&&next.pols==this.pols){
			return true;
		}
		return false;
		
	}
	
}
