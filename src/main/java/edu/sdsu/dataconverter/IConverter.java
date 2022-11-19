package edu.sdsu.dataconverter;

import edu.sdsu.dataType.IDataType;

public interface IConverter {
   IDataType convert(Object value);
}
