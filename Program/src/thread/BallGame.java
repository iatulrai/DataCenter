package thread;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BallGame extends Applet implements Runnable {

	Thread t;
	Image m;
	int x = 0, y = 500;

	public void init() {
		m = getImage(getCodeBase(), "ball.gif");
		t = new Thread(this); // to create new thread for current object
		t.start();
		addMouseListener(new My());
	}

	class My extends MouseAdapter {
		boolean flag = true;

		public void MousePressded(MouseEvent e) {
			if (flag) {
				t.suspend();
				flag = false;
			} else {
				t.resume();
				flag = true;
			}
		}
	}

	public void run() {
		for (;;) {
			x += 5;
			y -= 5;
			if (x == 500) {
				x = 0;
				y = 500;
			}
			try {
				t.sleep(15);
			} catch (Exception ex) {

			}
			repaint(); // clear the screen and auto call the paint method
		}
	}

	public void paint(Graphics g) {
		g.drawImage(m, x, x, this);
	}
}
// <applet code=BallGame width=550 height=520></applet>