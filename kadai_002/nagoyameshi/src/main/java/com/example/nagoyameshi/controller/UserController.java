package com.example.nagoyameshi.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal; // ログインユーザー情報を取得するアノテーション
import org.springframework.stereotype.Controller; // Spring MVCコントローラを示すアノテーション
import org.springframework.ui.Model; // ビューにデータを渡すためのオブジェクト
import org.springframework.validation.BindingResult; // バリデーション結果を格納するオブジェクト
import org.springframework.validation.FieldError; // フィールドエラーを表現するクラス
import org.springframework.validation.annotation.Validated; // バリデーションを有効にするアノテーション
import org.springframework.web.bind.annotation.GetMapping; // HTTP GETリクエストを処理するアノテーション
import org.springframework.web.bind.annotation.ModelAttribute; // フォームデータをオブジェクトにバインドするアノテーション
import org.springframework.web.bind.annotation.PostMapping; // HTTP POSTリクエストを処理するアノテーション
import org.springframework.web.bind.annotation.RequestMapping; // コントローラの共通URLを指定するアノテーション
import org.springframework.web.servlet.mvc.support.RedirectAttributes; // リダイレクト時にデータを渡すためのオブジェクト

import com.example.nagoyameshi.entity.User; // ユーザーエンティティ
import com.example.nagoyameshi.form.UserEditForm; // ユーザー編集フォーム
import com.example.nagoyameshi.repository.UserRepository; // ユーザーリポジトリ
import com.example.nagoyameshi.security.UserDetailsImpl; // ログインユーザー詳細情報
import com.example.nagoyameshi.service.UserService; // ユーザーサービス

/**
 * UserControllerクラス
 * 
 * このクラスはユーザーに関連する操作を管理するコントローラクラスです。
 * ユーザーの詳細表示、編集、更新などの機能を提供します。
 */
@Controller
@RequestMapping("/user") // "/user" URLに対応
public class UserController {

	private final UserRepository userRepository; // ユーザー情報を操作するリポジトリ
	private final UserService userService; // ユーザー関連のビジネスロジックを扱うサービス

	/**
	 * コンストラクタで依存オブジェクトを注入します。
	 * 
	 * @param userRepository ユーザーリポジトリ
	 * @param userService ユーザーサービス
	 */
	public UserController(UserRepository userRepository, UserService userService) {
		this.userRepository = userRepository;
		this.userService = userService;
	}

	/**
	 * ユーザー詳細ページを表示します。
	 * 
	 * @param userDetailsImpl ログインユーザーの詳細情報
	 * @param model ビューに渡すデータ
	 * @return ユーザー詳細ページのテンプレート名
	 */
	@GetMapping
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {
		// ログインしているユーザーをデータベースから取得
		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());

		// ユーザー情報をビューに渡す
		model.addAttribute("user", user);

		return "user/index"; // "user/index.html" を表示
	}

	/**
	 * ユーザー編集ページを表示します。
	 * 
	 * @param userDetailsImpl ログインユーザーの詳細情報
	 * @param model ビューに渡すデータ
	 * @return ユーザー編集ページのテンプレート名
	 */
	@GetMapping("/edit")
	public String edit(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {
		// ログインしているユーザーをデータベースから取得
		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());

		// ユーザー情報を編集フォームに設定
		UserEditForm userEditForm = new UserEditForm(
				user.getId(), user.getName(), user.getFurigana(),
				user.getPostalCode(), user.getAddress(),
				user.getPhoneNumber(), user.getEmail());

		// 編集フォームデータをビューに渡す
		model.addAttribute("userEditForm", userEditForm);

		return "user/edit"; // "user/edit.html" を表示
	}

	/**
	 * ユーザー情報を更新します。
	 * 
	 * @param userEditForm ユーザー編集フォームのデータ
	 * @param bindingResult バリデーション結果
	 * @param redirectAttributes リダイレクト時に渡すフラッシュデータ
	 * @return リダイレクト先のURL
	 */
	@PostMapping("/update")
	public String update(@ModelAttribute @Validated UserEditForm userEditForm,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		// メールアドレスが変更され、すでに登録済みの場合エラーを追加
		if (userService.isEmailChanged(userEditForm) &&
				userService.isEmailRegistered(userEditForm.getEmail())) {
			FieldError fieldError = new FieldError(
					bindingResult.getObjectName(), "email", "すでに登録済みのメールアドレスです。");
			bindingResult.addError(fieldError);
		}

		// バリデーションエラーがある場合、編集ページを再表示
		if (bindingResult.hasErrors()) {
			return "user/edit";
		}

		// ユーザー情報を更新
		userService.update(userEditForm);

		// 成功メッセージをリダイレクト時に設定
		redirectAttributes.addFlashAttribute("successMessage", "会員情報を編集しました。");

		return "redirect:/user"; // ユーザー詳細ページにリダイレクト
	}
}
