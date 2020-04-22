package com.controller;

/*import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;*/
import java.util.List;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
/*import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/*import com.model.BankAccount;*/
import com.model.Movie;
import com.model.Place;
import com.model.Theatre;
/*import com.model.Seats;
import com.model.Theatre;
import com.model.Ticket;
import com.model.UserReg;
import com.service.BankServiceIntf;*/
import com.service.MovieServIntf;
import com.service.PlaceServ;
/*import com.service.SeatsServiceIntf;
import com.service.TheatreServIntf;
import com.service.TicketService;
import com.service.UserService;*/

@RestController
public class OnlineController {
	@Autowired
	private PlaceServ pser;
	/*
	 * @Autowired BankServiceIntf bServ;
	 */
	
	  @Autowired 
	  private MovieServIntf mvServ;
	  
	  @RequestMapping("/home")
	  public ModelAndView home()
	  {
		  return new ModelAndView("home");
	  }
	  
	 
	/*
	 * @Autowired TheatreServIntf tserv; String s;
	 * 
	 * @Autowired UserService use;
	 * 
	 * @Autowired SeatsServiceIntf sServ;
	 * 
	 * @Autowired TicketService tktServ;
	 */

	// HttpSession session;
	/*
	 * Base64.Encoder encoder =Base64.getEncoder(); Base64.Decoder decoder =
	 * Base64.getDecoder();
	 * 
	 * @PostMapping("/saveplace") public String meThod(@RequestBody Place
	 * place,HttpServletRequest req) {
	 * 
	 * pser.save(place); int id = place.getpId(); System.out.println("id "+id);
	 * HttpSession sess=req.getSession(); sess.setAttribute("val", id); return
	 * "data added successfully"; } //jsp save place
	 * 
	 * @RequestMapping("/savplace") public ModelAndView
	 * savPlac(@ModelAttribute("place") Place place,HttpServletRequest req) {
	 * 
	 * pser.save(place);
	 * 
	 * int id = place.getpId(); System.out.println("id "+id); HttpSession
	 * sess=req.getSession(); sess.setAttribute("val", id); return new
	 * ModelAndView("redirect:/admin"); }
	 * 
	 * @GetMapping("/listval") public List<Place> getall(HttpServletRequest req) {
	 * List<Place> lis = pser.fetchPlaceAll(); //HttpSession
	 * sess=req.setAttribute("lisplace", o); return lis; }
	 * 
	 * 
	 * @RequestMapping("/savmovi") public ModelAndView
	 * saveMovi(@ModelAttribute("movies") Movie movie,HttpServletRequest req ) {
	 * 
	 * HttpSession sespid = req.getSession(); int id =(int)
	 * sespid.getAttribute("val");
	 * 
	 * String pname=req.getParameter("pname"); Place plac= pser.findbyName(pname);
	 * int id=plac.getpId(); System.out.println("p id is "+id); Place p = new
	 * Place(); p.setpId(id);
	 * 
	 * movie.setPlace(p);
	 * 
	 * mvServ.save(movie); System.out.println("mid is"+movie.getmId()); HttpSession
	 * sesmid=req.getSession(); sesmid.setAttribute("midval",movie.getmId()); return
	 * new ModelAndView ("redirect:/admin"); }
	 * 
	 * @RequestMapping("/savtheatr") public ModelAndView
	 * saveTheat(@ModelAttribute("theatre") Theatre theatre,HttpServletRequest req )
	 * { String mname=req.getParameter("mname"); System.out.println("m name"+mname);
	 * Movie mov= mvServ.findmovname(mname); Movie moc =new Movie(); // Theatre th
	 * =new Theatre(); System.out.println("movie id in savtheatre"+mov.getmId());
	 * moc.setmId(mov.getmId()); theatre.setMovie(moc);
	 * System.out.println("movie id is"+mov.getmId()); tserv.saveTheatre(theatre);
	 * return new ModelAndView ("redirect:/admin"); }
	 * 
	 * @RequestMapping("/onetwo") public ModelAndView methOne() { return new
	 * ModelAndView("oner"); }
	 * 
	 * @PostMapping("/savetheat") public String saveth(@RequestBody Theatre
	 * theatre,HttpServletRequest req) {
	 * 
	 * 
	 * 
	 * HttpSession secpname = req.getSession(); String pname=secpname
	 * 
	 * 
	 * 
	 * Movie mv = new Movie();
	 * 
	 * mv.setmId(1); theatre.setMovie(mv);
	 * 
	 * tserv.saveTheatre(theatre); return "theatre data saved successfully"; }
	 * 
	 * 
	 * @GetMapping("/listheat/{id}") public List<Theatre> lThe(@PathVariable("id")
	 * int id){ List<Theatre> lis = tserv.fetchById( id); return lis; }
	 * 
	 * @RequestMapping("/listplace") public ModelAndView
	 * getplaces(@ModelAttribute("lismovies") Place place) { List<Place> lis =
	 * pser.fetchPlaceAll(); return new ModelAndView("listplace","lspl",lis); }
	 * 
	 * @RequestMapping("/listmovies/{id}") public ModelAndView
	 * lisMov(@PathVariable("id") int id ,@ModelAttribute("lismovies") Place place)
	 * { System.out.println("controller place id"+id); List<Movie> lis =
	 * mvServ.fetchById(id);
	 * 
	 * 
	 * for (Movie movie : lis) {
	 * System.out.println("value of movie : "+movie.getmId()+movie.getmName()+movie.
	 * getLang()+movie.getDuration());
	 * 
	 * }
	 * 
	 * return new ModelAndView("lismovies","mvalues",lis); }
	 * 
	 * @RequestMapping("/listthetare/{id}") public ModelAndView
	 * getTheatre(@ModelAttribute("lismovies") Movie movi,@PathVariable("id") int
	 * id,HttpServletRequest req) { HttpSession sesid=req.getSession();
	 * List<Theatre> lis = tserv.fetchById(id); sesid.setAttribute("sid",id);
	 * System.out.println("movie name under theatre list:"+movi.getmName());
	 * List<String> list = new ArrayList<>(); for (Theatre theatre : lis) {
	 * System.out.println("theatre values"+theatre.gettId()+" "+theatre.gettName()
	 * +" "+theatre.getTimings()); s= theatre.getTimings();
	 * 
	 * list.add(s); } System.out.println("list timings "+list); //List<String> lst =
	 * new ArrayList<>();
	 * 
	 * 
	 * if(id%2==0 && id==1) {
	 * 
	 * lst.add(list.get(0)); } else { lst.add(list.get(1)); }
	 * 
	 * List<String> lest = new ArrayList<>();
	 * 
	 * 
	 * ModelAndView mv = new ModelAndView(); mv.addObject("timinglis",
	 * list.get(id-1));
	 * 
	 * 
	 * for (String string : list) {
	 * 
	 * for(String st:string.split(",")) { lest.add(st); }
	 * 
	 * }
	 * 
	 * System.out.println("lst values"+lest.get(0)+" "+lest.get(1));
	 * 
	 * ModelAndView mvd = new ModelAndView("listtheatre");
	 * mvd.addObject("timinglist",lest); mvd.addObject("lsth",lis);
	 * 
	 * return mvd; new ModelAndView("listtheatre","lsth",lis); }
	 * 
	 * 
	 * @RequestMapping("/showseats/{time}/{tName}") public ModelAndView
	 * showseats(@ModelAttribute("lismovies") Theatre theatre,@PathVariable("time")
	 * String time,@PathVariable("tName") String tName,HttpServletRequest req) {
	 * 
	 * System.out.println("theatre name ="+tName); HttpSession
	 * sesst=req.getSession(); sesst.setAttribute("tName",tName);
	 * sesst.setAttribute("time",time); List<Seats> lis = sServ.findunametime(tName,
	 * time); List<Integer> num = new ArrayList<>(); for(int i=1;i<=50;i++) {
	 * num.add(i);
	 * 
	 * } System.out.println("values in num is : "+num);
	 * 
	 * ModelAndView mdv = new ModelAndView("showseats");
	 * mdv.addObject("tabval",num); mdv.addObject("seatsval",lis); return mdv; }
	 * 
	 * 
	 * @RequestMapping("/getcode") public ModelAndView
	 * viewTheatre(@ModelAttribute("lismovies") Movie movie,HttpServletRequest req)
	 * 
	 * { String[] values =req.getParameterValues("seats"); String str =
	 * Arrays.toString(values);
	 * System.out.println("array values"+str+" "+movie.getmName());
	 * System.out.println("movie name in getcode is:"+movie.getmName()); HttpSession
	 * sesstr=req.getSession(); sesstr.setAttribute("seatvalues",str);
	 * 
	 * HttpSession sest =req.getSession(); String tName=(String)
	 * sest.getAttribute("tName"); String time =(String) sest.getAttribute("time");
	 * Seats sea= new Seats(); sea.setThName(tName); sea.setTimings(time);
	 * sea.setSeats(str); sServ.save(sea);
	 * 
	 * 
	 * for(int i=0;i<=values.length-1;i++) {
	 * System.out.println("values are = "+values[i]); } int num=values.length;
	 * double prize;
	 * 
	 * prize=num*120.0; HttpSession st =req.getSession();
	 * st.setAttribute("price",prize); ModelAndView mv = new ModelAndView("price");
	 * mv.addObject("arrayval",values); return new
	 * ModelAndView("price","prize",prize) ;
	 * 
	 * }
	 * 
	 * @RequestMapping("/payment") public ModelAndView
	 * pay(@ModelAttribute("lismovies") Theatre th) {
	 * 
	 * return new ModelAndView("payment"); }
	 * 
	 * @RequestMapping("/bsaved") public ModelAndView bSave(@ModelAttribute("bsave")
	 * BankAccount bAcct) { return new ModelAndView("savebank"); } //jsp save bank
	 * 
	 * @RequestMapping("/banksave") public ModelAndView
	 * bankSave(@ModelAttribute("bsave") BankAccount bAcct,HttpServletRequest req) {
	 * HttpSession sec = req.getSession(); int id=(int) sec.getAttribute("idgen");
	 * UserReg ur = new UserReg(); ur.setuId(id); bAcct.setUserReg(ur);
	 * 
	 * bServ.save(bAcct); return new ModelAndView("redirect:/listbanks"); }
	 * //postman save bank detail
	 * 
	 * @PostMapping("/banksavee") public ModelAndView bankSavee(@RequestBody
	 * BankAccount bAcct,HttpServletRequest req) {
	 * 
	 * HttpSession sec = req.getSession(); int id=(int) sec.getAttribute("idgen");
	 * 
	 * UserReg ur = new UserReg(); ur.setuId(1); bAcct.setUserReg(ur);
	 * bServ.save(bAcct); return new ModelAndView("listplace"); } //create user page
	 * 
	 * @RequestMapping("/createuser") public ModelAndView
	 * create(@ModelAttribute("login") UserReg user) {
	 * 
	 * 
	 * return new ModelAndView("createuser"); } //save user
	 * 
	 * @RequestMapping("/lo") public ModelAndView login(@ModelAttribute("login")
	 * UserReg user,HttpServletRequest req) { Date date = new Date(); DateFormat df
	 * = new SimpleDateFormat("dd-mm-yyyy"); String time=df.format(date); String
	 * password =encoder.encodeToString(user.getPass().getBytes());
	 * user.setDob(time); user.setPass(password); use.save(user); String role
	 * =user.getRole(); System.out.println("role is "+role);
	 * 
	 * HttpSession sesrole=req.getSession(); sesrole.setAttribute("role",role);
	 * 
	 * System.out.println("encode password"+password); return new
	 * ModelAndView("redirect:/logi"); } //login page
	 * 
	 * @RequestMapping("/logi") public ModelAndView logi(@ModelAttribute("login")
	 * UserReg user) { return new ModelAndView("login"); } //verify login
	 * 
	 * @RequestMapping("/verify") public ModelAndView
	 * verify(@ModelAttribute("login") UserReg user,HttpServletRequest req) { String
	 * name=user.getuName(); UserReg ug = use.findByName(name); int idgen =
	 * ug.getuId(); HttpSession ses=req.getSession(); ses.setAttribute("idgen",
	 * idgen); System.out.println("uid from verify :"+idgen); String passdecode= new
	 * String(decoder.decode(ug.getPass()));
	 * System.out.println("user id"+ug.getuId()); HttpSession session=
	 * req.getSession(); session.setAttribute("userReg",ug); String
	 * password=user.getPass();
	 * 
	 * HttpSession sesroles =req.getSession();
	 * 
	 * sesroles.setAttribute("nameuser",ug.getuName());
	 * 
	 * System.out.println("decrypted password :"+passdecode);
	 * 
	 * 
	 * session=req.getSession(); session.setAttribute("idval", ug);
	 * 
	 * System.out.println("database psd="+ug.getPass()+"\n"+"text box psd="+password
	 * ); if(password.equals(passdecode)) {
	 * if(ug.getRole().equalsIgnoreCase("user")) { return new
	 * ModelAndView("redirect:listplace"); }else { return new
	 * ModelAndView("redirect:admin"); } }else return new ModelAndView("login"); }
	 * 
	 * @RequestMapping("/fetchamount") public ModelAndView
	 * fetchAmt(@ModelAttribute("bal") BankAccount bAct,HttpServletRequest req) {
	 * HttpSession sesprice =req.getSession();
	 * 
	 * double prix =(double) sesprice.getAttribute("price"); String
	 * name=req.getParameter("bname"); System.out.println("entering controller");
	 * System.out.println(bAct.getbName()); System.out.println("name is "+name);
	 * BankAccount bca =bServ.fetchByBname(name);
	 * System.out.println("bank details "+bca.getBalance()); HttpSession sess
	 * =req.getSession(); sess.setAttribute("bal", bca); ModelAndView mdx =new
	 * ModelAndView("payment");
	 * 
	 * mdx.addObject("prizze",prix); mdx.addObject("balance",bca); return mdx;
	 * 
	 * }
	 * 
	 * @RequestMapping("/listbanks") public ModelAndView
	 * listBanks(HttpServletRequest req) { HttpSession sesprice =req.getSession();
	 * 
	 * double prix =(double) sesprice.getAttribute("price");
	 * 
	 * HttpSession sess=req.getSession(); UserReg reg = (UserReg)
	 * sess.getAttribute("userReg"); int id =reg.getuId();
	 * 
	 * System.out.println("session values ="+ reg.getuId());
	 * 
	 * if(reg.getuId()!=0)
	 * 
	 * {
	 * 
	 * List<BankAccount> bsf =bServ.fetbyUserReg(id); ModelAndView mdv = new
	 * ModelAndView("payment"); mdv.addObject("lisbank",bsf);
	 * mdv.addObject("prizze", prix); return mdv; } else { int idgen =(int)
	 * req.getAttribute("idgen"); List<BankAccount> bsf =bServ.fetbyUserReg(idgen);
	 * ModelAndView mdv = new ModelAndView("payment"); mdv.addObject("lisbank",bsf);
	 * mdv.addObject("prizze", prix); return mdv; }
	 * 
	 * }
	 * 
	 * 
	 * @RequestMapping("/ticketgen/{bal}") public ModelAndView
	 * gentkt(@ModelAttribute("lismovies") BankAccount bdx,@PathVariable("bal")
	 * double b1,HttpServletRequest req) { HttpSession ses =req.getSession();
	 * 
	 * BankAccount bgv = (BankAccount) ses.getAttribute("bal"); double bx =
	 * bgv.getBalance();
	 * 
	 * String b =req.getParameter("balanc");
	 * 
	 * double b1 =Double.parseDouble(b);
	 * 
	 * 
	 * BankAccount bBalance =bServ.fetchBybal(b1); HttpSession sy =
	 * req.getSession(); double priz = (double) sy.getAttribute("price");
	 * System.out.println("prize"+priz); double xt=b1-priz; BankAccount bzz = new
	 * BankAccount(); System.out.println("balance value="+b1+"bal from db"+bx);
	 * 
	 * bzz.setBalance(xt); bServ.save(bzz);
	 * 
	 * 
	 * if(bgv.getbId()==bBalance.getbId()) {
	 * 
	 * bgv.setBalance(xt);
	 * 
	 * bServ.save(bgv); return new ModelAndView ("success"); } else { return new
	 * ModelAndView("false"); }
	 * 
	 * //return new ModelAndView("success"); }
	 * 
	 * @RequestMapping("/getticket") public ModelAndView getTkt(HttpServletRequest
	 * req) { HttpSession ses1 =req.getSession(); HttpSession sestime
	 * =req.getSession(); String s1 =(String) ses1.getAttribute("tName"); String tim
	 * =(String) sestime.getAttribute("time"); Theatre the = tserv.findbytname(s1);
	 * //int tid=the.gettId(); int tid=(int) ses1.getAttribute("sid"); Movie
	 * mov=mvServ.findmov(tid); HttpSession sesmovname= req.getSession();
	 * System.out.println("movie name:"+mov.getmName());
	 * sesmovname.setAttribute("sesmov",mov.getmName()); HttpSession
	 * sesduration=req.getSession();
	 * sesduration.setAttribute("duration",mov.getDuration()); HttpSession
	 * sessstring=req.getSession(); String sets= (String)
	 * sessstring.getAttribute("seatvalues"); Ticket tic = new Ticket();
	 * tic.setmName(mov.getmName()); tic.setTiming(tim); int i=1;
	 * tic.settNumber(1234+i); i++; tic.setSeatNo(sets); tktServ.save(tic); return
	 * new ModelAndView("redirect:/pticket");
	 * 
	 * }
	 * 
	 * @RequestMapping("/pticket") public ModelAndView
	 * ptkt(@ModelAttribute("lismovies") Ticket tkt,HttpServletRequest req) {
	 * HttpSession sesmname =req.getSession(); String mName =(String)
	 * sesmname.getAttribute("sesmov");
	 * System.out.println("under pticket mName"+mName); HttpSession
	 * sesdurationget=req.getSession(); String duration = (String)
	 * sesdurationget.getAttribute("duration");
	 * System.out.println("duration is :"+duration); HttpSession
	 * sessstrings=req.getSession(); String setseat= (String)
	 * sessstrings.getAttribute("seatvalues"); Ticket tics
	 * =tktServ.findBymNameAndseatNoo(mName,setseat); ModelAndView mdev = new
	 * ModelAndView("ticketprint"); mdev.addObject("ticdet", tics);
	 * mdev.addObject("duration",duration); return mdev;
	 * 
	 * }
	 */
	  HttpSession sesroless;
	@RequestMapping("/admin")
	public ModelAndView admin(HttpServletRequest req) {
		
		ModelAndView mdv = new ModelAndView("admin");
		
		 sesroless = req.getSession();
		String name = (String) sesroless.getAttribute("nameuser");
        mdv.addObject("name",name);
		return mdv;
	}
	@RequestMapping("/user")
	public ModelAndView user(HttpServletRequest req) {
		
		ModelAndView mdv = new ModelAndView("userbookmyshow");
		
		HttpSession sesroless = req.getSession();
		HttpSession sesroless1 = req.getSession();
		String name = (String) sesroless.getAttribute("nameuser");
		String rol = (String) sesroless1.getAttribute("role");
        mdv.addObject("name",name);
        mdv.addObject("role",rol);
		return mdv;
	}

