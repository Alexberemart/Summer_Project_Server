package myWall.model.dao;

import myWall.model.dao.base.hibernate.GenericHibernateDAO;
import myWall.model.vo.Message;

import java.util.List;

public interface MessageDAO extends GenericHibernateDAO<Message, String> {

    public List<Message> getMessages();

    public void saveMessages(List<Message> messageList);
}
