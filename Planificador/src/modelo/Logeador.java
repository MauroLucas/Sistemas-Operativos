package modelo;
import org.apache.log4j.*;

import test.Main;

public class Logeador {
	static final Logger debugLog = Logger.getLogger("debugLogger");
	static final Logger resultLog = Logger.getLogger("reportsLogger");
	
	public Logeador(){ 
		PropertyConfigurator.configure("log4j.properties");
		//debugLog.debug("SE");
		//resultLog.debug("SEEEE");
	}
}
