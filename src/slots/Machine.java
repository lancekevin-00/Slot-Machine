package slots;

public class Machine {
	
	private Reel[] reels;
	private String[] pathArr;
	
	public Machine() {
		init();
	}
	
	private void init() {
		
		pathArr = null;
		
		Icon lemon = new Icon("lemon", 1, "lemon.png");
		Icon pound = new Icon("pound", 2, "pound.png");
		Icon seven = new Icon("seven", 3, "seven.png");
		Icon cherry = new Icon("cherry", 4, "cherry.png");
		Icon bell = new Icon("bell", 5, "bell.png");
		Icon bar = new Icon("bar", 6, "bar.png");
		Icon diamond = new Icon("diamond", 7, "diamond.png");
		reels = new Reel[3];
		reels[0] = new Reel(lemon, pound, seven, cherry, bell, bar, diamond);
		reels[1] = new Reel(lemon, pound, seven, cherry, bell, bar, diamond);
		reels[2] = new Reel(lemon, pound, seven, cherry, bell, bar, diamond);
	}

	public void play(int betAmt) {
		analyze(Play());
		
	}
	
	private int[] Play() {
		int[] returnArr = new int[reels.length];
		pathArr = new String[reels.length];
		for(int i = 0; i < reels.length; ++i) {
			Icon temp = reels[i].getIcon();
			System.out.println(temp.getName());
			returnArr[i] = temp.getNum();
			pathArr[i] = temp.getImagePath();
		}
		return returnArr;
	}
	
	private int analyze(int[] results) {
		return -1;
	}
	
	public String[] getPaths() {
		return pathArr;
	}
	
}
