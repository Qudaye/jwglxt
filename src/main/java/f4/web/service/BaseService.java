package f4.web.service;

import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

/**
 * BaseService
 * T:   实体类
 * ID:  实体类的主键
 *
 * Created by xuan on 16-10-28.
 */
public interface BaseService<T, ID extends Serializable> {

    /**
     * 插入一条数据
     *
     * @param t 要插入的实体对象
     * @return 该操作影响数据库的行数
     */
    int insert(T t);

    /**
     * 根据实体信息，查询记录
     *
     * @param t 要查询的实体信息
     * @return 查询的记录
     */
    List<T> select(T t);

    /**
     * 根据实体信息，查询记录
     *
     * @param t 要查询的实体信息
     * @return 查询的记录
     */
    T selectOne(T t);

    /**
     * 查询所有记录
     *
     * @return 所有记录
     */
    List<T> selectAll();

    /**
     * Example查询
     *
     * @return 满足条件的记录
     */
    List<T> selectByExample(Example example);

    /**
     * 根据实体更新记录
     *
     * @param t 实体
     * @return 该操作影响数据库的行数
     */
    int update(T t);

    /**
     * 根据id删除记录
     *
     * @param id 记录的id
     * @return 该操作影响数据库的行数
     */
    int deleteById(ID id);

    /**
     * 分页获取信息
     *
     * @param current 当前页
     * @param size 每页显示的记录
     * @return 分页返回记录信息
     */
    PageInfo<T> getByPage(Integer current, Integer size);

    /**
     * 分页获取信息
     *
     * @param t 实体
     * @param current 每页显示的记录
     * @param size 分页返回记录信息
     * @return 分页返回记录信息
     */
    PageInfo<T> getByPage(T t, Integer current, Integer size);

}
