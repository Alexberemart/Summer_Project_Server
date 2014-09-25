package myWall.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import myWall.model.dao.MessageDAO;
import myWall.model.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class MessageServices extends Controller {

    @Autowired
    @Qualifier("target")
    protected MessageDAO messageDAO;

    public Result getMessageList() throws JsonProcessingException {
        List<Message> messageList = this.messageDAO.getMessages();
        ObjectMapper mapper = new ObjectMapper();
        return ok(mapper.writeValueAsString(messageList));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result saveMessageList() throws JsonProcessingException {
        JsonNode json = request().body().asJson();
        ObjectMapper mapper = new ObjectMapper();
        List <Message> messageList = new ArrayList<>();
        for(int i=0; i<json.size(); i++){
            Message message = new Message();
            //message.setId(json.get(i).findPath("id").textValue());
            message.setName(json.get(i).findPath("name").textValue());
            message.setText(json.get(i).findPath("text").textValue());
            message.setDate_time(json.get(i).findPath("date_time_to_save").textValue());
            message.setLikes(json.get(i).findPath("likes").intValue());
            message.setComments(json.get(i).findPath("comments").intValue());
            messageList.add(message);
        }
        this.messageDAO.saveMessages(messageList);
        return ok(mapper.writeValueAsString(messageList));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result updateMessageList() throws JsonProcessingException {
        JsonNode json = request().body().asJson();
        ObjectMapper mapper = new ObjectMapper();
        List <Message> messageList = new ArrayList<>();
        for(int i=0; i<json.size(); i++){
            Message message = new Message();
            message.setId(json.get(i).findPath("id").textValue());
            message.setName(json.get(i).findPath("name").textValue());
            message.setText(json.get(i).findPath("text").textValue());
            message.setDate_time(json.get(i).findPath("date_time_to_save").textValue());
            message.setLikes(json.get(i).findPath("likes").intValue());
            message.setComments(json.get(i).findPath("comments").intValue());
            messageList.add(message);
        }
        this.messageDAO.saveMessages(messageList);
        return ok(mapper.writeValueAsString(messageList));
    }
}
