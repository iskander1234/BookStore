package com.example.demo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {

}
