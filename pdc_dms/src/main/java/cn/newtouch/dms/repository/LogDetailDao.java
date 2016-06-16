package cn.newtouch.dms.repository;

import java.util.List;

import cn.newtouch.dms.entity.LogDetail;

public interface LogDetailDao {
	
    int deleteByCondition(LogDetail logDetail);

    int insert(LogDetail record);

    int insertSelective(LogDetail record);

    List<LogDetail> selectByCondition(LogDetail logDetail);

    int updateByPrimaryKeySelective(LogDetail record);

    int updateByPrimaryKey(LogDetail record);
}