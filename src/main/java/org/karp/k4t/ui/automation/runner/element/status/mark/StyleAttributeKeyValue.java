package org.karp.k4t.ui.automation.runner.element.status.mark;

import org.apache.commons.collections4.keyvalue.DefaultKeyValue;
import org.karp.k4t.ui.automation.runner.element.attribute.ElementAttribute;

public class StyleAttributeKeyValue extends DefaultKeyValue<String, String > {

    public StyleAttributeKeyValue(String key, String value) {
        super(key, value);
    }

    public StyleAttributeKeyValue(ElementAttribute elementAttribute, String value) {
        this(elementAttribute.getName(), value);
    }
}
