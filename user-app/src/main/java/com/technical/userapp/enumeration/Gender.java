package com.technical.userapp.enumeration;

import com.technical.userapp.util.I18NUtil;

/**
 * The Gender enumeration.
 */
public enum Gender implements TranslatedEnum {
    UNKNOWN,
    MALE,
    FEMALE;

    @Override
    public String getTxt() {
        return I18NUtil.get(this.getClass().getSimpleName() + "." + this.name());
    }
}
