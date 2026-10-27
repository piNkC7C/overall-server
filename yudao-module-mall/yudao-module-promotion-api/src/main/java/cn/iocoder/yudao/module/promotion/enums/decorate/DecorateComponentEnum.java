package cn.iocoder.yudao.module.promotion.enums.decorate;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 页面组件枚举
 *
 * @author jason
 */
@Getter
@AllArgsConstructor
@SuppressWarnings("JavadocLinkAsPlainText") public enum DecorateComponentEnum { /** * format ：[{ *."name": "Title."
     *  "picUrl": "https://www.iocoder.cn/xxx.png",
     *  "url": "/pages/users/index"
     * }]
     *
     * 最多 10 个
     */
    MENU("menu", "Menu"), /** * format ：[{ *"name": "Title."
     *  "url": "/pages/users/index"
     * }]
     */
    ROLLING_NEWS("scrolling-news", "News ticker"),
    /**
     * 格式：[{
     *  "picUrl": "https://www.iocoder.cn/xxx.png",
     *  "url": "/pages/users/index"
     * }]
     */
    SLIDE_SHOW("slide-show", "Carousel"),
    /**
     * 格式：[{
     *  "name": "Title."
     *  "type": "Type.", // best、hot、new、benefit、good
     *  "tag": "Tag." // 例如说：多买多省
     * }]
     *
     * 最多 4 个
     */
    PRODUCT_RECOMMEND("product-recommend", "Product recommend");

    /**
     * 页面组件代码
     */
    private final String code;

    /**
     * 页面组件说明
     */
    private final String desc;

}
