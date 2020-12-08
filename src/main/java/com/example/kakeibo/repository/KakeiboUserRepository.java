package com.example.kakeibo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.kakeibo.entity.KakeiboUser;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
/**
 * ユーザー情報取得用のリポジトリクラス
 * @author nanak
 *
 */
@Repository
public class KakeiboUserRepository {

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	/**
	 * @param jdbcTemplate
	 */
	@Autowired
	public KakeiboUserRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * ユーザー情報取得
	 * @return user
	 */
	public KakeiboUser getUser() {
		String sql = "select * from kakeibo_user";
		List<Map<String, Object>>userList = jdbcTemplate.queryForList(sql);
//		List<KakeiboUser> list = new ArrayList<>();
		KakeiboUser user = new KakeiboUser();
		for(Map<String,Object> kakeiboUser : userList) {
			user.setId((String)kakeiboUser.get("id"));
			user.setName((String)kakeiboUser.get("name"));
		}
		return user;
	}

}
