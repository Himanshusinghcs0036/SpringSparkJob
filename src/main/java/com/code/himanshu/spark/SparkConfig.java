package com.code.himanshu.spark;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class SparkConfig {

    @Value("${spark.source.dir}")
    private String sourceFile;

    @Value("${spark.source.file}")
    private String sourceFileNames;

    @Value("${spark.target.db}")
    private String targetDB;

    @Value("${spark.target.table}")
    private String targetTable;

    @Value("${spark.target.table.path}")
    private String targetTablePath;

    public String getSourceFile() {
        return sourceFile;
    }

    public String getSourceFileNames() {
        return sourceFileNames;
    }

    public String getTargetDB() {
        return targetDB;
    }

    public String getTargetTable() {
        return targetTable;
    }

    public String getTargetTablePath() {
        return targetTablePath;
    }
}
