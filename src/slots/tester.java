package slots;

public class tester {
	public static void main(String [] args) {
		Machine machine = new Machine();
		machine.play(100);
		
		Icon lemon = new Icon("lemon", 1);
		Icon pound = new Icon("pound", 2);
		Icon seven = new Icon("seven", 3);
		Icon cherry = new Icon("cherry", 4);
		Icon bell = new Icon("bell", 5);
		Icon bar = new Icon("bar", 6);
		Icon diamond = new Icon("diamond", 7);
		Machine machine2 = new Machine(3, lemon, pound, seven, cherry, bell, bar, diamond);
		machine2.play(100);
	}
}
