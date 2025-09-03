package com.example.demo.mapper;

import java.util.List;

import com.example.demo.dto.PersonDto;
import com.example.demo.model.Person;

public class PersonMapper {
	private PersonMapper() {};
	
	public static PersonDto toDto(Person p) {
		return new PersonDto(p.getName(), p.getAge());
	}
	
	public static List<PersonDto> toDtoList(List<Person> persons){
		return persons.stream().map(PersonMapper::toDto).toList();
	}
}
