import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class webSearch {
	JFrame frame = new JFrame();
	JLabel view = new JLabel();
	String result = "";// 결과

	public void search(String word) throws Exception {
		Document doc = Jsoup.connect("http://dic.naver.com/search.nhn?dicQuery=" + word).get();
		
		Elements root = doc.select("div[class=en_dic_section search_result dic_en_entry]");
		Elements NList = root.select("dl[class=dic_search_result]");
		Elements NList2 = root.select("dd");
		Elements NList3 = root.select("span[class=c_b]");
		
		StringBuilder b = new StringBuilder("<html>");
		b.append(NList2.get(0).text() + "<br><br>");
		for(int i = 1; i < NList3.size(); i++){
			b.append(NList3.get(i).text() + "<br>");
			b.append(NList2.get(i).text() + "<br><br>");
		}
		b.append("</html>");
		result = b.toString();
		view.setText(result);
		//System.out.println(NList2.get(0).text());
	}

	public webSearch(String word) throws Exception {// word : 검색할 단어
		frame.setTitle("웹 검색");
		frame.setSize(300, 300);
		frame.setLocation(400, 500);

		Container cp = frame.getContentPane();
		view.setHorizontalAlignment(JLabel.CENTER);
		view.setVerticalAlignment(JLabel.CENTER);
		this.search(word);
		
		cp.add(view);

		frame.setVisible(true);
	}
}
