import java.rmi.RemoteException;
import java.rmi.ServerException;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.namespace.QName;

public class UploadFileClient {

	public static void main(String[] args) throws ServerException, RemoteException {
        String url = "http://localhost:8080/AxisWebService/services/UploadFile";
        String fileName = "readMe.txt";
        String path = System.getProperty("user.dir") + "\\WebRoot\\" + fileName;
        System.out.println(path);
        
        //�������൱�ڹ�����һ�����ļ�·����File��
        DataHandler handler = new DataHandler(new FileDataSource(path));
        
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(url);
        
        /**
         * ע���쳣����Ϣ�����л��� ns:FileUploadHandler �� wsdd �����ļ��е�typeMapping�е�xmlns:hns="ns:FileUploadHandler" �Ķ�Ӧ DataHandler
         * �� wsdd �����ļ��е�typeMapping�е�qname="hns:DataHandler"��DataHandler��Ӧ
         */
        QName qn = new QName("ns:FileUploadHandler", "DataHandler");
        call.registerTypeMapping(DataHandler.class, qn, 
                JAFDataHandlerSerializerFactory.class,
                JAFDataHandlerDeserializerFactory.class);
        call.setOperationName(new QName(url, "upload"));
        
        //���÷����βΣ�ע����ǲ���1��type��DataHandler���͵ģ��������qn��������һ����
        call.addParameter("handler", qn, ParameterMode.IN);
        call.addParameter("fileName", XMLType.XSD_STRING, ParameterMode.IN);

        //���÷���ֵ���ͣ�����2�ַ���������
        call.setReturnClass(String.class);
        //call.setReturnType(XMLType.XSD_STRING);
        
        String result = (String) call.invoke(new Object[] { handler, "remote_server_readMe.txt" });
        System.out.println(result);
    }

}
