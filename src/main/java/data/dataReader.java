package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class dataReader {
	public String useremail;
	public String password;
	public String receipentMail;
	public String mailTitle;

	public void readData() throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub


		String filepath=System.getProperty("user.dir")+"/src/main/java/data/data.json";
		File srcfile= new File(filepath);
		JSONParser parser=new JSONParser();
		JSONArray jsonarray=(JSONArray) parser.parse(new FileReader(srcfile));
		for (Object Jarray:jsonarray){

			JSONObject taskData = (JSONObject) Jarray;
			useremail = (String) taskData.get("user_email");
			System.out.println(useremail);
			password = (String) taskData.get("password");
			System.out.println(password);
			receipentMail = (String) taskData.get("receipent_mail");
			System.out.println(receipentMail);
			mailTitle = (String) taskData.get("mail_title");
			System.out.println(mailTitle);
		}
	}
}