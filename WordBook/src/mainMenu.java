import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class mainMenu {
	JFrame frame = new JFrame("Word Book");
	Container cp = frame.getContentPane();
	FlowLayout layout = new FlowLayout();

	JButton wordBook = new JButton("단어장");
	JButton exam = new JButton("TEST");
	JButton webSearch = new JButton("웹 검색");
	JButton testInfo = new JButton("어학시험 정보");

	public mainMenu() {
		frame.setLocation(500, 400);
		cp.setLayout(layout);

		this.openWordBook();
		this.openExam();
		this.webSearch();
		this.openTestInfo();

		cp.add(wordBook);
		cp.add(exam);
		cp.add(webSearch);
		cp.add(testInfo);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	private void openWordBook() {
		wordBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new WordBookType();
			}
		});
	}
	
	private void openExam(){
		exam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new WordExam();
			}
		});
	}
	
	private void webSearch(){
		webSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				frame.dispose();
				new inputWebSearch();
			}
		});
	}
	
	private void openTestInfo(){
		testInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new TestInfo();
			}
		});
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		mainMenu test = new mainMenu();
	}

}
