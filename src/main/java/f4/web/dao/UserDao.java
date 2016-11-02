package f4.web.dao;

import f4.web.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by xuan on 16-11-1.
 */
@Repository
public interface UserDao {

    /**
     * 根据username查询User
     *
     * @param username
     * @return
     */
    User getByUsername(String username);
}
