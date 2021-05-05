package com.example.flyway;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.ResultSet;
import java.sql.Statement;

public class FlywayApplication extends BaseJavaMigration {

    public void migrate(Context context) throws Exception{
        try(Statement select = context.getConnection().createStatement()){
            try(ResultSet rs = select.executeQuery("select * from people")){
                while (rs.next()){
                    System.out.println(rs.getString(0));
                    System.out.println(rs.getString(1));
                }
            }
        }
    }

}
