package AbstractRooms;

public class Office extends Room {

	private String owner;

	public Office(String number, int capacity, int area, String owner) {
		super(number, capacity, area);
		this.owner = owner;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String o) {
		this.owner = o;
	}

	public String toString() {
		return super.toString() + "Owner: " + owner;
	}


}
