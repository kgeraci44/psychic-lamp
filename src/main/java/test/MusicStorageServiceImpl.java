package test;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import org.springframework.stereotype.Service;
import com.amazonaws.services.s3.model.S3Object;

import java.io.InputStream;
import java.util.List;

@Service
public class MusicStorageServiceImpl implements MusicStorageService{

    private final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("us-east-2")
            .withForceGlobalBucketAccessEnabled(true) 
            .build();;

    @Override
    public String testMethod(String id) {
        ListObjectsV2Result result = s3.listObjectsV2("testingbucket-us-east-kg1234");
        List<S3ObjectSummary> objects = result.getObjectSummaries();
        String key = "";
        for (S3ObjectSummary os: objects) {
            key = os.getKey();
            System.out.println("* " + os.getKey());
        }
        return key;
    }


	@Override
	public InputStream getSong(String songLocation) {
		S3Object song = s3.getObject("testingbucket-us-east-kg1234", songLocation);
        return song.getObjectContent();
	}
}
