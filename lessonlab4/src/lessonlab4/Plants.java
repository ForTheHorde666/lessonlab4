package lessonlab4;

import java.util.ArrayList;

public class Plants {

	private String nameOfSoil;
	private int multiplier;
	private double heightThreshold;
	private int leaveThreshold;
	private int meetsThresholdCounter = 0;
	private int doesnotmeetThresholdCounter = 0;
	// private ArrayList<PlantRecord> plantRecordList = new ArrayList<>();

	public String getNameOfSoil() {
		return nameOfSoil;
	}

	public void setNameOfSoil(String nameOfSoil) {
		this.nameOfSoil = nameOfSoil;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}

	public double getHeightThreshold() {
		return heightThreshold;
	}

	public void setHeightThreshold(double heightThreshold) {
		this.heightThreshold = heightThreshold;
	}

	public int getLeaveThreshold() {
		return leaveThreshold;
	}

	public void setLeaveThreshold(int leaveThreshold) {
		this.leaveThreshold = leaveThreshold;
	}

	// public void addPlantRecord(PlantRecord plantRecord) {
	// //this.plantRecordList.add(plantRecord);
	// }
	//
	// public ArrayList<PlantRecord> getPlantRecordList() {
	// return this.plantRecordList;
	// }
	//
	// public boolean hasPlantRecords(){
	// return !this.plantRecordList.isEmpty();
	// }

	public void addRecord(boolean doesMeetThreshold) {
		if (doesMeetThreshold) {
			this.meetsThresholdCounter += 1;
		} else {
			this.doesnotmeetThresholdCounter += 1;
		}
	}

	public int getMeetsThresholdCounter() {
		return this.meetsThresholdCounter;
	}

	public int getDoesNotMeetThresholdCounter() {
		return this.doesnotmeetThresholdCounter;
	}

	public String toString() {
		return "soil: " + this.nameOfSoil;
		// "\nmultiplier: " + this.multiplier +
		// "\nheight threshold: " + this.heightThreshold +
		// "\nleave threshold: " + this.leaveThreshold;
	}
}
