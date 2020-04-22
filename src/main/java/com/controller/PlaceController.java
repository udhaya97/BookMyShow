package com.controller;

import java.util.List;

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

import com.model.Place;
import com.service.PlaceServ;

@RestController
public class PlaceController {
	
	
	@Autowired
	private PlaceServ pser;

	@PostMapping("/saveplace")
	public String meThod(@RequestBody Place place,HttpServletRequest req)
	{
		
		pser.save(place);
		int id = place.getpId();
		System.out.println("id "+id);
		HttpSession sess=req.getSession();
		sess.setAttribute("val", id);
		return "data added successfully";
	}
	//jsp save place
	@RequestMapping("/savplace")
	public ModelAndView savPlac(@Valid @ModelAttribute("place") Place place,BindingResult errors,HttpServletRequest req)
	{
		if(errors.hasErrors())
		{
			return new ModelAndView("addplace");
		}
		else
		{
		
		pser.save(place);
	
		int id = place.getpId();
		System.out.println("id "+id);
		HttpSession sess=req.getSession();
		sess.setAttribute("val", id);
		return new ModelAndView("redirect:/admin");
		}
	}
	@GetMapping("/listval")
	public List<Place> getall(HttpServletRequest req)
	{
		List<Place> lis = pser.fetchPlaceAll();
		//HttpSession sess=req.setAttribute("lisplace", o);
		return lis;
	}
	@RequestMapping("/listplace")
	public ModelAndView getplaces(@ModelAttribute("lismovies") Place place,HttpServletRequest req)
	{
		List<Place> lis = pser.fetchPlaceAll();
		/*
		 * HttpSession sesroless = req.getSession(); String name = (String)
		 * sesroless.getAttribute("nameuser");
		 */
		return new ModelAndView("listplace","lspl",lis);
	}
	@RequestMapping("/ediplace")
	public ModelAndView editPlace()
	{
		List<Place> pl = pser.fetchPlaceAll();
		
		return new ModelAndView("editplac","pl",pl);
	}
@RequestMapping("/editplcid/{id}")
public ModelAndView editplid(@ModelAttribute("editplace") Place place,@PathVariable("id") int id)
{
	Place plc = pser.findbyId(id);
	return new ModelAndView("editrowplace","plc",plc);
}
@RequestMapping("/edplid/{id}")
public ModelAndView eplid(@PathVariable("id") int id,@ModelAttribute("editplace") Place place)
{
	Place plx =pser.findbyId(id);
	if(plx.getpId()==id)
	{
		plx.setpName(place.getpName());
		pser.update(plx);
		
	}
	return new ModelAndView("redirect:/ediplace");
	
	
}
@RequestMapping("/deleteplace/{id}")
public ModelAndView deletePlace(@PathVariable int id)
{
	pser.delete(id);
	
	return new ModelAndView("redirect:/ediplace");
}

}
