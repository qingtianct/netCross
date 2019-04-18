package ct.netctoss.dao;

import ct.netctoss.entity.Admin;
/*
 * 持久层接口
 */
public interface AdminDAO {
	
	public Admin findByAdminCode(String adminCode);

}
