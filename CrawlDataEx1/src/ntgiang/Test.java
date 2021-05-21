package ntgiang;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
//        for(int i=519 ; i<525; i++) {
        int i = 154;
            String url = "https://tieuchi.chatluongbenhvien.vn/node/" + i;
            Document document = Jsoup.connect(url).get();
            Elements aElements = document.getElementsByClass("field-item even");
//        Elements aElements = document.getElementsByClass("field field-name-field-standard-auditguide field-type-text-long field-label-above");
//            System.out.println(aElements.get(0).child(0).child(0).child(0).text());
            for (Element aElement : aElements) {
                if(aElement.parent().firstElementSibling() != null) {
                    System.out.println(aElement.parent().firstElementSibling().text());
                }
//                String text = aElement.text();
//                System.out.println(text);
                System.out.println("------------");
            }

//            System.out.println("-----------------------------");
//        }


    }
}
