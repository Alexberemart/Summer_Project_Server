package myWall.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import myWall.model.dao.CommentDAO;
import myWall.model.vo.Comment;
import myWall.model.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class CommentServices extends Controller {

    @Autowired
    @Qualifier("target")
    protected CommentDAO commentDAO;

    public Result getCommentList() throws JsonProcessingException {
        List<Comment> commentList = this.commentDAO.getComments();
        ObjectMapper mapper = new ObjectMapper();
        return ok(mapper.writeValueAsString(commentList));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result getCommentListById() throws JsonProcessingException {
        JsonNode json = request().body().asJson();
        List<Comment> commentList = this.commentDAO.getCommentsById(json.get(0).findPath("id").textValue());
        ObjectMapper mapper = new ObjectMapper();
        return ok(mapper.writeValueAsString(commentList));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result saveCommentList() throws JsonProcessingException {
        JsonNode json = request().body().asJson();
        ObjectMapper mapper = new ObjectMapper();
        List <Comment> commentList = new ArrayList<>();
        for(int i=0; i<json.size(); i++){
            Comment comment = new Comment();
            comment.setName(json.get(i).findPath("name").textValue());
            comment.setText(json.get(i).findPath("text").textValue());
            comment.setDate_time(json.get(i).findPath("date_time_to_save").textValue());
            comment.setId_message(json.get(i).findPath("idMessage").textValue());
            commentList.add(comment);
        }
        this.commentDAO.saveComments(commentList);
        return ok(mapper.writeValueAsString(commentList));
    }
}
