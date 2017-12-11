import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ViewAllWord {
	JFrame frame = new JFrame();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JLabel wordView = new JLabel();
	JLabel blank = new JLabel();
	
	JButton inputFile = new JButton("txt파일 읽기");
	JButton onlyWord = new JButton("단어만 보기");
	JButton onlyMeaning = new JButton("뜻만 보기");
	JButton mainMenu = new JButton("메인 메뉴로");
	
	HashMap<String, String> wordBook = new HashMap<String, String>();//단어와 뜻 쌍이 들어있는 map
	Set<String> key = null;//wordBook의 키값이 들어있는 집합
	Iterator<String> itr;//반복자
	String word, allword;//단어
	StringBuilder b = new StringBuilder("<html>");
	
	public void openInputFile(){
		inputFile.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				InputFile input = new InputFile();
				wordBook = input.map;
				key = wordBook.keySet();
				itr = key.iterator();
				word = itr.next();
				b.append(word+"    ");
				b.append(wordBook.get(word) + "<br>");
				while(itr.hasNext()){
					word = itr.next();
					b.append(word+"    ");
					b.append(wordBook.get(word)+"<br>");
				}
				b.append("</html>");
				allword = b.toString();
				wordView.setText(allword);
			}
		});
	}
	
	public void onlyWord(){
		onlyWord.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Iterator<String> itr2 = key.iterator();
				b = new StringBuilder("<html>");
				while(itr2.hasNext()){
					word = itr2.next();
					b.append(word+"<br>");
				}
				b.append("</html>");
				allword = b.toString();
				wordView.setText(allword);
			}
		});
	}
	
	public void onlyMeaning(){
		onlyMeaning.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Iterator<String> itr2 = key.iterator();
				b = new StringBuilder("<html>");
				while(itr2.hasNext()){
					word = itr2.next();
					b.append(wordBook.get(word)+"<br>");
				}
				b.append("</html>");
				allword = b.toString();
				wordView.setText(allword);
			}
		});
	}
	
	public void openMainMenu(){
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new mainMenu();
			}
		});
	}
	

	
	public ViewAllWord(){
		frame.setTitle("단어장");
		frame.setSize(400, 400);
		frame.setLocation(400,500);
		
		Container cp = frame.getContentPane();
		BoxLayout layout = new BoxLayout(cp, BoxLayout.Y_AXIS);
		cp.setLayout(layout);
		panel1.setLayout(new GridLayout(1,3));
		this.openInputFile();
		this.onlyWord();
		this.onlyMeaning();

		panel1.add(blank);
		panel1.add(inputFile);
		
		this.openMainMenu();
		
		panel2.setLayout(new GridLayout(1,2));
		panel2.add(onlyWord);
		panel2.add(onlyMeaning);
		
		mainMenu.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		wordView.setPreferredSize(new Dimension(400,400));
		wordView.setAlignmentX(Label.CENTER_ALIGNMENT);
		wordView.setHorizontalAlignment(JLabel.CENTER);
		wordView.setVerticalAlignment(JLabel.CENTER);
		wordView.setFont(new Font("돋움", Font.PLAIN, 20));
		
		cp.add(panel1);
		cp.add(wordView);
		cp.add(panel2);
		cp.add(mainMenu);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
