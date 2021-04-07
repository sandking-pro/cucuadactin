package com.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.adactin.BaseClass;
import org.junit.Assert;
import org.login.elements.BookHotel;
import org.login.elements.SearchHotelElements;
import org.login.elements.SelectHotel;

import cucumber.api.java.en.Then;

public class SearchPageSteps extends BaseClass {
	
	SearchHotelElements sh;
	SelectHotel slh;
	BookHotel bh;
	
	private static int n =0;
	
	@Then("User should verify login and in search hotels Page")
	public void user_should_verify_login_and_in_search_hotels_Page() {
		sh = new SearchHotelElements();
		Assert.assertTrue("verify", sh.getLoginVerify().getAttribute("value").contains("prakash"));
	}
	
	@Then("User should search hotels using preferred valid details")
	public void user_should_search_hotels_using_preferred_valid_details(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(n);

			selectDropdown(sh.getLocation(), map.get("location"), "vt");
			selectDropdown(sh.getHotels(), map.get("hotels"), "vt");
			selectDropdown(sh.getRt(), map.get("roomType"), "vt");
			selectDropdown(sh.getNor(), map.get("numberOfRooms"), "val");
			enterText(sh.getCheckin(), map.get("checkIn"));
			enterText(sh.getCheckout(), map.get("checkOut"));
			selectDropdown(sh.getApr(), map.get("apr"), "val");
			selectDropdown(sh.getCpr(), map.get("cpr"), "val");

	}

	@Then("User should click the search button")
	public void user_should_click_the_search_button() {
		   btnClick(sh.getSubmitSearch());
	}

	@Then("User should select hotel and click the continue button")
	public void user_should_select_hotel_and_click_the_continue_button() {
	    slh = new SelectHotel();
	    btnClick(slh.getSelectHotel());
		btnClick(slh.getContinueBtn());
	}

	@Then("User should book hotel using valid user details")
	public void user_should_book_hotel_using_valid_user_details(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> asMaps1 = dataTable.asMaps();
		Map<String, String> map = asMaps1.get(n);
		
			bh = new BookHotel();
			enterText(bh.getFname(), map.get("firstName"));
			enterText(bh.getLname(),  map.get("lastName"));
			enterText(bh.getAddress(),  map.get("address"));
			enterText(bh.getCcnum(),  map.get("crediCardNo"));
			selectDropdown(bh.getCctype(),  map.get("creditCardType"),"val");
			selectDropdown(bh.getCc_exp_month(),  map.get("expiryMonth"),"val");
			selectDropdown(bh.getCc_exp_year(),  map.get("expiryYear"),"val");
			enterText(bh.getCc_cvv(),  map.get("cvv"));
		
	}

	@Then("User should book the hotel and verify order details")
	public void user_should_book_the_hotel_and_verify_order_details() {
		btnClick(bh.getBook_now());
		driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS) ;
		System.out.println("Order Id"+getAttributeText(bh.getOrderno()));
	}

	@Then("User should logout and exit")
	public void user_should_logout_and_exit() {
	    n++;
	    driver.close();
	}


}
