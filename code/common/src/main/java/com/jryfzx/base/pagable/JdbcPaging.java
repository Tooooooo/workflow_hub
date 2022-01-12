package com.jryfzx.base.pagable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.Page;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 涂鼎 [eMail: tuding27@gmail.com]
 * @version 0.1 [2020/2/16]
 */
@Getter
@Setter
public class JdbcPaging<T> implements Serializable {


  private static final long serialVersionUID = 8656597559014685635L;
  private long total;        //总记录数
  private List<T> data;    //结果集
  private int pageNum;    // 第几页
  private int pageSize;    // 每页记录数
  private int pages;        // 总页数
  @JsonIgnore
  private int size;        // 当前页的数量 <= pageSize，该属性来自ArrayList的size属性


  public JdbcPaging() {
  }


  /**
   * 包装Page对象，因为直接返回Page对象，在JSON处理以及其他情况下会被当成List来处理， 而出现一些问题。
   *
   * @param list page结果
   */
  public JdbcPaging(List<T> list) {
    if (list instanceof Page) {
      Page<T> page = (Page<T>)list;
      this.pageNum = page.getPageNum();
      this.pageSize = page.getPageSize();
      this.total = page.getTotal();
      this.pages = page.getPages();
      this.data = page;
      this.size = page.size();
    }
  }


}
