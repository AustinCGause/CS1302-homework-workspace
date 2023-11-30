package prob1;

public abstract class Cake {
	private String cakeMix;

	public Cake(String cakeMix) { this.cakeMix = cakeMix; }

	public String getCakeMix() { return cakeMix; }

	abstract protected String getLiquid();
	abstract protected String getOil();
	abstract protected String getEggs();

	final public String makeCake() {
		String cake = "";
		cake += blend();
		cake += pour();
		cake += bake();
		return cake;
	}

	private String blend() {
		String cake = "Blend:(";
		cake += getCakeMix() + ", ";
		cake += getLiquid() + ", ";
		cake += getOil() + ", ";
		cake += getEggs() + ")\n";
		return cake;
	}

	protected String bake() {
		return "Bake at 350 degrees F 30 minutes";
	}

	protected String pour() {
		return "Pour mix into pan\n";
	}
}
