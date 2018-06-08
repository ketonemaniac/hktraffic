package net.ketone.hktraffic.antlr;

import net.ketone.hktraffic.antlr.TrafficMsgBaseVisitor;
import net.ketone.hktraffic.antlr.TrafficMsgParser;

public class TrafficMsgVisitorImpl extends TrafficMsgBaseVisitor<String> {

    @Override
    public String visitParse(TrafficMsgParser.ParseContext ctx) {
        System.out.println("parse: " + ctx.getText());
        return super.visitParse(ctx);
    }

    @Override
    public String visitSentence(TrafficMsgParser.SentenceContext ctx) {
        System.out.println("sentance: " + ctx.getText());
        return super.visitSentence(ctx);
    }

    @Override
    public String visitAreaMsg(TrafficMsgParser.AreaMsgContext ctx) {
        System.out.println("areaMsg: " + ctx.getText());
        return super.visitAreaMsg(ctx);
    }

    @Override
    public String visitAccidentMsg(TrafficMsgParser.AccidentMsgContext ctx) {
        System.out.println("accident: " + ctx.getText());
        return super.visitAccidentMsg(ctx);
    }

    @Override
    public String visitDeadCarMsg(TrafficMsgParser.DeadCarMsgContext ctx) {
        System.out.println("dead car: " + ctx.getText());
        return super.visitDeadCarMsg(ctx);
    }

    @Override
    public String visitUpdate(TrafficMsgParser.UpdateContext ctx) {
        System.out.println("update: " + ctx.getText());
        return super.visitUpdate(ctx);
    }

    @Override
    public String visitArea(TrafficMsgParser.AreaContext ctx) {
        System.out.println("area: " + ctx.getText());
        return super.visitArea(ctx);
    }

}