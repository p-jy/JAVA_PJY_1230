package day19.instructor;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Record implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int count;
	private String nickName;
	private Date date;
	
	public Record(int count, String nickName) {
		this.count = count;
		
		//nickName은 최대 3자, 3자 미만이면 남은 자리를 "?"로 채움.
		if(nickName == null) {
			nickName = "";
		}
		if(nickName.length() > 3) {
			this.nickName = nickName.substring(0, 3);
			return;
		}
		
		int cnt = 3 - nickName.length();
		this.nickName = nickName + "?".repeat(cnt);
		this.date = new Date();
	}

	@Override
	public String toString() {
		return nickName + " : " + count + "회";
	}
	
}
