package com.myanmar.travel.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.myanmar.travel.service.PackageDaoService;
import com.myanmar.travel.service.PackageService;
import com.myanmar.travel.vo.TravelPackage;
import com.myanmar.travel.vo.User;
import com.opensymphony.xwork2.ActionSupport;

public class BuyPackageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private PackageService packageService = new PackageDaoService();
	private List<TravelPackage> packageList;
	private HttpSession session;
	
	public List<TravelPackage> getPackageList() {
		return packageList;
	}

	public void setPackageList(List<TravelPackage> packageList) {
		this.packageList = packageList;
	}
	
	public String buyPackage() {
		session = ServletActionContext.getRequest().getSession(false);
		User u = (User) session.getAttribute("userSession");
		String packageIdStr = ServletActionContext.getRequest().getParameter("buyId");
		int packageId = Integer.parseInt(packageIdStr);
		packageService.insertBuyPackage(u.getId(), packageId);
		packageService.updateQuantity(packageId);
		packageService.updateFlag(packageId);
		return SUCCESS;
	}
	
	public String searchPackageAgain() {
		session = ServletActionContext.getRequest().getSession(false);
		Integer locId = (Integer) session.getAttribute("locId");
		int price = (int) session.getAttribute("price");
		packageList = packageService.getPackageByLocAndPrice(locId, price);
		return SUCCESS;
	}

	@Override
	public void validate() {
		addActionMessage("You have been successfully bought.");
	}
}
