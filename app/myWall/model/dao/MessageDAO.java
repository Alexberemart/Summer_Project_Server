package myWall.model.dao;

import myWall.model.vo.Message;

import java.util.List;

public interface MessageDAO extends myWall.model.dao.base.hibernate.GenericHibernateDAO<Message, String> {

    public List<Message> getMessages();
}
