package net.ketone.hktraffic.entity;


import net.ketone.hktraffic.config.TestConfiguration;
import net.ketone.hktraffic.repo.TrafficMessageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = TestConfiguration.class)
public class TrafficMsgTest {

    @Autowired
    private TrafficMessageRepository repository;

    @Test
    public void testExample() throws Exception {
        TrafficMessage msg = new TrafficMessage("http://test.net/", new Date(), "test title", "test content");
        TrafficMessage saved = repository.save(msg);
        System.out.println("saved ID=" + saved.getId());
        assertTrue(saved.getId() > 0);
    }
}
