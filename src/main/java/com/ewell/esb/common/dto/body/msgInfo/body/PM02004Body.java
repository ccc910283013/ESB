package com.ewell.esb.common.dto.body.msgInfo.body;

import com.ewell.esb.common.dto.body.msgInfo.body.row.PM02004Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.NONE)
public class PM02004Body {
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
