package com.pivotal;

import com.pivotal.domain.Message;
import com.pivotal.repositories.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

/**
 * Created by jaguilar on 6/29/16.
 */
@EnableBinding(Sink.class)
public class MysqlSink {

    public static Logger LOG = LoggerFactory.getLogger(SCDfMysqlSinkSampleApplication.class);

    @Autowired
    private MessageRepository messageRepository;

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void handleMessage(@Payload String message, @Headers Map<String, Object> headers) {
        Message msg = new Message(message);
        LOG.info("message repo is: " + messageRepository);
        LOG.info(msg.getMessage());
        for(Map.Entry e : headers.entrySet()) {
            LOG.info('\t' + e.getKey().toString() + '=' + e.getValue());
        }
        messageRepository.save(msg);
    }


}
