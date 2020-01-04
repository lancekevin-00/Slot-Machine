package slots;

public class Machine {
	
	private Reel[] reels;
	
	public Machine() {
		init();
	}
	
	private void init() {
		Icon lemon = new Icon("lemon", 1);
		Icon pound = new Icon("pound", 2);
		Icon seven = new Icon("seven", 3);
		Icon cherry = new Icon("cherry", 4);
		Icon bell = new Icon("bell", 5);
		Icon bar = new Icon("bar", 6);
		Icon diamond = new Icon("diamond", 7);
		reels = new Reel[3];
		reels[0] = new Reel(lemon, pound, seven, cherry, bell, bar, diamond);
		reels[1] = new Reel(lemon, pound, seven, cherry, bell, bar, diamond);
		reels[2] = new Reel(lemon, pound, seven, cherry, bell, bar, diamond);
	}
	
	public Machine(int numOfReels, Icon ... icons) {
		reels = new Reel[numOfReels];
		for(int i = 0; i < numOfReels; ++i) {
			Reel tempReel = new Reel(icons);
			reels[i] = tempReel;
		}
	}

	public void play(int betAmt) {
		int[] results = Play();
		//analyze results and determine winnings
	}
	
	private int[] Play() {
		int[] returnArr = new int[reels.length];
		for(int i = 0; i < reels.length; ++i) {
			Icon temp = reels[i].getIcon();
			System.out.println(temp.getName());
			returnArr[i] = temp.getNum();
		}
		return returnArr;
	}
	
}
