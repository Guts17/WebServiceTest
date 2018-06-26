import java.io.File;
import java.io.FileOutputStream;
public class UploadFileWebService {
	public static String uploadFile(byte[] input,String filename) {
		String liststr = "";
		try {
			File file = new File("D:\\apache-tomcat-7.0.86\\webapps\\Test" + filename);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(input);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			return "unsuccess:" + e.getMessage();
		}
		return "success:" + liststr;
	}
}
