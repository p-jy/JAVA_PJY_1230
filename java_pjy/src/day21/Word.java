package day21;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Word implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String word;
	private String partOfSpeech;
	private String meaning;
	
	@Override
	public String toString() {
		return word + " [" + partOfSpeech + "] " + meaning;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(word, other.word);
	}

	public void update(String word, String partOfSpeech, String meaning) {
		this.word = word;
		this.partOfSpeech = partOfSpeech;
		this.meaning = meaning;
	}
}
