package com.tide.meitu.action;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadImgAction extends ActionSupport{
	
	private File image; //上传的文件
    private String filetype;

    public void uploadImg() throws Exception {
    	
        String realpath = ServletActionContext.getServletContext().getRealPath("/images");
        System.out.println("realpath: "+realpath);
        String path=System.currentTimeMillis()+"."+filetype;
        System.out.println(path);
        
        if (image != null) {
            File savefile = new File(new File(realpath), path);
            if (!savefile.getParentFile().exists())
                savefile.getParentFile().mkdirs();
            FileUtils.copyFile(image, savefile);
            ActionContext.getContext().put("message", "文件上传成功");
        }
        
        try {
			HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
			response.setContentType("text/html; charset=utf-8");
			response.setHeader("Cache-Control", "no-cache");
			PrintWriter pw=null;
			pw = response.getWriter();
			pw.write("/images/"+path);
			pw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        
        
    }
    

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }


	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
}
