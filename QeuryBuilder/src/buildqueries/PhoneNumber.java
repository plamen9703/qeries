package buildqueries;

public class PhoneNumber {
	@PrimaryKey
	private int id;
	@NotNull
	private String number;
	@NotNull
	private String pn_name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPn_name() {
		return pn_name;
	}

	public void setPn_name(String pn_name) {
		this.pn_name = pn_name;
	}

	@Override
	public String toString() {
		return "PhoneNumber [id=" + id + ", number=" + number + ", pn_name=" + pn_name + "]";
	}
	
	
	
}
