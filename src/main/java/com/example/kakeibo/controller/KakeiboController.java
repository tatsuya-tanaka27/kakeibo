package com.example.kakeibo.controller;

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
import com.example.kakeibo.repository.KakeiboDataRepository;
import com.example.kakeibo.repository.KakeiboUserRepository;

/**
 * 家計簿コントローラークラス
 * @author nanak
 *
 */
@Controller
@RequestMapping("/kakeibo")
@SessionAttributes(types = KakeiboFormBean.class)
public class KakeiboController {

	@SuppressWarnings("unused")
	@Autowired
	private KakeiboUserRepository kakeiboUserRepository;

	@SuppressWarnings("unused")
	@Autowired
	private KakeiboDataRepository kakeiboDataRepository;

//	@SuppressWarnings("unused")
//	@Autowired
//	private KakeiboFormBean kakeiboFormBean;

	@ModelAttribute
	KakeiboFormBean setUpForm() {
		return new KakeiboFormBean();
	}

	/**
	 * @param model
	 * @return 家計簿データ
	 */
//	@RequestMapping(value = "", method = RequestMethod.GET)
	@RequestMapping("kakeibo")
	public String index(@ModelAttribute("kakeiboFormBean") @Validated KakeiboFormBean kakeiboFormBean, Model model) {
		model.addAttribute("msg", "ここでは家計簿を作成や編集、登録することができるワン！");

		// 空のフォームオブジェクトをModelに設定
		//		model.addAttribute("KakeiboForm", new KakeiboForm());
		// 遷移先を返す(この場合はkakeibo.htmlが遷移先となる)

		try {
			kakeiboFormBean.setKakeiboUser(kakeiboUserRepository.getUser());
			model.addAttribute("userName", kakeiboFormBean.getKakeiboUser().getName());
			model.addAttribute("userId", kakeiboFormBean.getKakeiboUser().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "kakeibo/kakeibo";
	}

	@RequestMapping(value = "input", method = RequestMethod.POST)
	public String input(@Validated KakeiboFormBean kakeiboFormBean, BindingResult result, @RequestParam("input") String input, Model model) {
		model.addAttribute("input", input);
		model.addAttribute("userName", kakeiboFormBean.getKakeiboUser().getName());
		model.addAttribute("userId", kakeiboFormBean.getKakeiboUser().getId());
		return "kakeibo/input";
	}

	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String registration(@Validated KakeiboFormBean kakeiboFormBean, BindingResult result, @RequestParam("registration") String registration, Model model) {
		model.addAttribute("registration", registration);
		model.addAttribute("userName", kakeiboFormBean.getKakeiboUser().getName());
		model.addAttribute("userId", kakeiboFormBean.getKakeiboUser().getId());
		return "kakeibo/registration";
	}

	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(@Validated KakeiboFormBean kakeiboFormBean, BindingResult result, @RequestParam("list") String list, Model model) {
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