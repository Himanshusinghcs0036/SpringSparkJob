package com.code.himanshu.spark;

import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;

@Configuration
@PropertySource("classpath:config.properties")
public class GlobalSparkSession {


    @Value("${spark.master}")
    private String master;

    //hello
    @Value("${spark.appName}")
    private String appName;
    @Bean
    public SparkSession getSparkSession(){
        SparkSession sparkSessionn = SparkSession.builder().appName(appName).master(master).getOrCreate();
        return sparkSessionn;
    }


}
