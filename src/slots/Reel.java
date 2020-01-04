package slots;
import java.util.Random;

public class Reel {
	private Icon[] icons;
	private Random gen;
	
	public Reel(Icon...icons) {
		this.icons = icons;
	}
	
	public Icon getIcon() {
		if (gen == null)
			gen = new Random();
		int n = gen.nextInt(icons.length);
		return icons[n];
	}
}
