package de.softan.mycontacts.db.dao;

import java.util.List;

import de.softan.mycontacts.db.entity.PhoneUser;

public interface PhoneUserI extends BaseServiceI{

    List<PhoneUserI> getPhonesByUserId(int userId);

   // PhoneUserI getPhoneByUserId(PhoneUserI phoneUserI);

    void setPhoneForUser(PhoneUser phoneForUser);

}
