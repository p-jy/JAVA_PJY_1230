package day21;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private List<String> searchWord = new ArrayList<String>();
	
	public User(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	public boolean addWord(String id, String word) {
		
		if(word == null) {
			return false;
		}
		
		searchWord.add(word);
		
		return true;
	}
	
}
