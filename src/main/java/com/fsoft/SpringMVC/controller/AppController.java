package com.fsoft.SpringMVC.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsoft.SpringMVC.entity.AUTDPHKM;
import com.fsoft.SpringMVC.entity.AUTDPHKMFORM;
import com.fsoft.SpringMVC.entity.AUTMFOPM;
import com.fsoft.SpringMVC.service.AUTDPHKMService;
import com.fsoft.SpringMVC.service.AUTMFOPMService;

/**
 * @author PhucTV7
 *
 * Version 1.0
 *
 * @date 2020-Jun-06
 *
 * Copyright
 *
 */
@Controller
public class AppController {

	@Autowired
	AUTDPHKMService aUTDPHKMService;

	@Autowired
	AUTMFOPMService aUTMFOPMService;

	private List<AUTDPHKM> AUTDPHKMs;

	@RequestMapping(value = "/list")
	public String getAll(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "pageInput", defaultValue = "1") int pageInput,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "error", required = false) String error) {

		if (page == 0) {
			page = pageInput - 1;
		}

		Page<AUTDPHKM> list = aUTDPHKMService.getAll(page, size);
		initial(size);

		AUTDPHKMs = list.getContent();
		AUTDPHKMFORM autdphkmform = new AUTDPHKMFORM();
		autdphkmform.setAutdphkms(AUTDPHKMs);

		model.addAttribute("autdphkmform", autdphkmform);
		model.addAttribute("listMakers", aUTMFOPMService.getAll());
		model.addAttribute("currentPage", page);
		model.addAttribute("pageInput", pageInput);
		model.addAttribute("size", size);
		model.addAttribute("totalPage", list.getTotalPages());
		model.addAttribute("error", error);
		return "home";
	}

	@RequestMapping(value = "/loadshippingdepot", method = RequestMethod.POST)
	@ResponseBody
	public String loadShippingDepotName(@RequestParam("shippingDepotCode") String shippingDepotCode) {
		AUTMFOPM autmfopm = aUTMFOPMService.findByShippingDepotCode(shippingDepotCode);
		if (autmfopm != null) {
			return autmfopm.getShippingDepotName();
		}
		return "";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "maker", required = false) String maker,
			@RequestParam(value = "shippingDepotCode", required = false) String shippingDepotCode,
			@RequestParam(value = "shippingDepotName", required = false) String shippingDepotName,
			@RequestParam(value = "carType", required = false) String carType,
			@RequestParam(value = "sScode", required = false) String sScode,
			@RequestParam(value = "deliveryLocationCode", required = false) String deliveryLocationCode,
			@RequestParam(value = "manufactureCode", required = false) String manufactureCode) {

		AUTDPHKMs = new ArrayList<AUTDPHKM>();
		List<AUTDPHKM> list = new ArrayList<AUTDPHKM>();
		// if not input all field, display all data
		if ("".equals(shippingDepotCode) && "".equals(maker) && "".equals(carType) && "".equals(sScode)
				&& "".equals(deliveryLocationCode) && "".equals(manufactureCode)) {
			return "redirect:/list";
		}

		List<AUTDPHKM> list1 = aUTDPHKMService.searchBySScode(sScode);
		if (sScode != "" && list1.size() > 0) {
			AUTDPHKMs = Stream.of(list, list1).flatMap(Collection::stream).collect(Collectors.toList());
		}

		List<AUTDPHKM> list2 = aUTDPHKMService.searchByDeliveryLocationCode(deliveryLocationCode);
		if (deliveryLocationCode != "" && list2.size() > 0) {
			AUTDPHKMs = Stream.of(AUTDPHKMs, list2).flatMap(Collection::stream).collect(Collectors.toList());
		}

		List<AUTDPHKM> list3 = aUTDPHKMService.searchByCarType(carType);
		if (carType != "" && list3.size() > 0) {
			AUTDPHKMs = Stream.of(AUTDPHKMs, list3).flatMap(Collection::stream).collect(Collectors.toList());
		}

		List<AUTDPHKM> list4 = aUTDPHKMService.searchByMaker(maker);
		if (maker != "" && list4.size() > 0) {
			AUTDPHKMs = Stream.of(AUTDPHKMs, list4).flatMap(Collection::stream).collect(Collectors.toList());
		}

		List<AUTDPHKM> list5 = aUTDPHKMService.searchByManufactureCode(manufactureCode);
		if (manufactureCode != "" && list5.size() > 0) {
			AUTDPHKMs = Stream.of(AUTDPHKMs, list5).flatMap(Collection::stream).collect(Collectors.toList());
		}

		List<AUTDPHKM> list6 = aUTDPHKMService.searchByShippingDepotCode(shippingDepotCode);
		if (shippingDepotCode != "" && list6.size() > 0) {
			AUTDPHKMs = Stream.of(AUTDPHKMs, list6).flatMap(Collection::stream).collect(Collectors.toList());
		}
		// if input not available data
		if (AUTDPHKMs.size() == 0) {
			model.addAttribute("error", "該当するデータが存在しません。");
		}

		AUTDPHKMFORM autdphkmform = new AUTDPHKMFORM();
		autdphkmform.setAutdphkms(AUTDPHKMs);

		model.addAttribute("autdphkmform", autdphkmform);
		model.addAttribute("listMakers", aUTMFOPMService.getAll());
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("totalPage", 1);
		model.addAttribute("maker", maker);
		model.addAttribute("shippingDepotCode", shippingDepotCode);
		model.addAttribute("shippingDepotName", shippingDepotName);
		model.addAttribute("carType", carType);
		model.addAttribute("sScode", sScode);
		model.addAttribute("deliveryLocationCode", deliveryLocationCode);
		model.addAttribute("manufactureCode", manufactureCode);

		return "home";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size, Model model,
			@ModelAttribute(value = "autdphkmform") AUTDPHKMFORM autdphkmform) {

		Page<AUTDPHKM> list = aUTDPHKMService.getAll(page, size);
		initial(size);

		model.addAttribute("autdphkmform", autdphkmform);
		model.addAttribute("listMakers", aUTMFOPMService.getAll());
		model.addAttribute("currentPage", page);
		model.addAttribute("pageInput", page + 1);
		model.addAttribute("size", size);
		model.addAttribute("totalPage", list.getTotalPages());

		for (int i = 0; i < autdphkmform.getAutdphkms().size(); i++) {
			// if OP = 'C' , update
			if ("C".equalsIgnoreCase(autdphkmform.getAutdphkms().get(i).getOP())) {
				// if fullsize return to page
				if (checkFullSizeShippingDepotCode(
						autdphkmform.getAutdphkms().get(i).getaUTMFOPM().getShippingDepotCode())) {
					model.addAttribute("error", (i + 1) + "行目の出荷デポは半角文字数を入力してください。");
					model.addAttribute("line", i);
					return "home";
				}
				try {
					AUTDPHKM autdphkm = aUTDPHKMService.findByShippingDepotCode(
							autdphkmform.getAutdphkms().get(i).getaUTMFOPM().getShippingDepotCode());
					if (autdphkm != null) {
						// if already exist shippingDepotCode, return home page
						if (!autdphkmform.getAutdphkms().get(i).getsScode().equals(autdphkm.getsScode())) {
							model.addAttribute("error", (i + 1) + "配送デポはすでにシステムに存在します");
							model.addAttribute("line", i);
							return "home";
						}
						aUTDPHKMService.save(autdphkm);
						model.addAttribute("message", (i + 1) + "件の新ﾃﾞﾎﾟ変換情報を更新しました。");

					} else {
						model.addAttribute("error", (i + 1) + "行目の出荷デポはＦＯＰ関連・加工／購入／委託業者情報に存在しません。");
						model.addAttribute("line", i);
						return "home";
					}

				} catch (Exception e) {
					model.addAttribute("error", (i + 1) + "データベース接続エラー!");
					model.addAttribute("line", i);
					return "home";
				}
			}
			// if OP = 'D' , delete
			if ("D".equalsIgnoreCase(autdphkmform.getAutdphkms().get(i).getOP())) {
				try {
					aUTDPHKMService.delete(autdphkmform.getAutdphkms().get(i));
					autdphkmform.getAutdphkms().remove(i);
					model.addAttribute("message", (i + 1) + "件の新ﾃﾞﾎﾟ変換情報を削除しました。");

				} catch (Exception e) {
					model.addAttribute("error", (i + 1) + "データベース接続エラー!");
					model.addAttribute("line", i);
					return "home";
				}
			}
		}

		return "home";
	}

	private List<AUTDPHKM> initial(int size) {
		AUTDPHKMs = new ArrayList<AUTDPHKM>();
		for (int i = 0; i < size; i++) {
			AUTDPHKMs.add(new AUTDPHKM());
		}
		return AUTDPHKMs;
	}

	private boolean checkFullSizeShippingDepotCode(String s) {
		try {
			int size = s.getBytes("UTF-16").length;
			return size > 12;
		} catch (UnsupportedEncodingException e) {
			e.getStackTrace();
		}
		return false;
	}

}
