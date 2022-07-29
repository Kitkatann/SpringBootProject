package com.software.institute.kathb.springbootdemo.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    private final ActorRepository actorRepository;

    public ActorController(ActorRepository actorRepository)
    {
        this.actorRepository = actorRepository;
    }

    @GetMapping(params = {"actorFirstName", "actorLastName"})
    public @ResponseBody
    Iterable<Actor> getActors(@RequestParam(name = "actorFirstName", required = false) String firstName,
                              @RequestParam(name = "actorLastName", required = false) String lastName)
    {
        if (firstName != null || lastName != null)
        {
            return actorRepository.findByFirstNameContainingAndLastNameContainingOrderByLastName(firstName, lastName);
        }
        return actorRepository.findAll();
    }



    @PostMapping(params = {"actorFirstName", "actorLastName"})
    public @ResponseBody String addNewActor(@RequestParam String actorFirstName,
                                            @RequestParam String actorLastName)
    {
        Actor actor = new Actor(actorFirstName, actorLastName);
        System.out.println(actorFirstName + " " + actorLastName);
        actorRepository.save(actor);
        return "saved";
    }

    @PatchMapping(params = {"actorId", "actorFirstName", "actorLastName"})
    public @ResponseBody String updateActorById(@RequestParam int actorId, @RequestParam String actorFirstName, @RequestParam String actorLastName)
    {
        Actor actor = actorRepository
                .findById(actorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No actor exists with that id."));
        actor.setFirstName(actorFirstName);
        actor.setLastName(actorLastName);
        actorRepository.save(actor);
        return "saved";
    }

    @DeleteMapping(params = {"actorId"})
    public @ResponseBody
    void deleteActorById(@RequestParam int actorId)
    {
        actorRepository.deleteById(actorId);
    }


}
