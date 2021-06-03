package com.toy.sy;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


import java.util.List;


@Mapper
@Repository
public interface UserRepository {

    @Select("select * from user")
    public List<User> selectAll();

    @Insert("insert into toy.USER(ID,PASSWORD,TELL,EMAIL) values(#{ID},#{PASSWORD},#{TELL},#{EMAIL})")
    public void insertUser(User user);

    @Update("update USER set PASSWORD = #{PASSWORD}, TEll =#{TELL}, EMAIL = #{EMAIL} where ID = #{ID}")
    public void updateUser(User user);

    @Update("delete from USER where ID = #{ID}")
    public void deleteUser(User user);

    public void updateTest(User user);

}
