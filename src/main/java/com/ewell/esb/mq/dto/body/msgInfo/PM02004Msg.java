package com.ewell.esb.mq.dto.body.msgInfo;

import com.ewell.esb.mq.dto.body.msgInfo.body.PM02004Body;
import com.ewell.esb.mq.dto.body.msgInfo.body.row.PM02004Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Msg")
@XmlAccessorType(XmlAccessType.NONE)
public class PM02004Msg {
    @XmlElementWrapper(name="body")
    @XmlElement(name="row")
    private List<PM02004Data> body;

    public List<PM02004Data> getBody() {
        return body;
    }

    public void setBody(List<PM02004Data> body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "PM02004Msg{" +
                "body=" + body +
                '}';
    }
}
