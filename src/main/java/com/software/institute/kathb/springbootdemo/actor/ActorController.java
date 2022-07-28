package com.software.institute.kathb.springbootdemo.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        Actor a = new Actor(actorFirstName, actorLastName);
        System.out.println(actorFirstName + " " + actorLastName);
        actorRepository.save(a);
        return "saved";
    }

    @PatchMapping(params = {"actorId", "actorFirstName", "actorLastName"})
    public @ResponseBody String updateActorById(@RequestParam int actorId, @RequestParam String actorFirstName, @RequestParam String actorLastName)
    {
        Optional<Actor> actor = actorRepository.findById(actorId);
        if (!actor.isEmpty())
        {
            actor.get().setFirstName(actorFirstName);
            actor.get().setLastName(actorLastName);
            actorRepository.save(actor.get());
            return "saved";
        }
        return "not saved";
    }

    @DeleteMapping(params = {"actorId"})
    public @ResponseBody
    void deleteActorById(@RequestParam int actorId)
    {
        actorRepository.deleteById(actorId);
    }


}
