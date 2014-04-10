package de.softan.mycontacts.db.dao;

import de.softan.mycontacts.db.entity.MailUser;

public interface MailUserI extends BaseServiceI {

    MailUserI getMailByUserId(int userId);

    void setMailForUser(MailUser mailForUser);

}
