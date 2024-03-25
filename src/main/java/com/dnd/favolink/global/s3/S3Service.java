package com.dnd.favolink.global.s3;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.net.URL;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Value("${cloud.s3.bucket}")
    private String bucket;

    @Value("${cloud.s3.presigned-url.valid-minute}")
    private int presignedUrlValidMinute;

    private final AmazonS3 amazonS3;

    public String getPresignedUrl(String fileName, S3Category s3Category) {
        String filePath = createPath(fileName, s3Category);

        GeneratePresignedUrlRequest generatePresignedUrlRequest = getGeneratePresignedUrlRequest(bucket, filePath);
        URL presignedUrl = amazonS3.generatePresignedUrl(generatePresignedUrlRequest);

        return presignedUrl.toString();
    }

    private GeneratePresignedUrlRequest getGeneratePresignedUrlRequest(String bucket, String filePath) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucket, filePath)
                .withMethod(HttpMethod.PUT)
                .withExpiration(getPresignedUrlExpiration());

        generatePresignedUrlRequest.addRequestParameter(
                Headers.S3_CANNED_ACL,
                CannedAccessControlList.PublicRead.toString()
        );

        return generatePresignedUrlRequest;
    }

    private Date getPresignedUrlExpiration() {
        Date expiration = new Date();
        long expTimeMillisec = expiration.getTime();
        expTimeMillisec += 1000 * 60 * presignedUrlValidMinute;
        expiration.setTime(expTimeMillisec);
        return expiration;
    }

    private String createPath(String fileName, S3Category s3Category) {
        String fileNameWithUUID = createFileNameWithUUID(fileName);
        return String.format("%s/%s/%s", activeProfile, s3Category.getCategory(), fileNameWithUUID);
    }

    private String createFileNameWithUUID(String fileName) {
        String uuid = UUID.randomUUID().toString();
        return uuid + "-" + fileName;
    }
}
