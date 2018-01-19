package ru.mephi.qualityManagement.web.process;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.mephi.qualityManagement.model.Process;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Анастасия on 28.11.2017.
 */
@RestController
@RequestMapping(ProcessRestController.REST_URL)
public class ProcessRestController extends AbstractProcessController {

    static final String REST_URL = "/rest/profile/processes";

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Process get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Process> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/between", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Process> getBetween(
            @RequestParam(value = "startDate") LocalDateTime startDate,
            @RequestParam(value = "endDate", defaultValue = "") LocalDateTime endDate) {
        return super.getBetween(startDate, endDate);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Process process, @PathVariable("id") int id) {
        super.update(process, id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Process> createWithLocation(@RequestBody Process process) {
        Process created = super.create(process);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriOfNewResource);

        return new ResponseEntity<>(created, httpHeaders, HttpStatus.CREATED);
    }
}
