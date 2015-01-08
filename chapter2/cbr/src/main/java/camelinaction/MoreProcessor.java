package camelinaction;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MoreProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("MORE PROCESSING OCCURING:: " 
                + exchange.getIn().getHeader("CamelFileName"));
	}

}
