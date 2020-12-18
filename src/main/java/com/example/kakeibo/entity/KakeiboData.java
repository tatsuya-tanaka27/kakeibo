package com.example.kakeibo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 家計簿データ
 * @author nanak
 */
@Entity
@Table(name = "kakeibo_data")
public class KakeiboData {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seq_num")
	@Id
	/** シーケンス番号 */
	private char seq_num;

	@Column(name = "id")
	/** id */
	private String id;

	@Column(name = "itemId")
	/** 項目 */
	private String itemId;

	@Column(name = "amount")
	/** 金額 */
	private int amount;

	@Column(name = "inputDate")
	/** 入力日付 */
	private Date inputDate;

	@Column(name = "biko")
	/** 備考 */
	private String biko;

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
	 * 項目を取得
	 * @return itemId
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * 項目を設定
	 * @param itemId
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * 金額を取得
	 * @return amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * 金額を設定
	 * @param amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * 入力日付を取得
	 * @return inputDate
	 */
	public Date getInputDate() {
		return inputDate;
	}

	/**
	 * 入力日付を設定
	 * @param inputDate
	 */
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	/**
	 * 備考を取得
	 * @return biko
	 */
	public String getBiko() {
		return biko;
	}

	/**
	 * 備考を設定
	 * @param biko
	 */
	public void setBiko(String biko) {
		this.biko = biko;
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
