package com.jryfzx.lowcode.form.dictionary.restful;

import com.jryfzx.base.pagable.JdbcPaging;
import com.jryfzx.lowcode.form.dictionary.restful.parameter.BuildInDictionary;
import com.jryfzx.lowcode.form.dictionary.restful.parameter.DBTableDictionary;
import com.jryfzx.lowcode.form.dictionary.restful.parameter.EnumerationDictionary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/10
 */
@RestController
@RequestMapping("flow/form/dictionaries")
public class DictionaryController {

    @GetMapping("list")
    public ResponseEntity<JdbcPaging<DictionaryWVO>> listDictionary(
            @RequestParam(value = "q",required = false) String query) {
        return null;
    }


    @GetMapping("get/{id}")
    public ResponseEntity<Map<Integer,String>> getDictiohiary(@PathVariable("id") Integer id) {
        return null;
    }


    @DeleteMapping("remove/{id}")
    public ResponseEntity<String> deleteDictionary(@PathVariable("id") Integer id) {
        return null;
    }


    @PostMapping(value = "add", params = "type=buildIn")
    public ResponseEntity<DictionaryWVO> newDictionary(@RequestBody BuildInDictionary dictionary) {
        System.out.println("new buildIn");
        return null;
    }


    @PostMapping(value = "add", params = "type=dbTable")
    public ResponseEntity<DictionaryWVO> newDictionary(@RequestBody DBTableDictionary dictionary) {
        System.out.println("new dbTable");
        return null;
    }


    @PostMapping(value = "add", params = "type=enumeration")
    public ResponseEntity<DictionaryWVO> newDictionary(@RequestBody EnumerationDictionary dictionary) {
        String s = dictionary.getDictionaryName();
        System.out.println("new enum"+s);
        return null;
    }


    @PutMapping(value = "update",params = "type=buildIn")
    public ResponseEntity<DictionaryWVO> modifyDictionary(@RequestBody BuildInDictionary dictionary) {
        System.out.println("update buildIn");
        return null;
    }


    @PutMapping(value = "update",params = "type=dbTable")
    public ResponseEntity<DictionaryWVO> modifyDictionary(@RequestBody DBTableDictionary dictionary) {
        System.out.println("update dbTable");
        return null;
    }


    @PutMapping(value = "update",params = "type=enumeration")
    public ResponseEntity<DictionaryWVO> modifyDictionary(@RequestBody EnumerationDictionary dictionary) {
        System.out.println("update enum");
        return null;
    }
}
