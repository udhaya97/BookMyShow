package com.controller;

import java.util.ArrayList;
/*import java.util.Arrays;*/
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.model.Movie;
import com.model.Ticket;
import com.model.UserReg;
import com.service.MovieServIntf;
import com.service.TicketService;
import com.service.UserService;

@RestController
public class TicketController {
	
	@Autowired
	private TicketService tktServ;
	@Autowired
	private MovieServIntf mvServ;
	@Autowired 
	private UserService use;
	int i=1;
	
	@RequestMapping("/getticket")
	public ModelAndView getTkt(HttpServletRequest req)
	{
		
		Random ran = new Random();
		int x = ran.nextInt(10000) + 10000;
		HttpSession thValues = req.getSession();
		//Theatre th =(Theatre) thValues.getAttribute("thvals");
		String st =(String) thValues.getAttribute("tName");
		
		 HttpSession ses1 =req.getSession(); 
		HttpSession sestime =req.getSession();
		/* String s1 =(String) ses1.getAttribute("tName"); */
		String tim =(String) sestime.getAttribute("time");
		/* Theatre the = tserv.findbytname(s1); */
		//int tid=the.gettId();
		int tid=(int) ses1.getAttribute("sid");
		Movie mov=mvServ.findmov(tid);
		
		HttpSession sesmovname= req.getSession();
		System.out.println("movie name:"+mov.getmName());
		sesmovname.setAttribute("sesmov",mov.getmName());
		HttpSession sesduration=req.getSession();
		sesduration.setAttribute("duration",mov.getDuration());
		HttpSession sessstring=req.getSession();
		String sets= (String) sessstring.getAttribute("seatvalues");
		Ticket tic = new Ticket();
		tic.setmName(mov.getmName());
		tic.setTiming(tim);
		tic.setThName(st);
		tic.settNumber(x);
		
		
		tic.setSeatNo(sets.replaceAll("[\\[\\]]","").replaceAll(" ", ""));
		tktServ.save(tic);
		return new ModelAndView("redirect:/pticket");
		
	}
	@RequestMapping("/pticket")
	public ModelAndView ptkt(@ModelAttribute("lismovies") Ticket tkt,HttpServletRequest req)
	{
		HttpSession thVal2 = req.getSession();
		//Theatre thNam = (Theatre) thVal2.getAttribute("thvals");
		String nam =(String) thVal2.getAttribute("tName");
		
		HttpSession sesmname =req.getSession();
		String mName =(String) sesmname.getAttribute("sesmov");
		System.out.println("under pticket mName"+mName);
		HttpSession ses2 = req.getSession();
		String tim=(String) ses2.getAttribute("time");
		HttpSession sesdurationget=req.getSession();
		String duration = (String) sesdurationget.getAttribute("duration");
		System.out.println("duration is :"+duration);
		HttpSession sessstrings=req.getSession();
		String setseat= (String) sessstrings.getAttribute("seatvalues");
		System.out.println("seat values in ticket controller"+setseat.replaceAll("[\\[\\]]",""));
		String rVal=setseat.replaceAll("[\\[\\]]","").replaceAll(" ","");
		System.out.println("rval is "+rVal);
		Ticket tics =tktServ.findBymNameAndseatNoo(mName,rVal,tim,nam);
		//System.out.println("tics val ="+tics);
		String st =tics.getSeatNo().replaceAll("[\\[\\]]","");
		
		List<String> lisint=new ArrayList<>();
		lisint.add(st);
	
		HttpSession sesroleid =req.getSession();
		int roleId=(int) sesroleid.getAttribute("idgen");
		UserReg ureg =use.findbyid(roleId);
		ModelAndView mdev = new ModelAndView("ticketprint");
		mdev.addObject("roleval",ureg.getRole());
		mdev.addObject("ticdet", tics);
		mdev.addObject("lisseat", st);
		mdev.addObject("duration",duration);
		mdev.addObject("tName", nam);
		return mdev;
		
	}
	

}
