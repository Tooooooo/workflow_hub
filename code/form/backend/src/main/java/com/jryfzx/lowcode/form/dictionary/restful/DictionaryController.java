package com.jryfzx.lowcode.form.dictionary.restful;

import com.whjryf.common.pagable.JdbcPaging;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/10
 */
@Tag(name = "dictionary", description = "数据字典相关接口")
@RestController
@RequestMapping("flow/form/dictionaries")
public class DictionaryController {

    @Operation(summary = "按分页获取字典列表数据", description = "获取满足查询条件的字典列表数据(分页)，如不指定条件，获取所有")
    @GetMapping("pagingList")
    public ResponseEntity<JdbcPaging<DictionaryWVO>> listDictionaryPaged(
            @Parameter(in = ParameterIn.QUERY, description = "以字典名称作为模糊查询条件")
            @RequestParam(value = "q", required = false) String query) {
        return null;
    }


    @Operation(summary = "获取字典列表数据", description = "获取满足查询条件的字典列表数据，如不指定条件，获取所有")
    @GetMapping("list")
    public ResponseEntity<List<DictionaryWVO>> listDictionary(
            @Parameter(in = ParameterIn.QUERY, description = "以字典名称作为模糊查询条件")
            @RequestParam(value = "q", required = false) String query) {
        return null;
    }


    @Operation(summary = "获取单个字典信息", description = "获取指定id的字典信息")
    @GetMapping("get/{id}")
    public ResponseEntity<Map<Integer,String>> getDictiohiary(
            @Parameter(in = ParameterIn.PATH,description = "数据字典id")
            @PathVariable("id") Integer id) {
        return null;
    }


    @Operation(summary = "删除数据字典", description = "删除指定id的数据字典数据")
    @DeleteMapping("remove/{id}")
    public ResponseEntity<Void> deleteDictionary(@PathVariable("id") Integer id) {
        return null;
    }


    @Operation(summary = "创建数据字典",description = "以传入参数的type属性作为区分，用于创建三种类型的数据字典：" +
            "数据表(dbTable)/枚举(enum)/内置(buildIn)")
    @PostMapping("add")
    public ResponseEntity<DictionaryWVO> newDictionary(@RequestBody DictionaryParam dictionary) {
        System.out.println("new buildIn");
        return null;
    }


    @Operation(summary = "修改数据字典")
    @PutMapping("update")
    public ResponseEntity<DictionaryWVO> modifyDictionary(@RequestBody DictionaryParam dictionary) {
        System.out.println("update buildIn");
        return null;
    }

}
