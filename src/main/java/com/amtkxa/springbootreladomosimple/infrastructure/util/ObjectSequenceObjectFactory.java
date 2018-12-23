package com.amtkxa.springbootreladomosimple.infrastructure.util;

import com.amtkxa.springbootreladomosimple.domain.entity.ObjectSequence;
import com.amtkxa.springbootreladomosimple.domain.entity.ObjectSequenceFinder;
import com.gs.fw.common.mithra.MithraSequence;
import com.gs.fw.common.mithra.MithraSequenceObjectFactory;

public class ObjectSequenceObjectFactory implements MithraSequenceObjectFactory {
  public MithraSequence getMithraSequenceObject(String sequenceName, Object sourceAttribute, int initialValue) {
    ObjectSequence objectSequence = ObjectSequenceFinder.findByPrimaryKey(sequenceName);
    if (objectSequence == null) {
      objectSequence = new ObjectSequence();
      objectSequence.setSimulatedSequenceName(sequenceName);
      objectSequence.setNextValue(initialValue);
      objectSequence.insert();
    }
    return objectSequence;
  }
}
