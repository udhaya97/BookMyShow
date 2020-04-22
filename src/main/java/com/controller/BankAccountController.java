package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.model.BankAccount;
import com.model.Theatre;
import com.model.UserReg;
import com.service.BankServiceIntf;
import com.service.SeatsServiceIntf;

@RestController
public class BankAccountController {
	
	@Autowired
	
	private BankServiceIntf bServ;
	@Autowired 
	private SeatsServiceIntf seatServ;
	@RequestMapping("/payment")
	public ModelAndView pay(@ModelAttribute("lismovies") Theatre th)
	{
		
		return new ModelAndView("payment");
	}
	@RequestMapping("/bsaved")
	public ModelAndView bSave(@ModelAttribute("bsave") BankAccount bAcct)
	{
		return new ModelAndView("savebank");
	}
	//jsp save bank
	@RequestMapping(value="/banksave",method = RequestMethod.POST)
	public ModelAndView bankSave(@Valid @ModelAttribute("bsave") BankAccount bAcct,BindingResult errors,HttpServletRequest req)
	{
		
		
		if(errors.hasErrors())
		{
			return new ModelAndView("savebank");
		}
		else
		{
			HttpSession sec = req.getSession();
			int id=(int) sec.getAttribute("idgen");
			UserReg ur = new UserReg();
			ur.setuId(id);
			bAcct.setUserReg(ur);
			
			bServ.save(bAcct);
			return new ModelAndView("redirect:/listbanks");
		}
	}
	//postman save bank detail
	@PostMapping("/banksavee")
	public ModelAndView bankSavee(@RequestBody BankAccount bAcct,HttpServletRequest req)
	{
		/*
		 * HttpSession sec = req.getSession(); int id=(int) sec.getAttribute("idgen");
		 */
		UserReg ur = new UserReg();
		ur.setuId(1);
		bAcct.setUserReg(ur);
		bServ.save(bAcct);
		return new ModelAndView("listplace");
	}
	@RequestMapping("/fetchamount")
	public ModelAndView fetchAmt(@ModelAttribute("bal") BankAccount bAct,HttpServletRequest req)
	{
		HttpSession sesprice =req.getSession();
		
		double prix =(double) sesprice.getAttribute("price");
		String name=req.getParameter("bname");
		HttpSession sesidgen =req.getSession();
		int idge =(int) sesidgen.getAttribute("idgen");
		System.out.println("entering controller id is"+idge);
		System.out.println(bAct.getbName());
		System.out.println("name is "+name);
		//BankAccount bca =bServ.fetchByBname(name);
		BankAccount bnameuid =bServ.fetbybnameanduid(name, idge);
		//HttpSession sespriced=req.getSession();
		double price = bnameuid.getBalance();
		
		
		System.out.println("bank details "+bnameuid.getBalance());
		HttpSession sess =req.getSession();
		sess.setAttribute("bal", bnameuid);
		ModelAndView mdx =new ModelAndView("payment");
		
		mdx.addObject("prizze",prix);
		mdx.addObject("balance",bnameuid);
		mdx.addObject("bnc", price);
		return mdx;
		
	}
	
	@RequestMapping("/listbanks")
	public ModelAndView listBanks(HttpServletRequest req)
	{
		try {
			
		
		HttpSession sesprice =req.getSession();
	
	double prix =(double) sesprice.getAttribute("price");
		
		    HttpSession sess=req.getSession();
		   UserReg reg = (UserReg) sess.getAttribute("userReg");
		   int id =reg.getuId();
			/*
			 * UserReg ugo =(UserReg) req.getAttribute("newusereg");
			 * System.out.println("session values ="+ ugo.getuId());
			 */
		
		if(reg.getuId()!=0)
		
			{
		
	 List<BankAccount> bsf =bServ.fetbyUserReg(id);
		ModelAndView mdv = new ModelAndView("payment");
		mdv.addObject("lisbank",bsf);
		mdv.addObject("prizze", prix);
		return mdv;
		}
		
		else 
		{
			int idgen =(int) req.getAttribute("idgen");
			 List<BankAccount> bsf =bServ.fetbyUserReg(idgen);
				ModelAndView mdv = new ModelAndView("payment");
				mdv.addObject("lisbank",bsf);
				mdv.addObject("prizze", prix);
				return mdv;
		}
		}catch(NullPointerException ne)
		{
			ne.printStackTrace();
		
			HttpSession se =req.getSession();
			String seat =(String) se.getAttribute("seatvalues");
			seatServ.delete(seat.replaceAll("[\\[\\]]","").replaceAll(" ",""));
			System.out.println("Session Expired! relogin..");
		}
		return new ModelAndView("login3");
	}
		
	
	@RequestMapping("/ticketgen/{bal}/{bid}")
	public ModelAndView gentkt(@ModelAttribute("lismovies") BankAccount bdx,@PathVariable("bid") int bid,@PathVariable("bal") double b1,HttpServletRequest req)
	{
		HttpSession ses =req.getSession();
		 
		BankAccount bgv = (BankAccount) ses.getAttribute("bal");
		double bx = bgv.getBalance();
		/*
		 * String b =req.getParameter("balanc");
		 * 
		 * double b1 =Double.parseDouble(b);
		 */
		
		BankAccount bBalance =bServ.fetchBybalandbid(b1, bid);
		HttpSession sy = req.getSession();
		double priz =  (double) sy.getAttribute("price");
		System.out.println("prize"+priz);
		double xt=b1-priz;
		//BankAccount bzz = new BankAccount();
		System.out.println("balance value="+b1+"bal from db"+bx);
		/*
		 * bzz.setBalance(xt); bServ.save(bzz);
		 */
		
		  if(bgv.getbId()==bBalance.getbId()) {
		  
		  bgv.setBalance(xt);
		  
		  bServ.save(bgv); return new ModelAndView
		  ("success"); } else { return new ModelAndView("false"); }
		 
		//return new ModelAndView("success");
	}
}
