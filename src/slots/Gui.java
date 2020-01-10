package slots;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui {

	private Machine machine;
	private JLabel left, center, right;
	private final int ICON_WIDTH = 200, ICON_HEIGHT = 200;
	private final Dimension ICON_DIMESION = new Dimension(ICON_WIDTH, ICON_HEIGHT);
	private ImageIcon l, c, r;

	public Gui() {
		init();
	}

	private void init() {
		machine = new Machine();
		JFrame f = new JFrame();

		JPanel panel = new JPanel();
		BorderLayout layout = new BorderLayout();
		panel.setLayout(layout);

		JPanel north = new JPanel();
		BorderLayout layout0 = new BorderLayout();
		north.setLayout(layout0);
		
		JLabel info = new JLabel("welcome");
		info.setPreferredSize(new Dimension(ICON_WIDTH, 25));
		
		JLabel betPrompt = new JLabel("Enter Bet Here -->");
		betPrompt.setPreferredSize(new Dimension(ICON_WIDTH, 25));
		
		JTextField betInput = new JTextField();
		betInput.setPreferredSize(new Dimension(ICON_WIDTH, 25));
		
		north.add(info, BorderLayout.WEST);
		north.add(betPrompt, BorderLayout.CENTER);
		north.add(betInput, BorderLayout.EAST);
		

		JButton play = new JButton("PLAY!");
		play.addActionListener(new ActionListener() {
			int plays = 0;
			int score = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				String betAmt = betInput.getText();
				int bet = -1;
				try {
				bet = Integer.parseInt(betAmt);
				}
				catch(Exception exception) {
					exception.printStackTrace();
					info.setText("enter a valid bet");
					return;
				}
				if (bet < 0) {
					info.setText("enter a valid bet");
					return;
				}
			
				++plays;
				score = machine.play(bet);
				info.setText("Current bet: "+betAmt+" score: "+score);
				
				updateImages();
			}
		});

		left = new JLabel("", JLabel.CENTER);
		left.setPreferredSize(ICON_DIMESION);
		
		center = new JLabel("", JLabel.CENTER);
		center.setPreferredSize(ICON_DIMESION);
		
		right = new JLabel("", JLabel.CENTER);
		right.setPreferredSize(ICON_DIMESION);

		panel.add(left, BorderLayout.WEST);
		panel.add(center, BorderLayout.CENTER);
		panel.add(right, BorderLayout.EAST);

		panel.add(play, BorderLayout.SOUTH);
		panel.add(north, BorderLayout.NORTH);

		f.setSize(600,350);
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
