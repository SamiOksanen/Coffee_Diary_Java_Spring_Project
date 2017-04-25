package fi.hh.coffeediary.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fi.hh.coffeediary.bean.Kahvi;
import fi.hh.coffeediary.dao.KahviDao;


@Controller
@RequestMapping (value="/kahvit")
public class KahviController {
	
	@Inject
	private KahviDao dao;
	
	public KahviDao getDao() {
		return dao;
	}

	public void setDao(KahviDao dao) {
		this.dao = dao;
	}
	
	//FORMIN TEKEMINEN
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Kahvi tyhjaKahvi = new Kahvi();
		tyhjaKahvi.setMaara(0);
		
		model.addAttribute("kahvi", tyhjaKahvi);
		return "kahv/createForm";
	}
	
	//FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value="uusi", method=RequestMethod.POST)
	public String create( @ModelAttribute(value="kahvi") @Valid Kahvi kahvi, BindingResult result) {
		if (result.hasErrors()) {
			return "kahv/createForm";
		} else {
			dao.talleta(kahvi);
			return "redirect:/kahvit/" + kahvi.getId();
		}
	}
	
	//KAHVINJUONTIPÄIVÄN TIETOJEN NÄYTTÄMINEN
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Integer id, Model model) {
		Kahvi kahvi = dao.etsi(id);
		model.addAttribute("kahvi", kahvi);
		return "kahv/view";
	}
	
	//KAHVIPÄIVÄKIRJAN NÄYTTÄMINEN
	@RequestMapping(value="paivakirja", method=RequestMethod.GET)
	public String getLista(Model model) {
		List<Kahvi> kahvit = dao.haeKaikki();
		model.addAttribute("kahvit", kahvit);
		return "kahv/lista";
	}
	
}