	@RequestMapping("/addplace")
	public ModelAndView addPlace(@ModelAttribute("place") Place place,HttpServletRequest req) {
		
		HttpSession sesroless = req.getSession();
		String name = (String) sesroless.getAttribute("nameuser");
		
		if(name ==null)
		{
			return new ModelAndView("redirect:/logi");
		}
		

		return new ModelAndView("addplace");
	}

	@RequestMapping("/addmovies")
	public ModelAndView addMovies(@ModelAttribute("movies") Movie movie,HttpServletRequest req) {
		
		HttpSession sesroless = req.getSession();
		String name = (String) sesroless.getAttribute("nameuser");
		
		if(name ==null)
		{
			return new ModelAndView("redirect:/logi");
		}
		
		List<Place> pl = pser.fetchPlaceAll();

		return new ModelAndView("addmovies", "pall", pl);
	}

	@RequestMapping("/addtheatre")
	public ModelAndView addTheatre(@ModelAttribute("theatre") Theatre theatre,HttpServletRequest req) {

		//MovieController cm = new MovieController();
		HttpSession sesroless = req.getSession();
		String name = (String) sesroless.getAttribute("nameuser");
		
		if(name ==null)
		{
			return new ModelAndView("redirect:/logi");
		}
		
		List<Movie> mv = mvServ.findMvAll();

		return new ModelAndView("addtheatre", "movi", mv);
	}
	@RequestMapping("/logout")
	public ModelAndView logout() {

		return new ModelAndView("redirect:/createuser");
	}
}
