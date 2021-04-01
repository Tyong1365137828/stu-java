package edu.hebeu.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 传统上传文件的方式
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/file_upload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("fileUpload1()方法执行了...");
        /**调用FileUpload组件完成文件上传*/
        String uploadPath = request.getSession().getServletContext().getRealPath("/uploads/"); // 获取这个项目的 /uploads/文件夹的 绝对路径
        /**通过获取的上传文件的绝对路径创建出一个File对象*/
        File filePath = new File(uploadPath);
        /**判断该上传路径是否存在*/
        if (!filePath.exists()) { // 如果不存在
            System.out.println("创建目录成功！！！");
            filePath.mkdirs(); // 创建这个上传路径对应的文件夹
        }

        /**创建解析request对象来进行上传文件的工具对象*/
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory(); // 创建磁盘文件项工厂
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory); // 通过磁盘文件项工厂对象 创建 上传文件使用的对象

        /**解析request对象，获取上传文件项*/
        List<FileItem> fileItems = upload.parseRequest(request); // 获取所有的文件项
        System.out.println("fileItems = " + fileItems);
        /**
         * 因为前台的表单上传文件使用的是 enctype="multipart/form-data" ， 会将上传的文件分割成若干个文件项
         */
        /**遍历文件项*/
        for (FileItem fileItem : fileItems) { // 遍历所有的文件项
            System.out.println("正在遍历...");
            /**判断当前的fileItem对象是否是上传文件对象*/
            if (fileItem.isFormField()) { // 如果是一个普通的表单项
                System.out.println("是一个普通表单");
            } else { // 否则，即是一个上传文件项
                System.out.println("是一个上传文件项");

                String fileName = fileItem.getName(); // 获取上传文件的名称
                /**将文件的名称设置为唯一的*/
                String uniqueName = UUID.randomUUID().toString().replace("-", ""); // 生成一个唯一的字符串，并且将 - 替换掉(替换为空)
                /**创建上传的文件对象*/
                File uploadFile = new File(filePath, uniqueName + "_" + fileName); // 创建文件对象(文件名为 fileName_uniqueName，文件路径为 filePath)
                /**完成文件上传*/
                fileItem.write(uploadFile);
                /**删除临时文件
                 *      因为当上传的文件大小在10kb以内，会在把内存中以缓存的形式创建临时文件;
                 *      如果上传的文件大小大于10kb，此时会创建临时文件，为了减少存储空间的浪费，需要我们手动删除掉这个临时文件;*/
                fileItem.delete();
                System.out.println(fileName + "_" + uniqueName);
            }
        }
        return "success";
    }

    /**
     * 使用SpringMVC方式实现文件上传
     *  注意：
     *      要求MultipartFile类型的参数名要与前台的 <input type="file" name = "upload" />标签的 name属性值保持一致！！！
     * @param request
     * @param upload
     * @return
     */
    @RequestMapping("/file_upload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("fileUpload2()方法执行了...");
        /**调用FileUpload组件完成文件上传*/
        String uploadPath = request.getSession().getServletContext().getRealPath("/uploads/"); // 获取这个项目的 /uploads/文件夹的 绝对路径

        File filePath = new File(uploadPath);
        /**判断该上传路径是否存在*/
        if (!filePath.exists()) { // 如果不存在
            System.out.println("创建目录成功！！！");
            filePath.mkdirs(); // 创建这个上传路径对应的文件夹
        }

        System.out.println("SpringMVC方式上传文件...");

        /**获取上传文件的名称*/
        String fileName = upload.getOriginalFilename();
        /**将文件的名称设置为唯一的*/
        String uniqueName = UUID.randomUUID().toString().replace("-", ""); // 生成一个唯一的字符串，并且将 - 替换掉(替换为空)
        /**创建上传的文件对象*/
        File uploadFile = new File(filePath, uniqueName + "_" + fileName); // 创建文件对象(文件名为 fileName_uniqueName，文件路径为 filePath)
        upload.transferTo(uploadFile);

        return "success";
    }

    /**
     * 跨服务器上传文件
     * @param upload
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/file_upload3", method = RequestMethod.POST)
    public String fileUpload3(MultipartFile upload) throws IOException {
        System.out.println("fileUpload3()方法执行了...");
        System.out.println("跨服务器上传文件...");

        /**定义上传文件的服务器路径*/
        String uploadPath = "http://localhost:9090/uploads";

        /**获取上传文件的名称*/
        String fileName = upload.getOriginalFilename();
        /**将文件的名称设置为唯一的*/
        String uniqueName = UUID.randomUUID().toString().replace("-", ""); // 生成一个唯一的字符串，并且将 - 替换掉(替换为空)
        fileName = uniqueName + "_" + fileName;

        /**创建客户端对象*/
        Client client = Client.create();
        /**与要上传到的服务器进行连接*/
        WebResource webResource = client.resource(uploadPath + "/" + fileName);
        /**上传文件(通过字节的方式传送)*/
        webResource.put(upload.getBytes());

        return "success";
    }
}
