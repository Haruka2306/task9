package com.example.task9.mapper;

import com.example.task9.entity.Guest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface GuestMapper {
    @Select("Select * FROM guests")
    List<Guest> findAll();

    //id検索
    @Select("SELECT * FROM guests WHERE id = #{id}")
    Optional<Guest> findGuestById(int id);
}
