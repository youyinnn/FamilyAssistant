package controller.LoginServiceController;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.LoginService.SignInService;
import utils.UpLoadUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/16
 */
@WebServlet("/lg/signIn")
public class SignInController extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignInController.class);

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String contextPath = getServletContext().getRealPath("/");

        Map<String,Object> fieldMap;

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // 设置内存中最多可以存放的上传文件的大小, 若超出则把文件写到一个临时文件夹中. 以 byte 为单位
        factory.setSizeThreshold(1024*1024*4);

        //临时文件夹
        String tempDirectoryPath = contextPath+"\\TempDirectory";

        File tempDirectory = new File(tempDirectoryPath);
        factory.setRepository(tempDirectory);

        ServletFileUpload upload = new ServletFileUpload(factory);

        // 设置上传文件的总的大小. 也可以设置单个文件的大小 5mb
        upload.setSizeMax(1024*1024*5);

        try {
            List<FileItem> items = upload.parseRequest(req);

            fieldMap = UpLoadUtil.getMap(items,contextPath);

        } catch (FileUploadException e) {
            LOGGER.error("SignIn service failure cause by file upload !",e);
            throw new RuntimeException(e);
        }

        //System.out.println(fieldMap);

        //将所有得到的信息存入Map中
        boolean finishMark = SignInService.signInHandler(fieldMap);

        resp.getWriter().print(finishMark);
    }
}