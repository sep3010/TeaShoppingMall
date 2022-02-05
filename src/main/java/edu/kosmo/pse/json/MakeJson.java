package edu.kosmo.pse.json;

import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class MakeJson {
	
	public static String maekJson(Collection<?> collection){
		ObjectMapper objectMapper = new ObjectMapper();
		String objJson = "";
		
		try {
			objJson = objectMapper.writeValueAsString(collection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objJson;
	}
	
}
