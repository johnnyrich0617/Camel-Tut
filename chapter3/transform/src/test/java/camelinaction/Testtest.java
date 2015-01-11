package camelinaction;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class Testtest extends CamelTestSupport {
	 @Test
	    public void testBeanPrinter() throws Exception {
	       String test = "ORDERS 1234567890";
	       template.sendBodyAndHeader("direct:start", test, "Date", "2015-01-09");
	    }

	    @Override
	    protected RouteBuilder createRouteBuilder() throws Exception {
	        return new RouteBuilder() {
	            @Override
	            public void configure() throws Exception {
	                from("direct:start")
	                    // format inhouse to csv using a bean
	                    .bean(new StringPrinterBean())
	                    // and save it to a file
	                    .to("file://target/orders/received?fileName=report-${header.Date}.csv");
	            }
	        };
	    }
}
