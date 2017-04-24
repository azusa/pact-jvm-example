package jp.fieldnotes.jjug.pact.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animals")
public class AnimalContoroller {

    @Autowired
    private AnimalsRepository repository;

    @RequestMapping(value="/{type}", method=RequestMethod.GET)
    public Animals method2(@PathVariable String type) {
        return new Animals(repository.findByType(type));
    }
}