package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.model.Movie;

import com.model.Theatre;
import com.service.MovieServIntf;
import com.service.TheatreServIntf;

@RestController
public class TheatreController {
	@Autowired
	private TheatreServIntf tserv;
	@Autowired
	MovieServIntf mvServ;
	String s;
	 @RequestMapping("/savtheatr") 
	  public ModelAndView saveTheat(@Valid @ModelAttribute("theatre") Theatre theatre,BindingResult errors,HttpServletRequest req )
	  {
		 List<Movie> mv = mvServ.findMvAll();
		 if(errors.hasErrors())
		 {
			 return new ModelAndView("addtheatre","movi",mv);
		 }else
		 {
			 try
			 {
		  String mname=req.getParameter("mname");
		  String[] aone =mname.split(",");
		List<String> lst = new ArrayList<>();
		  for(int z=0;z<aone.length;z++)
		  {
			  lst.add(aone[z]);
		  }
		 
		  String mnameo=lst.get(0);
		  System.out.println("m name"+mnameo);
		 Movie mov= mvServ.findmovname(mnameo);
		 Movie moc =new Movie();
		// Theatre th =new Theatre();
		 System.out.println("movie id in savtheatre"+mov.getmId());
		 moc.setmId(mov.getmId());
		 theatre.setMovie(moc);
		  System.out.println("movie id is"+mov.getmId());
		  tserv.saveTheatre(theatre);
		  return new ModelAndView ("redirect:/admin");
			 }catch(NullPointerException ne)
			 {
				 return new ModelAndView("addtheatre","movi",mv);
			 }
		 }
	  }
	 @PostMapping("/savetheat")
		public String saveth(@RequestBody Theatre theatre,HttpServletRequest req)
		{
			
			
			/*
			 * HttpSession secpname = req.getSession(); String pname=secpname
			 */
			
			 
			Movie mv = new Movie();
			
			 mv.setmId(1);
			 theatre.setMovie(mv);

			tserv.saveTheatre(theatre);
			return "theatre data saved successfully";
		}
	 @GetMapping("/listheat/{id}") public List<Theatre> lThe(@PathVariable("id") int id){
		  List<Theatre> lis = tserv.fetchById( id); return lis; }
	 
	 @RequestMapping("/listthetare/{id}")
		public ModelAndView getTheatre(@ModelAttribute("lismovies") Movie movi,@PathVariable("id") int id,HttpServletRequest req)
		{
			//HttpSession thVal = req.getSession();
			
			List<Theatre> lis = tserv.fetchById(id);
			//Theatre th = tserv.getbyid(id);
			//thVal.setAttribute("thvals",th);
			//System.out.println("theatre values from getbyid "+th.gettName()+" "+th.getTimings());

			if(lis.isEmpty())
			{
				HttpSession sede = req.getSession();
				int mid=(int) sede.getAttribute("mid");
				ModelAndView mdv = new ModelAndView("redirect:/listmovies/{id}");
				mdv.addObject("id",mid);
				return mdv;
			}
			else
			{
				
				HttpSession sesid=req.getSession();
			sesid.setAttribute("sid",id);
			System.out.println("movie name under theatre list:"+movi.getmName());
			List<String> list = new ArrayList<>();
			for (Theatre theatre : lis) {
				System.out.println("theatre values"+theatre.gettId()+" "+theatre.gettName()+" "+theatre.getTimings());
				 s= theatre.getTimings();
				 
				 list.add(s);
			}
			System.out.println("list timings "+list);
			//List<String> lst = new ArrayList<>();
			
			/*
			 * if(id%2==0 && id==1) {
			 * 
			 * lst.add(list.get(0)); } else { lst.add(list.get(1)); }
			 */
			List<String> lest = new ArrayList<>();
			
			/*
			 * ModelAndView mv = new ModelAndView(); mv.addObject("timinglis",
			 * list.get(id-1));
			 */
			
			  for (String string : list) {
			  
			  for(String st:string.split(",")) { lest.add(st); }
			  
			  }
			 
			System.out.println("lst values"+lest.get(0)+" "+lest.get(1));
			
			ModelAndView mvd = new ModelAndView("listtheatre");
			mvd.addObject("timinglist",lest);
			mvd.addObject("lsth",lis);
			
			return mvd;
			}
			/*new ModelAndView("listtheatre","lsth",lis);*/
		}

	 @RequestMapping("/edittheat")
	 public ModelAndView edittheat()
	 
	 {
		List<Theatre> th = tserv.findTheatAll();
		return new ModelAndView("edittheatre","evalues",th); 
		 
	 }
	 @RequestMapping("/editth/{tid}")
	 public ModelAndView editById(@PathVariable("tid") int id,@ModelAttribute("editTheatre") Theatre theatre)
	 {
		 List<Movie> lism =mvServ.findMvAll();
		/*
		 * List<String> lisstr =new ArrayList<>(); List<Integer> lisint = new
		 * ArrayList<>();
		 */
		 //List<Map<Integer,String>> lis =new ArrayList<>();
		 Map<Integer,String> ma =new HashMap<Integer,String>();
		 for (Movie movie : lism) {
			 
			 ma.put(movie.getmId(),movie.getmName());
			/*
			 * lisstr.add(movie.getmName()); lisint.add(movie.getmId());
			 */
		}
		 
		
		// System.out.println("movie name is "+ lisstr+"movie id"+lisint);
		 Theatre theat = tserv.getbyid(id);
		 ModelAndView mdv = new ModelAndView("editrowtheat");
		 mdv.addObject("theatrow",theat);
		
		 mdv.addObject("mapval",ma);
		return mdv;
	 }
	 
		
	 @RequestMapping("/editthea/{id}")
	 public ModelAndView editThea(@PathVariable("id") int id, @ModelAttribute("editTheatre") Theatre theatre,HttpServletRequest req)
	 {
		 try
		 {
		 String midname= req.getParameter("midname");
		 String[] val =midname.split(",");
		 System.out.println("value ="+midname);
		 List<String> lis = new ArrayList<>();
		 for(int i=0;i<val.length;i++)
		 {
			 System.out.println("Array values"+val[i]);
			 lis.add(val[i]);
		 }
		
		 System.out.println("id value parsed from string"+lis.get(1));
		Theatre th = tserv.getbyid(id);
		System.out.println("th id "+ th.gettId());
		
		String mnames=lis.get(1);
		Movie mid =mvServ.findmovname(mnames);
		
		 if(th.gettId() == id)
		 {
			 th.settName(theatre.gettName());
			 th.setTimings(theatre.getTimings());
			 Movie mv = new Movie();
			 //int idz =Integer.valueOf(lis.get(0));
			//System.out.println("idz val "+idz); //mv.setmId(idz);
			mv.setmId(mid.getmId());
			th.setMovie(mv);
		 tserv.updateTheat(th);
		 } 
		 System.out.println("updated successfully");
		 return new ModelAndView("redirect:/edittheat");
		 }catch(IndexOutOfBoundsException ie)
		 {
			 ie.printStackTrace();
			 return new ModelAndView("redirect:/editth/{id}") ;
			
		 }
		 
		/*
		 * else { return new ModelAndView("redirect:/admin"); }
		 */
	 }
		
	 @RequestMapping("/deleteth/{tid}")
	 public ModelAndView deleTheat(@PathVariable("tid") int id)
	 {
		 tserv.deleteTheat(id);
		 System.out.println("deleted Successfully");
		 return new ModelAndView("redirect:/edittheat");
	 }


}
