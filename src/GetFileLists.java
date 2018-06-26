import java.io.File;

public class GetFileLists {
	public String getFileLists() {
		String liststr = "";
		File file = new File("D:\\apache-tomcat-7.0.86\\webapps\\Test");
		String[] list = file.list();
		for(String str : list) {
			liststr += str + "#";
		}
		return liststr;
	}
}
