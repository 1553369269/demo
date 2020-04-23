package crawl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Description 爬取云栖社区的所有直播链接、时间、名称、状态
 * Author caihaojie
 * @Date 2020-04-14 9:06
 **/
public class CrawlTest {

    public static void main(String[] args) {
        getInfo();
    }

    public static void getInfo(){
        try {
            Document doc = Jsoup.connect("https://yq.aliyun.com/webinar/schedule?%20date=2020-04").maxBodySize(0).get();
            Elements elementsDate = doc.getElementsByClass("yq-schedule-list").select("option");
            List<String> dateList = elementsDate.eachText();
            dateList.forEach(date ->{
                try {
                    Document doc1 = Jsoup.connect("https://yq.aliyun.com/webinar/schedule?%20date="+date).maxBodySize(0).get();
                    // 获取url
                    Elements elementsUrl = doc1.getElementsByClass("sub-item").select("a");
                    ListIterator<Element> urlListIterator = elementsUrl.listIterator();
                    List<String> urlList = new ArrayList<>();
                    urlListIterator.forEachRemaining(element -> {
                        String href = element.select("a").first().attr("href");
                        urlList.add(href);
                    });
                    // 时间
                    Elements elementsTime = doc1.getElementsByClass("time-info");
                    List<String> timeList = elementsTime.eachText();
                    // 标题
                    Elements elementsTitle = doc1.getElementsByClass("title-info");
                    List<String> titleList = elementsTitle.eachText();
                    // 状态
                    Elements elementsState = doc1.getElementsByClass("state-info");
                    List<String> stateList = elementsState.eachText();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
