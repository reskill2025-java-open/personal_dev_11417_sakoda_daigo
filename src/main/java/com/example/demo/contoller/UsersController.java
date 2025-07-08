package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;


@Controller
public class UsersController {
	
	@Autowired
	UsersRepository usersRepository;	
	
	
	@GetMapping ("/login")
	public String login() 	{

		return "login";
	} 
	
	@PostMapping("/login")
	public String login(
		@RequestParam(name = "name", defaultValue = "") String name,
		@RequestParam(name = "password", defaultValue = "") String password,
		Model model) {
		
		if(name.equals("") || password.equals("")) {
			// 「必須です」と表示する
			model.addAttribute("message", "必須です");
			return "login";	
		}
		
		else {
			Users users = usersRepository.findByNameAndPassword(name,password);
				if(users != null) {
				// signin成功
				// セッションに名前を覚えさせる
				users.setName(name);

				
				// redirect:をつけると
				// 「GET」/drink
				// 再びリクエストを投げるようにクライアントに指示する
				return "redirect:/drink";
			} else {
				// signin失敗
				model.addAttribute("message", "login失敗");
				return "login";
			}
	}
	}
	
	@GetMapping ("/users")
	public String users() 	{

		return "users";
	} 
	
//	@PostMapping("/users")
//	public String users(
//			@RequestParam(name = "name", defaultValue = "") String name,
//			@RequestParam(name = "password", defaultValue = "") String password,
//			@RequestParam(name = "email", defaultValue = "") String email,
//			@RequestParam(name = "address", defaultValue = "") String address,
//			Model model) {
//		
//		// エラーチェック
//				List<String> errorList = new ArrayList<>();
//				if (name.length() == 0) {
//					errorList.add("名前は必須です");
//				}
//				if (password.length() == 0) {
//					errorList.add("パスワードは必須です");
//				}
//				if (email.length() == 0) {
//					errorList.add("メールアドレスは必須です");
//				}
//				if (address.length() == 0) {
//					errorList.add("住所は必須です");
//				}
//				
//		
//		if(name.equals("") || password.equals("") || email.equals("") || address.equals("")) {
//			// 「必須です」と表示する
//			model.addAttribute("message", "必須です");
//			return "users";	
//		}
//		else {
//			Users users = usersRepository.findByNameAndPassword(name,password);
//				if(users != null) {
//				// signin成功
//				// セッションに名前を覚えさせる
//				users.setName(name);
//
//				
//				// redirect:をつけると
//				// 「GET」/drink
//				// 再びリクエストを投げるようにクライアントに指示する
//				return "redirect:/drink";
//			} else {
//				// signin失敗
//				model.addAttribute("message", "登録失敗");
//				return "users";
//			}
//}
}

