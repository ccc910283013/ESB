package com.ewell.esb.mq.dto.body.msgInfo;

import com.ewell.esb.mq.dto.body.msgInfo.body.PM02004Body;
import com.ewell.esb.mq.dto.body.msgInfo.body.row.PM02004Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.util.List;
@Getter
@Setter
@ToString
@XmlRootElement(name = "Msg")
@XmlAccessorType(XmlAccessType.NONE)
public class PM02004Msg {
    @XmlElementWrapper(name="body")
    @XmlElement(name="row")
    private List<PM02004Data> body;


}
