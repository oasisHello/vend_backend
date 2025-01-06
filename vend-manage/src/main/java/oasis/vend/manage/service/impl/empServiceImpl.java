package oasis.vend.manage.service.impl;

import java.util.List;
import oasis.vend.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oasis.vend.manage.mapper.empMapper;
import oasis.vend.manage.domain.emp;
import oasis.vend.manage.service.IempService;

/**
 * Employee ListService业务层处理
 * 
 * @author oasis
 * @date 2024-12-31
 */
@Service
public class empServiceImpl implements IempService 
{
    @Autowired
    private empMapper empMapper;

    /**
     * 查询Employee List
     * 
     * @param id Employee List主键
     * @return Employee List
     */
    @Override
    public emp selectempById(Long id)
    {
        return empMapper.selectempById(id);
    }

    /**
     * 查询Employee List列表
     * 
     * @param emp Employee List
     * @return Employee List
     */
    @Override
    public List<emp> selectempList(emp emp)
    {
        return empMapper.selectempList(emp);
    }

    /**
     * 新增Employee List
     * 
     * @param emp Employee List
     * @return 结果
     */
    @Override
    public int insertemp(emp emp)
    {
        emp.setCreateTime(DateUtils.getNowDate());
        return empMapper.insertemp(emp);
    }

    /**
     * 修改Employee List
     * 
     * @param emp Employee List
     * @return 结果
     */
    @Override
    public int updateemp(emp emp)
    {
        emp.setUpdateTime(DateUtils.getNowDate());
        return empMapper.updateemp(emp);
    }

    /**
     * 批量删除Employee List
     * 
     * @param ids 需要删除的Employee List主键
     * @return 结果
     */
    @Override
    public int deleteempByIds(Long[] ids)
    {
        return empMapper.deleteempByIds(ids);
    }

    /**
     * 删除Employee List信息
     * 
     * @param id Employee List主键
     * @return 结果
     */
    @Override
    public int deleteempById(Long id)
    {
        return empMapper.deleteempById(id);
    }
}
