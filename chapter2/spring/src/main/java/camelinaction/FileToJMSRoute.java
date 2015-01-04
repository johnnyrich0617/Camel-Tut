/**
 * 
 */
package camelinaction;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileToJMSRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("ftp://192.168.1.23/orders?username=FTPUSER1&password=Trinity!0617")
        .process(new DownloadLogger())
        .to("jms:incomingOrders");
    }
}
