package edu.hebeu.service;

import edu.hebeu.domain.SysLog;

import java.util.List;

public interface ISysLogService {

    /**
     * 保存日志
     * @param sysLog
     * @throws Exception
     */
    void saveS(SysLog sysLog) throws Exception;

    /**
     * 查询全部日志
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<SysLog> findAllS(Integer page, Integer pageSize) throws Exception;
}
