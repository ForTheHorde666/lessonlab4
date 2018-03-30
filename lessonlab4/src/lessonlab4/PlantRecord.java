package lessonlab4;

public class PlantRecord {
	
	private int numberSample;
	private double height;
	private int numLeaves;

	public int getNumberSample() {
		return numberSample;
	}

	public void setNumberSample(int numberSample) {
		this.numberSample = numberSample;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getNumLeaves() {
		return numLeaves;
	}

	public void setNumLeaves(int numLeaves) {
		this.numLeaves = numLeaves;
	}

	public String toString(){
		return  "Plant No. " + this.numberSample +
				"\nHeight    " + this.height +
				"\nLeaves    " + this.numLeaves ;
	}
}
