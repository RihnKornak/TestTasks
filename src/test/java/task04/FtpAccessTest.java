package task04;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by Rihn Kornak on 04.07.2017.
 */
public class FtpAccessTest {

    String fileName = "Test2017";
    String server = "ftp.byfly.by";
    String user = "anonymous";
    String pass = "anonymous";
    FTPClient ftpClient = new FTPClient();
    File file = null;

    public FtpAccessTest() throws MalformedURLException {
    }

    private void ftpConnect() {
        FTPClient client = this.ftpClient;

        try {
            client.connect(server);
            client.login(this.user, this.pass);
            client.enterLocalPassiveMode();
            client.setFileType(FTP.BINARY_FILE_TYPE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void uploadDir(FTPFile[] files) {
        for (FTPFile ftpFile : files) {
            if (ftpFile.isDirectory()) {
                try {

                    file = new File(ftpFile + File.separator + fileName);
                    if (file.mkdir()) {
                        file.delete();
                        System.exit(0);
                    }
//
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {


        FtpAccessTest access = new FtpAccessTest();
        access.ftpConnect();
        FTPFile[] allFiles = access.ftpClient.listFiles();
        access.uploadDir(allFiles);

    }


}
