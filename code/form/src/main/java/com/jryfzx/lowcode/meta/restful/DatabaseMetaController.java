package com.jryfzx.lowcode.meta.restful;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/13
 */
@Tag(name = "数据库元数据")
@RequestMapping("dbMeta")
@RestController
public class DatabaseMetaController {

    @Operation(summary = "列举数据库表",description = "用于取得数据库中的表的清单，可以指定表名前缀作为过滤条件")
    @GetMapping("tables/list")
    public ResponseEntity<List<MetaInfo>> showTables(
            @Parameter(in = ParameterIn.QUERY,description = "用于过滤的表名前缀，只列举名称以该前缀开头的表")
            @RequestParam(name = "prefix", required = false) String tablePrefix) {
        return null;
    }


    @Operation(summary = "列举表的字段",description = "用于取得指定数据库表字段的清单，可以指定字段名前缀作为过滤条件")
    @GetMapping("columns/{tablename}/list")
    public ResponseEntity<List<MetaInfo>> showFields(
            @Parameter(in = ParameterIn.PATH, required = true,description = "指定用于获取其中字段的表的表名")
            @PathVariable
            String tablename,
            @Parameter(in=ParameterIn.QUERY,description = "用于过滤的字段名前缀，只列举名称以该前缀开头的字段")
            @RequestParam(name = "prefix", required = false) String columnPrefix){
        return null;
    }


}
