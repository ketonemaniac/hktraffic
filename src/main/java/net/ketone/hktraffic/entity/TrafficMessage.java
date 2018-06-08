package net.ketone.hktraffic.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "traffic_msg")
public class TrafficMessage {

    @Id
    @GeneratedValue
    private long id;
    private String msgLink;
    private Date msgDate;
    private String title;
    private String content;

    public TrafficMessage() {}

    public TrafficMessage(String msgLink, Date msgDate, String title, String content) {
        this.msgLink = msgLink;
        this.msgDate = msgDate;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMsgLink() {
        return msgLink;
    }

    public void setMsgLink(String msgLink) {
        this.msgLink = msgLink;
    }

    public Date getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(Date msgDate) {
        this.msgDate = msgDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
