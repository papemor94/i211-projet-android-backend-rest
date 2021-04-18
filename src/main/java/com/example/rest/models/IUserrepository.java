package com.example.rest.models;

import org.glassfish.jersey.internal.util.Producer;

import javax.rmi.CORBA.Util;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.UUID;


/**
 *
 *  This Interface describe all the interaction with the database
 *
 */
public interface IUserrepository {

    /**
     *
     * save a User
     * @param livre
     */
    public void save(Utilisateur livre);

    /**
     *
     *  get all Users
     * @return
     */
    public List<Utilisateur> findAll() ;
    public Utilisateur  find(int id) ;


    /**
     *
     * Update a Livre
     * @param
     */
    public void update(int id) ;

    /**
     *
     * Delete a User by Id
     * @param id
     */
    public void delete(int id ) ;

    public void init() throws NoSuchAlgorithmException, InvalidKeySpecException;
}
