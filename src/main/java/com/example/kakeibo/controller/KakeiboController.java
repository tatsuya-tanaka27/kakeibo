package com.example.kakeibo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.kakeibo.bean.KakeiboFormBean;
import com.example.kakeibo.service.TopService;

/**
 * 家計簿コントローラークラス
 * @author nanak
 *
 */
@Controller
@RequestMapping("/kakeibo")
@SessionAttributes(types = KakeiboFormBean.class)
public class KakeiboController {

	//	Log log = LogFactory.getLog(KakeiboController.class);
	private static final Logger logger = LoggerFactory.getLogger(KakeiboController.class);

	@SuppressWarnings("unused")
	@Autowired
	private TopService topService;

	//	@SuppressWarnings("unused")
	//	@Autowired
	//	private KakeiboFormBean kakeiboFormBean;

	@ModelAttribute
	KakeiboFormBean setUpForm() {
		return new KakeiboFormBean();
	}

	@RequestMapping("login")
	public String login(Model model) {

		return "kakeibo/login";
	}

	/**
	 * 家計簿トップ画面
	 * @param kakeiboFormBean
	 * @param model
	 * @return 家計簿データ
	 */
	@RequestMapping(value = "index", method = RequestMethod.POST)
	public String index(@Validated KakeiboFormBean kakeiboFormBean, BindingResult result,
			@RequestParam Map<String, String> params, Model model) {
		model.addAttribute("msg", "ここでは家計簿を作成や編集、登録することができるワン！");

		logger.info("家計簿トップ画面");

		// 空のフォームオブジェクトをModelに設定
		//		model.addAttribute("KakeiboForm", new KakeiboForm());
		// 遷移先を返す(この場合はkakeibo.htmlが遷移先となる)

		try {

			// ユーザー情報取得
			kakeiboFormBean.setKakeiboUser(topService.getUser());
			model.addAttribute("kakeiboUser", kakeiboFormBean.getKakeiboUser());
//			model.addAttribute("userName", kakeiboFormBean.getKakeiboUser().getName());
//			model.addAttribute("userId", kakeiboFormBean.getKakeiboUser().getId());

			// 家計簿データ取得
			kakeiboFormBean
					.setKakeiboDataList(topService.getDataList(kakeiboFormBean.getKakeiboUser().getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("家計簿ユーザー情報「ユーザー名：" + kakeiboFormBean.getKakeiboUser().getName()
				+ "　ID：" + kakeiboFormBean.getKakeiboUser().getId());

		return "kakeibo/index";
	}

	/**
	 * 家計簿入力画面
	 * @param kakeiboFormBean
	 * @param result
	 * @param input
	 * @param model
	 * @return 家計簿データ
	 */
	@RequestMapping(value = "input", method = RequestMethod.POST)
	public String input(@Validated KakeiboFormBean kakeiboFormBean, BindingResult result,
			@RequestParam("input") String input, Model model) {
		model.addAttribute("input", input);
		model.addAttribute("userName", kakeiboFormBean.getKakeiboUser().getName());
		model.addAttribute("userId", kakeiboFormBean.getKakeiboUser().getId());
		return "kakeibo/input";
	}

	/**
	 * 家計簿項目登録画面
	 * @param kakeiboFormBean
	 * @param result
	 * @param registration
	 * @param model
	 * @return 家計簿データ
	 */
	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String registration(@Validated KakeiboFormBean kakeiboFormBean, BindingResult result,
			@RequestParam("registration") String registration, Model model) {
		model.addAttribute("registration", registration);
		model.addAttribute("userName", kakeiboFormBean.getKakeiboUser().getName());
		model.addAttribute("userId", kakeiboFormBean.getKakeiboUser().getId());
		return "kakeibo/registration";
	}

	/**
	 * 家計簿一覧画面
	 * @param kakeiboFormBean
	 * @param result
	 * @param list
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(@Validated KakeiboFormBean kakeiboFormBean, BindingResult result,
			@RequestParam("list") String list, Model model) {
		model.addAttribute("list", list);
		model.addAttribute("userName", kakeiboFormBean.getKakeiboUser().getName());
		model.addAttribute("userId", kakeiboFormBean.getKakeiboUser().getId());
		return "kakeibo/list";
	}

	//	/**
	//	 * @return
	//	 */
	//	@RequestMapping(value="/input", method=RequestMethod.POST, params="action=input")
	//	public ModelAndView input() {
	//		return input;
	//	}

	//	/**
	//	 * @return
	//	 */
	//	@RequestMapping(value = "/input", params = "input", method = RequestMethod.POST)
	//    public String input() {
	//        return "kakeibo/input";
	//    }

	//	/**
	//	 * @param kakeiboForm
	//	 * @return
	//	 */
	//	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	//	public String input(@ModelAttribute("kakeiboForm") KakeiboForm kakeiboForm) {
	//                // 遷移先を返す(この場合はinput.htmlが遷移先となる)
	//		return "input";
	//	}

}