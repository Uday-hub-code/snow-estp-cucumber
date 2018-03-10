package com.disney.cast.platform.estp.ui.snow.pages.vo;

import com.disney.cast.platform.common.ui.snow.pages.vo.ValueObject;

@SuppressWarnings("unused")
public class AlertVO extends ValueObject {
    private String active;
    private String body;
    private String type;

    public AlertVO(String active, String body, String type) {
        this.active = active;
        this.body = body;
        this.type = type;
    }
}
