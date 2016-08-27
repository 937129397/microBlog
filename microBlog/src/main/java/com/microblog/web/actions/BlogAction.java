package com.microblog.web.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.microblog.biz.BlogBiz;
import com.microblog.util.YcConstants;
import com.microblog.web.model.BlogModel;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Namespace("/")
@Scope("prototype")
@ParentPackage("struts-default")
@InterceptorRefs({ 
	@InterceptorRef(value = "fileUpload", params = {"allowedTypes","image/bmp,image/png,image/gif,image/jpeg,image/pjpeg,image/x-png"}),
	@InterceptorRef(value = "basicStack")  
})
public class BlogAction extends BaseAction implements ModelDriven<BlogModel> {
	private static final long serialVersionUID = 1L;
	private String picAllowed = "jpg,bmp,gif,png,tiff";
	private BlogModel blogModel;
	private BlogBiz blogBiz;

	@Action(value = "/blog_saveBlog")
	public void saveBlog() throws IOException {
		String pic = "";
		String video = "";
		List<File> files = blogModel.getFile();
		if (files != null && files.size() > 0) {
			for (int i = 0; i < files.size(); i++) {
				File f = new File(getSavePath(YcConstants.SAVEPATH + "\\"
						+ blogModel.getFileContentType().get(i)));
				try {
					if (!f.exists()) {
						if (!f.mkdirs()) {
							System.out.println("创建文件失败");
							return;
						}
					}
					String filename = blogModel.getFileFileName().get(i);
					String pp = getSavePath(YcConstants.SAVEPATH + "\\"
							+ blogModel.getFileContentType().get(i))
							+ "\\" + rename(filename);
					FileOutputStream fos = new FileOutputStream(pp);
					FileInputStream fis = new FileInputStream(files.get(i));
					String type = filename
							.substring(filename.lastIndexOf(".") + 1);
					if (picAllowed.contains(type)) {
						pic += pp + YcConstants.URLSPLIT;
					} else {
						video += pp + YcConstants.URLSPLIT;
					}
					byte[] buffer = new byte[1024];
					int len = 0;
					while ((len = fis.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}
					fis.close();
					fos.close();
					jsonModel.setCode(1);
					jsonModel.setObj(new Object[] { pic, video });
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		super.printJson(jsonModel, ServletActionContext.getResponse());

	}

	private String rename(String filename) {
		String type = filename.substring(filename.lastIndexOf("."));
		String newName = System.currentTimeMillis() + type;
		return newName;

	}

	private String getSavePath(String path) {
		return ServletActionContext.getServletContext().getRealPath(path);
	}

	@Override
	public BlogModel getModel() {
		blogModel = new BlogModel();
		return blogModel;
	}

	@Resource(name = "blogBizImpl")
	public void setBlogBiz(BlogBiz blogBiz) {
		this.blogBiz = blogBiz;
	}

}
