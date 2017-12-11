import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WordBookType {
	JFrame frame = new JFrame();
	JPanel panel1 = new JPanel();
	JButton oneWord = new JButton("한 단어씩 보기");
	JButton allWord = new JButton("전체 보기");
	JButton backMain = new JButton("메인메뉴로");
	
	public void backMain(){
		backMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new mainMenu();
			}
		});
	}
	
	public void openOneWord(){
		oneWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new ViewOneWord();
			}
		});
	}
	
	public void openAllWord(){
		allWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new ViewAllWord();
			}
		});
	}
	
	public WordBookType(){
		frame.setLocation(400,500);
		frame.setSize(300,100);
		
		this.openAllWord();
		this.openOneWord();
		this.backMain();
		
		
		Container cp = frame.getContentPane();
		panel1.setLayout(new GridLayout(1,2));
		cp.setLayout(new BorderLayout());
		panel1.add(oneWord, BorderLayout.WEST);
		panel1.add(allWord, BorderLayout.EAST);
		cp.add(panel1, BorderLayout.CENTER);
		cp.add(backMain, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
