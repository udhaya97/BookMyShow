package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.model.Movie;
import com.model.Place;
import com.service.MovieServIntf;
import com.service.PlaceServ;

@RestController
public class MovieController {
	
	
	@Autowired
	private MovieServIntf mvServ;
	
	@Autowired
	private PlaceServ pser;

	  @RequestMapping("/savmovi") 
	  public ModelAndView saveMovi(@Valid @ModelAttribute("movies") Movie movie,BindingResult errors,HttpServletRequest req )
	  {
		/*
		 * HttpSession sespid = req.getSession(); int id =(int)
		 * sespid.getAttribute("val");
		 */List<Place> pl = pser.fetchPlaceAll();
		  if(errors.hasErrors())
		  {
			  
			  return new ModelAndView("addmovies","pall",pl);
		  }else
		  {
			  try
			  {
		 String pname=req.getParameter("pname");
		Place plac=  pser.findbyName(pname);
		int id=plac.getpId();
		System.out.println("p id is "+id);
	  Place p = new Place();
		  p.setpId(id);
		
		   movie.setPlace(p);
		 
		  mvServ.save(movie);
		  System.out.println("mid is"+movie.getmId());
		  HttpSession sesmid=req.getSession();
		  sesmid.setAttribute("midval",movie.getmId());
		  return new ModelAndView ("redirect:/admin");
			  }catch(NullPointerException ne)
			  {
				  return new ModelAndView("addmovies","pall",pl);
			  }
	  }
		  
	  }
	  @RequestMapping("/listmovies/{id}")
		public ModelAndView lisMov(@PathVariable("id") int id ,@ModelAttribute("lismovies") Place place,HttpServletRequest req)
		{
	System.out.println("controller place id"+id);
	List<Movie> lis = mvServ.fetchById(id);
	if(lis.isEmpty())
	{
		return new ModelAndView("redirect:/listplace");
	}
	else
	{
		
		HttpSession sed=req.getSession();
		sed.setAttribute("mid",id);
		
	  for (Movie movie : lis) {
	  System.out.println("value of movie : "+movie.getmId()+movie.getmName()+movie.
	  getLang()+movie.getDuration());
	  
	  }
	 
	return new ModelAndView("lismovies","mvalues",lis);
	}
		}
   @RequestMapping("/editmov")
   public ModelAndView editMov(@ModelAttribute("editmovie") Movie movie)
   {
	   List<Movie> lmov =mvServ.findMvAll();
	   return new ModelAndView("editmov","lmov",lmov);
   }
   @RequestMapping("/editmovid/{id}")
   public ModelAndView editbyId(@ModelAttribute("editmovie") Movie movie,@PathVariable("id") int id)
   {
	  List<Place> lis = pser.fetchPlaceAll();
	   Movie mv =mvServ.findmov(id);
	   ModelAndView mdw = new ModelAndView("editrowmovie");
	   mdw.addObject("mv",mv);
	   mdw.addObject("plval",lis);
	   return mdw;
   }
   
   @RequestMapping("/editmval/{id}")
   public ModelAndView editmVal(@PathVariable("id") int id,@ModelAttribute("editmovie") Movie mov,HttpServletRequest req)
   {
	   try
	   {
	   String pname=req.getParameter("pidname");
	 String[] pthree =pname.split(",");
	 List<String> lfour =new ArrayList<>();
	 for(int i=0;i<pthree.length;i++)
	 {
		 lfour.add(pthree[i]);
	 }
	  System.out.println("mid = "+id);
	  Place ptwo = new Place();
	  Place pl =pser.findbyName(lfour.get(1));
	 // System.out.println("pname ="+pname+"\nplid ="+plid+","+lfour.get(0));
	   Movie mvn =mvServ.findmov(id);
	   if(mvn.getmId() == id)
	   {
		   mvn.setmName(mov.getmName());
		   mvn.setLang(mov.getLang());
		   mvn.setDuration(mov.getDuration());
		  
		   ptwo.setpId(pl.getpId());
		   mvn.setPlace(ptwo);
		   mvServ.updateMov(mvn);
		  
	   } return new ModelAndView("redirect:/editmov");
	   }catch(IndexOutOfBoundsException ie)
	   {
		   ie.printStackTrace();
		   return new ModelAndView("redirect:/editmovid/{id}");
	   }
   }
   
   
   @RequestMapping("/delete/{id}")
   public ModelAndView deleteMov(@PathVariable("id") int id)
   {
	   mvServ.deleteMovi(id);
	   return new ModelAndView("redirect:/editmov");
   }
}
