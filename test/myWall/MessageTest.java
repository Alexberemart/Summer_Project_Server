package myWall;

import myWall.model.dao.MessageDAO;
import myWall.model.vo.Message;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context.xml")
public class MessageTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    @Qualifier(value="target")
    protected MessageDAO messageDAO;

    @Test
    public void miPrimerTest() {

        //Message myMessage = new Message();
        //myMessage.setId("UniqueId");

        //this.messageDAO.makePersistent(myMessage);

        List<Message> messages = this.messageDAO.getMessages();

        Assert.assertEquals(messages.size(), 1);
    }
}
