package utils;

import db.Table_User;
import org.apache.commons.fileupload.FileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/18
 */
public class UpLoadUtil {

    private UpLoadUtil(){}

    private static final Logger LOGGER = LoggerFactory.getLogger(UpLoadUtil.class);

    /**
     * 处理以格式enctype="multipart/form-data"传过来的数据 以键值对的形式存如map中并返回
     * @param items
     * @param username
     * @return
     * @throws IOException
     */
    public static Map<String,Object> getMap(List<FileItem> items,String username) throws IOException {
        Map<String,Object> fieldMap = new HashMap<>();
        for (FileItem item : items){
            if (item.isFormField()){
                //把注册信息的键值对对应放入Map中
                String fieldName = item.getFieldName();
                String value = (new String(item.getString().getBytes("iso-8859-1"),"UTF-8"));

                fieldMap.put(fieldName,value);
            }else {
                //读取图片到输入流中
                InputStream in = item.getInputStream();

                fieldMap.put("portraitInputStream",in);

                String portrait_directory_path = username+"Portrait/";

                String portrait_url = portrait_directory_path+fieldMap.get("username")+".jpg";

                //本地路径
                System.out.println(portrait_url);

                //将图片地地址放入Map中
                fieldMap.put(Table_User.COLUMN_PORTRAIT_URL,portrait_url);
            }
        }

        if (fieldMap.containsKey("equip")){
            fieldMap.remove("equip");
        }
        return fieldMap;
    }

    /**
     * 把输入流中的文件输出到url地址位置
     * @param url
     * @param in
     */
    public static void outputFile(String url,InputStream in) {

        if (url == null){
            LOGGER.error("Url null !");
            return;
        }

        OutputStream out;

        byte[] buffer = new byte[1024];
        int len;

        try {
            out = new FileOutputStream(url);

            while ((len = in.read(buffer)) != -1){
                out.write(buffer,0,len);
            }

            out.close();
            in.close();
        } catch (IOException e) {
            LOGGER.error("Output file fail !");
            throw new RuntimeException(e);
        }

    }
}
