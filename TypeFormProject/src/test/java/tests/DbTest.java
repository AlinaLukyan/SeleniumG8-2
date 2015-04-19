package tests;

import com.app.utils.Database;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class DbTest {

    private Database dbOracle;
    protected static final Logger LOG = Logger.getLogger(DbTest.class);

    @BeforeClass
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbOracle = new Database();
    }

    @Test
    public void selectFromCountries() throws SQLException {
        Object testTable1 =  dbOracle.selectTable("SELECT * FROM countries");
        LOG.info("Countries table contains: " + testTable1);
    }

    @Test
    public void insertIntoCountries() throws SQLException {
        dbOracle.updateDB("INSERT INTO countries VALUES ('UA', 'Ukraine', 1)");
        Object resultTable = dbOracle.selectTable("SELECT * FROM countries");
        LOG.info("Countries table now contains: " + resultTable);
    }

    @Test
    public void deleteFromCountries() throws SQLException {
        dbOracle.updateDB("DELETE from countries WHERE country_name = 'Ukraine'");
        Object resultTable = dbOracle.selectTable("SELECT * FROM countries");
        LOG.info("Countries table now contains: " + resultTable);
    }

    @AfterClass
    public void tearDown() throws SQLException {
        dbOracle.quit();
    }
}
