package com.ewell.esb.mq.config;

import com.ewell.esb.mq.util.MQFactoryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

@Component
public class QueueDestroy implements DisposableBean,ExitCodeGenerator {
    private static final Logger logger = LoggerFactory.getLogger(QueueDestroy.class);
    @Override
    public void destroy() throws Exception {
    }

    @Override
    public int getExitCode() {
        return 0;
    }
}
