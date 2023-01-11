package buildqueries;
public class Person {
	@PrimaryKey
	private int id;
	@NotNull
	private String p_name;
	
	@OneToMany(mappedName="id")
	private PhoneNumber number;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return p_name;
	}
	public void setName(String name) {
		this.p_name = name;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + p_name + "]";
	}
	
}
