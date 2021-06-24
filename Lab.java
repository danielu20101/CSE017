package AbstractRooms;

public class Lab extends Room {
	private int computers;

	public Lab(String number, int capacity, int area, int computers) {
		super(number, capacity, area);
		this.computers = computers;
	}

	public int getComputers() {
		return computers;
	}

	public void setComputers(int c) {
		this.computers = c;
	}

	public String toString() {
		return super.toString() + "Computers: " + computers;
	}

}
