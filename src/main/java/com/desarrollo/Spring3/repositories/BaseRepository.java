package com.desarrollo.Spring3.repositories;

import com.desarrollo.Spring3.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository <E, ID>{
}