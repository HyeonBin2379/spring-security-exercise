package org.project.springsecurityex;

import java.sql.Connection;
import javax.sql.DataSource;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/members/root-context.xml")
public class ConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnection() throws Exception{
        Connection connection = dataSource.getConnection();
        log.info(dataSource);
        Assertions.assertNotNull(connection);
        connection.close();
    }
}
