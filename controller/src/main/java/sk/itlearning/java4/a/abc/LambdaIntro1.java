package sk.itlearning.java4.a.abc;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LambdaIntro1 extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		LambdaIntro1 frame = new LambdaIntro1();
		frame.showFrame();
	}

	private void showFrame() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		JPanel content = new JPanel();

		JButton tlacitko = new JButton("Stlac ma");

		content.add(tlacitko);
		
		JTextField t = new JTextField();
		t.setColumns(20);
		content.add(t);

		this.setContentPane(content);

//		tlacitko.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				showDialog();
//			}
//
//		});

		/* 
		 * Parameter listenera musi byt FUNCTIONAL INTERFACE =
		 * interface s jedinou nenaimplementovanou metodou
		 */
		tlacitko.addActionListener(e -> showDialog());
		
		// toto nefunguje KeyListener ma viacero metod
//		 t.addKeyListener(a -> showDialog());

		this.pack();
		this.setBounds(300, 300, 300, 300);

	}

	private void showDialog(){
		JDialog dialog = new JDialog(this, "Zavri ma");
		dialog.setBounds(this.getBounds());
		dialog.setVisible(true);
	}

}
