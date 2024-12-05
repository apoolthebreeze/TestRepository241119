package springBootPDYMiniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import springBootPDYMiniProject.repository.DeliveryRepository;
import springBootPDYMiniProject.service.delivery.DeliveryInsertService;
import springBootPDYMiniProject.service.purchase.OrderProcessListService;

@Controller
@RequestMapping("delivery")
public class DeliveryController {
	@Autowired
	OrderProcessListService orderProcessListService;
	@Autowired
	DeliveryInsertService deliveryInsertService;
	@Autowired
	DeliveryRepository deliveryRepository;

	@GetMapping("deliveryRegist")
	public String deliveryRegist(String purchaseNum, Model model, HttpSession session) {
		orderProcessListService.execute(session, model, purchaseNum);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/delivery/deliveryRegist";
	}

	@PostMapping("deliveryRegist")
	public String deliveryRegist(String purchaseNum,
			@RequestParam(value = "deliveryNum", required = false, defaultValue = "") String deliveryNum) {
		deliveryInsertService.execute(purchaseNum, deliveryNum);
		return "redirect:deliveryRegist?purchaseNum=" + purchaseNum;
	}

	@GetMapping("deliveryStatus")
	public String deliveryStatus(String purchaseNum) {
		deliveryRepository.deliveryStatusUpdate(purchaseNum);
		return "redirect:/purchase/purchaseList";
	}

	@PostMapping("deliveryDelete")
	public String deliveryDelete(String purchaseNum) {
		deliveryRepository.deliveryDelete(purchaseNum);
		return "redirect:deliveryRegist?purchaseNum=" + purchaseNum;
	}
}