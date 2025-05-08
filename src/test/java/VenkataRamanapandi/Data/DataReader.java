package VenkataRamanapandi.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> reader() throws IOException
	{
		//read json file to string
		String jsoncontent=FileUtils.readFileToString(new File("C:\\Users\\pandi\\eclipse-workspace\\SeleniumFrameworkDesign"
				+ "\\src\\main\\java\\VenkataRamanapandi\\Resources\\Data.json"), StandardCharsets.UTF_8);
		//now convert this string format to hashmap format by using data bind dependency
		
		ObjectMapper mapper=new ObjectMapper();
		return mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>(){} );
		
	}

}
