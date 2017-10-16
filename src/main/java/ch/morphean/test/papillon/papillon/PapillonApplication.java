package ch.morphean.test.papillon.papillon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.videoai.papillon.PapillonSDK;

@SpringBootApplication
public class PapillonApplication {

	static {
        System.loadLibrary("PapillonCoreJava");
  }

	public static void main(String[] args) {
		init();
		SpringApplication.run(PapillonApplication.class, args);
		uninit();
	}

	private static void init(){
      // Load only once
      if(!PapillonSDK.IsInitialised()) {
          PapillonSDK.Initialise(PapillonSDK.EPapillonOptions.E_CONSOLE_LOGGER_DEBUG_LEVEL.swigValue());
      }
  }

	private static void uninit() {
	    if(PapillonSDK.IsInitialised()) {
	        PapillonSDK.Finalise();
	    }
	}
}
