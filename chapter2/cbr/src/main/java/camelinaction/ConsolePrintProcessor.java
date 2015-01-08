package camelinaction;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ConsolePrintProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		 System.out.println("Received Order:: " 
                 + exchange.getIn().getHeader("CamelFileName"));
	}

}
