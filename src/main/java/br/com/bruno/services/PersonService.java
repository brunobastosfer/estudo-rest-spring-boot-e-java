package br.com.bruno.services;

import br.com.bruno.exceptions.ResourceNotFoundException;
import br.com.bruno.model.Person;
import br.com.bruno.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public Person create(Person person) {
        return repository.save(person);
    }

    public Person update(Person person) {
        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        entity.setLastName(person.getLastName());

        return repository.save(entity);
    }

    public void delete(Long id) {
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

}
