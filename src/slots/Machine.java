package slots;

public class Machine {
	
	private final int NUM_OF_REELS = 3;
	private Reel[] reels;
	private String[] pathArr;
	private int[] results;
	
	public Machine() {
		init();
	}
	
	private void init() {
		
		pathArr = null;
		
		//these are the icons on each reel of he machine
		Icon lemon = new Icon("lemon", 1, "lemon.png");
		Icon pound = new Icon("pound", 2, "pound.png");
		Icon seven = new Icon("seven", 3, "seven.png");
		Icon cherry = new Icon("cherry", 4, "cherry.png");
		Icon bell = new Icon("bell", 5, "bell.png");
		Icon bar = new Icon("bar", 6, "bar.png");
		Icon diamond = new Icon("diamond", 7, "diamond.png");
		
		//putting the icons in the reels
		reels = new Reel[NUM_OF_REELS];
		for(int i = 0; i < NUM_OF_REELS; ++i) {
			reels[i] = new Reel(lemon, pound, seven, cherry, bell, bar, diamond);
		}
	}

	public boolean play(int betAmt) {
		Play();
		if(analyze(results) == 3)
			return true;
		return false;
	}
	
	private void Play() {
		results = new int[reels.length];
		pathArr = new String[reels.length];
		for(int i = 0; i < reels.length; ++i) {
			Icon temp = reels[i].getIcon();
			System.out.println(temp.getName());
			results[i] = temp.getNum();
			pathArr[i] = temp.getImagePath();
		}
	}
	
	private int analyze(int[] results) {
		if(results == null || results.length != 3)
			return 0;
		if(results[0] == results[1] && results[0] == results[2])
			return 3;
		if(results[0] == results[1])
			return 2;
		if(results[0] == results[2])
			return 2;
		if(results[1] == results[2])
			return 2;
		return 0;
	}
	
	public String[] getPaths() {
		return pathArr;
	}
	
}
