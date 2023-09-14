package model.dao;

// 안전결제 클래스
public class SafePaymentDao extends Dao{

	private static SafePaymentDao safePaymentDao = new SafePaymentDao();
	public static SafePaymentDao getInstance() {
		return safePaymentDao;
	}
	private SafePaymentDao() {}
	
	/* 미정 */
	
}
