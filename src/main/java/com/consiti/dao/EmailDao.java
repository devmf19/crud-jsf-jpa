package com.consiti.dao;

import com.consiti.model.Email;
import java.util.List;

public interface EmailDao {

    public List<Email> findAllEmails();

    public Email findById(int id);
    
    public Email findByEmail(String email);

    public void insert(Email email);

    public void update(Email email);

    public void delete(Email email);
}
