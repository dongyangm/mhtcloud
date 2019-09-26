package com.mht.util.imgs;

import com.mht.util.beanUtils.ResultInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/img")
public class ImageController {

    @RequestMapping("/doupload")
    public ResultInfo imageUploa(@RequestParam("file") MultipartFile[] file, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IllegalStateException, IOException{
        List list = new ArrayList();
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        if(file!=null&&file.length>0){
             //循环获取file数组中得文件
            for(int i = 0;i<file.length;i++){
              MultipartFile files = file[i];
              //保存文件
            String amageurl = ImageUpload(files, request, response, session);

             list.add(amageurl);
             }
           }
     return new ResultInfo(true,list,1);
   }

public String ImageUpload(MultipartFile file,HttpServletRequest request,HttpServletResponse response,HttpSession session)
              throws IllegalStateException, IOException{
  String savePaths ="";
  if (file!=null) {// 判断上传的文件是否为空
     // String path="";// 文件路径
     String type=null;// 文件类型
     String fileName=file.getOriginalFilename();// 文件原名称
     // 判断文件类型
      type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
     if (type!=null) {// 判断文件类型是否为空
       if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
         // 项目在容器中实际发布运行的根路径
           String realPath=request.getSession().getServletContext().getRealPath("/");
           System.out.println("真实文件路径:"+realPath);
           String substring = realPath.substring(0, realPath.lastIndexOf("\\"));
           System.out.println("第一次截取后路径："+substring);
           String realPath2 = substring.substring(0,substring.lastIndexOf("\\"));
           System.out.println("第二次截取后路径："+realPath2);
           String finalRealPath = realPath2+"\\images\\";
           // 自定义的文件名称
           String trueFileName=String.valueOf(System.currentTimeMillis())+"."+type; //15312196403485.jpg
         // 设置存放图片文件的路径
         String path=finalRealPath+/*System.getProperty("file.separator")+*/trueFileName;
          // 转存文件到指定的路径
           File file1 = new File(path);
           if (!file1.exists()){
               file1.mkdirs();
           }
           file.transferTo(file1);
          savePaths =trueFileName;
       }else {
         System.out.println("不是我们想要的文件类型,请按要求重新上传");
         return null;
        }
     }else {
        System.out.println("文件类型为空");
        return null;
      }
    }else {
      System.out.println("没有找到相对应的文件");
      return null;
     }
    return savePaths;
  }

  @GetMapping("/downloadImg/{imgName}")
  public ResultInfo downloadImg(@PathVariable String imgName, HttpServletRequest request, HttpServletResponse response){
      String realPath = request.getSession().getServletContext().getRealPath("/");
      System.out.println("真实文件路径:"+realPath);
      String realPath1 = realPath.substring(0, realPath.lastIndexOf("\\"));
      System.out.println("第一次截取后路径："+realPath1);
      String realPath2 = realPath1.substring(0,realPath1.lastIndexOf("\\"));
      System.out.println("第二次截取后路径："+realPath2);
      String finalRealPath = realPath2+"\\images\\";
      String filePath = finalRealPath+imgName;
      File tempFile = new File(filePath);
      FileInputStream inStream = null;
      OutputStream fos = null;
      try{
          if(tempFile.exists()){
               inStream = new FileInputStream(filePath);//文件的存放路径
              fos=response.getOutputStream();
              //设置输出的格式
              response.setContentType("application/octet-stream");
              response.setHeader("Content-Disposition", "attachment;filename="+ new String(imgName.getBytes("gbk"), "iso-8859-1"));
              //循环取出流中的数据
              byte[] b = new byte[1024];
              long siz=0;
              int len = 0;
              while((len=inStream.read(b)) != -1){
                  fos.write(b,0,len);
                  siz+=len;
              }
              System.out.println(siz);
          }else{
              //无该附件
              return new ResultInfo(true,null,-1);
          }
      }catch(Exception e){
          e.printStackTrace();
      }finally {
          try {
              if (inStream != null){
                  inStream.close();
              }
              if (fos != null){
                  fos.close();
              }
          }catch (IOException e) {
              e.printStackTrace();
          }
      }
    return new ResultInfo(true,null,1);
  }

}
