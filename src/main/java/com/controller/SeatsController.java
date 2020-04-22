package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.model.Movie;
import com.model.Seats;
import com.model.Theatre;
import com.service.SeatsServiceIntf;

@RestController
public class SeatsController {

	@Autowired
	
	private SeatsServiceIntf sServ;
	@RequestMapping("/showseats/{time}/{tName}")
	public ModelAndView showseats(@ModelAttribute("lismovies") Theatre theatre,@PathVariable("time") String time,@PathVariable("tName") String tName,HttpServletRequest req)
	{
		
		List<Integer> num = new ArrayList<>();
		System.out.println("theatre name ="+tName);
		System.out.println("timings are :"+time);
		HttpSession sesst=req.getSession();
		sesst.setAttribute("tName",tName);
		sesst.setAttribute("time",time);
		String strd="process";
		String strd2="hello";
		List<String> str = new ArrayList<>();
		List<String> lisStr = new ArrayList<>();
		for(int i=1;i<=50;i++)
		{
			num.add(i);
			
		}
		List<Seats> lis = sServ.findunametime(tName, time);
		
		  if(lis.isEmpty()) {
			  
			  ModelAndView mdc = new ModelAndView("showseats");
			  mdc.addObject("tabval",num);
			  
		  mdc.addObject("values",strd);
		  return mdc; 
		}
		
		  else { 
			  for (Seats seats : lis) {
					str.add(seats.getSeats());
				}
				
				/*
				 * List<String> liss = new ArrayList<>(); String[] stu=null;
				 */
			  System.out.println("values in seats using for each");
			  String[] neweVal=null;
			 // List<String> val2 = new ArrayList<>();
			  for (String seae : str) {
				
				  System.out.println(seae.replaceAll(" ",""));
				  neweVal= seae.split(",");
				  
			}
			  Set<String> setval = new TreeSet<>();
			  System.out.println("s2 values");
			  for(int t =0;t<neweVal.length;t++)
			  {
				  System.out.println(neweVal[t].replaceAll(" ",""));
				  setval.add(neweVal[t].replaceAll(" ",""));
			  }
				//=str.toArray(new String[str.size()]);
				
			//	List<String> lis3 =new ArrayList<>();
				
				
			/*
			 * for(int t=0;t<s2.length;t++) { System.out.println(s2[t].replaceAll(" ",""));
			 * setval.add(s2[t].replaceAll(" ","")); }
			 */
				System.out.println("using foreach");
				//Collections.sort(lis3);
				for (String string : setval) {
					System.out.println(string);
					lisStr.add(string);
				}
				
				System.out.println("normal list"+setval);
				Collections.sort(lisStr);
				System.out.println("sorted lisStr"+lisStr);
				//System.out.println("value of string"+s);
				/*
				 * System.out.println("list to array"); for(int z=0;z<neweVal.length;z++) {
				 * System.out.println(neweVal[z]); s=neweVal[z]; stu=s.split(","); }
				 */ /*
					 * for(int y=0;y<stu.length;y++) { System.out.println("stu "+stu[y]);
					 * liss.add(stu[y]); }
					 */
				//List<Seats> allValues=sServ.findAll();
				
				
				System.out.println("values in num is : "+num);
				
				List<Integer> convint= new ArrayList<>();
				List<Integer> lisrem =new ArrayList<>();

				
				 convint = setval.stream().map(t->Integer.parseInt(t)).collect(Collectors.toList());
				 lisrem =new ArrayList<>();
				
				for (Integer integer : num) {
					lisrem.add(integer);
					
				}
				for (Integer integer : convint) {
					lisrem.remove(integer);
				}
				
				
				ModelAndView mdv = new ModelAndView("showseats");
				mdv.addObject("values",strd2);
				mdv.addObject("tabval",num);
				
				System.out.println("values in lis is :"+str);
				System.out.println("lis rem"+lisrem);
				
				mdv.addObject("seatsval",convint);
				mdv.addObject("lisrem",lisrem);
				
				return mdv;
			}
		 
	}
	
	
	
	@RequestMapping("/getcode")
	public ModelAndView viewTheatre(@ModelAttribute("lismovies") Movie movie,HttpServletRequest req)
	
	{
		  try
		  {

				 HttpSession sest =req.getSession(); 
				 HttpSession sests = req.getSession();
				  String tName=(String) sests.getAttribute("tName"); 
				  String time =(String) sest.getAttribute("time");
		String[] values =req.getParameterValues("seats");
		System.out.println("length of values "+values.length);
		
		
			
			//return new ModelAndView("redirect:/showseats/time/tName");
		
		//List<String> lisval =new ArrayList<>();
		//lisval.addAll(values);
		String str = Arrays.toString(values);
		Seats seat =sServ.findbySeats(str);
		
		System.out.println("str is "+str);
		System.out.println("array values "+str);
		
		HttpSession sesstr=req.getSession();
		sesstr.setAttribute("seatvalues",str);
		
		 
		  System.out.println("thetre name in seats controller"+tName);
		  if(seat==null)
			{
		  Seats sea= new Seats();
		  sea.setThName(tName); 
		  sea.setTimings(time); 
		  sea.setSeats(str.replaceAll( "[\\[\\]]", "").replaceAll(" ",""));
	sServ.save(sea);
	
		 
		for(int i=0;i<=values.length-1;i++)
		{
			System.out.println("values are = "+values[i]);
		}
		int num=values.length;
		double prize;
		
		prize=num*120.0;
		HttpSession st =req.getSession();
		st.setAttribute("price",prize);
		
		ModelAndView mv = new ModelAndView("price");
		mv.addObject("arrayval",values);
		return new ModelAndView("price","prize",prize) ;
		}
		else
		{
			ModelAndView mdv =new ModelAndView("login4");
			mdv.addObject("seats",seat);
			mdv.addObject("tname", tName);
			mdv.addObject("time",time);
			sServ.delete(str);
			return mdv;
		
		}
		  }catch(NullPointerException ne)
		  {
			  String st="selectseat";
			  HttpSession sest =req.getSession(); 
			  String tName=(String) sest.getAttribute("tName"); 
			  String time =(String) sest.getAttribute("time");
			  //first way to redirect to the url with values
			/*
			 * RedirectView redir= new RedirectView("/showseats/{time}/{tName}",true) ;
			 * redir.addStaticAttribute("time",time);
			 * redir.addStaticAttribute("tName",tName);
			 */
			  //second way with redirect url and send the values
			  ModelAndView mdv = new ModelAndView("redirect:/showseats/{time}/{tName}");
			  mdv.addObject("time", time);
			  mdv.addObject("tName", tName);
			  mdv.addObject("mes",st);
			    return  mdv;
		  }
		
	}
	
}
