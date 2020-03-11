package com.example.pruebatodolist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity //ORM JPA, para que TodoItem sea una entidad
public class TodoItem 
{
	private Long id;
	@NotBlank // title no podra ser nulo ni un caracter espacio
	private String title;
	private boolean done;
	

	public TodoItem ()
	{
		
	}
	
	public TodoItem(Long id, String title, boolean done) 
	{
		this.id = id;
		this.title = title;
		this.done = done;
	}

	@Id // declarando id como el identificador
	@GeneratedValue // para que genere los valores del id automaticamente 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	
	
}
