import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WordExam {
	String[] wordArray;
	String[] meaningArray;
	String word;
	int index = 0;
	int size;
	int random[] = new int[5];

	int score = 0;
	HashMap<String, String> wordBook = new HashMap<String, String>();// 단어와 뜻 쌍이
																		// 들어있는
																		// map
	Set<String> key = null;// wordBook의 키값이 들어있는 집합
	Iterator<String> itr;// 반복자

	JFrame frame = new JFrame();
	JButton inputFile = new JButton("txt파일 읽기");
	JLabel word1 = new JLabel();
	JLabel word2 = new JLabel();
	JLabel word3 = new JLabel();
	JLabel word4 = new JLabel();
	JLabel word5 = new JLabel();

	JTextField answer1 = new JTextField();
	JTextField answer2 = new JTextField();
	JTextField answer3 = new JTextField();
	JTextField answer4 = new JTextField();
	JTextField answer5 = new JTextField();

	JButton mainMenu = new JButton("메인 메뉴로");
	JButton scoring = new JButton("채점");
	public void inputFile() {
		inputFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InputFile input = new InputFile();
				wordBook = input.map;
				key = wordBook.keySet();
				itr = key.iterator();
				word = itr.next();
				size = wordBook.size();
				wordArray = new String[size];
				meaningArray = new String[size];

				if (size < 5) {
					JOptionPane.showMessageDialog(null, "5개 이상의 단어가 필요합니다.");
					return;
				}

				for (int i = 0; i < size; i++) {
					wordArray[i] = word;
					meaningArray[i] = wordBook.get(word);
					if (!itr.hasNext()) {
						key = wordBook.keySet();
						itr = key.iterator();
						word = itr.next();
					} else {
						word = itr.next();
					}
				}

				
				for (int i = 0; i < random.length; i++) {
					random[i] = (int) (Math.random() * size);
					for (int j = i - 1; j >= 0; j--) {
						if (random[i] == random[j]) {
							i--;
							break;
						}
					}
				}
				
				word1.setText(wordArray[random[0]]);
				word2.setText(wordArray[random[1]]);
				word3.setText(wordArray[random[2]]);
				word4.setText(wordArray[random[3]]);
				word5.setText(wordArray[random[4]]);

			}
		});
	}
	
	public void scoring(){
		scoring.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(key == null){
					JOptionPane.showMessageDialog(null, "선택된 파일이 없습니다.");
					return;
				}
				
				if(meaningArray[random[0]].equalsIgnoreCase(answer1.getText())){
					score++;
				}
				if(meaningArray[random[1]].equalsIgnoreCase(answer2.getText())){
					score++;
				}
				if(meaningArray[random[2]].equalsIgnoreCase(answer3.getText())){
					score++;
				}
				if(meaningArray[random[3]].equalsIgnoreCase(answer4.getText())){
					score++;
				}
				if(meaningArray[random[4]].equalsIgnoreCase(answer5.getText())){
					score++;
				}
				JOptionPane.showMessageDialog(null, "맞은 갯수: " + score+"/5");
				score = 0;
				return;
				
			}
		});
	}

	public void openMainMenu() {
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new mainMenu();
			}
		});
	}

	public WordExam() {
		frame.setTitle("단어시험");
		frame.setSize(400, 400);
		frame.setLocation(400, 500);
		Container cp = frame.getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(5, 2));

		this.openMainMenu();
		this.inputFile();
		this.scoring();
		cp.add(inputFile);

		panel1.add(word1);
		panel1.add(answer1);
		panel1.add(word2);
		panel1.add(answer2);
		panel1.add(word3);
		panel1.add(answer3);
		panel1.add(word4);
		panel1.add(answer4);
		panel1.add(word5);
		panel1.add(answer5);

		cp.add(panel1);
		
		cp.add(scoring);
		cp.add(mainMenu);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
