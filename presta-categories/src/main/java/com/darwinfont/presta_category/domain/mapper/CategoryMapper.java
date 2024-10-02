package com.darwinfont.presta_category.domain.mapper;

import com.darwinfont.presta_category.domain.Language;
import com.darwinfont.presta_category.domain.LanguageWrapper;
import com.darwinfont.presta_category.domain.request.CategoryCreateRequest;
import com.darwinfont.presta_category.domain.request.CategoryUpdateRequest;
import com.darwinfont.presta_category.domain.request.PrestaCategoryRequest;
import com.darwinfont.presta_category.domain.request.PrestaCategoryRoot;

import java.util.ArrayList;

public class CategoryMapper {
    public static PrestaCategoryRoot createPrestaCategory(CategoryCreateRequest dto, Integer id) {
        PrestaCategoryRequest request = new PrestaCategoryRequest();

        request.setId(id);
        request.setIdParent(dto.getIdParent());
        request.setActive(dto.getActive() ? 1 : 0);
        request.setIsRootCategory(dto.getIsRootCategory() ? 1 : 0);
        request.setLinkRewrite(genereteOneLanguageWrapper(1, dto.getLinkRewrite()));

        request.setName(genereteOneLanguageWrapper(1, dto.getName()));
        request.setDescription(genereteOneLanguageWrapper(1, dto.getDescription()));
        request.setMetaTitle(genereteOneLanguageWrapper(1, dto.getMetaTitle()));
        request.setMetaDescription(genereteOneLanguageWrapper(1, dto.getMetaDescription()));

        return new PrestaCategoryRoot(request);
    }

    public static PrestaCategoryRoot updateMapperCategory(CategoryUpdateRequest dto, Integer id) {
        PrestaCategoryRequest request = new PrestaCategoryRequest();

        request.setId(id);
        request.setIdParent(dto.getIdParent());
        request.setActive(dto.getActive() ? 1 : 0);
        request.setIsRootCategory(dto.getIsRootCategory() ? 1 : 0);
        request.setLinkRewrite(genereteOneLanguageWrapper(1, dto.getLinkRewrite()));

        request.setName(genereteOneLanguageWrapper(1, dto.getName()));
        request.setDescription(genereteOneLanguageWrapper(1, dto.getDescription()));
        request.setMetaTitle(genereteOneLanguageWrapper(1, dto.getMetaTitle()));
        request.setMetaDescription(genereteOneLanguageWrapper(1, dto.getMetaDescription()));

        return new PrestaCategoryRoot(request);
    }
//    public static PrestaCategoryRoot mapUpdateCategory(CategoryUpdateRequest dto) {
//        CategoryUpdateRequest request = new CategoryUpdateRequest();
//    }

    public static LanguageWrapper genereteOneLanguageWrapper(Integer lenId, String lenValue){
        LanguageWrapper lenWrapper = new LanguageWrapper(new ArrayList<>());

        lenWrapper.getLanguages().add(new Language(lenId, lenValue));

        return lenWrapper;
    }
}