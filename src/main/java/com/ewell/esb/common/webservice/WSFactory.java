package com.ewell.esb.common.webservice;

import com.ewell.esb.common.webservice.FYClient.Mchis;
import com.ewell.esb.common.webservice.FYClient.MchisPortType;

public class WSFactory {
    public static final MchisPortType mp = new Mchis().getMchisHttpSoap11Endpoint();
}
