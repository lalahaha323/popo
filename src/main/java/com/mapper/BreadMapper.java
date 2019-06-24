package com.mapper;

import com.pojo.Bread;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreadMapper {
     List<Bread> showBread();
}
