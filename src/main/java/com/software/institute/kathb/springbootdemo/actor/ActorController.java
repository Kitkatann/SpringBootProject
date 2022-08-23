package com.software.institute.kathb.springbootdemo.actor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private IActorService actorService;
    @Autowired
    private ModelMapper modelMapper;


    public ActorController(IActorService actorService)
    {
        this.actorService = actorService;
    }

    @GetMapping(params = {"fullName"})
    public @ResponseBody
    List<ActorDTO> getActorsByName(@RequestParam(name = "fullName", required = false) String fullName)
    {
        return actorService.getActorsByName(fullName)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @GetMapping(params = {"actorId"})
    public @ResponseBody
    ActorDTO getActorById(@RequestParam(name = "actorId", required = false) Integer actorId)
    {
        return convertToDTO(actorService.getActorById(actorId));
    }

    @GetMapping(params = {"filmId"})
    public @ResponseBody
    List<ActorDTO> getActorsByFilm(@RequestParam(name = "filmId") Integer filmId)
    {
        return actorService.getActorsByFilm(filmId)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<ActorDTO> createActor(@RequestBody ActorDTO actorDTO)
    {
        Integer actorId = actorService.createActor(actorDTO);
        Actor actor = actorService.getActorById(actorId);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(actor));
    }

    @PatchMapping("/{actorId}")
    public @ResponseBody
    ResponseEntity<ActorDTO> updateActor(@PathVariable Integer actorId, @RequestBody ActorDTO actorDTO)
    {
        actorService.updateActor(actorId, actorDTO);
        Actor actor = actorService.getActorById(actorId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(convertToDTO(actor));
    }

    @DeleteMapping("/{actorId}")
    public @ResponseBody
    void deleteActor(@PathVariable Integer actorId)
    {
        actorService.deleteActor(actorId);
    }


    private ActorDTO convertToDTO(Actor actor) {
        return modelMapper.map(actor, ActorDTO.class);
    }
}
