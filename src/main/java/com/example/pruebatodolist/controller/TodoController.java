package com.example.pruebatodolist.controller; //el paquete en el cual me encuentro

import com.example.pruebatodolist.repo.TodoRepo;
import com.sun.istack.NotNull;
import com.example.pruebatodolist.model.TodoItem; //esto lo puse pa vee

import org.springframework.beans.factory.annotation.Autowired;  //@Autowired
import org.springframework.web.bind.annotation.GetMapping;      //@GetMapping 
import org.springframework.web.bind.annotation.PostMapping;     //@PostMapping
import org.springframework.web.bind.annotation.RequestMapping;  //@RequestMapping
import org.springframework.web.bind.annotation.RestController;  //@RestController
import org.springframework.web.bind.annotation.*;               // supongo que el * ya abarca todo. los annotation.chucha   
import org.springframework.web.bind.annotation.PutMapping;//@PutMapping
import javax.validation.Valid;
import java.util.List; //para poder usar List  
import java.util.Optional;



@RestController //le da a esta clase un REST endpoint
@RequestMapping(value= 	"/todo") 
public class TodoController 
{
	@Autowired
	private TodoRepo todoRepo; //debo importar el paquete donde se encuentre la clase TodoRepo, arriba lo puse
	   
	@GetMapping //busca todos los items
	public List<TodoItem> findAll() //para ver todos los items (la lista de items)
	{
		return todoRepo.findAll();
	}
	
	@GetMapping(value = "/{id}") //busca solo un item
	public Optional<TodoItem> getone (@PathVariable Long id)
	{
		return todoRepo.findById(id);
	}
	
	@PostMapping //permite publicar un item
	public TodoItem save(@Valid @NotNull @RequestBody TodoItem todoItem) //si no coloco el @Valid el @NotBlank no va a funcionar
	{
		return todoRepo.save(todoItem); 
	}
	
	
	@PutMapping //actualiza/edita, pero aqui se puede editar todo y no debería 
	public TodoItem update (@Valid @NotNull @RequestBody TodoItem todoItem)
	{
		return todoRepo.save(todoItem);
	}
	
	@DeleteMapping(value= "/{id}") //elimina un item de la lista peor debo pasarle el ide por la url
	public void  delete(@PathVariable Long id)
	{
		todoRepo.deleteById(id);
	}
}






