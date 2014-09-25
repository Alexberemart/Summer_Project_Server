package myWall.model.dao.impl;

import myWall.model.dao.MessageDAO;
import myWall.model.dao.base.hibernate.spring.impl.GenericHibernateSpringDAOImpl;
import myWall.model.vo.Message;

import java.util.List;

public class MessageDAOImpl extends GenericHibernateSpringDAOImpl<Message, String> implements MessageDAO{

    public MessageDAOImpl() {
        super(Message.class);
    }

    @Override
    public List<Message> getMessages() {

        List<Message> returnValue = super.findAll();

        return returnValue;
    }

    @Override
    public void saveMessages(List<Message> messageList) {

        for (Message aMessageList : messageList) {
            super.makePersistent(aMessageList);
        }
    }
}
