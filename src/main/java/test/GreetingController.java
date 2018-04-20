package test;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Autowired
    private MusicDetailsRepository musicDetailsRepository;
    //private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	System.out.println("HERE 0");
    	Iterator<MusicDetails> it = musicDetailsRepository.findAll().iterator();
    	System.out.println("HERE 1");
    	MusicDetails sample = new MusicDetails();
    	while(it.hasNext()){
    		sample = it.next();
    	}
        return new Greeting(sample.getTitle(),sample.getArtist().toString(), "Demo Album", sample.getLocation());
    }
    
}