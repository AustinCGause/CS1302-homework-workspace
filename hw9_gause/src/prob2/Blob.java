package prob2;

public class Blob implements Comparable<Blob> {

	private int coolnessFactor;

	public Blob(int coolnessFactor) {
		this.coolnessFactor = coolnessFactor;
	}

	public int getCoolnessFactor() {
		return coolnessFactor;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Blob) {
			Blob b = (Blob)o;
			return this.coolnessFactor == b.coolnessFactor;
		}
		return false;
	}

	@Override
	public int compareTo(Blob b) {
		return this.coolnessFactor - b.coolnessFactor;
	}
	
	@Override
	public String toString(){
		return "B(" + coolnessFactor + ")";
	}
}
