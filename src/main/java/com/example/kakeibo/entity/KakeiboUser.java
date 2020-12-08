package com.example.kakeibo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * ユーザーエンティティ
 * @author nanak
 */
@Entity
@Table(name = "kakeibo_user")
public class KakeiboUser {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seq_num")
	@Id
	/** シーケンス番号 */
	private char seq_num;

	@Column(name = "id")
	/** id */
	private String id;

	@Column(name = "pass")
	/** パスワード */
	private char pass;

	@Column(name = "name")
	/** 氏名 */
	private String name;

	@Column(name = "memo")
	/** メモ */
	private String memo;

	@Column(name = "del_flg")
	/** 削除フラグ */
	private char del_flg;

	@Column(name = "insert_date")
	/** 登録日付 */
	private Date insert_date;

	@Column(name = "update_date")
	/** 更新日付 */
	private Date update_date;


	/**
	 * シーケンス番号を取得
	 * @return seq_num
	 */
	public char getSeq_num() {
		return seq_num;
	}

	/**
	 * シーケンス番号を設定
	 * @param seq_num
	 */
	public void setSeq_num(char seq_num) {
		this.seq_num = seq_num;
	}

	/**
	 * idを取得
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * idを設定
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * パスワードを取得
	 * @return pass
	 */
	public char getPass() {
		return pass;
	}

	/**
	 * パスワードを設定
	 * @param pass
	 */
	public void setPass(char pass) {
		this.pass = pass;
	}

	/**
	 * 名前を取得
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名前を設定
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * メモを取得
	 * @return memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * メモを設定
	 * @param memo
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * 削除フラグを取得
	 * @return del_flg
	 */
	public char getDel_flg() {
		return del_flg;
	}

	/**
	 * 削除フラグを設定
	 * @param del_flg
	 */
	public void setDel_flg(char del_flg) {
		this.del_flg = del_flg;
	}

	/**
	 * 登録日付を取得
	 * @return insert_date
	 */
	public Date getInsert_date() {
		return insert_date;
	}

	/**
	 * 登録日付を設定
	 * @param insert_date
	 */
	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}

	/**
	 * 更新日付を取得
	 * @return update_date
	 */
	public Date getUpdate_date() {
		return update_date;
	}

	/**
	 * 更新日付を設定
	 * @param update_date
	 */
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

}
