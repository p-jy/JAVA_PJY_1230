package kr.kh.spring.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	int bo_num;
	String bo_title, bo_content, bo_me_id;
	Date bo_date;
	int bo_view;
	
	public int getBo_num() {
		return bo_num;
	}
	public void setBo_num(int bo_num) {
		this.bo_num = bo_num;
	}
	public String getBo_title() {
		return bo_title;
	}
	public void setBo_title(String bo_title) {
		this.bo_title = bo_title;
	}
	public String getBo_content() {
		return bo_content;
	}
	public void setBo_content(String bo_content) {
		this.bo_content = bo_content;
	}
	public String getBo_me_id() {
		return bo_me_id;
	}
	public void setBo_me_id(String bo_me_id) {
		this.bo_me_id = bo_me_id;
	}
	public Date getBo_date() {
		return bo_date;
	}
	public void setBo_date(Date bo_date) {
		this.bo_date = bo_date;
	}
	public int getBo_view() {
		return bo_view;
	}
	public void setBo_view(int bo_view) {
		this.bo_view = bo_view;
	}
	
	
	
}
