package com.ewell.esb.mq.dto.body.msgInfo.body;

import com.ewell.esb.mq.dto.body.msgInfo.body.row.PM02004Data;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "bod")
@XmlAccessorType(XmlAccessType.NONE)
public class PM02004Body {
    @XmlElementWrapper
    @XmlElement
    private PM02004Data row;

    public PM02004Data getRow() {
        return row;
    }

    public void setRow(PM02004Data row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "PM02004Body{" +
                "row=" + row +
                '}';
    }
}
