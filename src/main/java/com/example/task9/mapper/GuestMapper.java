package com.example.task9.mapper;

import com.example.task9.entity.Guest;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;
import java.util.Optional;

@Mapper
public interface GuestMapper {
    @Select("Select * FROM guests")
    List<Guest> findAll();

    //id検索
    @Select("SELECT * FROM guests WHERE id = #{id}")
    Optional<Guest> findGuestById(int id);

    @Insert("INSERT INTO guests(id, name, age, address) VALUES(#{id}, #{name}, #{age}, #{address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertGuest(Guest guest);

    @Update("UPDATE guests SET name = #{name}, age = #{age}, address = #{address} WHERE id = #{id}")
    void updateGuest(Guest guest);
}
