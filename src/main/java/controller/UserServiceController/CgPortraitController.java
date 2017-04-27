package controller.UserServiceController;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.UserService.CgPortraitService;
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
 * @date: 2017/2/18
 */
@WebServlet("/us/cgPortrait")
public class CgPortraitController extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(CgPortraitController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String contextPath = getServletContext().getRealPath("/");

        Map<String,Object> fieldMap ;

        DiskFileItemFactory factory = new DiskFileItemFactory();

        factory.setSizeThreshold(1024*1024*4);

        String tempDirectoryPath = contextPath+"\\TemDirectory";

        File tempDirectory = new File(tempDirectoryPath);
        factory.setRepository(tempDirectory);

        ServletFileUpload upload = new ServletFileUpload(factory);

        upload.setSizeMax(1024*1024*5);

        try {
            List<FileItem> items = upload.parseRequest(req);

            fieldMap = UpLoadUtil.getMap(items,contextPath);

        } catch (FileUploadException e) {
            LOGGER.error("UpLoad portrait fail cause by file upload !",e);
            throw new RuntimeException(e);
        }

        boolean finishMark = CgPortraitService.cgPortraitHandler(fieldMap);

        resp.getWriter().print(finishMark);
    }
}
