package net.ketone.hktraffic.feed;

import net.ketone.hktraffic.HkTrafficApplication;
import net.ketone.hktraffic.antlr.TrafficMsgLexer;
import net.ketone.hktraffic.antlr.TrafficMsgParser;
import net.ketone.hktraffic.antlr.TrafficMsgVisitorImpl;
import net.ketone.hktraffic.entity.TrafficMessage;
import net.ketone.hktraffic.repo.TrafficMessageRepository;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@Component
public class TrafficFeed {

    Logger log = Logger.getLogger(TrafficFeed.class);

    @Autowired
    private TrafficMessageRepository trafficMsgRepo;

    @Value("${traffic.feed.url}")
    private String trafficUrl;

    @Scheduled(fixedRate = 600000)  // 10 mins
    public void getTrafficFeed() {
        try {
            log.info("fetching from " + trafficUrl);
            Document doc = Jsoup.connect(trafficUrl).get();
            Elements items = doc.select("item");
            for(Element item : items) {
                TrafficMessage msg = new TrafficMessage();
                msg.setTitle(item.select("title").first().text());
                msg.setMsgLink(item.select("link").first().text());
                Document linkDoc = Jsoup.connect(msg.getMsgLink()).get();
                msg.setContent(linkDoc.select("#divnewsTextContent").first().text());
                msg.setMsgDate(new Date());

                // TODO: move to service, try printing here first
                InputStream inputStream = new ByteArrayInputStream(msg.getContent().getBytes());
                TrafficMsgLexer lexer = new TrafficMsgLexer(CharStreams.fromStream(inputStream));
                CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
                TrafficMsgParser parser = new TrafficMsgParser(commonTokenStream);

                TrafficMsgParser.ParseContext parseTree = parser.parse();
                TrafficMsgVisitorImpl visitor = new TrafficMsgVisitorImpl();
                visitor.visit(parseTree);
                // end TODO

                trafficMsgRepo.save(msg);
            };
        } catch (IOException e) {
            log.error(e);
        }

    }
}
