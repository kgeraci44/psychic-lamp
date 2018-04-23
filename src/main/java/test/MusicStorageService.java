package test;

import java.io.InputStream;

public interface MusicStorageService {

    String testMethod(String id);
	InputStream getSong(String songLocation);
}
