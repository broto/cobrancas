package com.algaworks.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;



//Toda controller precisa ser anotada com esse @ controller
@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private Titulos titulos;
	
	//Esse request mapeia a esse metodo, toda vez que eu digitar essa url no browser
	//ele entra nesse metodo e chama a pagina caastroTitulo
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		//criar um objeto e armazena um vetor do enum statusTitulo
		//mv.addObject("todosStatusTitulo", StatusTitulo.values());
		return mv;
	}
	
	//ModelandView diz que alem de retornar uma view, tbem retorna dados do model
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo){
		titulos.save(titulo);
		//Objeto que model and view, onde o construtor já recebe a view
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		//quando eu chegar na view o objeto mensagem estara disponivel lá
		//la tem a condição se mensagem NÃO estiver vazia  para aparecer a mensagem, logo depois de salvar
		mv.addObject("mensagem", "Título salvo com sucesso!");
		return mv;
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		//return Arrays.asList(StatusTitulo.values());
		return Arrays.asList(StatusTitulo.values());
	}
}
