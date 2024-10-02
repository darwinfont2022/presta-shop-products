package com.darwinfont.presta_products.domain.mapper;

import com.darwinfont.presta_products.domain.prestaShop.Language;
import com.darwinfont.presta_products.domain.prestaShop.LanguageWrapper;

import java.util.ArrayList;

public class LanguageMapper {
    public static LanguageWrapper genereteOneLanguageWrapper(Integer lenId, String lenValue){
        if (lenValue == null) {
            return null;
        } else if (lenValue.isEmpty()) {
            return null;
        }
        LanguageWrapper lenWrapper = new LanguageWrapper(new ArrayList<>());

        lenWrapper.getLanguages().add(new Language(lenId, lenValue));

        return lenWrapper;
    }
}
