package edu.hebeu.dao;

import edu.hebeu.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("sysLogDao")
public interface ISysLogDao {

    @Insert("INSERT INTO syslog(visitTime, username, ip, url, executionTime, method) " +
            " VALUES(#{visitTime}, #{username}, #{ip}, #{url}, #{executionTime}, #{method})")
    void insert(SysLog sysLog) throws Exception;

    @Select("SELECT * FROM sysLog ORDER BY visitTime DESC")
    List<SysLog> selectAll() throws Exception;
}
