package com.pivotal.repositories;

import com.pivotal.domain.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jaguilar on 5/27/16.
 */
public interface MessageRepository extends CrudRepository<Message, Long> {

}
