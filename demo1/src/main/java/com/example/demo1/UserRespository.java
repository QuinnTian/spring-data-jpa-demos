package com.example.demo1;

import org.springframework.data.repository.CrudRepository;

public interface UserRespository extends CrudRepository<User,Long> {
}
