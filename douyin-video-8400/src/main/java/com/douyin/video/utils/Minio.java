package com.douyin.video.utils;
import com.douyin.common.entities.video.PublishVideoResp;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.beans.factory.annotation.Value;

import java.io.InputStream;

/**
 * @author castall
 * @date 2023/7/16 19:40
 */

public class Minio {
    @Value("${minio.accessKey}")
    private static String accessKey;
    @Value("${minio.secretKey}")
    private static String secretKey;
    @Value("${minio.url}")
    private static String url;
    private static MinioClient instance;

    public static MinioClient getMinioClient(){
        if(instance == null){
            synchronized (Minio.class){
                if(instance == null){
                    try{
                        instance = new MinioClient(url,accessKey,secretKey);
                    } catch (InvalidPortException e) {
                        throw new RuntimeException(e);
                    } catch (InvalidEndpointException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return instance;
    }
    public static String publishVideo(InputStream data, String videoPathName) throws Exception{
        MinioClient minioClient = getMinioClient();
        try{
            minioClient.bucketExists("video");
            PutObjectOptions minioOption = new PutObjectOptions(-1,1000*1000*5);
            minioClient.putObject("video",videoPathName,data,minioOption);
            // 返回URL
            String videoURL = minioClient.getObjectUrl("video",videoPathName);
            return videoURL;
        }catch (ErrorResponseException e){
            System.out.println("Video Bucket 不存在");
            System.out.println("Exception" + e);
            throw e;
        }catch (Exception e){
            System.out.println("文件上传失败");
            System.out.println("Exception" + e);
        }
        return null;
    }
}
