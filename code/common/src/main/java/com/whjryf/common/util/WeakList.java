package com.jrwhjd.support;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import lombok.Getter;

/**
 * 弱(weak)持有的List实现. 底层是一个 ArrayList, 提供常用的 List 方法.
 * 由于持有对象的不确定性,因此不提供 get(index) 方法.
 *
 * @author 涂鼎 [eMail: tuding27@gmail.com]
 * @version 0.1 [2019/12/20]
 */
public class WeakList<E> implements Iterable<E>{


  // private final ReferenceQueue<Wrapper<E>> q = new ReferenceQueue<>();
  private List<WeakReference<Wrapper<E>>> items;


  /**
   * Creates new WeakList
   */
  public WeakList() {
    items = new ArrayList<>();
  }


  public boolean add(E e) {
    return items.add(new WeakReference<>(new Wrapper<>(e)));
  }


  public int size() {
    expungeStaleEntries();
    return items.size();
  }


  public boolean isEmpty() {
    expungeStaleEntries();
    return size() == 0;
  }


  public boolean contains(E o) {
    expungeStaleEntries();
    if (null == o) {
      return false;
    }
    return items.stream().anyMatch(ref -> {
      Wrapper<E> w = ref.get();
      if (null == w) {
        return false;
      }
      return o.equals(w.getV());
    });
  }


  public E get(int index) {
    expungeStaleEntries();
    throw new UnsupportedOperationException(
        "基于WeakReference的运行逻辑(条目的引用随时可能被释放导致索引混乱), 无法提供get方法");
  }


  public Iterator<E> iterator() {
    expungeStaleEntries();
    return retain().iterator();
  }


  public ListIterator<E> listIterator() {
    expungeStaleEntries();
    return retain().listIterator();
  }


  public Object[] toArray() {
    expungeStaleEntries();
    return retain().toArray();
  }


  public <T> T[] toArray(T[] a) {
    expungeStaleEntries();
    return retain().toArray(a);
  }


  private void expungeStaleEntries() {
    items.removeIf(con -> con.get() == null);
  }


  private List<E> retain() {
    List<E> retained = new ArrayList<>();
    items.forEach(wrp -> {
      Wrapper<E> w = wrp.get();
      if (w == null) {
        return;
      }
      retained.add(w.getV());
    });
    return retained;
  }


  private static class Wrapper<E> {


    @Getter
    private E v;


    public Wrapper(E v) {
      this.v = v;
    }


    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Wrapper<?> wrapper = (Wrapper<?>)o;

      return Objects.equals(v, wrapper.v);
    }


    @Override
    public int hashCode() {
      return v != null ? v.hashCode() : 0;
    }


  }


}
