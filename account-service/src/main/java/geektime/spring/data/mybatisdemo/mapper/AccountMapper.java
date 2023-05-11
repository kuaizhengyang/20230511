package geektime.spring.data.mybatisdemo.mapper;

import geektime.spring.data.mybatisdemo.model.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {
    @Insert("insert into t_account (user_id, name, create_time,create_by, update_time, update_by) values (now(), #{name}, now(),#{createBy}, now(),#{updateBy})")
    @Options(useGeneratedKeys = true)
    int save(Account account);

    @Select("select * from t_account where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
    })
    Account findById(@Param("id") Long id);
}
