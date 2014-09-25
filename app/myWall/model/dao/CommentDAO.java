package myWall.model.dao;

import myWall.model.dao.base.hibernate.GenericHibernateDAO;
import myWall.model.vo.Comment;

import java.util.List;

public interface CommentDAO extends GenericHibernateDAO<Comment, String> {

    public List<Comment> getComments();

    public List<Comment> getCommentsById(String pId);

    public void saveComments(List<Comment> commentList);
}
