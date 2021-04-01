package edu.hebeu.service.impl;

import com.github.pagehelper.PageHelper;
import edu.hebeu.dao.ISysLogDao;
import edu.hebeu.domain.SysLog;
import edu.hebeu.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sysLogService")
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public List<SysLog> findAllS(Integer page, Integer pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        return sysLogDao.selectAll();
    }

    @Override
    public void saveS(SysLog sysLog) throws Exception {
        sysLogDao.insert(sysLog);
    }
}
