package f4.web;

import f4.web.config.AppConfig;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by xuan on 16-10-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class DataSourceTest {

    private static final Logger log = Logger.getLogger(DataSourceTest.class);

    @Autowired
    private DataSource dataSource;

    @Test
    public void dataSource() throws SQLException {
        log.debug(dataSource.getClass());
    }
}
