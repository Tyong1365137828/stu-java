package edu.hebeu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.hebeu.po.User;
import edu.hebeu.po.UserCustom;
import edu.hebeu.po.UserQueryVo;

/**
 * @author Tyong(����)
 * UserDao.java
 * Jul 6, 2020
 * �û��ӿ�
 */
public interface UserDao {
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 * ģ����ѯ�û�
	 */
	public List<UserCustom> findUserDim(UserQueryVo userQueryVo) throws Exception;
	
	/**
	 * ��ȷ��ѯ�û�
	 * @param userQueryVo
	 * @return
	 * @throws Exception
	 */
	public UserCustom findUserSingle(UserQueryVo userQueryVo) throws Exception;
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 * ����һ������
	 */
	public void save(User user) throws Exception;
	
	/**
	 * �����û���ĵ�n��m���ļ�¼��,�������Ҫ�ö��������
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public List<UserCustom> findUserByCount(@Param("start")int start , @Param("end")int end) throws Exception;
	
	/**
	 * �û���ĸ���
	 * @param user
	 * @throws Exception
	 */
	public void update(User user) throws Exception;
	
	/**
	 * ɾ���û���һ����¼
	 * @param user
	 * @throws Exception
	 */
	public void delete(User user) throws Exception;

	/**
	 * ͨ���û�account�����������Ʒ
	 * @return
	 * @throws Exception
	 */
	public List<UserCustom> findOrderToItemsByUserAccount(UserQueryVo userQueryVo) throws Exception;
	
	/**
	 * ͨ���û�account�����������Ʒ��ʵ�ַ�ҳչʾ
	 * @param start
	 * @param end
	 * @param userQueryVo
	 * @return
	 * @throws Exception
	 */
	public List<UserCustom> findOrderToItemsByUserAccountForCount(@Param("start")int start,  @Param("end")int end, @Param("userQueryVo")UserQueryVo userQueryVo) throws Exception;
	
	/**
	 * ��ѯ��n��m�������������û�
	 * @param start
	 * @param end
	 * @param userCustom
	 * @return
	 */
	public List<UserCustom> findUserByCountMul(@Param("start")int start,  @Param("end")int end,  @Param("userCustom")UserCustom userCustom);
	
}
