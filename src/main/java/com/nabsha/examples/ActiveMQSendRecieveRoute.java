package com.nabsha.examples;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by nabsha_monash on 2/10/17.
 */
@Component
public class ActiveMQSendRecieveRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:queue:inbox")
                .routeId("jms-inbox-route-id")
                .log(LoggingLevel.INFO,"${body} recieved")
                .setBody(simple("Hi"));
    }
}
