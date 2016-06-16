package cn.newtouch.dms.repository;

import cn.newtouch.dms.entity.LogDetail;
import cn.newtouch.dms.entity.LogDetailKey;

public interface LogDetailDao {
    int deleteByPrimaryKey(LogDetailKey key);

    int insert(LogDetail record);

    int insertSelective(LogDetail record);

    LogDetail selectByPrimaryKey(LogDetailKey key);

    int updateByPrimaryKeySelective(LogDetail record);

    int updateByPrimaryKey(LogDetail record);
}