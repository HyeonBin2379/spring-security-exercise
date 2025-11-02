package org.project.springsecurityex.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TimeMapperTests {

    // 실제 객체 주입 X
    @Autowired(required = false)
    private TimeMapper timeMapper;

    @Test
    public void testTimeMapper2() {
        log.info(timeMapper.getNow());
    }
}
