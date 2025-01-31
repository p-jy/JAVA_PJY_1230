package day22;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
	
	private String authority; //권한: 관리자, 사용자
	private String id;
	private String pw;
	
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
		this.authority = "사용자";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(id, other.id);
	}

}
