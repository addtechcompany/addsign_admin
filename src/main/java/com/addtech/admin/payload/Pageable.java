package com.addtech.admin.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pageable {
    private int pageNumber;
    private int pageSize;
    private Sort sort;
    private int offset;
    private boolean unpaged;
    private boolean paged;
}
