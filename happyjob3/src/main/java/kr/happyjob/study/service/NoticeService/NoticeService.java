package kr.happyjob.study.service.NoticeService;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.happyjob.study.common.comnUtils.FileUtilCho;
import kr.happyjob.study.repository.notice.NoticeMapper;

import kr.happyjob.study.vo.notice.NoticeModel;

@Service
public class NoticeService {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	@Value("${fileUpload.rootPath}")
	private String rootPath;
	
	@Value("${fileUpload.noticePath}")
	private String noticePath;
	
	@Value("${fileUpload.virtualRootPath}")
	private String virtualRootPath;
	
	@Autowired
	private NoticeMapper noticeMapper;

	public List<NoticeModel> noticeList(Map<String, Object> paramMap) throws Exception {
		return noticeMapper.noticeList(paramMap);
	}

	public int noticeCnt(Map<String, Object> paramMap) throws Exception {
		return noticeMapper.noticeCnt(paramMap);
	}

	public NoticeModel noticeDetail(Map<String, Object> paramMap) throws Exception {
		return noticeMapper.noticeDetail(paramMap);
	}

	public void noticeUpdate(Map<String, Object> paramMap) throws Exception {
		
		/*
        NoticeModel detailinfo = noticeMapper.noticeDetail(paramMap);
        
        if(detailinfo.getFile_name() != null || detailinfo.getFile_name() != "") {
        	logger.info("   File Delete " + paramMap);
        	
        	File attfile = new File(detailinfo.getPhygical_path());
        	attfile.delete();        	
        } 
        */
		
		noticeMapper.updateNotice(paramMap);
	}
	
	public void noticeUpdatefile(Map<String, Object> paramMap, HttpServletRequest  request) throws Exception {
		
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		
        NoticeModel detailinfo = noticeMapper.noticeDetail(paramMap);
        
        String checkyn = (String) paramMap.get("checkyn");			
        
        if(detailinfo.getFile_size() > 0) {
        	logger.info("   File Delete " + paramMap);
        	
        	File attfile = new File(detailinfo.getPhygical_path()); 
        	
        	if(!"on".equals(checkyn)) {
				attfile.delete(); 
			}	        	       	
        }        
        
		String itemFilePath = noticePath + File.separator;	
		
		FileUtilCho fileUtil = new FileUtilCho(multipartHttpServletRequest, rootPath, virtualRootPath, itemFilePath);
		Map<String, Object> fileinfo = fileUtil.uploadFiles();
		
		//map.put("file_nm", file_nm);
        //map.put("file_size", file_Size);
        //map.put("file_loc", file_loc);
        //map.put("vrfile_loc", vrfile_loc);
        //map.put("fileExtension", fileExtension);
        //map.put("file_nm_uuid", file_nm_uuid);
		
		if(fileinfo.get("file_nm") == null){
			paramMap.put("fileyn", "N");	
			paramMap.put("fileinfo", null);	
			
			if(!"on".equals(checkyn)) {
				paramMap.put("fileyn", "Y");
			}	
		}else{
			paramMap.put("fileyn", "Y");
			paramMap.put("fileinfo", fileinfo);			
		}		
		
		noticeMapper.updateNotice(paramMap);
	}
	
	public void insertNotice(Map<String, Object> paramMap) throws Exception {

		
		noticeMapper.insertNotice(paramMap);
	}
	
	public void insertNoticefile(Map<String, Object> paramMap, HttpServletRequest  request ) throws Exception {
				
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		
		
		// "notice" + /
		String itemFilePath = noticePath + File.separator;	
		// rootpath : "Z:\\FileRepository"
		// RvirtualRootPath : /servefile
		// 저장 경로 : Z:\\FileRepository\notice\a.jpg
		
		// 1. multipartHttpServletRequest upload file 의 blob 와 파일이름
		// 2. 파일을 지정된 디렉토리에 저장 
		FileUtilCho fileUtil = new FileUtilCho(multipartHttpServletRequest, rootPath, virtualRootPath, itemFilePath);
		Map<String, Object> fileinfo = fileUtil.uploadFiles();
		
		//map.put("file_nm", file_nm);
        //map.put("file_size", file_Size);
        //map.put("file_loc", file_loc);
        //map.put("vrfile_loc", vrfile_loc);
        //map.put("fileExtension", fileExtension);
        //map.put("file_nm_uuid", file_nm_uuid);
		
		logger.info("fileinfo : " + fileinfo);
		logger.info("fileinfo file_nm : " + fileinfo.get("file_nm"));
		logger.info("fileinfo file_size : " + fileinfo.get("file_size"));
		logger.info("fileinfo file_loc : " + fileinfo.get("file_loc"));
		logger.info("fileinfo vrfile_loc : " + fileinfo.get("vrfile_loc"));
		logger.info("fileinfo fileExtension : " + fileinfo.get("fileExtension"));
		
		
		
		
		
		
		if(fileinfo.get("file_nm") == null){
			paramMap.put("fileyn", "N");	
			paramMap.put("fileinfo", null);	
		}else{
			paramMap.put("fileyn", "Y");
			paramMap.put("fileinfo", fileinfo);			
		}
		
		noticeMapper.insertNotice(paramMap);
	}
	
	public void noticeDelete(Map<String, Object> paramMap) throws Exception {
		
		NoticeModel detailinfo = noticeMapper.noticeDetail(paramMap);
	        
	    if(detailinfo.getFile_size() > 0) {
	        logger.info("   File Delete " + paramMap);
	        	
	        File attfile = new File(detailinfo.getPhygical_path());
	        attfile.delete();        	
	    }   
	        
		noticeMapper.deleteNotice(paramMap);
	}
}