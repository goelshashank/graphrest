package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.ibatis.common.jdbc.ScriptRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by shashank on 28/5/16.
 */
public class ExecuteSQLScript {

    private static final Logger logger = LoggerFactory.getLogger(ExecuteSQLScript.class);

    public static void executeScript()
    {
        String aSQLScriptFilePath = "/schema/createSchema.sql";

        // Create MySql Connection
        try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "root");
        Statement stmt = null;


            // Initialize object for ScripRunner
            ScriptRunner sr = new ScriptRunner(con, false, false);

            // Give the input file to Reader
            Reader reader = new BufferedReader(
                    new FileReader(aSQLScriptFilePath));

            // Exctute script
            sr.runScript(reader);

            logger.info("SQL Script executed");
        } catch (Exception e) {
            logger.error("Failed to Execute" + aSQLScriptFilePath
                    + " The error is " + e.getMessage());
        }
    }


}
