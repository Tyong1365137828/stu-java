package edu.hebeu.dao;

import edu.hebeu.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public interface IMemberDao {

    /**
     * 通过id精确查询会员信息
     * @param memberId
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM member WHERE id = #{ty}")
    Member selectById(String memberId) throws Exception;
}
