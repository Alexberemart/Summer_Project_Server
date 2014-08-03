package myWall.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import myWall.model.dao.MessageDAO;
import myWall.model.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

@org.springframework.stereotype.Controller
public class MessageServices extends Controller{

    @Autowired
    @Qualifier("target")
    protected MessageDAO messageDAO;

    public Result getMessageList() throws JsonProcessingException{
        List<Message> messageList = this.messageDAO.getMessages();
        ObjectMapper mapper = new ObjectMapper();

        return ok(mapper.writeValueAsString(messageList));
    }
}
