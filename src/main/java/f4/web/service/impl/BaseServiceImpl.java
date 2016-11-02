package f4.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import f4.web.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xuan on 16-10-28.
 */
@Service
@Transactional
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    @Autowired
    private Mapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

    @Override
    @Transactional
    public int insert(T t) {
        return mapper.insert(t);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> select(T t) {
        return mapper.select(t);
    }

    @Override
    @Transactional(readOnly = true)
    public T selectOne(T t) {
        return mapper.selectOne(t);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> selectByExample(Example example) {
        return mapper.selectByExample(example);
    }

    @Override
    @Transactional
    public int update(T t) {
        return mapper.updateByPrimaryKey(t);
    }

    @Override
    @Transactional
    public int deleteById(ID id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = true)
    public PageInfo<T> getByPage(Integer current, Integer size) {
        PageHelper.startPage(current, size);
        return new PageInfo<T>(mapper.selectAll());
    }

    @Override
    @Transactional(readOnly = true)
    public PageInfo<T> getByPage(T t, Integer current, Integer size) {
        PageHelper.startPage(current, size);
        return new PageInfo<T>(mapper.select(t));
    }
}
