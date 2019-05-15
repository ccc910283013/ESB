package com.ewell.esb.mq.dto.body.msgInfo.body;

import com.ewell.esb.mq.dto.body.msgInfo.body.row.PM02004Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;
@Getter
@Setter
@ToString
@XmlRootElement(name = "bod")
@XmlAccessorType(XmlAccessType.NONE)
public class PM02004Body {
    @XmlElementWrapper
    @XmlElement
    private PM02004Data row;


}
