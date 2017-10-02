package com.nabsha.examples;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.ConnectionFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest extends CamelTestSupport
{
    private ConnectionFactory connectionFactory;

    @Before
    public  void foo() {
        connectionFactory = new ActiveMQConnectionFactory("vm://localhost?broker.persistent=true");
        context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
    }

    @Test
    public void testRoute() throws InterruptedException {
        assertEquals(template.requestBody("jms:queue:inbox", "HelloWorld"), "Hi");
    }
}
