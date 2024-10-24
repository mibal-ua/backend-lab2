package ua.mibal.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.mibal.model.Record;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @GetMapping("/{id}")
    public Record get(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public Record search(@RequestParam(name = "user_id", required = false) Long userId,
                         @RequestParam(name = "category_id", required = false) Long categoryId) {
        return null;
    }

    @DeleteMapping("/{id}")
    public Record delete(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public Record create(@RequestBody Record record) {
        return null;
    }
}
