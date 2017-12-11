import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewOneWord{
	JFrame frame = new JFrame();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	JLabel back = new JLabel();

	JButton next = new JButton("다음 단어 보기");
	JButton onlyWord = new JButton("단어만 보기");
	JButton onlyMeaning = new JButton("뜻만 보기");
	JButton web = new JButton("웹에서 검색");
	JButton mainMenu = new JButton("메인 메뉴로");
	JButton inputFile = new JButton("txt파일 읽기");
	JLabel wordView = new JLabel();
	
	
	HashMap<String, String> wordBook = new HashMap<String, String>();//단어와 뜻 쌍이 들어있는 map
	Set<String> key = null;//wordBook의 키값이 들어있는 집합
	Iterator<String> itr;//반복자
	String word;//단어
	
	//파일 불러오기
	private void openInputFile(){
		inputFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InputFile input = new InputFile();
				wordBook = input.map;
				key = wordBook.keySet();
				itr = key.iterator();
				word = itr.next();//다음 단어
				wordView.setText(word + "    " + wordBook.get(word));
			}
		});
	}
	
	//메인메뉴로 돌아가기
	public void openMainMenu(){
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new mainMenu();
			}
		});
	}
	
	//다음단어로
	public void nextWord(){
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(!itr.hasNext()){
					key = wordBook.keySet();
					itr = key.iterator();
					word = itr.next();
					wordView.setText(word + "    " + wordBook.get(word));
				}else{
					word = itr.next();
					wordView.setText(word + "    " + wordBook.get(word));
				}
			}
		});
		
	}
	
	public void nextWord_onlyWord(){
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(!itr.hasNext()){
					key = wordBook.keySet();
					itr = key.iterator();
					word = itr.next();
					wordView.setText(word);
				}else{
					word = itr.next();
					wordView.setText(word);
				}
			}
		});
	}
	
	public void onlyWord(){
		onlyWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				nextWord_onlyWord();
				wordView.setText(word);	
				
			}
		});
	}
	
	public void onlyMeaning(){
		onlyMeaning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				wordView.setText(wordBook.get(word));	
				
			}
		});
	}
	

	//웹검색
	public void webSearch(){
		web.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				try {
					webSearch webSearch = new webSearch(word);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//class webSearch에 구현
			}
		});
	}
	
	public ViewOneWord(){
		
		frame.setTitle("단어장");
		frame.setSize(400,400);
		frame.setLocation(400,500);
		
		Container cp = frame.getContentPane();
		
		panel1.setLayout(new BorderLayout());
		this.openInputFile();
		panel1.add(inputFile, BorderLayout.EAST);
		
		String test[] = {"Day1","Day2","Day3"};

		
		cp.add(panel1,BorderLayout.NORTH);
		
		panel2.setLayout(new GridLayout(3,3));
		
		this.onlyWord();
		this.onlyMeaning();
		this.openMainMenu();
		this.nextWord();
		this.webSearch();
		
		
		panel2.add(back);
		panel2.add(next);
		panel2.add(onlyWord);
		panel2.add(onlyMeaning);
		panel2.add(web);
		panel2.add(mainMenu);
		cp.add(panel2, BorderLayout.SOUTH);
		
		
		wordView.setSize(new Dimension(100,100));
		
		wordView.setHorizontalAlignment(JLabel.CENTER);
		wordView.setVerticalAlignment(JLabel.CENTER);
		wordView.setFont(new Font("돋움", Font.PLAIN, 20));
		
		cp.add(wordView,BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
