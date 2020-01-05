package slots;

public class Icon {
	private String name;
	private int num;
	private String path;
	
	public Icon(String name, int num, String path) {
		this.name = name;
		this.num = num;
		this.path = path;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNum() {
		return num;
	}
	
	public String getImagePath() {
		return path;
	}
}
