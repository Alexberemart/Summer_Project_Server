package myWall.model.dao.impl;

import myWall.model.dao.CommentDAO;
import myWall.model.dao.base.hibernate.spring.impl.GenericHibernateSpringDAOImpl;
import myWall.model.vo.Comment;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CommentDAOImpl extends GenericHibernateSpringDAOImpl<Comment, String> implements CommentDAO {

    public CommentDAOImpl() {
        super(Comment.class);
    }

    @Override
    public List<Comment> getComments() {

        List<Comment> returnValue = super.findAll();

        return returnValue;
    }

    @Override
    public void saveComments(List<Comment> commentList) {

        for (Comment aCommentList : commentList) {
            super.makePersistent(aCommentList);
        }
    }

    @Override
    public List<Comment> getCommentsById(String pId) {
        Criterion idCriteria = Restrictions.eq("id_message", pId);
        return super.findByCriteria(idCriteria);
    }
}
