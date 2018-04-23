package test;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Optional;

import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;

@RestController
public class GreetingController {

	@Autowired
    private MusicDetailsRepository musicDetailsRepository;
    @Autowired
    private MusicStorageService musicStorageService;

    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/testBucket")
    public Greeting testBucket(){
      String result =  musicStorageService.testMethod("testId");
        return new Greeting(result,"Artist", "Demo Album", "Demo Location");
    }

//    @RequestMapping(value="/testDownload")
//    public void testDownload(HttpServletResponse response) throws Exception{
//        InputStream songStream = musicStorageService.getSong();
//
//        response.addHeader("Content-disposition", "attachment;filename=myfilename.txt");
//        response.setContentType("audio/mpeg");
//
//        IOUtils.copy(songStream, response.getOutputStream());
//        response.flushBuffer();
//    }
	

//    @CrossOrigin(origins = "http://localhost:4200")
//    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//    	System.out.println("HERE 0");
//    	Iterator<MusicDetails> it = musicDetailsRepository.findAll().iterator();
//    	System.out.println("HERE 1");
//    	MusicDetails sample = new MusicDetails();
//    	while(it.hasNext()){
//    		sample = it.next();
//    	}
//        return new Greeting(sample.getTitle(),sample.getArtist().toString(), "Demo Album", sample.getLocation());
//    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/getSong")
    public MusicDetails getSong() {
    	Optional<MusicDetails> song = musicDetailsRepository.findById( (long) 1);
    	return song.get();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/playSong")
    public void playSong(HttpServletResponse response, @RequestParam(value="song") String songLocation) throws Exception{
        InputStream songStream = musicStorageService.getSong(songLocation);

      //  response.addHeader("Content-disposition", "attachment;filename=myfilename.txt");
        response.setContentType("audio/mpeg");

        IOUtils.copy(songStream, response.getOutputStream());
        response.flushBuffer();
    }
    

}