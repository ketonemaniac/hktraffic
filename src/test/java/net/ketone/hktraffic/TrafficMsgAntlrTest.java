package net.ketone.hktraffic;

import net.ketone.hktraffic.antlr.TrafficMsgLexer;
import net.ketone.hktraffic.antlr.TrafficMsgParser;
import net.ketone.hktraffic.antlr.TrafficMsgVisitorImpl;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * To generate classes, type: mvn antlr4:antlr4
 */
public class TrafficMsgAntlrTest {

    // String s = "【馬路的事交通消息】龍翔道去荃灣，近摩士泳池快線有交通意外，龍尾︰黃大仙中心。";
    String s = "【馬路的事交通消息】較早前荃灣路去九龍，近有線電視大樓的交通意外仍未清理，龍尾：油柑頭。";
    // String s = "【馬路的事交通消息】較早前青嶼幹線及汀九橋第一階段強風管制措施已經取消，所有車輛現可使用橋面道路。";

    @Test
    public void testLexer() throws IOException {
        InputStream inputStream = new ByteArrayInputStream(s.getBytes());
        TrafficMsgLexer lexer = new TrafficMsgLexer(CharStreams.fromStream(inputStream));
        Token t;
        do {
            t = lexer.nextToken();
            System.out.println("Token : " + t);
        } while(t.getText() != "<EOF>");
    }

    @Test
    public void testParser() throws IOException {
        InputStream inputStream = new ByteArrayInputStream(s.getBytes());
        TrafficMsgLexer lexer = new TrafficMsgLexer(CharStreams.fromStream(inputStream));
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        TrafficMsgParser parser = new TrafficMsgParser(commonTokenStream);

        TrafficMsgParser.ParseContext parseTree = parser.parse();
        TrafficMsgVisitorImpl visitor = new TrafficMsgVisitorImpl();
        visitor.visit(parseTree);
  }

}
