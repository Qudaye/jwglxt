package f4.web.dao;

import f4.web.entity.Authority;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by xuan on 16-10-30.
 */
@Repository
public interface AuthorityDao extends Mapper<Authority> {

    /**
     * 根据roleId获取Authority
     *
     * @param roleId
     * @return
     */
    List<Authority> getByRoleId(Integer roleId);

}
