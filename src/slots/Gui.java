package slots;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui {
	
	private Machine machine;
	private JLabel left, center, right;
	private ImageIcon l, c, r;
	
	public Gui() {
		setup();
	}
	
	private void setup() {
		machine = new Machine();
		JFrame f = new JFrame();
		
		JPanel panel = new JPanel();
		BorderLayout layout = new BorderLayout();
		panel.setLayout(layout);
		
		JLabel info = new JLabel("score");
	         
		JButton play = new JButton("PLAY!");
		play.addActionListener(new ActionListener() {
			int plays = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				plays++;
				info.setText("played:" + plays + " times");
				machine.play(100);
				updateImages();
			}
		});
		
		left = new JLabel("");
		center = new JLabel("");
		right = new JLabel("");
		
		panel.add(left, BorderLayout.WEST);
		panel.add(center, BorderLayout.CENTER);
		panel.add(right, BorderLayout.EAST);
		
		panel.add(play, BorderLayout.SOUTH);
		panel.add(info, BorderLayout.NORTH);
		
		f.setSize(400,350);
		f.add(panel);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void updateImages() {
		String[] paths = machine.getPaths();
		
		try {
			 l = new ImageIcon(paths[0]);
			 c = new ImageIcon(paths[1]);
			 r = new ImageIcon(paths[2]);
	    }
		catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		left.setIcon(l);
		center.setIcon(c);
		right.setIcon(r);
	}
}
