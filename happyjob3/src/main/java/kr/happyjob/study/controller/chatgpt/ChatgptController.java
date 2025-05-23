package kr.happyjob.study.controller.chatgpt;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.service.chatgpt.ChatgptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/chatgpt/")
public class ChatgptController {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	// chatgpt Key
	private static final String CHATGPT_API_KEY = "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";
	
	private static final String CHATGPT_TURBO_API_KEY = "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";
	
	@Autowired
	private ChatgptService chatgptService;
	
	// chatgpt 요청 
	@RequestMapping("connectchatgpt.do")
	@ResponseBody
	public Map<String, Object> connectchatgpt(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("   - paramMap : " + paramMap);
		
        String result="N";
        String answer="연결을 실패하였습니다.";
                
        String sendmsg = (String) paramMap.get("sendmsg");
        
        try{
             answer=chatgptService.getChatResponse(sendmsg,CHATGPT_API_KEY);
             result="Y";
        }catch (Exception e){
        	result="N";
        	answer="연결 중 오류가 발생 했습니다.";
        }

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result",result);
		resultMap.put("answer",answer);

		return resultMap;
	}

	// chatgpt 요청 
	@RequestMapping("connectchatgpt4.do")
	@ResponseBody
	public Map<String, Object> connectchatgpt4(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("   - paramMap : " + paramMap);
		
        String result="N";
        String answer="연결을 실패하였습니다.";
                
        String sendmsg = (String) paramMap.get("sendmsg");
        
        try{
             answer=chatgptService.getChatResponse4(sendmsg,CHATGPT_API_KEY);
             result="Y";
        }catch (Exception e){
        	result="N";
        	answer="연결 중 오류가 발생 했습니다.";
        }

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result",result);
		resultMap.put("answer",answer);

		return resultMap;
	}	
	
	// chatgpt 요청 
	@RequestMapping("connectchatgpt4file.do")
	@ResponseBody
	public Map<String, Object> connectchatgpt4file(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("   - paramMap : " + paramMap);
		
        String result="N";
        String answer="연결을 실패하였습니다.";
                
        String sendmsg = (String) paramMap.get("sendmsg");
        
        try{
             answer=chatgptService.getChatResponse4file(sendmsg, request, CHATGPT_API_KEY, CHATGPT_TURBO_API_KEY);
             result="Y";
        }catch (Exception e){
        	result="N";
        	answer="연결 중 오류가 발생 했습니다.";
        }

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result",result);
		resultMap.put("answer",answer);

		return resultMap;
	}	
	
}