package day19;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Record implements Serializable{
	
	private static final long serialVersionUID = -1880244755179808692L;
	
	private int record;
	private String name;
	private Date date;
	
	public Record(String name, int record) {
		this.name = name;
		this.record = record;
		this.date = new Date();
	}

	@Override
	public String toString() {
		return name + " : " + record;
	}
	
	
}
