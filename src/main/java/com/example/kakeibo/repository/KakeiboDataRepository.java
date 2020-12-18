package com.example.kakeibo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.kakeibo.entity.KakeiboData;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
/**
 * 家計簿データ情報取得用のリポジトリクラス
 * @author nanak
 *
 */
@Repository
public class KakeiboDataRepository {

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	/**
	 * @param jdbcTemplate
	 */
	@Autowired
	public KakeiboDataRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 家計簿データ情報取得
	 * @param id
	 * @return data
	 */
	public List<KakeiboData> getDataList(String id) {
		String sql = "select * from kakeibo_data where id='";
		sql = sql + id + "'";
		List<Map<String, Object>> dataList = jdbcTemplate.queryForList(sql);
		List<KakeiboData> list = new ArrayList<>();
		for (Map<String, Object> kakeiboData : dataList) {
			KakeiboData data = new KakeiboData();
			data.setId((String) kakeiboData.get("id"));
			data.setItemId((String) kakeiboData.get("itemId"));
			data.setAmount((int) kakeiboData.get("amount"));
			data.setInputDate((Date) kakeiboData.get("inputDate"));
			data.setBiko((String) kakeiboData.get("biko"));
			list.add(data);
		}
		return list;
	}

}
