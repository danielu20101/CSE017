package AbstractRooms;

public abstract class Room implements Comparable<Object> {

	private String number;
	private int capacity;
	private int area;

	protected Room(String number, int capacity, int area) {
		this.number = number;
		this.capacity = capacity;
		this.area = area;
	}

	public String getNumber() {
		return number;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getArea() {
		return area;
	}

	public void setNumber(String n) {
		this.number = n;
	}

	public void setCapacity(int c) {
		this.capacity = c;
	}

	public void setArea(int a) {
		this.area = a;
	}

	public String toString() {
		return "Number: " + number + "Capacity: " + capacity + "Area: " + area;
	}

	public int compareTo(Object r) {
		if (r instanceof Room) {
			Room otherRoom = (Room) r;
			if (getCapacity() == otherRoom.getCapacity())
				return 0;
			else if (getCapacity() < otherRoom.getCapacity())
				return -1;
			else
				return 1;
		}
		return 0;
		
	}
}
