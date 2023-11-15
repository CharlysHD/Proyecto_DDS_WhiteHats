package com.desarrollo.Spring5.repositories;

import com.desarrollo.Spring5.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository <E, ID>{
}