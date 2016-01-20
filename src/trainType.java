
public class trainType {
	private double length;
	private double inspectionTime;
	private double repairTime;
	private double cleaningTime;
	private double washingTime;

	public trainType(double length, double inspectiontime, double repairtime, double cleaningtime, double washingtime){
		this.length = length;
		this.inspectionTime = inspectiontime;
		this.repairTime = repairtime; 
		this.cleaningTime = cleaningtime;
		this.washingTime = washingtime;
	}

	public double getLength(){
		return length;
	}

	public double getInspectiontime(){
		return inspectionTime;
	}

	public double getRepairtime(){
		return repairTime;
	}

	public double getCleaningtime(){
		return cleaningTime;
	}

	public double getWashingtime(){
		return washingTime;
	}
	
}
