import java.awt.Container;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestInfo {
	JFrame frame = new JFrame();
	JButton TOEICinfo = new JButton("TOEIC 정보");
	JButton TEPSinfo = new JButton("TEPS 정보");
	JButton TOEFLinfo = new JButton("TOEFL 정보");

	JButton applyTOEIC = new JButton("TOEIC 접수");
	JButton applyTEPS = new JButton("TEPS 접수");
	JButton applyTOEFL = new JButton("TOEFL 접수");
	
	JButton mainMenu = new JButton("메인 메뉴로");
	

	public void openMainMenu(){
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new mainMenu();
			}
		});
	}
	
	public void toeicApply(){
		applyTOEIC.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				try{
					Desktop.getDesktop().browse(new URI("https://appexam.ybmnet.co.kr/toeic/receipt/receipt.asp"));
				}catch(IOException e){
					e.printStackTrace();
				}catch(URISyntaxException e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public void tepsApply(){
		applyTEPS.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				try{
					Desktop.getDesktop().browse(new URI("https://www.teps.or.kr/receiption/examination"));
				}catch(IOException e){
					e.printStackTrace();
				}catch(URISyntaxException e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public void toeflApply(){
		applyTOEFL.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				try{
					Desktop.getDesktop().browse(new URI("https://www.ets.org/ko/toefl/ibt/register"));
				}catch(IOException e){
					e.printStackTrace();
				}catch(URISyntaxException e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public void toeicInfo(){
		TOEICinfo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				try{
					Desktop.getDesktop().browse(new URI("http://exam.ybmnet.co.kr/toeic/info/composition.asp"));
				}catch(IOException e){
					e.printStackTrace();
				}catch(URISyntaxException e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public void tepsInfo(){
		TEPSinfo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				try{
					Desktop.getDesktop().browse(new URI("https://www.teps.or.kr/Info/Teps"));
				}catch(IOException e){
					e.printStackTrace();
				}catch(URISyntaxException e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public void toeflInfo(){
		TOEFLinfo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				try{
					Desktop.getDesktop().browse(new URI("https://www.ets.org/ko/toefl/ibt/about/content/"));
				}catch(IOException e){
					e.printStackTrace();
				}catch(URISyntaxException e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public TestInfo() {
		
		frame.setTitle("어학 시험 정보");
		frame.setSize(350, 350);
		frame.setLocation(400, 500);
		Container cp = frame.getContentPane();
		cp.setLayout(new GridLayout(4, 2));
		
		this.toeicApply();
		this.tepsApply();
		this.toeflApply();
		this.toeicInfo();
		this.tepsInfo();
		this.toeflInfo();
		cp.add(TOEICinfo);
		cp.add(applyTOEIC);
		cp.add(TEPSinfo);
		cp.add(applyTEPS);
		cp.add(TOEFLinfo);
		cp.add(applyTOEFL);
		
		this.openMainMenu();
		
		cp.add(mainMenu);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
