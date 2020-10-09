package com.code.himanshu.spring.scheduler;


import com.code.himanshu.spark.SparkConfig;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SampleJobService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SparkSession sparkSession;

    @Autowired
    SparkConfig sparkConfig;

    public void executeRestartService(){
        logger.info("=====executeRestartService====");
        Dataset<Row> dataset=sparkSession.read().format("csv").option("header","true").load("/Users/hsing110/Data/20201010/MOCK_DATA.csv");
        createTable(dataset);
    }

    public void createTable(Dataset<Row> dataset){

        dataset.write().partitionBy("gender","state" +
                "").mode("append").format("parquet").insertInto(sparkConfig.getTargetDB()+"."+sparkConfig.getTargetTable());
        sparkSession.sql("Msck repair table "+sparkConfig.getTargetDB()+"."+sparkConfig.getTargetTable());
        sparkSession.sql("select * from "+sparkConfig.getTargetDB()+"."+sparkConfig.getTargetTable()).show();

        //parkSession.sql("create external table IF NOT EXIST "+sparkConfig.getTargetDB()+"."+sparkConfig.getTargetTable()+" STORED AS parquet");
    }

    public Boolean isFilePresent(){
        return false;
    }

    public void createDB(){
        sparkSession.sql("create database IF NOT EXIST "+sparkConfig.getTargetDB());
    }

    public void loadData( ){

    }


}