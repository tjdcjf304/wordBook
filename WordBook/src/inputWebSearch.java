import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class inputWebSearch {
	JFrame frame = new JFrame();
	JTextField searchingWord = new JTextField();
	
	JButton search = new JButton("검색");
	JButton mainMenu = new JButton("메인 메뉴로");
	
	public void mainMenu(){
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new mainMenu();
			}
		});
	}
	
	public void webSearch(){
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					webSearch w = new webSearch(searchingWord.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "입력된 단어가 없습니다.");
					return;
				}
			}
		});
	}
	
	public inputWebSearch(){
		frame.setTitle("웹 검색");
		frame.setSize(300, 300);
		frame.setLocation(400,500);
		
		Container cp = frame.getContentPane();
		
		this.mainMenu();
		this.webSearch();
		cp.setLayout(new BorderLayout());
		cp.add(searchingWord,BorderLayout.CENTER);
		cp.add(search,BorderLayout.EAST);
		cp.add(mainMenu,BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}
}
