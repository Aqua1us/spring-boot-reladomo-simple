package com.amtkxa.springbootreladomosimple.domain.entity;

import com.gs.fw.common.mithra.MithraSequence;

public class ObjectSequence extends ObjectSequenceAbstract implements MithraSequence {
  public ObjectSequence() {
    super();
    // You must not modify this constructor. Mithra calls this internally.
    // You can call this constructor. You can also add new constructors.
  }

  public void setSequenceName(String sequenceName) {
    this.setSimulatedSequenceName(sequenceName);
  }

  @Override
  public long getNextId() {
    return this.getNextValue();
  }

  @Override
  public void setNextId(long nextValue) {
    this.setNextValue(nextValue);
  }
}
