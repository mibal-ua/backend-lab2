package ua.mibal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.mibal.model.Record;
import ua.mibal.model.RecordSearchQuery;
import ua.mibal.service.RecordService;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/record")
public class RecordController {
    private final RecordService service;

    @GetMapping
    public List<Record> search(@RequestParam(name = "user_id", required = false) Long userId,
                               @RequestParam(name = "category_id", required = false) Long categoryId) {
        RecordSearchQuery query = new RecordSearchQuery(userId, categoryId);
        return service.searchBy(query);
    }

    @GetMapping("/{id}")
    public Record get(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public Record delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PostMapping
    public Record create(@RequestBody Record record) {
        return service.create(record);
    }
}
